<template>
  <div class="container  step4">
    <!-- 상단 로딩바 -->
    <LoadingBar :isLoading="isLoading" />
    <div class="card">
      <!-- 중간의 질문과 비디오 녹화 -->
      <div class="content">
        <div class="question-area">
          <p class="nav"><span class="n">{{ currentQuestionIndex + 1}}/{{ interviewQuestions.length }}</span></p>
          <p class="title" v-if="currentQuestion">{{ currentQuestion.question }}
            <span @click="generateSpeech" class="speaker -on"></span>
          </p>
          <p v-else>로딩 중...</p>
        </div>

        <div class="box">
          <div class="video-area">
            <video controls autoplay playsinline ref="video" height="400" width="600"></video>
          </div>
          <div class="timer-container">
            <canvas ref="timerCanvas" width="200" height="200"></canvas>
<!--            <p v-if="isRecording">REC {{ minutes }}분 {{ seconds }}초</p>-->
          </div>
          <button class="btn_next chevron right" v-if="currentQuestion" @click="nextQuestion(currentQuestion)"></button>
        </div>
      </div>
    </div>
    <!-- 하단 버튼 -->
    <div class="">
      <button class="btn_line" id="btn-start-recording" @click="stopAndstartRec">다시 녹화</button>
      <button class="btn_line" style="width: 250px" v-if="currentQuestion" @click="endInterview(currentQuestion)">답변 저장 후 면접 종료하기</button>
    </div>
  </div>
</template>

<script>
// import axios from '../../plugins/axios';
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex';
import RecordRTC from "recordrtc";
import LoadingBar from '../util/LoadingBar.vue';

export default {
  components: {
    LoadingBar
  },
  data() {
    return {
      isLoading: false,
      autoAnswer: '',
      recorder: null,
      synth: window.speechSynthesis,
      finalTranscripts: [], // 최종 결과
      isRecording: false, // 음성 인식 상태 확인
      recognition: null, // SpeechRecognition 객체 저장
      elapsedTime: 180, // 녹화 시간
      timer: null, // 타이머 변수,
      answerBlob: null,
    };
  },
  computed: {
    ...mapState(['interviewQuestions', 'currentQuestionIndex', 'answers']),
    ...mapGetters(['currentQuestion']),
    minutes() {
      return Math.floor(this.elapsedTime / 60); // 초를 분으로 변환
    },
    seconds() {
      return this.elapsedTime % 60; // 60으로 나눈 나머지를 초로 표시
    }
  },
  watch: {
    currentQuestionIndex(newIndex) {
      this.autoAnswer = this.answers[newIndex] || '';
    }
  },
  mounted() {
    this.autoAnswer = this.answers[this.currentQuestionIndex] || '';
    this.startRec();
    this.drawTimer();
  },
  methods: {
    ...mapMutations(['addInterviewQA', 'decrementQuestionIndex']),
    ...mapActions(['updateInterviewIndex', 'loadInterviewQuestions', 'saveSession']),
    updateAnswer(question) {
      this.addInterviewQA(
        {"questionId": question.id, "question": question.question, "idealAnswer": question.idealAnswer,
        "answer": this.autoAnswer, "answerBlob": this.answerBlob});
    },
    // Deprecated
    previousQuestion() {
      if (this.currentQuestionIndex === 0) {
        alert('첫번째 질문입니다.');
        return;
      }
      this.decrementQuestionIndex();
    },
    async nextQuestion(question) {
      if (this.currentQuestionIndex < this.interviewQuestions.length - 1) {
        await this.stopRec();
        this.updateAnswer(question);
        this.updateInterviewIndex();
        this.answer = '';
        this.startRec();
      } else {
        await this.endInterview(question);
      }
    },
    async endInterview(question) {
      this.isLoading = true;
      await this.stopRec();
      this.updateAnswer(question);
      //로그인 기능이 추가되면 그때 서버에 데이터 저장하기 (현재 저장하는건 의미없다. 다시 볼 수도 없고)
      // await this.saveSession();
      this.$router.push({ name: 'CoupangAd' });
      this.isLoading = false;
    },
    generateSpeech() {
      const text = this.currentQuestion.question;
      this.textToSpeech(text);
    },
    textToSpeech(text) {
      const utterance = new SpeechSynthesisUtterance(text);
      this.synth.speak(utterance);
    },
    startToWriteDown() {
      this.recognition = new (window.SpeechRecognition || window.webkitSpeechRecognition)();
      this.recognition.lang = 'ko-KR';
      this.recognition.interimResults = true;

      this.recognition.onresult = (event) => {
        let final = '';

        for (const result of event.results) {
          if (result.isFinal) {
            final += result[0].transcript;
          }
        }
        if (final) {
          this.finalTranscripts.push(final);
        }
      };

      this.recognition.onerror = (event) => {
        console.error('Speech recognition error:', event.error);
      };

      this.recognition.onend = () => {
        if (this.isRecording) {
          this.recognition.start();
        }
      };

      this.isRecording = true;
      this.finalTranscripts = []; // 새로운 세션 시작 시 최종 결과 배열 초기화
      this.recognition.start(); // 음성 인식 시작
    },
    stopWritingDown() {
      if (this.recognition) { 
        this.recognition.stop(); // 음성 인식 중지
      }
      this.isRecording = false;
    },
    async stopAndstartRec() {
      await this.stopRec();
      this.startRec();
    },
    startRec() {
      this.finalTranscripts = [];
      this.$refs.video.srcObject = null;
      this.captureCamera(camera => {
        const video = this.$refs["video"];
        video.muted = true;
        video.volume = 0;
        video.srcObject = camera;
        this.recorder = RecordRTC(camera, {
          type: "video",
          mimeType: 'video/webm', // 웹 브라우저에서 가장 호환성 좋은 포맷
          videoBitsPerSecond: 2500000, // 비트레이트 설정 (2.5Mbps)
          frameRate: 30 // 프레임 속도 설정
        });
        this.recorder.startRecording();
        this.recorder.camera = camera;

        this.startTimer(); // 타이머 시작
      });
      // this.startToWriteDown();
      this.isRecording = true; // 녹화 중 상태로 변경
    },
    captureCamera(callback) {
      navigator.mediaDevices
      .getUserMedia({
        video: {
          width: { ideal: 1280 }, // 원하는 해상도 (가로)
          height: { ideal: 720 }, // 원하는 해상도 (세로)
          frameRate: { ideal: 30, max: 60 } // 프레임 속도
        },
        audio: true
      })
        .then(function(camera) {
          callback(camera);
        })
        .catch(function(error) {
          alert("Unable to capture your camera. Please check console logs.");
          console.error(error);
        });
    },
    stopRec() {
      return new Promise((resolve) => {
        this.stopTimer(); // 타이머 중지
        
        try {
          // 녹화 중인지 확인하고, recorder가 있는 경우에만 stopRecording 호출
          this.recorder.stopRecording(this.stopRecordingCallback);
          this.isRecording = false; // 녹화 중 상태 해제
          
          this.recorder.stopRecording(() => {
            this.stopRecordingCallback();
            resolve(); // 녹화가 끝난 후에 resolve 호출
          });
          // this.stopWritingDown();
          this.autoAnswer = this.finalTranscripts.join(' ');
          this.isRecording = false; // 녹화 중 상태 해제
        } catch (e) {
          alert('비디오가 로딩중입니다. 잠시만 기다려주세요.');
        }
        
      });
    },
    stopRecordingCallback() {
      const video = this.$refs["video"];
      if (video) {
        video.srcObject = null;
        video.muted = false;
        video.volume = 1;
      }
      
      this.answerBlob = this.recorder.getBlob();
      this.recorder.camera.stop();
      this.recorder.destroy();
      this.recorder = null;
    },
    drawTimer() {
      const canvas = this.$refs.timerCanvas;
      const ctx = canvas.getContext('2d');
      const radius = 80; // 원의 반지름

      const draw = () => {
        ctx.clearRect(0, 0, canvas.width, canvas.height); // 이전 프레임 지우기

        // 배경 원 그리기
        ctx.beginPath();
        ctx.arc(100, 100, radius, 0, 2 * Math.PI); // 전체 원
        ctx.lineWidth = 15;
        ctx.strokeStyle = '#d1d1d1'; // 배경 색상
        ctx.stroke();

        // 줄어드는 원 그리기
        ctx.beginPath();
        const startAngle = 1.5 * Math.PI; // 시작 각도 (12시 방향)
        const endAngle = startAngle + (this.elapsedTime / 180) * 2 * Math.PI; // 남은 시간에 따른 각도 (시계 방향)

        ctx.arc(100, 100, radius, startAngle, endAngle, false); // false로 시계 방향
        ctx.lineWidth = 15;
        ctx.strokeStyle = '#894CFF'; // 원 색상
        ctx.stroke();

        // 텍스트 그리기
        ctx.fillStyle = '#894CFF'; // 텍스트 색상
        ctx.font = '20px Arial';
        ctx.textAlign = 'center';
        ctx.textBaseline = 'middle';
        ctx.fillText(`${this.minutes}분 ${this.seconds}초`, 100, 100); // 원 안에 텍스트 추가

        if (this.elapsedTime > 0) {
          requestAnimationFrame(draw); // 계속 그리기
        }
      };

      draw(); // 첫 번째 호출
    },

    startTimer() {
      this.elapsedTime = 180; // 3분 (180초)에서 시작
      this.timer = setInterval(() => {
        this.elapsedTime--; // 1초씩 감소
        if (this.elapsedTime <= 0) {
          clearInterval(this.timer); // 타이머 종료
          this.nextQuestion(this.currentQuestion); // 0초가 되면 자동으로 다음 질문으로 넘어감
        }
      }, 1000); // 1초마다 실행
    },
    stopTimer() {
      clearInterval(this.timer);
    }
  },
};
</script>

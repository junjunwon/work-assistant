<template>
  <div class="container">
    <!-- 상단 로딩바 -->
    <LoadingBar :isLoading="isLoading" />
    <div class="card">
      <!-- 중간의 질문과 비디오 녹화 -->
      <div class="content">
        <div class="question-area">
          <p v-if="currentQuestion">{{ currentQuestion.question }}
            <span @click="generateSpeech" class="speaker -on"></span>
          </p>
          <p v-else>로딩 중...</p>
        </div>

        <div class="box" style="width: 800px">
          <p v-if="isRecording">REC {{ elapsedTime }} 초</p>
          <div class="video-area" style="float: center;">
            <video controls autoplay playsinline ref="video" height="400" width="600"></video>
            <div>
              <button class="button-small" id="btn-start-recording" :disabled="disabled" @click="startRec">녹화 시작</button>
              <button class="button-small" id="btn-stop-recording" :disabled="!disabled" @click="stopRec">녹화 중지</button>
              <button class="button-small" :disabled="disabled" @click="downloadRec" >다운로드</button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- 하단 버튼 -->
    <div class="box">
      <button class="button-small" v-if="currentQuestion" @click="previousQuestion()">이전 질문</button>
      <button class="button-small" v-if="currentQuestion" @click="nextQuestion(currentQuestion)">다음 질문</button>
      <button class="button-small" style="width: 250px" v-if="currentQuestion" @click="endInterview(currentQuestion)">답변 저장 후 면접 종료하기</button>
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
      disabled: false,
      recorder: null,
      synth: window.speechSynthesis,
      finalTranscripts: [], // 최종 결과
      isRecording: false, // 음성 인식 상태 확인
      recognition: null, // SpeechRecognition 객체 저장
      elapsedTime: 0, // 녹화 시간
      timer: null, // 타이머 변수,
      answerBlob: null
    };
  },
  computed: {
    ...mapState(['interviewQuestions', 'currentQuestionIndex', 'answers']),
    ...mapGetters(['currentQuestion'])
  },
  watch: {
    currentQuestionIndex(newIndex) {
      this.autoAnswer = this.answers[newIndex] || '';
    }
  },
  mounted() {
    this.autoAnswer = this.answers[this.currentQuestionIndex] || '';
  },
  methods: {
    ...mapMutations(['addInterviewQA', 'decrementQuestionIndex']),
    ...mapActions(['updateInterviewIndex', 'loadInterviewQuestions', 'saveSession']),
    updateAnswer(question) {
      this.addInterviewQA({"questionId": question.id, "question": question.question, "answer": this.autoAnswer});
    },
    previousQuestion() {
      if (this.currentQuestionIndex === 0) {
        alert('첫번째 질문입니다.');
        return;
      }
      this.decrementQuestionIndex();
    },
    nextQuestion(question) {
      if (this.currentQuestionIndex < this.interviewQuestions.length - 1) {
        this.updateAnswer(question);
        this.updateInterviewIndex();
        this.answer = '';
      } else {
        this.endInterview(question);
      }
    },
    async endInterview(question) {
      this.isLoading = true;
      await this.updateAnswer(question);
      await this.saveSession();
      this.isLoading = false;
      this.$router.push({ name: 'InterviewResult' });
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
    startRec() {
      this.finalTranscripts = [];
      this.$refs.video.srcObject = null;
      this.disabled = true;
      this.isRecording = true; // 녹화 중 상태로 변경
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
      this.startToWriteDown();
    },
    stopRec() {
      this.disabled = false;
      this.isRecording = false; // 녹화 중 상태 해제
      this.recorder.stopRecording(this.stopRecordingCallback);
      this.stopWritingDown();
      this.stopTimer(); // 타이머 중지
      this.autoAnswer = this.finalTranscripts.join(' ');
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
    stopRecordingCallback() {
      const video = this.$refs["video"];
      video.srcObject = null;
      video.muted = false;
      video.volume = 1;
      
      this.answerBlob = this.recorder.getBlob();

      this.recorder.camera.stop();
      this.recorder.destroy();
      this.recorder = null;
    },
    downloadRec() {
      if (!this.answerBlob) {
        alert('동영상 다운로드에 실패했습니다. 관리자에게 문의해주세요.');
        return;
      }
      const downloadLink = document.createElement('a');
      downloadLink.href = URL.createObjectURL(this.answerBlob);
      downloadLink.download = 'mock_interview_video.webm';
      downloadLink.click();
    },
    startTimer() {
      this.elapsedTime = 0;
      this.timer = setInterval(() => {
        this.elapsedTime++;
      }, 1000);
    },
    stopTimer() {
      clearInterval(this.timer);
    }
  },
};
</script>

<template>
  <div class="container">
    <LoadingBar :isLoading="isLoading" />
    <div class="card">
      <h2>면접 진행 중...</h2>
      <p v-if="currentQuestion">{{ currentQuestion.question }} <button class="secondary" @click="generateSpeech" >음성</button></p>
      <p v-else>로딩 중...</p>

      <input v-if="currentQuestion" type="text" v-model="answer" @keyup.enter="nextQuestion(currentQuestion)" placeholder="답변을 입력하세요" />
      <button class="primary" v-if="currentQuestion" @click="nextQuestion(currentQuestion)">다음 질문</button>
      <button class="primary" v-if="currentQuestion" @click="endInterview(currentQuestion)">답변 저장 후 면접 종료하기</button>
      <div>
        <button id="btn-start-recording" :disabled="disabled" @click="startRec" class="primary">녹화시작</button>
        <button id="btn-stop-recording" :disabled="!disabled" @click="stopRec" class="primary">녹화중지</button>
        <video controls autoplay playsinline ref="video" height="300" width="400"></video>
      </div>
      <p v-if="finalTranscripts.length">{{ finalTranscripts.join(' ') }}</p>
    </div>
  </div>
</template>

<script>
import axios from '../../plugins/axios';
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
      answer: '',
      disabled: false,
      recorder: null,
      synth: window.speechSynthesis,
      finalTranscripts: [], // 최종 결과
      isRecording: false, // 음성 인식 상태 확인
      recognition: null // SpeechRecognition 객체 저장
    };
  },
  computed: {
    ...mapState(['interviewQuestions', 'currentQuestionIndex', 'answers']),
    ...mapGetters(['currentQuestion'])
  },
  watch: {
    currentQuestionIndex(newIndex) {
      this.answer = this.answers[newIndex] || '';
    }
  },
  async created() {
    try {
      const response = await axios.get(`/public/interview/question/${this.$store.state.selectedRole.id}`);
      this.loadInterviewQuestions(response.data);
    } catch (error) {
      console.error('Error fetching quizzes:', error);
    }
  },
  mounted() {
    this.answer = this.answers[this.currentQuestionIndex] || '';
  },
  methods: {
    ...mapMutations(['addInterviewQuestion']),
    ...mapActions(['updateInterviewIndex', 'loadInterviewQuestions', 'saveSession']),
    updateAnswer(question) {
      console.log(question);
      this.addInterviewQuestion({"questionId": question.id, "question": question.question, "answer": this.answer});
    },
    nextQuestion(question) {
      this.updateAnswer(question);
      if (this.currentQuestionIndex < this.interviewQuestions.length - 1) {
        this.updateInterviewIndex();
        this.answer = '';
      } else {
        this.$router.push({ name: 'InterviewResult' });
      }
    },
    async endInterview(question) {
      this.isLoading = true; // 요청 시작 시 로딩바 표시
      await this.updateAnswer(question);
      await this.saveSession();
      this.isLoading = false; // 요청 완료 후 로딩바 숨기기
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
      // Web Speech API의 SpeechRecognition을 사용
      this.recognition = new (window.SpeechRecognition || window.webkitSpeechRecognition)();

      this.recognition.lang = 'ko-KR';
      this.recognition.interimResults = true; // 중간 결과 표시

      this.recognition.onresult = (event) => {
        let final = '';

        for (const result of event.results) {
          if (result.isFinal) {
            final += result[0].transcript;
          }
        }
        // 실시간으로 최종 결과 업데이트
        if (final) {
          this.finalTranscripts.push(final);
        }
      };

      this.recognition.onerror = (event) => {
        console.error('Speech recognition error:', event.error);
      };

      this.recognition.onend = () => {
        if (this.isRecording) {
          // 음성 인식이 종료되면 자동으로 다시 시작
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
      this.disabled = true;
      this.captureCamera(camera => {
        const video = this.$refs["video"];
        video.muted = true;
        video.volume = 0;
        video.srcObject = camera;
        this.recorder = RecordRTC(camera, {
          type: "video"
        });
        this.recorder.startRecording();
        this.recorder.camera = camera;

        this.disabled = true;
      });
      this.startToWriteDown();

    },
    stopRec() {
      this.disabled = false;
      this.recorder.stopRecording(this.stopRecordingCallback);
      this.stopWritingDown();
    },
    captureCamera(callback) {
      navigator.mediaDevices
          .getUserMedia({ audio: true, video: true })
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
      video.src = URL.createObjectURL(this.recorder.getBlob());

      this.recorder.camera.stop();
      this.recorder.destroy();
      this.recorder = null;
    },
  },
};
</script>

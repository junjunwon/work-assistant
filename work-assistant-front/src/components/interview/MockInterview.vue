<template>
  <div class="container">
    <div class="card">
      <h2>면접 진행 중...</h2>
      <p v-if="currentQuestion">{{ currentQuestion.question }} <button class="secondary" @click="generateSpeech" >음성</button></p>
      <p v-else>로딩 중...</p>

      <input v-if="currentQuestion" type="text" v-model="answer" @input="updateAnswer" placeholder="답변을 입력하세요" />
      <button class="primary" v-if="currentQuestion" @click="submitAnswer">다음 질문</button>
      <button class="primary" v-if="currentQuestion" @click="stopAndMoveToResult">면접 결과보기</button>
      <div>
        <button id="btn-start-recording" :disabled="disabled" @click="startRec" class="primary">녹화시작</button>
        <button id="btn-stop-recording" :disabled="!disabled" @click="stopRec" class="primary">녹화중지</button>
        <video controls autoplay playsinline ref="video" height="300" width="400"></video>
      </div>
    </div>
  </div>
</template>

<script>
import axios from '../../plugins/axios';
import { mapState, mapActions, mapGetters } from 'vuex';
import RecordRTC from "recordrtc";

export default {
  data() {
    return {
      answer: '',
      disabled: false,
      recorder: null,
      synth: window.speechSynthesis
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
  methods: {
    ...mapActions(['nextQuestion', 'setAnswer', 'loadInterviewQuestions']),
    updateAnswer() {
      this.setAnswer(this.answer);
    },
    submitAnswer() {
      this.updateAnswer();
      if (this.currentQuestionIndex < this.interviewQuestions.length - 1) {
        this.nextQuestion();
        this.answer = '';
      } else {
        this.$router.push({ name: 'InterviewResult' });
      }
    },
    stopAndMoveToResult() {
      this.updateAnswer();
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
    },
    stopRec() {
      this.disabled = false;
      this.recorder.stopRecording(this.stopRecordingCallback);
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
  }
};
</script>

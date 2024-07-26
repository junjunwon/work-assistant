<template>
  <div class="container">
    <div class="card">
      <h2>면접 진행 중...</h2>
      <p v-if="currentQuestion">{{ currentQuestion.question }}</p>
      <p v-else>로딩 중...</p>
      <input v-if="currentQuestion" type="text" v-model="answer" @input="updateAnswer" placeholder="답변을 입력하세요" />
      <button class="primary" v-if="currentQuestion" @click="submitAnswer">다음 질문</button>
      <button class="primary" v-if="currentQuestion" @click="stopAndMoveToResult">면접 결과보기</button>
    </div>
  </div>
</template>

<script>
import axios from '../../plugins/axios';
import { mapState, mapActions, mapGetters } from 'vuex';

export default {
  data() {
    return {
      answer: ''
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
  }
};
</script>

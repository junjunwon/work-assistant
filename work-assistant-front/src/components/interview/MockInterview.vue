<template>
  <div>
    <h2>면접 진행 중...</h2>
    <p v-if="currentQuestion">{{ currentQuestion.question }}</p>
    <p v-else>로딩 중...</p>
    <input v-if="currentQuestion" type="text" v-model="answer" placeholder="답변을 입력하세요" />
    <button v-if="currentQuestion" @click="nextQuestion">다음 질문</button>
  </div>
</template>

<script>
import axios from '../../plugins/axios';

export default {
  name: 'MockInterview',
  props: ['role'],
  data() {
    return {
      questions: [],
      currentQuestionIndex: 0,
      answer: ''
    };
  },
  async created() {
    try {
      const response = await axios.get(`/public/quiz/${this.role.id}`);
      this.questions = response.data;
      console.log(this.questions);
    } catch (error) {
      console.error('Error fetching quizzes:', error);
    }
  },
  computed: {
    currentQuestion() {
      return this.questions[this.currentQuestionIndex];
    }
  },
  methods: {
    nextQuestion() {
      if (this.currentQuestionIndex < this.questions.length - 1) {
        this.currentQuestionIndex++;
        this.answer = '';
      } else {
        this.$emit('interviewFinished');
      }
    }
  }
};
</script>

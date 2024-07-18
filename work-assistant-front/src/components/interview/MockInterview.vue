<template>
  <div>
    <h2>면접 진행 중...</h2>
    <p v-if="currentQuestion">{{ currentQuestion.question }}</p>
    <p v-else>로딩 중...</p>
    <input v-if="currentQuestion" type="text" v-model="answer" placeholder="답변을 입력하세요" />
    <button v-if="currentQuestion" @click="nextQuestionMethod">다음 질문</button>
  </div>
</template>

<script>
import { mapState, mapActions, mapGetters } from 'vuex';

export default {
  data() {
    return {
      answer: ''
    };
  },
  computed: {
    ...mapState(['interviewQuestions', 'currentQuestionIndex']),
    ...mapGetters(['currentQuestion'])
  },
  methods: {
    ...mapActions(['nextQuestion']),
    nextQuestionMethod() {
      if (this.currentQuestionIndex < this.interviewQuestions.length - 1) {
        this.nextQuestion();
        this.answer = '';
      } else {
        this.$router.push({ name: 'InterviewResult' });
      }
    }
  }
};
</script>

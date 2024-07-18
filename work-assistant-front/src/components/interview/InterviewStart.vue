<template>
  <div>
    <h2 v-if="selectedRole">{{ selectedRole.title }} 직무를 선택하였습니다.</h2>
    <p>면접 준비가 되었으면 "YES"를 눌러주세요!</p>
    <button @click="startInterview">YES</button>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex';

export default {
  computed: {
    ...mapState(['selectedRole'])
  },
  methods: {
    ...mapActions(['loadInterviewQuestions', 'resetInterview']),
    async startInterview() {
      // Mock data
      const questions = [
        { question: 'Tell me about yourself.' },
        { question: 'Why do you want to work here?' },
        // Add more questions as needed
      ];

      this.loadInterviewQuestions(questions);
      this.resetInterview();
      this.$router.push({ name: 'MockInterview' });
    }
  }
};
</script>

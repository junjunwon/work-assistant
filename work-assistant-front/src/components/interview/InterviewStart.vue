<template>
  <div class="container">
    <div class="card">
      <h2 v-if="selectedRole">{{ selectedRole.title }} 직무를 선택하였습니다.</h2>
      <p>면접 준비가 되었으면 "YES"를 눌러주세요!</p>
      <button class="primary large" @click="startInterview">YES</button>
    </div>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions } from 'vuex';

export default {
  mounted() {
    this.resetAnswers();
  },
  computed: {
    ...mapState(['selectedRole'])
  },
  methods: {
    ...mapMutations(['resetAnswers']),
    ...mapActions(['createSession', 'loadInterviewQuestions', 'resetInterview']),
    async startInterview() {
      await this.createSession();
      this.resetInterview();
      this.$router.push({ name: 'MockInterview' });
    }
  }
};
</script>

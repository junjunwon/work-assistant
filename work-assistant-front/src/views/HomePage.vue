<template>
  <div class="container">
    <div class="header">
      <h1>개발자 모의면접 사이트</h1>
      <h2>라이프타임 면접 준비 플랫폼</h2>
    </div>
    <div class="card">
      <button class="primary large" @click="goToInterviewSelection">유형별 면접보러가기</button>
      <!-- <button class="primary large" @click="goToCompanySelection">회사별 기출면접보러가기</button> -->
    </div>
  </div>
</template>
<script>
import { mapMutations } from 'vuex';
export default {
  name: 'HomePage',
  mounted() {
    this.resetState();
  },
  methods: {
    ...mapMutations(['resetState']),
    goToInterviewSelection() {
      this.$router.push({ name: 'InterviewSelection' });
    },
    goToCompanySelection() {
      alert("준비중입니다");
    }
  }
};
</script>

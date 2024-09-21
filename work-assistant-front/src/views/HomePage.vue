<template>
  <div class="container">
    <div class="header">
      <h1>퍼스널면접코치</h1>
      <h2>라이프타임 면접 준비 플랫폼</h2>
    </div>
    <div class="card">
      <button class="primary large" @click="goToJobSelection">직무별 면접보러가기</button>
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
    goToJobSelection() {
      this.$router.push({ name: 'JobSelection' });
    },
    goToCompanySelection() {
      alert("준비중입니다");
    }
  }
};
</script>

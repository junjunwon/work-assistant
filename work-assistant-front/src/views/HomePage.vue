<template>
  <div class="container">
    <div class="header">
      <h1>퍼스널면접코치</h1>
      <h2>라이프타임 면접 준비 플랫폼</h2>
    </div>
    <div class="card">
      <button class="button" @click="goToJobSelection">직무별 면접보러가기</button>
      <button class="button" @click="goToCompanySelection">회사별 기출면접보러가기</button>
    </div>
  </div>
</template>
<script>
export default {
  name: 'HomePage',
  methods: {
    goToJobSelection() {
      this.$router.push({ name: 'JobSelection' });
    },
    goToCompanySelection() {
      alert("준비중입니다");
    }
  }
};
</script>

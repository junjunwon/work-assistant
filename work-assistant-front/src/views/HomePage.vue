<template>
  <div class="container">
      <div class="box">
        <p class="title">면접만큼은 커밋 취소가 안 됩니다. <br />지금부터 리허설 시작!</p>
        <p class="subtitle">당신의 면접을 시뮬레이션 해보세요 🤓</p>
      </div>
      <div class="box">
        <button class="button-text" @click="goToInterviewSelection">START</button>
      </div>
      <div class="box image-box">
        <img src="@/assets/otter_ character.png" alt="면접 리허설 이미지" class="image" />
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

<template>
  <div class="container">
      <div class="box">
        <p class="title">면접만큼은 커밋 취소가 안 됩니다. <br />지금부터 모의면접 시작!</p>
        <p class="subtitle">개발자 면접 많이 어려우시죠? <br />면접 영상을 녹화하고 스스로 피드백해보세요 🤓</p>
        <button class="button-text" @click="goToInterviewSelection">START</button>
        <div class="image-box">
          <img style="width:400px; height: 400px;"
               src="@/assets/otter_ character.png" alt="면접 리허설 이미지" class="image" />
        </div>
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
    }
  }
};
</script>

<template>
  <div class="container">
    <div class="box">
      <h2 class="subtitle">개발자 모의면접 사이트에 오신 걸 환영합니다.</h2>
      <p class="subtitle">면접 유형을 선택해주세요.</p>
      <div class="box" v-for="interview in interviews" :key="interview.id">
        <button class="button-text" @click="selectInterviewMethod(interview)">{{ interview.title }}</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from '../../plugins/axios';
import { mapActions } from 'vuex';

export default {
  data() {
    return {
      interviews: []
    };
  },
  async created() {
    try {
      const response = await axios.get('/public/interviews');
      this.interviews = response.data;// 응답 데이터를 파싱하여 interviews 배열에 저장
    } catch (error) {
      this.interviews = [];
      console.error('Error fetching interviews:', error);
    }
    if (this.interviews.length > 0) {
      this.selectInterviewMethod(this.interviews[0]);
    }
  },
  methods: {
    ...mapActions(['selectInterview']),
    selectInterviewMethod(interview) {
      this.selectInterview(interview);
      this.$router.push({ name: 'SkillSelection' });
    }
  }
};
</script>

<style scoped>
/* 스타일 추가 가능 */
</style>

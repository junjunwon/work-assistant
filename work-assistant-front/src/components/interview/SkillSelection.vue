<template>
  <div class="container">
    <div class="card">
      <h2 v-if="selectedInterview">{{ selectedInterview.title }} 의 상세 기술을 선택해주세요.</h2>
      <h2 v-else>Loading...</h2>
      <div v-for="skill in skills" :key="skill.id">
        <button class="primary" @click="selectSkillMethod(skill)">{{ skill.title }}</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from '../../plugins/axios';
import { mapActions, mapState } from 'vuex';

export default {
  computed: {
    ...mapState(['selectedInterview'])
  },
  data() {
    return {
      skills: []
    };
  },
  async created() {
    if (this.selectedInterview && this.selectedInterview.id) {
      try {
        const response = await axios.get(`/public/skills/${this.selectedInterview.id}`);
        this.skills = response.data; // 응답 데이터를 파싱하여 skills 배열에 저장
      } catch (error) {
        console.error('Error fetching skills:', error);
      }
    }
  },
  methods: {
    ...mapActions(['selectSkill']),
    selectSkillMethod(skill) {
      this.selectSkill(skill);
      this.$router.push({ name: 'InterviewStart' });
    }
  }
};
</script>

<template>
  <div class="container">
    <div class="card">
      <h2 v-if="selectedJob">{{ selectedJob.title }} 직군의 상세 직무를 선택해주세요.</h2>
      <h2 v-else>Loading...</h2>
      <div v-for="role in roles" :key="role.id">
        <button @click="selectRoleMethod(role)">{{ role.title }}</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from '../../plugins/axios';
import { mapActions, mapState } from 'vuex';

export default {
  computed: {
    ...mapState(['selectedJob'])
  },
  data() {
    return {
      roles: []
    };
  },
  async created() {
    if (this.selectedJob && this.selectedJob.id) {
      try {
        const response = await axios.get(`/public/roles/${this.selectedJob.id}`);
        this.roles = response.data; // 응답 데이터를 파싱하여 roles 배열에 저장
      } catch (error) {
        console.error('Error fetching roles:', error);
      }
    }
  },
  methods: {
    ...mapActions(['selectRole']),
    selectRoleMethod(role) {
      this.selectRole(role);
      this.$router.push({ name: 'InterviewStart' });
    }
  }
};
</script>

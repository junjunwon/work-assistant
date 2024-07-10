<template>
    <div>
      <h2>{{ job.title }} 직군의 상세 직무를 선택해주세요.</h2>
      <div v-for="role in roles" :key="role.id">
        <button @click="selectRole(role)">{{ role.title }}</button>
      </div>
    </div>
  </template>
  
  <script>
  import axios from '../../plugins/axios';

  export default {
    props: ['job'],
    data() {
      return {
        roles: []
      };
    },
    async created() {
      const response = await axios.get(`/public/roles/${this.job.id}`);
      this.roles = await response.data; // 응답 데이터를 파싱하여 jobs 배열에 저장
    },
    methods: {
      selectRole(role) {
        this.$emit('roleSelected', role);
      }
    }
  };
  </script>
  
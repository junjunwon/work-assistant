<template>
    <div>
      <h2>나만의 면접트레이너에 오신 걸 환영합니다.</h2>
      <p>직군를 선택해주세요.</p>
      <div v-for="job in jobs" :key="job.id">
        <button @click="selectJob(job)">{{ job.title }}</button>
      </div>
    </div>
  </template>
  
  <script>
  import axios from '../../plugins/axios';
  
  export default {
    data() {
      return {
        jobs: []
      };
    },
    async created() {
      try {
        const response = await axios.get('/public/jobs');
        console.log(response);
        this.jobs = response.data; // 응답 데이터를 파싱하여 jobs 배열에 저장
      } catch (error) {
        console.error('Error fetching jobs:', error);
      }
    },
    methods: {
      selectJob(job) {
        this.$emit('jobSelected', job);
      }
    }
  };
  </script>
  
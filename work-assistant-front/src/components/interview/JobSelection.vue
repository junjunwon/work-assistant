<template>
  <div class="container">
    <div class="card">
      <h2>나만의 면접트레이너에 오신 걸 환영합니다.</h2>
      <p>직군을 선택해주세요.</p>
      <div v-for="job in jobs" :key="job.id">
        <button @click="selectJobMethod(job)">{{ job.title }}</button>
      </div>

      <div>
        <button @click="startRecording" :disabled="isRecording">녹화 시작</button>
        <button @click="stopRecording" :disabled="!isRecording">녹화 중지</button>
        <button @click="playRecording" :disabled="!recordedChunks.length">재생</button>
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
      jobs: [],
      mediaRecorder: null,
      recordedChunks: [],
      isRecording: false
    };
  },
  async created() {
    try {
      const response = await axios.get('/public/jobs');
      this.jobs = response.data; // 응답 데이터를 파싱하여 jobs 배열에 저장
    } catch (error) {
      console.error('Error fetching jobs:', error);
    }
  },
  methods: {
    ...mapActions(['selectJob']),
    selectJobMethod(job) {
      this.selectJob(job);
      this.$router.push({ name: 'RoleSelection' });
    },
    async startRecording() {
      const stream = await navigator.mediaDevices.getUserMedia({ audio: true, video: true });
      this.mediaRecorder = new MediaRecorder(stream);

      this.mediaRecorder.ondataavailable = (event) => {
        if (event.data.size > 0) {
          this.recordedChunks.push(event.data);
        }
      };

      this.mediaRecorder.start();
      this.isRecording = true;
    },
    stopRecording() {
      this.mediaRecorder.stop();
      this.isRecording = false;
    },
    playRecording() {
      const blob = new Blob(this.recordedChunks, { type: 'video/webm' });
      const url = URL.createObjectURL(blob);
      const video = document.createElement('video');
      video.src = url;
      video.controls = true;
      video.play();
      document.body.appendChild(video);
    }
  }
};
</script>

<style scoped>
/* 스타일 추가 가능 */
</style>

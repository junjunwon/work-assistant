<template>
  <div class="container">
    <div class="card">
      <h2>나만의 면접트레이너에 오신 걸 환영합니다.</h2>
      <p>직군을 선택해주세요.</p>
      <div v-for="job in jobs" :key="job.id">
        <button class="primary" @click="selectJobMethod(job)">{{ job.title }}</button>
      </div>
      <div>
        <button id="btn-start-recording" :disabled="disabled" @click="startRec" class="primary">녹화시작</button>
        <button id="btn-stop-recording" :disabled="!disabled" @click="stopRec" class="primary">녹화중지</button>
        <video controls autoplay playsinline ref="video" height="500" width="700"></video>
      </div>
    </div>
  </div>
</template>

<script>
import axios from '../../plugins/axios';
import { mapActions } from 'vuex';
import RecordRTC from "recordrtc";

export default {
  data() {
    return {
      jobs: [],
      recorder: null,
      disabled: false
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
    startRec() {
      this.disabled = true;
      this.captureCamera(camera => {
        const video = this.$refs["video"];
        video.muted = true;
        video.volume = 0;
        video.srcObject = camera;
        this.recorder = RecordRTC(camera, {
          type: "video"
        });
        this.recorder.startRecording();
        this.recorder.camera = camera;

        this.disabled = true;
      });
    },
    stopRec() {
      this.disabled = false;
      this.recorder.stopRecording(this.stopRecordingCallback);
    },
    captureCamera(callback) {
      navigator.mediaDevices
          .getUserMedia({ audio: true, video: true })
          .then(function(camera) {
            callback(camera);
          })
          .catch(function(error) {
            alert("Unable to capture your camera. Please check console logs.");
            console.error(error);
          });
    },
    stopRecordingCallback() {
      const video = this.$refs["video"];
      video.srcObject = null;
      video.muted = false;
      video.volume = 1;
      video.src = URL.createObjectURL(this.recorder.getBlob());

      this.recorder.camera.stop();
      this.recorder.destroy();
      this.recorder = null;
    },

  }
};
</script>

<style scoped>
/* 스타일 추가 가능 */
</style>

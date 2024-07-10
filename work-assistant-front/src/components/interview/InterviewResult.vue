<template>
    <div>
      <h2>모든 면접이 종료되었습니다.</h2>
      <p>결과를 확인해볼까요?</p>
      <button @click="showResult">확인하러가기</button>
      <div v-if="showingResult">
        <p>ChatGPT 평가점수: 82 / 100</p>
        <button @click="downloadFeedback">피드백 다운로드 (유료 서비스)</button>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        showingResult: false
      };
    },
    methods: {
      showResult() {
        this.showingResult = true;
      },
      downloadFeedback() {
        alert('피드백 다운로드는 유료 서비스입니다.');
      }
    }
  };
  </script>
  
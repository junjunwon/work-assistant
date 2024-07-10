<template>
    <div>
      <h2>{{ role.title }} 직무를 선택하였습니다.</h2>
      <p>면접 준비가 되었으면 "YES"를 눌러주세요!</p>
      <button @click="startInterview">YES</button>
    </div>
  </template>
  
  <script>
  export default {
    props: ['role'],
    methods: {
      startInterview() {
        this.$emit('interviewStarted');
      }
    }
  };
  </script>
  
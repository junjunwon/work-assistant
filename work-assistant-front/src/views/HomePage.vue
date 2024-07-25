<template>
  <div class="container">
    <div class="header">
      <h1>퍼스널면접코치</h1>
      <h2>라이프타임 면접 준비 플랫폼</h2>
    </div>
    <div class="card">
      <p>This is a sample card component styled with global CSS.</p>
      <button class="button" @click="goToJobSelection">Click Me</button>
    </div>
  </div>
</template>
<script>
export default {
  name: 'HomePage',
  methods: {
    goToJobSelection() {
      this.$router.push({ name: 'JobSelection' });
    }
  }
};
</script>

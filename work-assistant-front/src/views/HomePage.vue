<template>
  <div>
    <h1>Home Page</h1>
    <button @click="goToJobSelection">Go to Job Selection</button>
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

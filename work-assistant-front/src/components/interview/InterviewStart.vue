<template>
  <div class="container">
    <div class="card">
      <h2 v-if="selectedSkill">{{ selectedSkill.title }}를 선택하였습니다.</h2>
      <label for="numberSelect">질문 개수 선택:</label>
      <NumberComboBox :maxNumber="30" v-model="selectedNumber" />
      <p>면접 준비가 되었으면 "YES"를 눌러주세요!</p>
      <button class="primary large" @click="startInterview">YES</button>
    </div>
  </div>
</template>

<script>
import axios from '../../plugins/axios';
import NumberComboBox from '../util/NumberComboBox.vue';
import { mapState, mapMutations, mapActions } from 'vuex';

export default {
  components: {
    NumberComboBox
  },
  data() {
    return {
      selectedNumber: null
    }
    
  },
  mounted() {
    this.resetAnswers();
  },
  computed: {
    ...mapState(['selectedSkill'])
  },
  methods: {
    ...mapMutations(['resetAnswers']),
    ...mapActions(['createSession', 'loadInterviewQuestions', 'resetInterview']),
    async startInterview() {
      await this.createSession();
      await this.resetInterview();

      try {
        const response = await axios.get(`/public/interview/question/${this.$store.state.selectedSkill.id}`, {
          params: {numberOfQuestions: this.selectedNumber}
        });
        this.loadInterviewQuestions(response.data);
      } catch (error) {
        console.error('Error fetching quizzes:', error);
      }

      this.$router.push({ name: 'MockInterview' });
    }
  }
};
</script>

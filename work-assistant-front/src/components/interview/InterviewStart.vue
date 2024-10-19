<template>
  <div class="container">
    <div class="card">
      <h2 v-if="selectedSkill">
        선택하신 {{ selectedSkill.title }}에 관련한 질문
        <NumberComboBox :maxNumber="30" v-model="selectedNumber" />
        개로 면접이 진행됩니다.
      </h2>
      <p class="box">면접 준비가 되었으면 "YES"를 눌러주세요!</p>

      <div class="box">
        <button class="button-text" @click="startInterview">YES</button>
      </div>
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

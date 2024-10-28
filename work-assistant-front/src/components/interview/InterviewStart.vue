<template>
  <div class="container step3">
    <div class="card">
      <h2 v-if="selectedSkill">
        선택하신 {{ selectedSkill.title }}에 관련한 질문
        <NumberComboBox :maxNumber="30" v-model="selectedNumber" />
        개로 면접이 진행됩니다.
      </h2>
      <p class="box">
        면접 시작 시 마이크와 카메라가 활성화되며,<br>
        <span style="color: #894cff;">녹화된 영상은 종료 즉시 안전하게 삭제</span>됩니다.<br>
        안심하고 이용하세요! 😌
      </p>
      <p class="box">
        이제, 면접을 시작해 볼까요?
        <br>
        준비가 되었으면 "START"를 눌러주세요!
      </p>

      <div class="box">
        <button class="button-text" @click="startInterview">START</button>
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
      selectedNumber: 5
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

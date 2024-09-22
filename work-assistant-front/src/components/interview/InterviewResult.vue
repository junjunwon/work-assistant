<template>
  <div class="container">
    <div class="card">
      <h2>모든 면접이 종료되었습니다.</h2>
      <p >결과를 확인해볼까요?</p>
      <button class="primary large" @click="showResult">확인하러가기</button>
      <button class="primary large" @click="restartInterview">처음으로 가기</button>
      <div v-if="showingResult">
        <!-- 결과 테이블 -->
        <div class="response-table">
          <div class="session-info">
            <h4>직종 : {{ responseData.jobTitle }}</h4>
            <h4>직무 : {{ responseData.roleTitle }}</h4>
          </div>
          <table>
            <thead>
              <tr>
                <th>질문</th>
                <th>작성한 답변</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(item, index) in responseData.questionAnswerResponses" :key="index">
                <td>{{ item.question }}</td>
                <td>{{ item.answer || '답변 없음' }}</td>
              </tr>
            </tbody>
          </table>
        </div>
        <!-- <button class="primary large" @click="downloadFeedback">피드백 다운로드 (유료 서비스)</button> -->
        <button class="primary large" @click="restartInterview">처음으로 가기</button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapMutations, mapActions } from 'vuex';

export default {
  data() {
    return {
      showingResult: false,
      responseData: {
        sessionId: null,
        jobTitle: '',
        roleTitle: '',
        questionAnswerResponses: []
      }
    };
  },
  async mounted() {
    const sessionResponse = await this.getSessionResult();
    this.responseData = sessionResponse.data;
    if (this.responseData !== null) {
      this.showingResult = true;
    }
  },
  methods: {
    ...mapMutations(['resetState']),
    ...mapActions(['saveInterviewResults', 'getSessionResult']),
    async downloadFeedback() {
      const result = await this.saveInterviewResults();
      if (result) {
        const blob = new Blob([JSON.stringify(result)], { type: 'application/json' });
        const url = URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = 'interview_results.json';
        a.click();
        URL.revokeObjectURL(url);
      } else {
        alert('질의응답 다운로드 중 오류가 발생했습니다.');
      }
    },
    restartInterview() {
      this.resetState();
      this.$router.push({ name: 'Home' });
    }
  }
};
</script>

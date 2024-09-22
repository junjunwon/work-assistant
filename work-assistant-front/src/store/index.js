import { createStore } from 'vuex';
import createPersistedState from 'vuex-persistedstate';
import axios from '../plugins/axios';

const store = createStore({
  state: {
    selectedJob: null,
    selectedRole: null,
    interviewQuestions: [],
    currentQuestionIndex: 0,
    answers: [],
    sessionId: null
  },
  mutations: {
    setSelectedJob(state, job) {
      state.selectedJob = job;
    },
    setSelectedRole(state, role) {
      state.selectedRole = role;
    },
    setInterviewQuestions(state, questions) {
      state.interviewQuestions = questions;
    },
    incrementQuestionIndex(state) {
      state.currentQuestionIndex++;
    },
    resetQuestionIndex(state) {
      state.currentQuestionIndex = 0;
    },
    // 개별 질문을 추가하는 mutation
    addInterviewQuestion(state, answer) {
      state.answers.push(answer); // 질의응답을 배열에 추가
    },
    resetState(state) {
      state.selectedJob = null;
      state.selectedRole = null;
      state.interviewQuestions = [];
      state.currentQuestionIndex = 0;
      state.answers = [];
    },
    resetAnswers(state) {
      state.currentQuestionIndex = 0;
      state.answers = [];
    },
    setSessionId(state, sessionId) {
      state.sessionId = sessionId;
    }
  },
  actions: {
    selectJob({ commit }, job) {
      commit('setSelectedJob', job);
    },
    selectRole({ commit }, role) {
      commit('setSelectedRole', role);
    },
    loadInterviewQuestions({ commit }, questions) {
      commit('setInterviewQuestions', questions);
    },
    updateInterviewIndex({ commit }) {
      commit('incrementQuestionIndex');
    },
    resetInterview({ commit }) {
      commit('resetQuestionIndex');
    },
    resetState({ commit }) {
      commit('resetState');
    },
    async createSession({ commit, state }) {
      try {
        const response = await axios.post('/public/interview/session', {
          jobId: state.selectedJob.id,
          roleId: state.selectedRole.id
        });
        commit('setSessionId', response.data);
      } catch (error) {
        console.error('Error creating session:', error);
      }
    },
    saveSession({ state }) {
      const sessionId = state.sessionId;
      try {
        axios.put(`/public/interview/session/${sessionId}/answers`, 
          JSON.parse(JSON.stringify(state.answers)))
      } catch (error) {
        console.error('Error saveing session:', error);
      }
    },
    getSessionResult({ state }) {
      const params = {
        sessionId : state.sessionId
      }
      try {
        return axios.get('/public/interview/session', {params})
      } catch (error) {
        console.error('Error get session:', error);
      }
    }
  },
  getters: {
    currentQuestion(state) {
      return state.interviewQuestions[state.currentQuestionIndex] || null;
    }
  },
  plugins: [createPersistedState({
    storage: window.localStorage,
  })],
});

export default store;

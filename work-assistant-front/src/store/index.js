import { createStore } from 'vuex';

const store = createStore({
  state: {
    selectedJob: null,
    selectedRole: null,
    interviewQuestions: [],
    currentQuestionIndex: 0
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
    resetState(state) {
      state.selectedJob = null;
      state.selectedRole = null;
      state.interviewQuestions = [];
      state.currentQuestionIndex = 0;
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
    nextQuestion({ commit }) {
      commit('incrementQuestionIndex');
    },
    resetInterview({ commit }) {
      commit('resetQuestionIndex');
    },
    resetState({ commit }) {
      commit('resetState');
    }
  },
  getters: {
    currentQuestion(state) {
      return state.interviewQuestions[state.currentQuestionIndex];
    }
  }
});

export default store;

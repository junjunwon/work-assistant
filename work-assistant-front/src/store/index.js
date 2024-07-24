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
    setAnswer(state, { index, answer }) {
      state.answers[index] = answer;
    },
    resetState(state) {
      state.selectedJob = null;
      state.selectedRole = null;
      state.interviewQuestions = [];
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
    nextQuestion({ commit }) {
      commit('incrementQuestionIndex');
    },
    resetInterview({ commit }) {
      commit('resetQuestionIndex');
    },
    resetState({ commit }) {
      commit('resetState');
    },
    setAnswer({ commit, state }, answer) {
      commit('setAnswer', { index: state.currentQuestionIndex, answer });
    },
    async saveInterviewResults({ state }) {
      try {
        const response = await axios.post('/public/interview/answers', {
          job: state.selectedJob,
          role: state.selectedRole,
          questions: state.interviewQuestions,
          answers: state.answers
        });
        return response.data;
      } catch (error) {
        console.error('Error saving interview results:', error);
      }
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

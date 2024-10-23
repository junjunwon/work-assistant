import { createStore } from 'vuex';
import createPersistedState from 'vuex-persistedstate';
import axios from '../plugins/axios';

const store = createStore({
  state: {
    selectedInterview: null,
    selectedSkill: null,
    interviewQuestions: [],
    currentQuestionIndex: 0,
    answers: [],
    sessionId: null
  },
  mutations: {
    setSelectedInterview(state, interview) {
      state.selectedInterview = interview;
    },
    setSelectedSkill(state, skill) {
      state.selectedSkill = skill;
    },
    setInterviewQuestions(state, questions) {
      state.interviewQuestions = questions;
    },
    incrementQuestionIndex(state) {
      state.currentQuestionIndex++;
    },
    decrementQuestionIndex(state) {
      state.currentQuestionIndex--;
    },
    resetQuestionIndex(state) {
      state.currentQuestionIndex = 0;
    },
    // 개별 질의응답을 추가하는 mutation
    addInterviewQA(state, value) {
      state.answers.push(value); // 질의응답을 배열에 추가
    },
    resetState(state) {
      state.sessionId= null
      state.selectedInterview = null;
      state.selectedSkill = null;
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
    selectInterview({ commit }, interview) {
      commit('setSelectedInterview', interview);
    },
    selectSkill({ commit }, skill) {
      commit('setSelectedSkill', skill);
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
          interviewId: state.selectedInterview.id,
          skillId: state.selectedSkill.id
        });
        commit('setSessionId', response.data);
      } catch (error) {
        console.error('Error creating session:', error);
      }
    },
    async saveSession({ state }) {
      const sessionId = state.sessionId;
      try {
        await axios.put(`/public/interview/session/${sessionId}/answers`, 
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

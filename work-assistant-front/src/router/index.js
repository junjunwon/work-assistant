import { createRouter, createWebHistory } from 'vue-router';
import store from '../store';
import HomePage from '../views/HomePage.vue';
import InterviewSelection from '../components/interview/InterviewSelection.vue';
import InterviewResult from '../components/interview/InterviewResult.vue';
import MockInterview from '../components/interview/MockInterview.vue';
import InterviewStart from '../components/interview/InterviewStart.vue';
import SkillSelection from '../components/interview/SkillSelection.vue';
import CoupangAd from '@/components/util/\bCoupangAd.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomePage
  },
  {
    path: '/interview-selection',
    name: 'InterviewSelection',
    component: InterviewSelection
  },
  {
    path: '/interview-result',
    name: 'InterviewResult',
    component: InterviewResult
  },
  {
    path: '/mock-interview',
    name: 'MockInterview',
    component: MockInterview
  },
  {
    path: '/interview-start',
    name: 'InterviewStart',
    component: InterviewStart
  },
  {
    path: '/skill-selection',
    name: 'SkillSelection',
    component: SkillSelection,
    props: route => ({ interview: route.params.interview })
  },
  {
    path: '/coupang-ad',
    name: 'CoupangAd',
    component: CoupangAd
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

router.beforeEach((to, from, next) => {
  const allowedPaths = ['/', '/interview-selection', '/skill-selection', '/interview-start', '/coupang-ad'];
  console.log("to.path: " + to.path + ", sessionId: " + store.state.sessionId);
  if (!allowedPaths.includes(to.path) && !store.state.sessionId) {
    next('/');
  } else {
    next();
  }
});
export default router;
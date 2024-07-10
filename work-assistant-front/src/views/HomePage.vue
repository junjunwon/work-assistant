<template>
  <div>
    <JobSelection v-if="step === 1" @jobSelected="onJobSelected" />
    <RoleSelection v-if="step === 2" :job="selectedJob" @roleSelected="onRoleSelected" />
    <InterviewStart v-if="step === 3" :role="selectedRole" @interviewStarted="onInterviewStarted" />
    <MockInterview v-if="step === 4" :role="selectedRole" @interviewFinished="onInterviewFinished" />
    <InterviewResult v-if="step === 5" />
  </div>
</template>

<script>
import JobSelection from '@/components/interview/JobSelection.vue';
import RoleSelection from '@/components/interview/RoleSelection.vue';
import InterviewStart from '@/components/interview/InterviewStart.vue';
import MockInterview from '@/components/interview/MockInterview.vue';
import InterviewResult from '@/components/interview/InterviewResult.vue';

export default {
  data() {
    return {
      step: 1,
      selectedJob: null,
      selectedRole: null
    };
  },
  methods: {
    onJobSelected(job) {
      this.selectedJob = job;
      this.step = 2;
    },
    onRoleSelected(role) {
      this.selectedRole = role;
      this.step = 3;
    },
    onInterviewStarted() {
      this.step = 4;
    },
    onInterviewFinished() {
      this.step = 5;
    }
  },
  components: {
    JobSelection,
    RoleSelection,
    InterviewStart,
    MockInterview,
    InterviewResult
  }
};
</script>

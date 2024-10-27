(function(){"use strict";var e={4217:function(e,t,s){var n=s(5130),i=s(6768);const r={id:"app"};function o(e,t,s,n,o,a){const c=(0,i.g2)("router-view");return(0,i.uX)(),(0,i.CE)("div",r,[(0,i.bF)(c)])}var a={name:"App"},c=s(1241);const l=(0,c.A)(a,[["render",o]]);var u=l,d=s(1387),h=(s(4114),s(782)),v=s(5131),p=s(4373);const w=p.A.create({baseURL:"https://myinterviewscoach.com/api",headers:{"Content-Type":"application/json"}});var m=w;const k=(0,h.y$)({state:{selectedInterview:null,selectedSkill:null,interviewQuestions:[],currentQuestionIndex:0,answers:[],sessionId:null},mutations:{setSelectedInterview(e,t){e.selectedInterview=t},setSelectedSkill(e,t){e.selectedSkill=t},setInterviewQuestions(e,t){e.interviewQuestions=t},incrementQuestionIndex(e){e.currentQuestionIndex++},decrementQuestionIndex(e){e.currentQuestionIndex--},resetQuestionIndex(e){e.currentQuestionIndex=0},addInterviewQA(e,t){e.answers.push(t)},resetState(e){e.sessionId=null,e.selectedInterview=null,e.selectedSkill=null,e.interviewQuestions=[],e.currentQuestionIndex=0,e.answers=[]},resetAnswers(e){e.currentQuestionIndex=0,e.answers=[]},setSessionId(e,t){e.sessionId=t}},actions:{selectInterview({commit:e},t){e("setSelectedInterview",t)},selectSkill({commit:e},t){e("setSelectedSkill",t)},loadInterviewQuestions({commit:e},t){e("setInterviewQuestions",t)},updateInterviewIndex({commit:e}){e("incrementQuestionIndex")},resetInterview({commit:e}){e("resetQuestionIndex")},resetState({commit:e}){e("resetState")},async createSession({commit:e,state:t}){try{const s=await m.post("/public/interview/session",{interviewId:t.selectedInterview.id,skillId:t.selectedSkill.id});e("setSessionId",s.data)}catch(s){console.error("Error creating session:",s)}},async saveSession({state:e}){const t=e.sessionId;try{await m.put(`/public/interview/session/${t}/answers`,JSON.parse(JSON.stringify(e.answers)))}catch(s){console.error("Error saveing session:",s)}},getSessionResult({state:e}){const t={sessionId:e.sessionId};try{return m.get("/public/interview/session",{params:t})}catch(s){console.error("Error get session:",s)}}},getters:{currentQuestion(e){return e.interviewQuestions[e.currentQuestionIndex]||null}},plugins:[(0,v.A)({storage:window.localStorage})]});var b=k,g=s.p+"img/otter_ character.54004d54.png";const I={class:"container"},f={class:"box"},S=(0,i.Lk)("p",{class:"title"},[(0,i.eW)("면접만큼은 커밋 취소가 안 됩니다. "),(0,i.Lk)("br"),(0,i.eW)("지금부터 리허설 시작!")],-1),y=(0,i.Lk)("p",{class:"subtitle"},"당신의 면접을 시뮬레이션 해보세요 🤓",-1),L=(0,i.Lk)("div",{class:"image-box"},[(0,i.Lk)("img",{style:{width:"400px",height:"400px"},src:g,alt:"면접 리허설 이미지",class:"image"})],-1);function C(e,t,s,n,r,o){return(0,i.uX)(),(0,i.CE)("div",I,[(0,i.Lk)("div",f,[S,y,(0,i.Lk)("button",{class:"button-text",onClick:t[0]||(t[0]=(...e)=>o.goToInterviewSelection&&o.goToInterviewSelection(...e))},"START"),L])])}var x={name:"HomePage",mounted(){this.resetState()},methods:{...(0,h.PY)(["resetState"]),goToInterviewSelection(){this.$router.push({name:"InterviewSelection"})}}};const Q=(0,c.A)(x,[["render",C]]);var R=Q,A=s(4232);const E=e=>((0,i.Qi)("data-v-32b8bc5f"),e=e(),(0,i.jt)(),e),T={class:"container"},X={class:"box"},_=E((()=>(0,i.Lk)("h2",{class:"subtitle"},"개발자 모의면접 사이트에 오신 걸 환영합니다.",-1))),O=E((()=>(0,i.Lk)("p",{class:"subtitle"},"면접 유형을 선택해주세요.",-1))),N=["onClick"];function $(e,t,s,n,r,o){return(0,i.uX)(),(0,i.CE)("div",T,[(0,i.Lk)("div",X,[_,O,((0,i.uX)(!0),(0,i.CE)(i.FK,null,(0,i.pI)(r.interviews,(e=>((0,i.uX)(),(0,i.CE)("div",{class:"box",key:e.id},[(0,i.Lk)("button",{class:"button-text",onClick:t=>o.selectInterviewMethod(e)},(0,A.v_)(e.title),9,N)])))),128))])])}var j={data(){return{interviews:[]}},async created(){try{const e=await m.get("/public/interviews");this.interviews=e.data}catch(e){this.interviews=[],console.error("Error fetching interviews:",e)}this.interviews.length>0&&this.selectInterviewMethod(this.interviews[0])},methods:{...(0,h.i0)(["selectInterview"]),selectInterviewMethod(e){this.selectInterview(e),this.$router.push({name:"SkillSelection"})}}};const B=(0,c.A)(j,[["render",$],["__scopeId","data-v-32b8bc5f"]]);var q=B;const M={class:"container"},P={class:"card"},D=(0,i.Lk)("h2",{class:"box"},"모든 면접이 종료되었습니다.",-1),U=(0,i.Lk)("p",{class:"box"},"결과를 확인해볼까요?",-1),F={key:0},V={class:"response-table"},H={class:"session-info"},W=(0,i.Lk)("thead",null,[(0,i.Lk)("tr",null,[(0,i.Lk)("th",null,"질문"),(0,i.Lk)("th",null,"문항별 추천 답변"),(0,i.Lk)("th",null,"문항별 영상 다운로드")])],-1),Y=["onClick"],K={key:1},J={class:"box"};function z(e,t,s,n,r,o){return(0,i.uX)(),(0,i.CE)("div",M,[(0,i.Lk)("div",P,[D,U,r.showingResult?((0,i.uX)(),(0,i.CE)("div",F,[(0,i.Lk)("div",V,[(0,i.Lk)("div",H,[(0,i.Lk)("h4",null,"인터뷰 유형 : "+(0,A.v_)(r.responseData.interviewTitle),1),(0,i.Lk)("h4",null,"기술 : "+(0,A.v_)(r.responseData.skillTitle),1)]),(0,i.Lk)("table",null,[W,(0,i.Lk)("tbody",null,[((0,i.uX)(!0),(0,i.CE)(i.FK,null,(0,i.pI)(r.responseData.questionAnswerResponses,((e,t)=>((0,i.uX)(),(0,i.CE)("tr",{key:t},[(0,i.Lk)("td",null,(0,A.v_)(e.question),1),(0,i.Lk)("td",null,(0,A.v_)(e.idealAnswer||"준비중"),1),(0,i.Lk)("td",null,[e.answerBlob?((0,i.uX)(),(0,i.CE)("button",{key:0,onClick:s=>o.downloadAnswerBlob(e.answerBlob,t)}," 내 답변 다시보기 ",8,Y)):((0,i.uX)(),(0,i.CE)("span",K,"저장된 영상 없음"))])])))),128))])])])])):(0,i.Q3)("",!0),(0,i.Lk)("div",J,[(0,i.Lk)("button",{onClick:t[0]||(t[0]=(...e)=>o.restartInterview&&o.restartInterview(...e))},"처음으로 가기")])])])}s(4603),s(7566),s(8721);var G={data(){return{showingResult:!1,responseData:{sessionId:null,interviewTitle:"",skillTitle:"",questionAnswerResponses:[]}}},async mounted(){this.responseData.sessionId=this.$store.state.sessionId,this.responseData.interviewTitle=this.$store.state.selectedInterview.title,this.responseData.skillTitle=this.$store.state.selectedSkill.title,this.responseData.questionAnswerResponses=this.$store.state.answers,null!==this.responseData&&(this.showingResult=!0)},computed:{...(0,h.L8)(["getAnswers","getSelectedInterview","getSelectedSkill","getSessionId"])},methods:{...(0,h.PY)(["resetState"]),...(0,h.i0)(["saveInterviewResults","getSessionResult"]),downloadAnswerBlob(e,t){const s=document.createElement("a");s.href=URL.createObjectURL(e),s.download=`mock_interview_video_${t+1}.webm`,s.click()},async downloadFeedback(){const e=await this.saveInterviewResults();if(e){const t=new Blob([JSON.stringify(e)],{type:"application/json"}),s=URL.createObjectURL(t),n=document.createElement("a");n.href=s,n.download="interview_results.json",n.click(),URL.revokeObjectURL(s)}else alert("질의응답 다운로드 중 오류가 발생했습니다.")},restartInterview(){this.resetState(),this.$router.push({name:"Home"})}}};const Z=(0,c.A)(G,[["render",z]]);var ee=Z;const te={class:"container"},se={class:"card"},ne={class:"content"},ie={class:"question-area"},re={key:0},oe={key:1},ae={class:"box",style:{width:"800px"}},ce={key:0},le={class:"video-area",style:{float:"center"}},ue={controls:"",autoplay:"",playsinline:"",ref:"video",height:"400",width:"600"},de={class:"box"};function he(e,t,s,n,r,o){const a=(0,i.g2)("LoadingBar");return(0,i.uX)(),(0,i.CE)("div",te,[(0,i.bF)(a,{isLoading:r.isLoading},null,8,["isLoading"]),(0,i.Lk)("div",se,[(0,i.Lk)("div",ne,[(0,i.Lk)("div",ie,[(0,i.Lk)("p",null,(0,A.v_)(e.currentQuestionIndex)+" / "+(0,A.v_)(e.interviewQuestions.length),1),e.currentQuestion?((0,i.uX)(),(0,i.CE)("p",re,[(0,i.eW)((0,A.v_)(e.currentQuestion.question)+" ",1),(0,i.Lk)("span",{onClick:t[0]||(t[0]=(...e)=>o.generateSpeech&&o.generateSpeech(...e)),class:"speaker -on"})])):((0,i.uX)(),(0,i.CE)("p",oe,"로딩 중..."))]),(0,i.Lk)("div",ae,[r.isRecording?((0,i.uX)(),(0,i.CE)("p",ce,"REC "+(0,A.v_)(o.minutes)+"분 "+(0,A.v_)(o.seconds)+"초",1)):(0,i.Q3)("",!0),(0,i.Lk)("div",le,[(0,i.Lk)("video",ue,null,512),(0,i.Lk)("div",null,[(0,i.Lk)("button",{class:"button-small",id:"btn-start-recording",onClick:t[1]||(t[1]=(...e)=>o.stopAndstartRec&&o.stopAndstartRec(...e))},"다시 녹화")])])])])]),(0,i.Lk)("div",de,[e.currentQuestion?((0,i.uX)(),(0,i.CE)("button",{key:0,class:"button-small",onClick:t[2]||(t[2]=t=>o.nextQuestion(e.currentQuestion))},"다음 질문")):(0,i.Q3)("",!0),e.currentQuestion?((0,i.uX)(),(0,i.CE)("button",{key:1,class:"button-small",style:{width:"250px"},onClick:t[3]||(t[3]=t=>o.endInterview(e.currentQuestion))},"답변 저장 후 면접 종료하기")):(0,i.Q3)("",!0)])])}var ve=s(5890),pe=s.n(ve);const we={key:0,class:"loading-bar"};function me(e,t,s,n,r,o){return s.isLoading?((0,i.uX)(),(0,i.CE)("div",we,"Loading...")):(0,i.Q3)("",!0)}var ke={props:{isLoading:{type:Boolean,required:!0}}};const be=(0,c.A)(ke,[["render",me]]);var ge=be,Ie={components:{LoadingBar:ge},data(){return{isLoading:!1,autoAnswer:"",recorder:null,synth:window.speechSynthesis,finalTranscripts:[],isRecording:!1,recognition:null,elapsedTime:180,timer:null,answerBlob:null}},computed:{...(0,h.aH)(["interviewQuestions","currentQuestionIndex","answers"]),...(0,h.L8)(["currentQuestion"]),minutes(){return Math.floor(this.elapsedTime/60)},seconds(){return this.elapsedTime%60}},watch:{currentQuestionIndex(e){this.autoAnswer=this.answers[e]||""}},mounted(){this.autoAnswer=this.answers[this.currentQuestionIndex]||"",this.startRec()},methods:{...(0,h.PY)(["addInterviewQA","decrementQuestionIndex"]),...(0,h.i0)(["updateInterviewIndex","loadInterviewQuestions","saveSession"]),updateAnswer(e){this.addInterviewQA({questionId:e.id,question:e.question,idealAnswer:e.idealAnswer,answer:this.autoAnswer,answerBlob:this.answerBlob})},previousQuestion(){0!==this.currentQuestionIndex?this.decrementQuestionIndex():alert("첫번째 질문입니다.")},async nextQuestion(e){this.currentQuestionIndex<this.interviewQuestions.length-1?(await this.stopRec(),this.updateAnswer(e),this.updateInterviewIndex(),this.answer="",this.startRec()):await this.endInterview(e)},async endInterview(e){this.isLoading=!0,await this.stopRec(),this.updateAnswer(e),this.$router.push({name:"CoupangAd"}),this.isLoading=!1},generateSpeech(){const e=this.currentQuestion.question;this.textToSpeech(e)},textToSpeech(e){const t=new SpeechSynthesisUtterance(e);this.synth.speak(t)},startToWriteDown(){this.recognition=new(window.SpeechRecognition||window.webkitSpeechRecognition),this.recognition.lang="ko-KR",this.recognition.interimResults=!0,this.recognition.onresult=e=>{let t="";for(const s of e.results)s.isFinal&&(t+=s[0].transcript);t&&this.finalTranscripts.push(t)},this.recognition.onerror=e=>{console.error("Speech recognition error:",e.error)},this.recognition.onend=()=>{this.isRecording&&this.recognition.start()},this.isRecording=!0,this.finalTranscripts=[],this.recognition.start()},stopWritingDown(){this.recognition&&this.recognition.stop(),this.isRecording=!1},async stopAndstartRec(){await this.stopRec(),this.startRec()},startRec(){this.finalTranscripts=[],this.$refs.video.srcObject=null,this.captureCamera((e=>{const t=this.$refs["video"];t.muted=!0,t.volume=0,t.srcObject=e,this.recorder=pe()(e,{type:"video",mimeType:"video/webm",videoBitsPerSecond:25e5,frameRate:30}),this.recorder.startRecording(),this.recorder.camera=e,this.startTimer()})),this.isRecording=!0},captureCamera(e){navigator.mediaDevices.getUserMedia({video:{width:{ideal:1280},height:{ideal:720},frameRate:{ideal:30,max:60}},audio:!0}).then((function(t){e(t)})).catch((function(e){alert("Unable to capture your camera. Please check console logs."),console.error(e)}))},stopRec(){return new Promise((e=>{this.stopTimer();try{this.recorder.stopRecording(this.stopRecordingCallback),this.isRecording=!1,this.recorder.stopRecording((()=>{this.stopRecordingCallback(),e()})),this.autoAnswer=this.finalTranscripts.join(" "),this.isRecording=!1}catch(t){alert("비디오가 로딩중입니다. 잠시만 기다려주세요.")}}))},stopRecordingCallback(){const e=this.$refs["video"];e&&(e.srcObject=null,e.muted=!1,e.volume=1),this.answerBlob=this.recorder.getBlob(),this.recorder.camera.stop(),this.recorder.destroy(),this.recorder=null},startTimer(){this.elapsedTime=180,this.timer=setInterval((()=>{this.elapsedTime--,this.elapsedTime<=0&&(clearInterval(this.timer),this.nextQuestion(this.currentQuestion))}),1e3)},stopTimer(){clearInterval(this.timer)}}};const fe=(0,c.A)(Ie,[["render",he]]);var Se=fe;const ye={class:"container"},Le={class:"card"},Ce={key:0},xe=(0,i.Lk)("p",{class:"box"},'면접 준비가 되었으면 "YES"를 눌러주세요!',-1),Qe={class:"box"};function Re(e,t,s,n,r,o){const a=(0,i.g2)("NumberComboBox");return(0,i.uX)(),(0,i.CE)("div",ye,[(0,i.Lk)("div",Le,[e.selectedSkill?((0,i.uX)(),(0,i.CE)("h2",Ce,[(0,i.eW)(" 선택하신 "+(0,A.v_)(e.selectedSkill.title)+"에 관련한 질문 ",1),(0,i.bF)(a,{maxNumber:30,modelValue:r.selectedNumber,"onUpdate:modelValue":t[0]||(t[0]=e=>r.selectedNumber=e)},null,8,["modelValue"]),(0,i.eW)(" 개로 면접이 진행됩니다. ")])):(0,i.Q3)("",!0),xe,(0,i.Lk)("div",Qe,[(0,i.Lk)("button",{class:"button-text",onClick:t[1]||(t[1]=(...e)=>o.startInterview&&o.startInterview(...e))},"YES")])])])}const Ae=["value"];function Ee(e,t,s,r,o,a){return(0,i.bo)(((0,i.uX)(),(0,i.CE)("select",{"onUpdate:modelValue":t[0]||(t[0]=e=>o.selectedNumber=e),id:"numberSelect",onChange:t[1]||(t[1]=(...e)=>a.emitSelectedNumber&&a.emitSelectedNumber(...e))},[((0,i.uX)(!0),(0,i.CE)(i.FK,null,(0,i.pI)(a.numbers,(e=>((0,i.uX)(),(0,i.CE)("option",{key:e,value:e},(0,A.v_)(e),9,Ae)))),128))],544)),[[n.u1,o.selectedNumber]])}var Te={props:{maxNumber:{type:Number,required:!0},modelValue:{type:Number,default:null}},data(){return{selectedNumber:this.modelValue}},computed:{numbers(){return Array.from({length:this.maxNumber},((e,t)=>t+1))}},methods:{emitSelectedNumber(){this.$emit("update:modelValue",this.selectedNumber)}},watch:{modelValue(e){this.selectedNumber=e}}};const Xe=(0,c.A)(Te,[["render",Ee]]);var _e=Xe,Oe={components:{NumberComboBox:_e},data(){return{selectedNumber:5}},mounted(){this.resetAnswers()},computed:{...(0,h.aH)(["selectedSkill"])},methods:{...(0,h.PY)(["resetAnswers"]),...(0,h.i0)(["createSession","loadInterviewQuestions","resetInterview"]),async startInterview(){await this.createSession(),await this.resetInterview();try{const e=await m.get(`/public/interview/question/${this.$store.state.selectedSkill.id}`,{params:{numberOfQuestions:this.selectedNumber}});this.loadInterviewQuestions(e.data)}catch(e){console.error("Error fetching quizzes:",e)}this.$router.push({name:"MockInterview"})}}};const Ne=(0,c.A)(Oe,[["render",Re]]);var $e=Ne;const je={class:"container"},Be={class:"card"},qe={key:0,class:"subtitle"},Me={key:1},Pe={class:"box"},De=["onClick"];function Ue(e,t,s,n,r,o){return(0,i.uX)(),(0,i.CE)("div",je,[(0,i.Lk)("div",Be,[e.selectedInterview?((0,i.uX)(),(0,i.CE)("h2",qe,(0,A.v_)(e.selectedInterview.title)+"의 상세 기술을 선택해주세요.",1)):((0,i.uX)(),(0,i.CE)("h2",Me,"Loading...")),(0,i.Lk)("div",Pe,[((0,i.uX)(!0),(0,i.CE)(i.FK,null,(0,i.pI)(r.skills,(e=>((0,i.uX)(),(0,i.CE)("button",{class:"rect",key:e.id,onClick:t=>o.selectSkillMethod(e)},(0,A.v_)(e.title),9,De)))),128))])])])}var Fe={computed:{...(0,h.aH)(["selectedInterview"])},data(){return{skills:[]}},async created(){if(this.selectedInterview&&this.selectedInterview.id)try{const e=await m.get(`/public/skills/${this.selectedInterview.id}`);this.skills=e.data}catch(e){console.error("Error fetching skills:",e)}},methods:{...(0,h.i0)(["selectSkill"]),selectSkillMethod(e){this.selectSkill(e),this.$router.push({name:"InterviewStart"})}}};const Ve=(0,c.A)(Fe,[["render",Ue]]);var He=Ve;const We={class:"ad-container"},Ye=["innerHTML"];function Ke(e,t,s,n,r,o){return(0,i.uX)(),(0,i.CE)("div",We,[(0,i.Lk)("button",{class:"button-small",onClick:t[0]||(t[0]=(...e)=>o.showResult&&o.showResult(...e))},"결과 바로보기"),(0,i.Lk)("div",{innerHTML:r.coupangAd},null,8,Ye)])}var Je={data(){return{coupangAd:'<a href="https://link.coupang.com/a/bXyVen" target="_blank" referrerpolicy="unsafe-url">\n            <img src="https://ads-partners.coupang.com/banners/767228?subId=&traceId=V0-301-879dd1202e5c73b2-I767228&w=320&h=480" alt="">\n            </a>'}},methods:{showResult(){this.$router.push({name:"InterviewResult"})}}};const ze=(0,c.A)(Je,[["render",Ke]]);var Ge=ze;const Ze=[{path:"/",name:"Home",component:R},{path:"/interview-selection",name:"InterviewSelection",component:q},{path:"/interview-result",name:"InterviewResult",component:ee},{path:"/mock-interview",name:"MockInterview",component:Se},{path:"/interview-start",name:"InterviewStart",component:$e},{path:"/skill-selection",name:"SkillSelection",component:He,props:e=>({interview:e.params.interview})},{path:"/coupang-ad",name:"CoupangAd",component:Ge}],et=(0,d.aE)({history:(0,d.LA)("/"),routes:Ze});et.beforeEach(((e,t,s)=>{const n=["/","/interview-selection","/skill-selection","/interview-start","/coupang-ad"];console.log("to.path: "+e.path+", sessionId: "+b.state.sessionId),n.includes(e.path)||b.state.sessionId?s():s("/")}));var tt=et;(0,n.Ef)(u).use(tt).use(b).mount("#app")}},t={};function s(n){var i=t[n];if(void 0!==i)return i.exports;var r=t[n]={exports:{}};return e[n].call(r.exports,r,r.exports,s),r.exports}s.m=e,function(){var e=[];s.O=function(t,n,i,r){if(!n){var o=1/0;for(u=0;u<e.length;u++){n=e[u][0],i=e[u][1],r=e[u][2];for(var a=!0,c=0;c<n.length;c++)(!1&r||o>=r)&&Object.keys(s.O).every((function(e){return s.O[e](n[c])}))?n.splice(c--,1):(a=!1,r<o&&(o=r));if(a){e.splice(u--,1);var l=i();void 0!==l&&(t=l)}}return t}r=r||0;for(var u=e.length;u>0&&e[u-1][2]>r;u--)e[u]=e[u-1];e[u]=[n,i,r]}}(),function(){s.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return s.d(t,{a:t}),t}}(),function(){s.d=function(e,t){for(var n in t)s.o(t,n)&&!s.o(e,n)&&Object.defineProperty(e,n,{enumerable:!0,get:t[n]})}}(),function(){s.g=function(){if("object"===typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(e){if("object"===typeof window)return window}}()}(),function(){s.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)}}(),function(){s.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})}}(),function(){s.p="/"}(),function(){var e={524:0};s.O.j=function(t){return 0===e[t]};var t=function(t,n){var i,r,o=n[0],a=n[1],c=n[2],l=0;if(o.some((function(t){return 0!==e[t]}))){for(i in a)s.o(a,i)&&(s.m[i]=a[i]);if(c)var u=c(s)}for(t&&t(n);l<o.length;l++)r=o[l],s.o(e,r)&&e[r]&&e[r][0](),e[r]=0;return s.O(u)},n=self["webpackChunkPersonal_Interview_Coach"]=self["webpackChunkPersonal_Interview_Coach"]||[];n.forEach(t.bind(null,0)),n.push=t.bind(null,n.push.bind(n))}();var n=s.O(void 0,[504],(function(){return s(4217)}));n=s.O(n)})();
//# sourceMappingURL=app.7053f6aa.js.map
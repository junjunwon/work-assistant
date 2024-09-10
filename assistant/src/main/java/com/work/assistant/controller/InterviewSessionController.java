package com.work.assistant.controller;

import com.work.assistant.interview.entity.InterviewAnswer;
import com.work.assistant.interview.model.InterviewAnswerRequest;
import com.work.assistant.interview.model.InterviewSessionRequest;
import com.work.assistant.interview.service.InterviewSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/public/interview/session")
@RestController
@RequiredArgsConstructor
public class InterviewSessionController {

    private final InterviewSessionService interviewSessionService;

    @PostMapping
    public ResponseEntity<Long> createSession(@RequestBody InterviewSessionRequest sessionRequest) {
        return ResponseEntity.ok(interviewSessionService.save(sessionRequest));
    }

    //코드개선 필요 -> 세션을 저장하면 답도 같이 저장되어야하는거 아닌가? (답은 또 질문 id를 가지고 있어서)
    @PutMapping("/{sessionId}/answers")
    public ResponseEntity saveSession(@PathVariable long sessionId, @RequestBody List<InterviewAnswerRequest> answers) {
        interviewSessionService.saveSession(sessionId, answers);
        return ResponseEntity.ok("세션Id " + sessionId + "에 해당하는 질문 모음 등록 성공");
    }

    //코드개선 필요
    @PutMapping("/{sessionId}/end")
    public ResponseEntity endSession(@PathVariable int sessionId) {
        interviewSessionService.endSession(sessionId);
        return ResponseEntity.ok("성공적으로 세션 종료");
    }
}

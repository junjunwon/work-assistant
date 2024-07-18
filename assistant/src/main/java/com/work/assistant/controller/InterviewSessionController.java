package com.work.assistant.controller;

import com.work.assistant.interview.entity.InterviewAnswer;
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

    //코드개선 필요
    @PostMapping("/{sessionId}/answers")
    public ResponseEntity saveAnswers(@PathVariable int sessionId, @RequestBody List<InterviewAnswer> answers) {
        interviewSessionService.saveAnswers(sessionId, answers);
        return ResponseEntity.ok("세션Id " + sessionId + "에 해당하는 질문 모음 등록 성공");
    }

    //코드개선 필요
    @PutMapping("/{sessionId}/end")
    public ResponseEntity endSession(@PathVariable int sessionId) {
        interviewSessionService.endSession(sessionId);
        return ResponseEntity.ok("성공적으로 세션 종료");
    }
}

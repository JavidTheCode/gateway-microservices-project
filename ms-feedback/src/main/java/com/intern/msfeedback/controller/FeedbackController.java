package com.intern.msfeedback.controller;

import com.intern.msfeedback.dto.FeedbackRequest;
import com.intern.msfeedback.dto.FeedbackResponse;
import com.intern.msfeedback.service.FeedbackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @PostMapping
    public FeedbackResponse createFeedback(@Valid @RequestBody FeedbackRequest request) {
        return feedbackService.createFeedback(request);
    }

    @GetMapping
    public List<FeedbackResponse> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }
}

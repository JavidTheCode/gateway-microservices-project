package com.intern.msfeedback.service;

import com.intern.msfeedback.dto.FeedbackRequest;
import com.intern.msfeedback.dto.FeedbackResponse;
import com.intern.msfeedback.entity.Feedback;
import com.intern.msfeedback.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public FeedbackResponse createFeedback(FeedbackRequest request) {
        Feedback feedback = Feedback.builder()
                .userEmail(request.getUserEmail())
                .message(request.getMessage())
                .build();

        Feedback saved = feedbackRepository.save(feedback);

        return mapToResponse(saved);
    }

    public List<FeedbackResponse> getAllFeedbacks() {
        return feedbackRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private FeedbackResponse mapToResponse(Feedback feedback) {
        return FeedbackResponse.builder()
                .id(feedback.getId())
                .userEmail(feedback.getUserEmail())
                .message(feedback.getMessage())
                .build();
    }
}

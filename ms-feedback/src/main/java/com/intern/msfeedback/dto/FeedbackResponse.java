package com.intern.msfeedback.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FeedbackResponse {
    private Long id;
    private String userEmail;
    private String message;
}

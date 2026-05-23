package com.intern.msfeedback.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackRequest {
    @Email
    @NotBlank
    private String userEmail;

    @NotBlank
    @Size(max = 100)
    private String message;
}

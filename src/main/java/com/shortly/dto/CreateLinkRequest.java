package com.shortly.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateLinkRequest {

    @NotBlank(message = "URL is required")
    @Pattern(
            regexp = "^(https?://).+",
            message = "Please enter a valid URL starting with http:// or https://"
    )
    private String originalUrl;

}
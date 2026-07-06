package com.shortly.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateLinkRequest {

    @NotBlank
    private String originalUrl;

}
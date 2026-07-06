package com.shortly.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LinkResponse {

    private Long id;

    private String originalUrl;

    private String shortUrl;

    private String shortCode;

    private Long clickCount;

}
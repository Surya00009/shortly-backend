package com.shortly.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnalyticsResponse {

    private Long totalLinks;

    private Long totalClicks;

    private Double averageClicks;

    private String mostClickedLink;

}
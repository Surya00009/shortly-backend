package com.shortly.controller;

import com.shortly.dto.AnalyticsResponse;
import com.shortly.entity.User;
import com.shortly.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final LinkService linkService;

    @GetMapping
    public AnalyticsResponse getAnalytics(
            @AuthenticationPrincipal User user) {

        return linkService.getAnalytics(user);
    }
}
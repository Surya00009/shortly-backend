package com.shortly.controller;

import com.shortly.dto.CreateLinkRequest;
import com.shortly.dto.LinkResponse;
import com.shortly.entity.User;
import com.shortly.service.LinkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/links")
@RequiredArgsConstructor
public class LinkController {

    private final LinkService linkService;

    @PostMapping
    public LinkResponse createLink(
            @Valid @RequestBody CreateLinkRequest request,
            @AuthenticationPrincipal User user) {

        return linkService.createLink(request, user);
    }

    @GetMapping
    public List<LinkResponse> getUserLinks(
            @AuthenticationPrincipal User user) {

        return linkService.getUserLinks(user);
    }

    @DeleteMapping("/{id}")
    public void deleteLink(@PathVariable Long id) {

        linkService.deleteLink(id);
    }

}
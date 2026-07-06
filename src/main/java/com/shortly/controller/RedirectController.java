package com.shortly.controller;

import com.shortly.entity.Link;
import com.shortly.exception.LinkNotFoundException;
import com.shortly.repository.LinkRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class RedirectController {

    private final LinkRepository linkRepository;

    @GetMapping("/redirect-test")
    public String redirectTest() {
        return "Redirect Controller Working";
    }

    @GetMapping("/r/{shortCode}")
    public void redirect(
            @PathVariable String shortCode,
            HttpServletResponse response)
            throws IOException {

        Link link = linkRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new LinkNotFoundException("Link not found"));

        link.setClickCount(link.getClickCount() + 1);
        linkRepository.save(link);

        response.sendRedirect(link.getOriginalUrl());
    }
}

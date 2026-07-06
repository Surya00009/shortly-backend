package com.shortly.mapper;

import com.shortly.dto.LinkResponse;
import com.shortly.entity.Link;

public class LinkMapper {

    public static LinkResponse toResponse(Link link) {

        return LinkResponse.builder()
                .id(link.getId())
                .originalUrl(link.getOriginalUrl())
                .shortCode(link.getShortCode())
                .shortUrl(buildShortUrl(link))
                .clickCount(link.getClickCount())
                .build();

    }

    public static String buildShortUrl(Link link) {

        return "http://localhost:8080/r/" + link.getShortCode();

    }

}
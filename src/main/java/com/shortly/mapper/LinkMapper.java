package com.shortly.mapper;

import com.shortly.dto.LinkResponse;
import com.shortly.entity.Link;

public class LinkMapper {

    public static LinkResponse toResponse(Link link, String shortUrl) {

        return LinkResponse.builder()
                .id(link.getId())
                .originalUrl(link.getOriginalUrl())
                .shortCode(link.getShortCode())
                .shortUrl(shortUrl)
                .clickCount(link.getClickCount())
                .build();

    }

}
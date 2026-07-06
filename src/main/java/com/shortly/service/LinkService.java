package com.shortly.service;

import com.shortly.dto.AnalyticsResponse;
import com.shortly.dto.CreateLinkRequest;
import com.shortly.dto.LinkResponse;
import com.shortly.entity.User;

import java.util.List;

public interface LinkService {

    LinkResponse createLink(CreateLinkRequest request, User user);

    List<LinkResponse> getUserLinks(User user);

    void deleteLink(Long id);

    AnalyticsResponse getAnalytics(User user);

}
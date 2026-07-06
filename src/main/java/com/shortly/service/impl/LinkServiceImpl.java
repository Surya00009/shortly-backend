package com.shortly.service.impl;

import com.shortly.dto.AnalyticsResponse;
import com.shortly.dto.CreateLinkRequest;
import com.shortly.dto.LinkResponse;
import com.shortly.entity.Link;
import com.shortly.entity.User;
import com.shortly.mapper.LinkMapper;
import com.shortly.repository.LinkRepository;
import com.shortly.service.LinkService;
import com.shortly.util.ShortCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;

    @Override
    public LinkResponse createLink(CreateLinkRequest request, User user) {

        Optional<Link> existingLink =
                linkRepository.findByOriginalUrlAndUser(
                        request.getOriginalUrl(),
                        user
                );

        if (existingLink.isPresent()) {
            return LinkMapper.toResponse(existingLink.get());
        }

        String shortCode;

        do {
            shortCode = ShortCodeGenerator.generate(6);
        } while (linkRepository.existsByShortCode(shortCode));

        Link link = Link.builder()
                .originalUrl(request.getOriginalUrl())
                .shortCode(shortCode)
                .clickCount(0L)
                .user(user)
                .build();

        linkRepository.save(link);

        return LinkMapper.toResponse(link);
    }

    @Override
    public List<LinkResponse> getUserLinks(User user) {

        return linkRepository.findByUser(user)
                .stream()
                .map(LinkMapper::toResponse)
                .toList();

    }

    @Override
    public void deleteLink(Long id) {

        linkRepository.deleteById(id);

    }

    @Override
    public AnalyticsResponse getAnalytics(User user) {

        List<Link> links = linkRepository.findByUser(user);

        long totalLinks = links.size();

        long totalClicks = links.stream()
                .mapToLong(Link::getClickCount)
                .sum();

        double averageClicks =
                totalLinks == 0
                        ? 0
                        : (double) totalClicks / totalLinks;

        String mostClickedLink = links.stream()
                .max(Comparator.comparingLong(Link::getClickCount))
                .map(LinkMapper::buildShortUrl)
                .orElse("-");

        return AnalyticsResponse.builder()
                .totalLinks(totalLinks)
                .totalClicks(totalClicks)
                .averageClicks(averageClicks)
                .mostClickedLink(mostClickedLink)
                .build();
    }
}
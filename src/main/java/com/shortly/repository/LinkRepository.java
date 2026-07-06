package com.shortly.repository;

import com.shortly.entity.Link;
import com.shortly.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Long> {

    Optional<Link> findByShortCode(String shortCode);

    boolean existsByShortCode(String shortCode);

    List<Link> findByUser(User user);

    Optional<Link> findByOriginalUrlAndUser(String originalUrl, User user);

}
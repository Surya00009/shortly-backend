package com.shortly.repository;

import com.shortly.entity.ClickAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClickAnalyticsRepository extends JpaRepository<ClickAnalytics, Long> {
}
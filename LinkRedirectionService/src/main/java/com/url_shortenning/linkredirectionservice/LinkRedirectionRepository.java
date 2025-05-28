package com.url_shortenning.linkredirectionservice;

import com.url_shortenning.linkredirectionservice.Dtos.UrlResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinkRedirectionRepository extends JpaRepository<UrlResponse, Long> {
    Optional<UrlResponse> findByOutputUrl(String code);
}

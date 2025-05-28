package com.url_shortenning.linkgenerationservice;

import com.url_shortenning.linkgenerationservice.dto.UrlResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinkGenerationRepository extends JpaRepository<UrlResponse, Long> {

    Optional<UrlResponse> findByInputUrl(String url);
}

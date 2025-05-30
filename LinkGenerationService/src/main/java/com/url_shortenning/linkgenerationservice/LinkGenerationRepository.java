package com.url_shortenning.linkgenerationservice;

import com.url_shortenning.linkgenerationservice.dto.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinkGenerationRepository extends JpaRepository<UrlEntity, Long> {

    Optional<UrlEntity> findByInputUrl(String url);
}

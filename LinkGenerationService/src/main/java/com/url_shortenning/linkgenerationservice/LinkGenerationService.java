package com.url_shortenning.linkgenerationservice;

import com.url_shortenning.linkgenerationservice.dto.UrlDto;
import com.url_shortenning.linkgenerationservice.dto.UrlEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
@Transactional
public class LinkGenerationService {

    private final LinkGenerationRepository repository;
    private final String baseUrl = "http://localhost:8000/";

    @Cacheable(value = "urlResponse", key = "#url.inputUrl")
    public UrlEntity shortenUrl(UrlDto url) {

        String hash = MD5(url.getInputUrl()).substring(0, 7);

        return repository.findByInputUrl(url.getInputUrl()).orElseGet(() -> {
            UrlEntity response = new UrlEntity(
                    url.getInputUrl(),
                    hash
            );
            repository.save(response);

            return new UrlEntity(
                    url.getInputUrl(),
                    baseUrl + hash
            );
        });
    }

    private String MD5(String url) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(url.getBytes());
            StringBuilder sb = new StringBuilder();

            for (byte b : digest) sb.append(String.format("%02x", b));

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.url_shortenning.linkgenerationservice;

import com.url_shortenning.linkgenerationservice.dto.UrlDto;
import com.url_shortenning.linkgenerationservice.dto.UrlResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class LinkGenerationService {

    private final LinkGenerationRepository repository;
    private final String baseUrl = "http://localhost:8000/";

    public UrlResponse shortenUrl(UrlDto url) {

        String hash = MD5(url.getInputUrl()).substring(0, 7);

        return repository.findByInputUrl(url.getInputUrl()).orElseGet(() -> {
            UrlResponse response = new UrlResponse(
                    url.getInputUrl(),
                    baseUrl + hash
            );

            repository.save(response);

            return new UrlResponse(
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

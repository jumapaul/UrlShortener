package com.url_shortenning.linkredirectionservice;

import com.url_shortenning.linkredirectionservice.Dtos.UrlResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LinkRedirectionService {

    private final LinkRedirectionRepository repository;

    @Cacheable(value = "output", key = "#code")
    public String getOriginalUrl(String code) {
        Optional<UrlResponse> response = repository.findByOutputUrl(code);

        if (response.isEmpty()) {
            return "Not found";
        }

        return response.get().getInputUrl();
    }
}


//Here we go

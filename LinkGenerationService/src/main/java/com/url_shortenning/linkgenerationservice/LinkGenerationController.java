package com.url_shortenning.linkgenerationservice;

import com.url_shortenning.linkgenerationservice.dto.UrlDto;
import com.url_shortenning.linkgenerationservice.dto.UrlResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class LinkGenerationController {
    private final LinkGenerationService service;

    //Remove
    @PostMapping("Shorten")
    public ResponseEntity<UrlResponse> shortenUrl(
            @RequestBody UrlDto request
    ) {
        return ResponseEntity.ok(service.shortenUrl(request));
    }
}

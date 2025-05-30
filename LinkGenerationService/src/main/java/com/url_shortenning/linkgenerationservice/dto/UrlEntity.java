package com.url_shortenning.linkgenerationservice.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "urls")
public class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String inputUrl;
    private String outputUrl;

    public UrlEntity(String inputUrl, String outputUrl) {
        this.inputUrl = inputUrl;
        this.outputUrl = outputUrl;
    }
}

package org.example.youtube_downloader.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient ytDlpRestClient(
            @Value("${ytdlp.base-url}") String ytDlpBaseUrl
    ) {
        return RestClient.builder()
                .baseUrl(ytDlpBaseUrl)
                .build();
    }
}
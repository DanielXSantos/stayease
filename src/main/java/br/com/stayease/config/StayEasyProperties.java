package br.com.stayease.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties(prefix = "stayease", ignoreUnknownFields = false)
public class StayEasyProperties {

    private String title;
    private String description;
    private String version;
    private String endpointsPackage;
}

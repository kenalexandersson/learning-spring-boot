package com.greglturnquist.learningspringboot.learningspringboot;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class LearningSpringBootHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        try {
            URL url = new URL("http://localhost:8080");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            int statusCode = conn.getResponseCode();
            if (statusCode >= 200 && statusCode < 300) {
                return Health.up().build();
            } else {
                return Health.down()
                        .withDetail("HTTP Status Code", statusCode)
                        .build();
            }
        } catch (IOException e) {
            return Health.down(e).build();
        }
    }
}
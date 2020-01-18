package com.greglturnquist.learningspringboot.learningspringboot;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ImageRepository extends ReactiveCrudRepository<Image, String> {
    Mono<Image> findByName(String name);
}
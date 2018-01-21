package com.learning.spring;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.learning.spring.repository")
@EntityScan("com.learning.spring.domain")
public class RootConfig {
}

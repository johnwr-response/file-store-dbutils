package no.responseweb.imagearchive.filestoredbservice.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages={"no.responseweb.imagearchive.filestoredbservice"})
@EntityScan(basePackages = "no.responseweb.imagearchive.filestoredbservice.domain")
@ComponentScan(basePackages = {"no.responseweb.imagearchive.filestoredbservice.bootstrap", "no.responseweb.imagearchive.filestoredbservice.mappers", "no.responseweb.imagearchive.filestoredbservice.services"})
public class DBModuleConfig {
}

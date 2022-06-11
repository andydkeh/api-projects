package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EmployeeRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Projeto("PROJETO 1", "MAGAZINE LUIZA", "CARLOS ROBERTO", 4)));
      log.info("Preloading " + repository.save(new Projeto("PROJETO 2", "HH", "MARIANA SILVA", 999)));
      log.info("Preloading " + repository.save(new Projeto("PROJETO 3", "NIKE", "ANTONIO CABERTO", 1)));
      log.info("Preloading " + repository.save(new Projeto("PROJETO 4", "PP", "LUIZA SILVAS", 76)));
    };
  }
}
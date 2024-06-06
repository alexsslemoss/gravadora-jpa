package com.example.demo;

import com.example.demo.entity.Autor;
import com.example.demo.repository.AutorRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Log4j2
public class Demo1Application implements CommandLineRunner {

    @Autowired
    private AutorRepository autorRepository;

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final var autors = this.autorRepository.findAll();
        autors.forEach(autor -> log.info(autor.getMusicas()));
    }
}

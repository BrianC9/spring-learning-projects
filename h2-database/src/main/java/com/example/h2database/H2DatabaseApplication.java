package com.example.h2database;

import com.example.h2database.model.Book;
import com.example.h2database.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class H2DatabaseApplication {

    public static void main(String[] args) {

       SpringApplication.run(H2DatabaseApplication.class, args);

    }
    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository){
        return args -> {
            repository.save(new Book(null,"Narnia",300,"Autora"));
        };
    }

}

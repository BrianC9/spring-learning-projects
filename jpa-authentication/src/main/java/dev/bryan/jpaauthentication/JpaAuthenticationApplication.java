package dev.bryan.jpaauthentication;

import dev.bryan.jpaauthentication.model.Post;
import dev.bryan.jpaauthentication.model.User;
import dev.bryan.jpaauthentication.repository.PostRespository;
import dev.bryan.jpaauthentication.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaAuthenticationApplication {

    public static void main(String[] args) {

        SpringApplication.run(JpaAuthenticationApplication.class, args);


    }

    @Bean
    CommandLineRunner commandLineRunner(PostRespository postRespository, UserRepository userRepository){
        System.out.println("Ejecutando Command Line Runner");
        return args -> {
            userRepository.save(new User("bryan","bryan","ROLE_USER"));
            userRepository.save(new User("raquel","raquel","ROLE_USER,ROLE_ADMIN"));
            postRespository.save(new Post("Creating a blog post","creating-a-blog","Welcome to my blog. Lets create","Bryan"));
        };
    }
}

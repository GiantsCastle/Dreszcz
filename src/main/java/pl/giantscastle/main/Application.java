package pl.giantscastle.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import pl.giantscastle.entities.User;
import pl.giantscastle.entities.Character;
import pl.giantscastle.entities.Variable;

@SpringBootApplication
@ComponentScan("pl.giantscastle.*")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
      
        
    }
}

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
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        User user1 = new User();
        User user2 = new User();
        Character character1 = new Character();
        Character character2 = new Character();    
        Character character3 = new Character();  
        
        user1.setUserName("Arek");
        user1.setUserEmail("arek@gmail.com");
        user1.setUserPassword("hasloArka");

        user2.setUserName("Marcin");
        user2.setUserEmail("marcin@gmail.com");
        user2.setUserPassword("hasloMarcina");

        character1.setCharacterName("Geralt");
        character1.setUser(user1);
        
        character2.setCharacterName("Triss");
        character2.setUser(user2);
        
        character3.setCharacterName("Naizdup");
        character3.setUser(user2);

        
        entityManager.getTransaction().begin();
        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.persist(character1);
        entityManager.persist(character2);
        entityManager.persist(character3);
        entityManager.getTransaction().commit();
        
        entityManager.close();
        entityManagerFactory.close();
        
    }
}

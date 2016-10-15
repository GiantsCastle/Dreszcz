package pl.giantscastle.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pl.giantscastle.main.domain.User;
import pl.giantscastle.main.domain.Character;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		User user1 = new User();
		Character character1 = new Character();
		user1.setCharacterId(character1.getCharacterId());
		user1.setUserName("Remizer");
		character1.setCharacterName("Geralt");
		
		User user2 = new User();
		Character character2 = new Character();
		user2.setCharacterId(character2.getCharacterId());
		user2.setUserName("DrillR");
		character2.setCharacterName("Triss");
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(user1);
		entityManager.persist(character1);
		entityManager.persist(user2);
		entityManager.persist(character2);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
    }

}

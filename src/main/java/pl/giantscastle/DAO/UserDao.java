package pl.giantscastle.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import pl.giantscastle.model.Character;
import pl.giantscastle.model.User;

@Repository
public class UserDao {
	
	public User create(String userName, String userEmail,
			String userPassword) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//tworzenie w bazie rekordu nowego użytkownika
		User user = new User();
		user.setUserName(userName);
		user.setUserEmail(userEmail);
		user.setUserPassword(userPassword);
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return user;
	}
	
	public String getID(String userName) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		User user = entityManager.find(User.class, userName);
		String userID = user.getUserId();
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return userID;
	}
	
	public User get(long id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		User user = entityManager.find(User.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return user;
	}
	
	public User get(String userName) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		User user = entityManager.find(User.class, userName);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return user;
	}
	
	public User get(Character character) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		long id = character.getCharacterId();
		TypedQuery<User> queryDoor = entityManager.createQuery("select e from User e where e characterId = '"+id+"'", User.class);
		User user = queryDoor.getSingleResult();
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return user;
	}
	
	public void setName(User user, String name) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		user.setUserName(name);
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public void setEmail(User user, String email) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		user.setUserEmail(email);
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public void setPassword(User user, String password) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		user.setUserPassword(password);
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public void remove(User user) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.remove(user);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public void remove(long id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		TypedQuery<User> queryDoor = entityManager.createQuery("select e from User e where e userId = '" + id + "'",
				User.class);
		User user = queryDoor.getSingleResult();

		entityManager.getTransaction().begin();
		entityManager.remove(user);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}
}

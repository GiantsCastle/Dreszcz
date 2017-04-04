package pl.giantscastle.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import pl.giantscastle.model.Character;
import pl.giantscastle.model.Door;

public class DoorDao {

	public Door create(Character character) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Door door = new Door();
		door.setCharacter(character);
		entityManager.getTransaction().begin();
		entityManager.persist(door);
		entityManager.getTransaction().commit();
		return door;
	}

	public boolean isOpen(Character character, String doorNr) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		Door door = entityManager.find(Door.class, character.getCharacterId());
		entityManager.getTransaction().commit();
		boolean dOpen = false;
		switch (doorNr) {
		case "001":
			dOpen = door.isDoorOpen001();
		case "002":
			dOpen = door.isDoorOpen002();
		}
		entityManager.close();
		entityManagerFactory.close();
		return dOpen;
	}

	public void open(Character character, String doorNr) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		Door door = entityManager.find(Door.class, character.getCharacterId());
		switch (doorNr) {
		case "001":
			door.setDoorOpen001(true);
		case "002":
			door.setDoorOpen001(true);
		}
		entityManager.persist(door);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	public void remove(long id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		TypedQuery<Door> queryDoor = entityManager.createQuery("select e from Door e where e doorId = '" + id + "'",
				Door.class);
		Door door = queryDoor.getSingleResult();

		entityManager.getTransaction().begin();
		entityManager.remove(door);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	public void remove(Door door) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.remove(door);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}

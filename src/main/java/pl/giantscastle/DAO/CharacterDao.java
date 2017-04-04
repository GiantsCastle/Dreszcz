package pl.giantscastle.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import pl.giantscastle.model.Character;
import pl.giantscastle.model.Door;
import pl.giantscastle.model.User;
import pl.giantscastle.model.Variable;

public class CharacterDao {

	public Character create(User user, String characterName, int gold, int agility, int stamina, int luck) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// tworzenie rekordu w basie dla nowej postaci
		Character character = new Character();
		character.setUser(user);
		character.setCharacterName(characterName);
		character.setCharacterGold(gold);
		character.setCharacterAgility(agility);
		character.setCharacterStamina(stamina);
		character.setCharacterLuck(luck);

		// tworzenie w bazie rekordu drzwi dla utworzonej postaci
		Door door = new Door();
		door.setCharacter(character);
		door.setDoorOpen001(false);
		door.setDoorOpen002(false);

		// tworzenie w bazie rekordu zmiennych dla utworzonej postaci
		Variable variable = new Variable();
		variable.setCharacter(character);
		variable.setLakeSwim(0);

		entityManager.getTransaction().begin();
		entityManager.persist(character);
		entityManager.persist(door);
		entityManager.persist(variable);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return character;
	}

	public Character get(long id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Character character = entityManager.find(Character.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return character;
	}

	public void setGold(Character character, int g) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		int gold = character.getCharacterGold();
		gold += g;
		character.setCharacterGold(gold);
		entityManager.getTransaction().begin();
		entityManager.persist(character);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	public void setAgility(Character character, int a) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		int agility = character.getCharacterAgility();
		agility += a;
		character.setCharacterAgility(agility);
		entityManager.getTransaction().begin();
		entityManager.persist(character);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	public void setLuck(Character character, int l) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		int luck = character.getCharacterLuck();
		luck += l;
		character.setCharacterLuck(luck);
		entityManager.getTransaction().begin();
		entityManager.persist(character);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	public void setStamina(Character character, int s) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		int stamina = character.getCharacterStamina();
		stamina += s;
		character.setCharacterStamina(stamina);
		entityManager.getTransaction().begin();
		entityManager.persist(character);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	public void remove(long id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Character character = entityManager.find(Character.class, id);

		TypedQuery<Door> queryDoor = entityManager
				.createQuery("select e from Door e where e characterId = '" + id + "'", Door.class);
		Door door = queryDoor.getSingleResult();

		TypedQuery<Variable> queryVariable = entityManager
				.createQuery("select e from Variable e where e characterId = '" + id + "'", Variable.class);
		Variable variable = queryVariable.getSingleResult();

		entityManager.getTransaction().begin();
		entityManager.remove(character);
		entityManager.remove(door);
		entityManager.remove(variable);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}
}

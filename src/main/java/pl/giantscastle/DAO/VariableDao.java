package pl.giantscastle.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import pl.giantscastle.model.Character;
import pl.giantscastle.model.Variable;

public class VariableDao {

	public Variable create(Character character) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Variable variable = new Variable();
		variable.setCharacter(character);
		entityManager.getTransaction().begin();
		entityManager.persist(variable);
		entityManager.getTransaction().commit();
		return variable;
	}

	public Variable get(long id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Variable variable = entityManager.find(Variable.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		return variable;
	}

	public void setLakeSwim(Variable variable, int l) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		int lakeSwim = variable.getLakeSwim();
		lakeSwim += l;
		variable.setLakeSwim(lakeSwim);
		entityManager.getTransaction().begin();
		entityManager.persist(variable);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	public void remove(long id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		TypedQuery<Variable> queryVariable = entityManager
				.createQuery("select e from Variable e where e variableId = '" + id + "'", Variable.class);
		Variable variable = queryVariable.getSingleResult();

		entityManager.getTransaction().begin();
		entityManager.remove(variable);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}

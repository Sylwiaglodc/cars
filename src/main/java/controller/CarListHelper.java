package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CarList;

/**
 * @author sylw - srglod
 * CIS175 - Spring 2023
 * Jan 27, 2023
 */

public class CarListHelper {
	
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("cars");
	
	public void insertItem(CarList li) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
		
	}	
		
	public void deleteItem(CarList toDelete) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarList> typedQuery = em.createQuery("select li from CarList li where li.make = :selectedMake and li.model = :selectedModel", CarList.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		//we only want one result
		typedQuery.setMaxResults(1);
		//get the result and save it into a new list item
		CarList result = typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em
		.close();
	}

	public List<CarList> searchForCarByModel(String modelName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarList> typedQuery = em.createQuery("select li from CarList li where li.model = :selectedModel", CarList.class);
		typedQuery.setParameter("selectedModel", modelName);
		List<CarList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<CarList> searchForCarByMake(String makeName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarList> typedQuery = em.createQuery("select li from CarList li where li.make = :selectedMake", CarList.class);
		typedQuery.setParameter("selectedMake", makeName);
		List<CarList> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public CarList searchForCarById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CarList found = em.find(CarList.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(CarList toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public void cleanUp() {
		// TODO Auto-generated method stub
		emfactory.close();
	}

	public List<CarList> showAllItems() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		List<CarList> allCars = em.createQuery("SELECT i FROM CarList i").getResultList();
		return allCars;
	}


}

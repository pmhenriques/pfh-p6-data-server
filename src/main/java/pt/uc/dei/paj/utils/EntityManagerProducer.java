package pt.uc.dei.paj.utils;

import javax.ejb.Stateless;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This class creates entity manager.
 */
@Stateless
public class EntityManagerProducer {
	
	@PersistenceContext(unitName = "pfh-project6-data-server")
	private EntityManager em;
	
	@Produces
	public EntityManager em(){
		return em;
	}

	public void dispose(@Disposes EntityManager em) {
		em.close();
	}
}

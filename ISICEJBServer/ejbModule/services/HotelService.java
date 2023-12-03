package services;

import java.util.List;




import dao.IDaoLocale1;
import dao.IDaoRemote1;
import entities.Hotel;
import entities.Ville;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless(name = "asmaa")
public class HotelService implements IDaoRemote1<Hotel>,IDaoLocale1<Hotel>{

	@PersistenceContext
	private EntityManager entityManager;
	
	 @Override
	 @PermitAll
	    public Hotel create(Hotel hotel) {
	        entityManager.persist(hotel);
	        return hotel;
	    }

	 @Override
	 @PermitAll
	 public boolean delete(Hotel hotel) {
		    if (hotel != null) {
		        // Check if the entity is managed before trying to remove it
		        if (entityManager.contains(hotel)) {
		            entityManager.remove(hotel);
		            return true;
		        } else {
		            // If the entity is detached, merge it first and then remove
		            try {
		                Hotel managedEntity = entityManager.merge(hotel);
		                entityManager.remove(managedEntity);
		                return true;
		            } catch (IllegalArgumentException e) {
		                // Log or handle the exception as needed
		                e.printStackTrace();
		                return false;
		            }
		        }
		    }

		    return false;
		}

	  @Override
	  @PermitAll
	  public Hotel update(Hotel hotel) {
		    if (hotel != null) {
		        // Utilisez la méthode merge pour mettre à jour l'entité détachée
		        Hotel updatedEntity = entityManager.merge(hotel);
		        return updatedEntity;
		    }
		    return null;
		}

	 @Override
	 @PermitAll
	 public Hotel findById(int id) {
			// TODO Auto-generated method stub
			return entityManager.find(Hotel.class, id);
		}

	@Override
	 @PermitAll
	 public List<Hotel> findAll() {
			Query query = entityManager.createQuery("select h from Ville h");
			return query.getResultList();
		}
}
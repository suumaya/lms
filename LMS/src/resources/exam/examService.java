package resources.exam;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class examService {
	// @PersistenceContext
	//   private EntityManager em;

	    public exam find(Long id) {
	     //   return em.find(exam.class, id);
		 return new exam();
	    }

	    public List<exam> list() {
	        //return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
	    	return null; 
	    }

	    public void create(exam e) {
	   //     em.persist(e);
	    }

	    public void update(exam e) {
	//        em.merge(e);
	    }

	    public void delete(exam e) {
	//        em.remove(em.contains(e) ? e : em.merge(e));
	    }

}

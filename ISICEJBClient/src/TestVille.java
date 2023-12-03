import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.IDaoRemote;
import entities.Ville;

public class TestVille {

	public static IDaoRemote<Ville> lookUpEmployeRemote() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDaoRemote<Ville>) context.lookup("ejb:ISICEJBEAR/ISICEJBServer/kenza!dao.IDaoRemote");

	}
	public static void main(String[] args) {
		
		try {
			IDaoRemote<Ville> dao = lookUpEmployeRemote();
			dao.create(new Ville("Tanger"));
			dao.create(new Ville("Marrakech"));
			dao.create(new Ville("Agadir"));
			for (Ville v : dao.findAll()) {
	            System.out.println(v.getId() + " - " + v.getNom());
	        }
		        // Cr�ez une instance de Ville avec un ID existant
		       // Ville villeToUpdate = new Ville();
		       // villeToUpdate.setId(1); // Remplacez 1 par l'ID r�el de l'entit� que vous souhaitez mettre � jour
		       // villeToUpdate.setNom("Agarir");

		        // Appelez la m�thode update
		       // Ville updatedVille = dao.update(villeToUpdate);

		        // Affichez le r�sultat
		       // if (updatedVille != null) {
		       ////     System.out.println("Ville mise � jour avec succ�s : ID = " + updatedVille.getId() + ", Nom = " + updatedVille.getNom());
		       // } else {
		       //     System.out.println("La mise � jour de la ville a �chou�.");
		       // }

		        // Affichez toutes les villes apr�s la mise � jour
		       // for (Ville v : dao.findAll()) {
		        //    System.out.println(v.getId() + " - " + v.getNom());
		       // }
		   // } 
		}
			catch (NamingException e) {
		       e.printStackTrace();
		    }
		}
	}

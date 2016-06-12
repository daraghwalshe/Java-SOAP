package daragh.helper.classes;

import daragh.serviceif.com.ToystoreIF;
import daragh.serviceif.com.ToystoreIFService;

//import daragh.serviceif.com.*;

public class DeleteHelper {
	
	ToystoreIFService toystoreIFService;
	ToystoreIF toystoreIF;
	
	/**
	 * Constructor
	 */
	public DeleteHelper(){
		System.out.println("Delete Helper up and running");
		toystoreIFService = new ToystoreIFService();
		toystoreIF = toystoreIFService.getToystoreIFPort();
	}


	public String deleteToyItem(String name) {
		
		String reply = "";
		
		if( toystoreIF.delete(name) ){
			reply = name + " deleted sucesfully";
		}
		else{
			reply = "ERROR: " + name + " not found on the database.";
		}

		return reply;
	}
	

}

























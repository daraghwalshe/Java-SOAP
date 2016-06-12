package daragh.serviceif.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.jws.WebService;

import daragh.business.logic.Database;
import daragh.business.logic.StockItem;
import daragh.business.logic.Toy;

@WebService
public class ToystoreIF {

	private Database db;
		
	/**
	 * Class constructor, initialises the db
	 */
	public ToystoreIF(){
		db = new Database();
	}
	
	
	/**
	 * Creates a new item on the pseudo db
	 * @param details: List of item details
	 * @return boolean, true on success, false on error
	 */
	public boolean create(List<String> details){
		boolean noerror = true;
		int qty = -1;

		try {
			qty = Integer.parseInt(details.get(5));
		} 
		catch (NumberFormatException e) {
			noerror = false;
			e.printStackTrace();
		}
		
		
		if(noerror && qty > -1){
			String[] toyInfo = new String[5];
			for(int i=0; i<5; i++){
				toyInfo[i] = details.get(i);
			}			
			db.addNewItem(toyInfo, qty);
		}
		return noerror;
	}
	

	/**
	 * Void method, returns a List of all items
	 * @return List of all stockItems
	 */
	public List<StockItem> read(){
		return db.getStock();    
	}
	
	
	/**
	 * A method to update an item in the database
	 * @param details: A list of details for item to change
	 * @return: boolean, true on success, false on fail
	 */
	public boolean update(List<String> details){
		boolean noerror = true;
		String name = details.get(6);
		int qty = -1;

		try {
			qty = Integer.parseInt(details.get(5));
		} catch (NumberFormatException e) {
			noerror = false;
			e.printStackTrace();
		}
		
		if(noerror && qty > -1){

			String[] toyInfo = new String[5];
			for(int i=0; i<5; i++){
				toyInfo[i] = details.get(i);
			}			
			db.updateItem(toyInfo, qty, name);
		}
		return noerror;
		
	}
	
	
	/**
	 * Remove an item from the database
	 * @param toyName: name of the toy to remove
	 * @return: true on success, false on failure
	 */
	public boolean delete(String toyName){
		
		if(db.removeItem(toyName)){
			return true;
		}
		return false;
	}
	
	
	
}

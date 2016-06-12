package daragh.business.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to emulate a database
 * @author daragh
 *
 */
public class Database {
	
	private List<StockItem> stock;
	private String[] toy1 = {"1", "Football", "sport", "Addidas", "19.95"};
	private String[] toy2 = {"2", "Tennis Racket", "sport", "Addidas", "25.50"};
	private String[] toy3 = {"3", "Activity Center", "toddler", "Baybliss", "15.99"};
	private String[] toy4 = {"4", "Bubble Car", "toddler", "Baybliss", "78.99"};
	private String[] toy5 = {"5", "Cluedo", "Board Games", "Parker", "12.99"};
	private String[] toy6 = {"6", "Monopoly", "Board Games", "Parker", "14.99"};
	private String[] toy7 = {"7", "Pokemon", "Cards", "Tonkai", "2.50"};
	private String[] toy8 = {"8", "Wizards", "Cards", "Tonkai", "1.99"};	
	
	/**
	 * initialise db
	 */
	public Database(){
		stock = new ArrayList<StockItem>();
		populate();
	}
	
	/**
	 * Add initial stock items
	 */
	private void populate(){
		stock.add(new StockItem(new Toy(toy1), 20));
		stock.add(new StockItem(new Toy(toy2), 18));
		stock.add(new StockItem(new Toy(toy3), 46));
		stock.add(new StockItem(new Toy(toy4), 31));
		stock.add(new StockItem(new Toy(toy5), 28));
		stock.add(new StockItem(new Toy(toy6), 53));
		stock.add(new StockItem(new Toy(toy7), 107));
		stock.add(new StockItem(new Toy(toy8), 165));
	}
	
	/**
	 * Adds an item to stock
	 * @param newToy
	 * @param qty
	 */
	public void addNewItem( String[] newToy, int qty ){
		stock.add(new StockItem(new Toy(newToy), qty));
	}
	
	
	/**
	 * Adds an item to stock
	 * @param newItem
	 */
	public void addNewItem(StockItem newItem){
		stock.add(newItem);
	}

	/**
	 * Removes an item from the database
	 * @param toyName: name of item to remove
	 * @return: true on success
	 */
	public boolean removeItem(String toyName){
		
		toyName = toyName.toLowerCase();
		for(StockItem stockItem: stock){
			if(stockItem.getToyName().toLowerCase().equals(toyName)){				
				stock.remove(stockItem);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Get a list of all stock items
	 * @return
	 */
	public List<StockItem> getStock(){
		return stock;
	}
	
	/**
	 * Update an existing stock item
	 * @param newToy
	 * @param qty
	 * @param oldName
	 * @return
	 */
	public boolean updateItem( String[] newToy, int qty, String oldName ){
		Toy toy;
		for(StockItem stockItem: stock){
			if(stockItem.getToyName().equals(oldName)){				
				//stock.remove(stockItem);
				toy = stockItem.getToy();
				toy.setId(newToy[0]);
				toy.setName(newToy[1]);
				toy.setCategory(newToy[2]);
				toy.setBrand(newToy[3]);
				toy.setPrice(newToy[4]);
				
				stockItem.setQuantity(qty);
				
				return true;
			}
		}
		return false;
	}
	
}



















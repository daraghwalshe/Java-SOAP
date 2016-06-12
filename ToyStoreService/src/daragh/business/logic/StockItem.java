package daragh.business.logic;

/**
 * Class to represent a stock item
 * @author daragh
 *
 */
public class StockItem {
	
	private Toy toy;
	private int quantity;
	
	public StockItem(Toy toy, int quantity){		
		this.toy = toy;
		this.quantity = quantity;
	}
	
	public String getToyName(){
		return this.toy.getName();
	}

	public Toy getToy() {
		return toy;
	}

	public void setToy(Toy toy) {
		this.toy = toy;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

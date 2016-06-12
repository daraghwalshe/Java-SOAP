package daragh.business.logic;

public class Toy {

	private String id;
	private String name;
	private String category;
	private String brand;
	private String price;
	
	public Toy(){
		
	}
	
	public Toy(String id, String name, String category, String brand, String price){
		this.id = id;
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.price = price;
	}
	
	public Toy(String[] details){
		this.id = details[0];
		this.name = details[1];
		this.category = details[2];
		this.brand = details[3];
		this.price = details[4];
	}

	/**
	 * Generic getters and setters
	 * @return
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
}

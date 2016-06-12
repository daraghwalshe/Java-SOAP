package daragh.helper.classes;

import daragh.serviceif.com.StockItem;
import daragh.serviceif.com.Toy;
import daragh.serviceif.com.ToystoreIF;
import daragh.serviceif.com.ToystoreIFService;

import java.util.List;

//import daragh.serviceif.com.*;

public class ReadHelper {

	ToystoreIFService toystoreIFService;
	ToystoreIF toystoreIF;
	List<StockItem> stockList;


	/**
	 * Constructor
	 */
	public ReadHelper(){
		System.out.println("Helper up and running");
		toystoreIFService = new ToystoreIFService();
		toystoreIF = toystoreIFService.getToystoreIFPort();
		stockList = toystoreIF.read();
	}


	public String getAllContent() {

		String content = "";
		for(StockItem item: stockList){
			content += buildRow(item);
		}
		return content;
	}



	public String buildRow(StockItem item) {

		String row = "";
		Toy toy = item.getToy();

		row += "<tr>";			
		row += "<td>" + toy.getId() + "</td>";
		row += "<td>" + toy.getName() + "</td>";
		row += "<td>" + toy.getCategory() + "</td>";
		row += "<td>" + toy.getBrand() + "</td>";
		row += "<td>&euro;" + toy.getPrice() + "</td>";
		row += "<td>" + item.getQuantity() + "</td>";			
		row += "</tr>";		

		return row;
	}



	public String searchContent(String cat, String term) {

		term = term.toLowerCase();
		String content = "";

		switch (cat) {
		case "id":{
			//content += getContentById(term);
			content += getContentById(term);
		}
		break;
		case "name":{
			content += getContentByName(term);
		}
		break;
		case "category":{
			content += getContentByCategory(term);
		}
		break;
		case "brand":{
			content += getContentByBrand(term);
		}
		break;
		case "price":{
			content += getContentByPrice(term);
		}
		break;
		case "quantity":{
			content += getContentByQuantity(term);
		}
		break;
		}

		return content;
	}

	public String getContentById(String term) {
		String content = "";
		for(StockItem item: stockList){
			if(item.getToy().getId().toLowerCase().contains(term.toLowerCase())){
				content += buildRow(item);
			}
		}
		return content;
	}
	

	public String getContentByName(String term) {
		String content = "";
		for(StockItem item: stockList){
			String thisName = item.getToy().getName().toLowerCase();
			if(thisName.contains(term.toLowerCase())){
				content += buildRow(item);
			}
		}
		return content;
	}
	

	public String getContentByCategory(String term) {
		String content = "";
		for(StockItem item: stockList){
			String thisCat = item.getToy().getCategory().toLowerCase();
			if(thisCat.contains(term.toLowerCase())){
				content += buildRow(item);
			}
		}
		return content;
	}
	
	
	public String getContentByBrand(String term) {
		String content = "";
		String thisBrand;
		for(StockItem item: stockList){
			thisBrand = item.getToy().getBrand().toLowerCase();
			if(thisBrand.contains(term.toLowerCase())){
				content += buildRow(item);
			}
		}
		return content;
	}
	
	
	public String getContentByPrice(String term) {
		String content = "";
		for(StockItem item: stockList){
			if(item.getToy().getPrice().equals(term)){
				content += buildRow(item);
			}
		}
		return content;
	}
	
	public String getContentByQuantity(String term) {
		String content = "";
		if(checkIsInteger(term)){
			int qty = Integer.parseInt(term);
			for(StockItem item: stockList){
				if(item.getQuantity() == qty){
					content += buildRow(item);
				}
			}			
		}
		return content;
	}

	
	private boolean checkIsInteger(String value) {
		//int quantity = 0;
		boolean goodNum = true;
		try {
			//quantity = Integer.parseInt(value);
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			goodNum = false;
			e.printStackTrace();
		}
		return goodNum;
	}
	

}


























package daragh.helper.classes;

import daragh.serviceif.com.StockItem;
import daragh.serviceif.com.Toy;
import daragh.serviceif.com.ToystoreIF;
import daragh.serviceif.com.ToystoreIFService;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import daragh.serviceif.com.*;

public class UpdateHelper {
	
	ToystoreIFService toystoreIFService;
	ToystoreIF toystoreIF;
	List<StockItem> stockList;
	String nameToUpdate = "";
	
	public void setNameToUpdate(String name){
		this.nameToUpdate = name;
	}

	
	/**
	 * Constructor
	 */
	public UpdateHelper(){
		System.out.println("Update Helper up and running");
		toystoreIFService = new ToystoreIFService();
		toystoreIF = toystoreIFService.getToystoreIFPort();
		stockList = toystoreIF.read();
		//runMethod();
	}

	public String getUpdateForm(String name){
		String htmlString = "";
		return htmlString;
	}
	
	
	public String getAllContent() {
		
		String content = "";
		Toy toy;
		
		for(StockItem item: stockList){
			toy = item.getToy();
			String rVal = toy.getName();
			// System.out.println("Quantity: " + item.getQuantity());
			
			content += "<tr>";
			// content += "<td><input type='radio' name='radioName' value='" +radioVal+ "'></td>";
			content += "<td><input type='radio' name='radioName' value='" +rVal+ "' onclick='myFunction(this.value)'></td>";
			content += "<td id='" + rVal+0 + "'>" + toy.getId() + "</td>";
			content += "<td id='" + rVal+1 + "'>" + toy.getName() + "</td>";
			content += "<td id='" + rVal+2 + "'>" + toy.getCategory() + "</td>";
			content += "<td id='" + rVal+3 + "'>" + toy.getBrand() + "</td>";
			content += "<td id='" + rVal+4 + "'>&euro;" + toy.getPrice() + "</td>";
			content += "<td id='" + rVal+5 + "'>" + item.getQuantity() + "</td>";
			content += "</tr>";
		}
		return content;
	}
	
	public String[] thisItem(String name){
		Toy toy;
		String[] itemDetails = new String[6];
		for(StockItem item: stockList){
			if(name.equals(item.getToy().getName())){
				toy = item.getToy();
				itemDetails[0] = toy.getId();
				itemDetails[1] = toy.getName();
				itemDetails[2] = toy.getCategory();
				itemDetails[3] = toy.getBrand();
				itemDetails[4] = toy.getPrice();
				itemDetails[5] = Integer.toString(item.getQuantity());
			}
		}
		return itemDetails;
	}
	

	// ..................................................................
	
	String[] inputError = {" &nbsp;*", " &nbsp;*", "&nbsp;*", "&nbsp;*", " &nbsp;*", " &nbsp;*"};
	List<String> output = new ArrayList<String>();
	
	public boolean checkInput(Enumeration<String> en, HttpServletRequest request){
		boolean noErrors = true;
		int index = 0;
		while(en.hasMoreElements())
		{
			String inputName = en.nextElement();
			
			if(index > 0){
				String value = request.getParameter(inputName);
				System.out.println("Parameter Name: " + inputName + ". Parameter Value: " + value);
	
				if(value.length() < 1){
					inputError[index-1] = "Required value";
					noErrors = false;
				}
				else if(value.length() > 0){
					output.add(value);
				}
				if(index == 5){
					if(!checkIsDouble(value)){
						noErrors = false;
					}
				}
				if(index == 6){
					if(!checkIsInteger(value)){
						noErrors = false;
					}
				}
			}

			index++;
		}	
		return noErrors;
	}


	private boolean checkIsDouble(String value) {
		boolean goodNum = true;
		try {
			Double.parseDouble(value);
		} catch (NumberFormatException e) {
			inputError[4] = "Decimal please";
			goodNum = false;
			e.printStackTrace();
		}
		return goodNum;
	}


	private boolean checkIsInteger(String value) {
		boolean goodNum = true;
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			inputError[5] = "Integers only";
			goodNum = false;
			e.printStackTrace();
		}
		return goodNum;
	}
	
	
	public String[] getErrors(){
		return inputError;
	}
	
	
	public boolean updateItem(){
		System.out.println("======  UpdateHelper :: updateItem() ========");
		System.out.println("===== output: " + output.size() + "   =====");
		
		if(output.size() > 5){
			
			output.add(nameToUpdate);
			if(toystoreIF.update(output)){
				return true;
			}
		}		
		return false;		
	}
	
	// ..................................................................	
	
}

























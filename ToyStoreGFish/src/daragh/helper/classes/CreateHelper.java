package daragh.helper.classes;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import daragh.serviceif.com.ToystoreIF;
import daragh.serviceif.com.ToystoreIFService;

public class CreateHelper {

	ToystoreIFService toystoreIFService;
	ToystoreIF toystoreIF;
	String[] inputError = {" &nbsp;*", " &nbsp;*", "&nbsp;*", "&nbsp;*", " &nbsp;*", " &nbsp;*"};
	//String[] output = new String[6];
	List<String> output = new ArrayList<String>();
	int quantity = 0;
	
	/**
	 * Constructor
	 */
	public CreateHelper(){
		System.out.println("Create Helper up and running");
		toystoreIFService = new ToystoreIFService();
		toystoreIF = toystoreIFService.getToystoreIFPort();
	}
	
	
	public boolean checkInput(Enumeration<String> en, HttpServletRequest request){
		boolean noErrors = true;
		int index = 0;
		while(en.hasMoreElements())
		{
			String inputName = en.nextElement();
			String value = request.getParameter(inputName);
			System.out.println("Parameter Name: " + inputName + ". Parameter Value: " + value);
			if(value.length() < 1){
				inputError[index] = "Required value";
				noErrors = false;
			}
			else if(value.length() > 0){
				output.add(value);
			}
			if(index == 4){
				if(!checkIsDouble(value)){
					noErrors = false;
				}
			}
			if(index == 5){
				if(!checkIsInteger(value)){
					noErrors = false;
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
			quantity = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			inputError[5] = "Whole numbers only";
			goodNum = false;
			e.printStackTrace();
		}
		return goodNum;
	}
	
	
	public String[] getErrors(){
		return inputError;
	}
	
	
	public boolean writeNewItem(){
		System.out.println("======  CreateHelper :: writeNewItem() ========");
		System.out.println("===== output: " + output.size() + "   =====");
		
		if(output.size() > 5){
			if(toystoreIF.create(output)){
				return true;
			}
		}		
		return false;		
	}
	
	
	
}






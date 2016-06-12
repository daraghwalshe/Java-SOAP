
<%@page import="java.util.Enumeration"%>
<%@page import="daragh.helper.classes.UpdateHelper"%>
<%@page import="daragh.helper.classes.CreateHelper"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
<link rel="stylesheet" href="css/toyStyle.css">
</head>

<%
//-------------------------------------------------------
boolean first = true;
String[] errorOutput = {" &nbsp;*", " &nbsp;*", "&nbsp;*", "&nbsp;*", " &nbsp;*", " &nbsp;*"};
String[] values = {"", "", "", "", "", ""};
String command1;
String updateForm = "";
String tableOutput = "";
String opOutput = "*";


UpdateHelper uh = new UpdateHelper();

if(first){
	tableOutput = uh.getAllContent();
	first = false;
}

if(request.getParameter("updateButton") != null){
	
	if(request.getParameter("radioName") != null){
		command1 = request.getParameter("radioName");
		System.out.println("radioVal" + command1);
		
		//values = uh.thisItem(command1);

		Enumeration<String> en = request.getParameterNames();
		
		if(uh.checkInput(en, request)){
			
			uh.setNameToUpdate(command1);
			
			if(uh.updateItem()){
				opOutput = "Update Sucessful";
				uh = new UpdateHelper();
				tableOutput = uh.getAllContent();
			}
		}
		else{
			opOutput = "Please enter correct values";
			errorOutput = uh.getErrors();
		}
		
	}
}

// -------------------------------------------------------
%>
<body>

    <div class="background">
    glassfish Glassfish	glassfish glassfish glassfish Glassfish	glassfish glassfish
    glassfish Glassfish	glassfish glassfish glassfish Glassfish	glassfish glassfish
    </div>
    
    <div id="crudContent">
    
    	<h2>
    	<img class="iconImg" src="images/file_edit.png" alt="edit icon">
    	Update Existing Stock Items</h2>
		<hr />

		<div class="content">
		
		<form name=deleteForm method=post>			 
			
		<p id="pText">
		<input id="updateButton" class="button" name="updateButton" type=submit value=" Update ">
			Select a row, make changes and press update.&nbsp;
		</p>

		<!-- </form> -->
		<hr />
		<div id="updateForm"><%= updateForm %>
			<div class="leftCol">
			
			<label for=toyId class="leftLabel">Id</label>
			<input type=text id="new0" name=toyId class="rightInput" value="<%= values[0] %>">
			<span class="inputError"><%= errorOutput[0] %></span><br><hr />

			<label for=nameId class="leftLabel">Name</label>
			<input type=text id="new1" name=nameId class="rightInput" value="<%= values[1] %>">
			<span class="inputError"><%= errorOutput[1] %></span><br><hr />

			<label for=categoryId class="leftLabel">Category</label>
			<input type=text id="new2" name=categoryId class="rightInput" value="<%= values[2] %>">
			<span class="inputError"><%= errorOutput[2] %></span><br><hr />

			<br />
			</div>
			
			<div class="rightCol">
			<label for=brandId class="leftLabel">Brand</label>
			<input type=text id="new3" name=brandId class="rightInput" value="<%= values[3] %>">
			<span class="inputError"><%= errorOutput[3] %></span><br><hr />
	
			<label for=priceId class="leftLabel">Price</label>
			<input type=text id="new4" name=priceId class="rightInput" value="<%= values[4] %>">
			<span class="inputError"><%= errorOutput[4] %></span><br><hr />

			<label for=quantityId class="leftLabel">Quantity</label>
			<input type=text id="new5" name=quantityId class="rightInput" value="<%= values[5] %>">
			<span class="inputError"><%= errorOutput[5] %></span><br><hr />

			</div>
		</div>
		<hr />
		
		<!-- .................................................. -->
		<table id="errorTable">		
			<tr>
				<th><%=opOutput %></th>
			</tr>
		</table>				
		<!-- .................................................. -->
		<table id="readTable">		
			<tr>
				<th colspan="2">ID</th>
				<th>Name</th>
				<th>Category</th>
				<th>Brand</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<%=tableOutput %>
		</table>
		</form>
		<!-- .................................................. -->
		
		</div>
		
		<div class="aside">
	    <div id="nav">
		    <ul class="mainNav">
		    	<li id="index"><a href="index.jsp">Home</a></li>
		    	<li id="create"><a href="create.jsp">Create</a></li>
		    	<li id="read"><a href="read.jsp">Read</a></li>
		    	<li id="update"><a href="update.jsp" class="active">Update</a></li>
		    	<li id="delete"><a href="delete.jsp">Delete</a></li>
		    </ul>    
	    </div>
	    </div>
	</div>
	
<script type="text/javascript">
/**
 * Populate input fields on radio-button click
 */
function myFunction(val){
	var strValues = [];
	var idValues = [];
	
	for(var i=0; i<6; i++){
		
		var value = document.getElementById(val+i).textContent;
		var idValue = "new" + i;
		
		if(i == 4){
			value = value.slice(1, value.length);
		}
		strValues.push( value );
		idValues.push( idValue );
	}
	for(var i=0; i<6; i++){
	    var x = document.getElementById(idValues[i]);
	    x.value = strValues[i];
	}
}
</script>
</body>
</html>





















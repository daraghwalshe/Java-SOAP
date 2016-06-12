
<%@page import="java.util.Enumeration"%>
<%@page import="daragh.helper.classes.CreateHelper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create</title>
<link rel="stylesheet" href="css/toyStyle.css">
</head>

<%
//-------------------------------------------------------
boolean first = true;
String opOutput = "*";
String[] errorOutput = {" &nbsp;*", " &nbsp;*", "&nbsp;*", "&nbsp;*", " &nbsp;*", " &nbsp;*"};

CreateHelper ch;

if(first){
	System.out.println(" --- FIRST ---");
	first = false;
}


if(request.getParameterNames() != null){
	ch = new CreateHelper();
	Enumeration<String> en = request.getParameterNames();
	String name = request.getParameter("toyName");
	
	if(ch.checkInput(en, request)){
		if(ch.writeNewItem()){
			System.out.println("  *****  Good Write ******");
			opOutput = "Item '" + name + "' succesfully added to Database";
			ch = null;
		}
	}
	else{
		errorOutput = ch.getErrors();
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
    	<img class="iconImg" src="images/file_add.png" alt="add_file icon">
    	Create new stock item</h2>
		<hr />

		<div class="content">
		<p id="pText">
			Fill in all the required fields and press submit.
		</p>
		<!-- <hr /> -->
		<div id="createOut">
			<%=opOutput %>
		</div>

		<!-- <hr /> -->
		<form name=createForm method=post>
		
			<label for=toyId class="leftLabel">Id</label>
			<input type=text name=toyId class="rightInput">
			<span class="inputError"><%= errorOutput[0] %></span>
			<br />
			
			<label for=toyName class="leftLabel">Name</label>
			<input type=text name=toyName class="rightInput">
			<span class="inputError"><%= errorOutput[1] %></span>
			<br />
			
			
			<label for=category class="leftLabel">Category</label>
			<input type=text name=category class="rightInput">
			<span class="inputError"><%= errorOutput[2] %></span>
			<br />
			
			
			<label for=brand class="leftLabel">Brand</label>
			<input type=text name=brand class="rightInput">
			<span class="inputError"><%= errorOutput[3] %></span>
			<br />
			
			
			<label for=price class="leftLabel">Price</label>
			<input type=text name=price class="rightInput">
			<span class="inputError"><%= errorOutput[4] %></span>
			<br />
			
			
			<label for=price class="leftLabel">Quantity</label>
			<input type=text name=quantity class="rightInput">
			<span class="inputError"><%= errorOutput[5] %></span>
			<br />
			<br />

			<input id=createButton class="button" type=submit value="Create">
			<br />
			<br />
			<div id="emptyDiv"></div>
						
		</form>		
		</div>
		
		<div class="aside">
	    <div id="nav">
		    <ul class="mainNav">
		    	<li id="index"><a href="index.jsp">Home</a></li>
		    	<li id="create"><a href="create.jsp" class="active">Create</a></li>
		    	<li id="read"><a href="read.jsp">Read</a></li>
		    	<li id="update"><a href="update.jsp">Update</a></li>
		    	<li id="delete"><a href="delete.jsp">Delete</a></li>
		    </ul>    
	    </div>
	    </div>

	</div>

</body>
</html>
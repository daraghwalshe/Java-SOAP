
<%@page import="daragh.helper.classes.DeleteHelper"%>
<%@page import="daragh.helper.classes.ReadHelper"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete</title>
<link rel="stylesheet" href="css/toyStyle.css">
</head>
<body>
<%
//-------------------------------------------------------
boolean first = true;
String command1;
String tableOutput = "";
String errorOutput = ".";
DeleteHelper dh = new DeleteHelper();
ReadHelper rh = new ReadHelper();

if(first){
	tableOutput = rh.getAllContent();	
}


if(request.getParameter("deleteButton") != null){
	command1 = request.getParameter("toyName");
	
	if(request.getParameter("toyName") != null){
		errorOutput = dh.deleteToyItem(command1);
		rh = new ReadHelper();
		tableOutput = rh.getAllContent();		
	}
	
}
// -------------------------------------------------------
%>
    <div class="background">
    <img class="iconImg" id="gfimage" src="images/glassfish.png" alt="glassfish icon">
    glassfish Glassfish	glassfish glassfish glassfish Glassfish	glassfish glassfish
    </div>
    <div id="crudContent">
    
    	<h2>
    	<img class="iconImg" src="images/file_delete.png" alt="delete icon">
    	Deletee items from stock</h2>
		<hr />

		<div class="content">
		<p id="pText">
			Enter the item name and press delete.
		</p>
		<hr />
		
		<form name=deleteForm method=post>			 
			<input id="readButton" name="deleteButton" type=submit value=" Delete ">
			<input type=text name="toyName" class="deleteInput"><br />
		</form>
		<hr />
		
		<table id="errorTable">		
			<tr>
				<th><%=errorOutput %></th>
			</tr>
		</table>
		
		<!-- .................................................. -->
		<table id="readTable">		
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Category</th>
				<th>Brand</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<%=tableOutput %>
		</table>
		<!-- .................................................. -->
		
		</div>
		
		<div class="aside">
	    <div id="nav">
		    <ul class="mainNav">
		    	<li id="index"><a href="index.jsp">Home</a></li>
		    	<li id="create"><a href="create.jsp">Create</a></li>
		    	<li id="read"><a href="read.jsp">Read</a></li>
		    	<li id="update"><a href="update.jsp">Update</a></li>
		    	<li id="delete"><a href="delete.jsp" class="active">Delete</a></li>
		    </ul>    
	    </div>
	    </div>
		
	</div>

</body>
</html>
<%@page import="daragh.helper.classes.ReadHelper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Read</title>
<link rel="stylesheet" href="css/toyStyle.css">
</head>

<% 
String command1, command2, command3;
String tableOutput = "";
ReadHelper rh;

if(request.getParameter("searchButton") != null){
	command1 = request.getParameter("type");
	command2 = request.getParameter("searchInput");
	/// tableOutput += "<tr><td colspan='6'>command1: " + command1 + ". command2: " + command2 + "</td></tr>";
	/// System.out.println("command1: " + command1 + ". command2: " + command2);
	rh = new ReadHelper();
	tableOutput = rh.searchContent(command1, command2);
}

if(request.getParameter("readButton") != null) {
	command3 = request.getParameter("readButton");
	/// System.out.println("command1: " + command3 );
	rh = new ReadHelper();
	tableOutput = rh.getAllContent();
}

%>


<body>
    <div class="background">
    glassfish Glassfish	glassfish glassfish glassfish Glassfish	glassfish glassfish
    glassfish Glassfish	glassfish glassfish glassfish Glassfish	glassfish glassfish
    </div>
    
    <div id="crudContent">
    
    	<h2>
    	<img class="iconImg" src="images/file_search.png" alt="search icon">
    	Find items in stock</h2>
		<hr />

		<div class="content">
		<p id="pText">
			Search the database by item attribute.
		</p>
		<hr />
		
		<form id="readForm" name=readForm method=post>
			 <input type="radio" name="type" value="id"> Id &nbsp;
			 <input type="radio" name="type" value="name" checked> Name &nbsp;
			 <input type="radio" name="type" value="category"> Category &nbsp;
			 <input type="radio" name="type" value="brand"> Brand  &nbsp;
			 <input type="radio" name="type" value="price"> Price &nbsp;
			 <input type="radio" name="type" value="quantity"> Quantity &nbsp;
			 &nbsp; | &nbsp;
			 <input id="readButton" name="readButton" type=submit value=" Find All ">		 
		<hr />
		
		<label for=searchInput id="searchLabel">Enter a search term : </label>
		<input type=text name=searchInput id="searchInput">
		<input id="searchButton" class="searchButton" name="searchButton" type=submit value=" Search... ">
		<br />
		<hr />
		<br />
		</form>
		
		<!--
		textarea id="readout" rows="8">
		</textarea>
		-->
		
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
		
		</div>
		
		<div class="aside">
	    <div id="nav">
		    <ul class="mainNav">
		    	<li id="index"><a href="index.jsp">Home</a></li>
		    	<li id="create"><a href="create.jsp">Create</a></li>
		    	<li id="read"><a href="read.jsp" class="active">Read</a></li>
		    	<li id="update"><a href="update.jsp">Update</a></li>
		    	<li id="delete"><a href="delete.jsp">Delete</a></li>
		    </ul>    
	    </div>
	    </div>
		
	</div>

</body>
</html>
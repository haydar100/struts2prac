<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>Informatie over boek</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    
	    <hr />
	   <table>
		    <tr class="thcolor">
			    <th>Attribuut</th>
			    <th>Waarde</th>
			   
		    </tr>
		    
			    <tr class="tdcolor">
			    	<td><label>ID:</label></td>    
				    <td><s:property value="book.id" /></td>
		        </tr>
		        <tr class="tdcolor">
			    	<td><label>Titel:</label></td>    
				    <td><s:property value="book.titel" /></td>
		        </tr>
		        <tr class="tdcolor">
			    	<td><label>Auteur:</label></td>    
				    <td><s:property value="book.auteur" /></td>
		        </tr>
		        <tr class="tdcolor">
			    	<td><label>ISBN:</label></td>    
				    <td><s:property value="book.isbn" /></td>
		        </tr>
		        <tr class="tdcolor">
			    	<td><label>Pagina's:</label></td>    
				    <td><s:property value="book.pages" /></td>
		        </tr>
		        <tr class="tdcolor">
			    	<td><label>Status:</label></td>    
				    <td><s:property value="book.status" /></td>
		        </tr>
 		  
	    </table>

		
	 	
	    <hr /> 
	    
	    <a href=" <s:url action="ManagerMenu" namespace="/manager" /> ">Het menu voor managers</a>
	</body> 
</html>
 
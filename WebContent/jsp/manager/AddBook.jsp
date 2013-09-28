<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>Boek toevoegen</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    <h4>Voeg een boek toe</h4>
	    
	    <hr />
	    <s:actionerror/>
	    <s:actionmessage/>
	    
	    <table>
		    <tr class="thcolor">
			    <th>id</th>
			    <th>titel</th>
			    <th>status</th>
			    <th>ISBN</th>
			    <th>Auteur</th>
		    </tr>
		    <s:iterator value="books">
			    <tr class="tdcolor">
				    <td><s:property value="id" />
					<td><s:property value="titel" />
		     		<td><s:property value="status" />
		     		<td><s:property value="isbn" />
		     		<td><s:property value="auteur"/>
		        </tr>
		        </s:iterator>
		        
 		   
	    </table>
	   <hr />
		<s:form action="AddBook">
    	  <s:textfield name="id" label="id"/>
    	  <s:textfield name="titel" label="titel"/>
    	  <s:textfield name="auteur" label="auteur"/>
    	  <s:textfield name="isbn" label="isbn"/>
    	  <s:textfield name="pages" label="pages"/>
    	  <s:submit value="Voeg boek toe"/>
		</s:form>
		
		
	    
	    
	    

        <a href=" <s:url action="ManagerMenu" namespace="/manager" /> ">Het menu voor managers</a>	
        </body> 
</html>
 
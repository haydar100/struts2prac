<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>Medewerker Toevoegen</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    <h4>Medewerker Toevoegen</h4>
	    
	    <hr />
	    <s:actionerror/>
	    <s:actionmessage/>
	    
	    <hr />

	    <table>
		    <tr class="thcolor">
			    <th>Username</th>
			    <th>Password</th>
			    <th>UserRole</th>
		    </tr>
		    <s:iterator value="allUsers">
			    <tr class="tdcolor">
				    <td><s:property value="username" />
					<td><s:property value="password" />
		     		<td><s:property value="ur" />
		        </tr>
 		    </s:iterator>
	    </table>
  		
	    <hr /> 
	    
	    
		<s:form action="AddCoWorker">
    	  <s:textfield name="username" label="username"/>
    	  <s:textfield name="password" label="password"/>
    	  <s:submit value="Voeg medewerker toe"/>
		</s:form>
		
       <a href=" <s:url action="ManagerMenu" namespace="/manager" /> ">Het menu voor managers</a>	
        </body> 
</html>
 
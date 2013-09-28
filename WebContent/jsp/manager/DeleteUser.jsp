<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>Gebruiker verwijderen</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    <h4>Gebruiker verwijderen</h4>
	    
	    <hr />
	    <s:actionerror/>
	    <s:actionmessage/>
	    
	     <table>
		    <tr class="thcolor">
			    <th>Username</th>
			    <th>Password</th>
			    <th>ur</th>
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
	    
		<s:form action="DeleteUser">
    	  <s:textfield name="username" label="username"/>
    	  <s:submit value="Verwijder user"/>
		</s:form>
		
       <a href=" <s:url action="ManagerMenu" namespace="/manager" /> ">Het menu voor managers</a>	
        </body> 
</html>
 
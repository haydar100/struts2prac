<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>Alle gebruikers</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    <h4>Gebruikers</h4>
	    
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
	    
        <a href=" <s:url action="ManagerMenu" namespace="/manager" /> ">Het menu voor managers</a>
	</body> 
</html> 
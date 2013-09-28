<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>Change password</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    <h4>Wachtwoord veranderen</h4>
	    
	    <hr />

	    
		<s:form action="changePassword">
    	  <s:password name="newPassword" label="Wachtwoord"/>
    	  <s:password name="newPassword1" label="Herhaal wachtwoord"/>
    	  <s:submit value="Verander wachtwoord"/>
		</s:form>
	    
	    <hr />
	    

        <a href=" <s:url action="MemberMenu" namespace="/member" /> ">Het menu voor leden</a>
        	</body> 
</html>
 
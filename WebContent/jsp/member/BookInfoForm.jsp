<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>Boekenlijst</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    <h4>Zoek een boek</h4>
	    
	    <hr />
	    
	    
		<s:form action="ResultBookInfo">
    	  <s:textfield name="id" label="id"/>
    	  <s:submit value="Zoek informatie"/>
		</s:form>
	    
	    
	    

        <a href=" <s:url action="MemberMenu" namespace="/member" /> ">Het menu voor leden</a>	
        </body> 
</html>
 
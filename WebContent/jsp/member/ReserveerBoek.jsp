<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>Boek reserveren</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    <h4>Reserveer een boek</h4>
	    
	    <hr />
	    <s:actionerror/>
	    <s:actionmessage/>
	    
	    <table>
		    <tr class="thcolor">
			    <th>id</th>
			    <th>titel</th>
			    <th>status</th>
		    </tr>
		    <s:iterator value="booksAvailable">
			    <tr class="tdcolor">
				    <td><s:property value="id" />
					<td><s:property value="titel" />
		     		<td><s:property value="status" />
		        </tr>
 		    </s:iterator>
	    </table>
	    
	    
		<s:form action="BookReservation">
    	  <s:textfield name="id" label="id"/>
    	  <s:submit value="Reserveer boek"/>
		</s:form>
		
		
	    
	    
	    

        <a href=" <s:url action="MemberMenu" namespace="/member" /> ">Het menu voor leden</a>	
        </body> 
</html>
 
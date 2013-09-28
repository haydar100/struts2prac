<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

   <head>
      <title>Annuleer reservering.</title>
      <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
   </head>

   <body>
	    <h4>Annuleer reservering.</h4>
	    
	    <hr />
		<s:actionerror/>
	    <s:actionmessage/>

	    <table>
		    <tr class="thcolor">
			    <th>id</th>
			    <th>titel</th>
			    <th>status</th>
		    </tr>
		    <s:iterator value="booksreserved">
			    <tr class="tdcolor">
				    <td><s:property value="id" /></td>
					<td><s:property value="titel" /></td>
		     		<td><s:property value="status" /></td>
		        </tr>
 		    </s:iterator>
	    </table>
  		
	    <hr /> 
	    
	    
		<s:form action="CancelReservation">
    	  <s:textfield name="id" label="id"/>
    	  <s:submit value="Annuleer reservering"/>
		</s:form>
	    
	    
	    
	    <a href=" <s:url action="MemberMenu" namespace="/member" /> ">Het menu voor leden</a>
	</body> 
</html>
 
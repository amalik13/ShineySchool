<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
  
<body>  
<form action="ServletPrintCustomer">  
<table>
Enter your First Name:<input type="text" name="fname"/><br/>  
Enter your Last Name:<input type="text" name="lname"/><br/>  
<label> Textarea:</label> <input type="textarea" name="fname"/><br/>  
</table>  


<input type="submit" value="search"/>  

<select>
  <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="opel">Opel</option>
  <option value="audi">Audi</option>
</select>
</form>  


</body>
</html>
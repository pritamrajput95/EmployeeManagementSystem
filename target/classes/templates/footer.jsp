<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
  

 div.absolute {
    position:static;
    left: 20px;
    
    width: calc(100%);
    border:none;
  bottom:0;
    
} 
  </style>

 <br><br><br><br><br>
<div class="absolute" >


<%
Date dft=new Date(); 
int year=dft.getYear()+1900;
%>
 
<footer style="100%-200px;text-align: center;"> Terms  &nbsp;&nbsp; &nbsp;&nbsp;    Privacy Policy  &nbsp;&nbsp; &nbsp;&nbsp;    Send feedback  &nbsp;&nbsp; &nbsp;&nbsp;  COPYRIGHT  © <%=year%> By Pritam Rajput</footer>

</div>


</body>
</html>
<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đăng Nhập</title>
<style>

div.login{
border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
width: 500px;
  margin-left:500px;
}
div.login input{
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
}
div.login button{
margin-left: 100px;
	 width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

div.login dangky{

  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}
</style>
</head>
<body>
<div class="login">
<form:form action="TRASUA/forget-pass.htm" modelAttribute="USER" method="POST">
  <div>
   <h1 style="margin-left: 170px">Xác Thực Email</h1>
				<label>Email</label>
				<form:input path="email" />
			</div>
			<br>
			<form:errors  path="email" style = "color: red"/>
			 
 <div>
			<form:button >Xác Nhận</form:button>
			
</form:form>
<p style="color: blue">
       <button> <a href="TRASUA/register.htm" class="dangky" >Đăng ký</a> </button>
          <br>
          
        </p>
</div>
</body>
</html>
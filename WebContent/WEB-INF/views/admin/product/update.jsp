<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Quản Lý Trà Sữa</title>
<base href="${pageContext.servletContext.contextPath}/">
<style>
div.table-div {
	width: 50%;
	
	margin-left: 300px;
	margin-top: 20px;
	 border-radius: 20px;
  background-color: #f2f2f2;
  padding:30px;
}
div.table-div th{

  background-color: #4CAF50;
  color: white;
}
div.table-div button {
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
div.table-div button:hover {
  background-color: #45a049;
}
div.table-div input, select{
width: 100%;
  padding: 10px 15px;
  margin: 2px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  }
  
div.label-div{
margin-left: 400px;
	margin-top: 240px;
	font-size:50px;
	
	
}
 div.table-div img{
  display: block;
  max-width: 100px;
  max-height: 100px;
  
 }
</style>
</head>
<body>
<div class="label-div">Sửa Thông Tin Sản Phẩm</div>
	<div class="table-div"> 
		
		<form:form action="admin/product/update.htm" modelAttribute="product" method="POST">
			<div>
				<label>Mã Sản Phẩm</label>
				<form:input path="maTS" readonly="true"/>
			</div>
			<div>
				<label>Tên Sản Phẩm</label>
				<form:input path="tenTS" />
			</div>
			<div>
				<label>Giá</label>
				<form:input path="gia" />
			</div>
			<div>
				<label>Size</label>
				<form:select path="size.idSize" >
				<option value="1">L </option>
				<option value="2">M </option>
				<option value="3">S </option>
				</form:select>
			</div>
			<div>Link ảnh:</div>
			<img src="images/${product.hinhanh}" alt="hinhanh"/> 
            	<input type="file" name="hinhanh"/><br>
			<div>
			<div>
				<label>Trạng Thái</label>
				<form:select path="trangthai" >
				<option value="1">Đang Bán </option>
				<option value="2">Hết Bán </option>
				</form:select>
			</div>
			<form:button>Cập Nhập</form:button>
		</form:form>
	</div>
</body>
</html>
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
	padding: 30px;
}

div.table-div button {
	margin-left: 100px;
	width: 100%;
	background-color: #07190B;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size:20px
}

div.table-div button:hover {
	background-color: #45a049;
}

div.table-div input, select {
	width: 100%;
	padding: 10px 15px;
	margin: 2px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

div.label-div {
	margin-left: 420px;
	margin-top: 240px;
	font-size: 50px;
}

div.table-div img {
	display: block;
	max-width: 100px;
	max-height: 100px;
}
div.table-div th{

  background-color: #4CAF50;
  color: white;
}
div.info{
margin-left: 250px;
	margin-top: 10px;
	font-size: 20px;
}

 table.detail th,td  {
  padding: 8px;
  text-align: left;
  border-bottom: 5px solid #ddd;
 
}




</style>
</head>
<body>
	<div class="label-div">Thông Tin Hóa Đơn</div>
	<div class="table-div">

		<form:form action="admin/bill/update.htm" modelAttribute="bill"
			method="POST">

			<table>

				<tr>
					<th>Mã HD</th>
					<th>Ngày Tạo</th>
					<th>Tổng Giá</th>
					<th>Tài Khoản</th>
					<th>Trạng Thái Đơn Hàng</th>

					
					
				</tr>

				
					<tr>
						<td><form:hidden path="maHD"/>${bill.maHD} </td>
						<td><form:hidden path="ngayTao"/>${bill.ngayTao}</td>
					<td><form:hidden path="tongGia"/>${bill.tongGia}</td>
						<td><form:hidden path="taikhoan.taikhoan"/>${bill.taikhoan.tenNV}</td>
						<td>
						<c:choose>
						<c:when test="${bill.trangthai==1}" >
								<form:select path="trangthai">
									<option value="1">Chờ Xác Nhận</option>
									<option value="0">Xác Nhận Đơn Hàng</option>
								</form:select>
						</c:when>
						<c:otherwise>
						 Đã Xác Nhận  </td>
 						</c:otherwise>
						</c:choose>
						
						</tr>
				
		
		
				
		</table>
		<div class="info" >Chi Tiết Đơn Hàng</div>
		<table style="margin-top:10px" class="detail">
		 <tr>
		 <th></th>
    <th>Tên Trà Sữa</th>
    <th>Giá</th>
    <th>Số lượng</th>
    <th>Thành Tiền</th>
  </tr>
  <c:forEach var="b" items="${detail}">
  
		<tr>
		<td><img src="images/${b.maTS.hinhanh}"alt="${b.maTS.tenTS}" /></td>
		<td>${b.maTS.tenTS}</td>	
		<td>${b.maTS.gia}</td>
		<td>${b.soluong }</td>
		<td>${b.maTS.gia*b.soluong}</td>
		</tr>
		
		</c:forEach>
		</table>
		<form:button>Cập Nhập</form:button> </form:form>
		<p>
       <button style="margin-left:30px" > <a href="admin/bill/index.htm" style="color:black; font-size:20px" >Back</a> </button>
       </p>
      
	</div>
	
          
</body>
</html>
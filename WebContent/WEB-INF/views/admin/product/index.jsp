<%@ page   pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>

<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">


<style type="text/css">
@import
  url("https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap")
  ;

:root { -
  -tablet: 768px; -
  -smallMonitor: 992px; -
  -largeMonitor: 1200px; -
  -font-family: 'Open Sans', sans-serif;
}

body {
  font-family: var(- -font-family) !important;
}

body ::-webkit-scrollbar {
  width: 6px;
}

.ui.vertical.menu.sidebar-menu {
  margin-top: 0px !important;
  max-height: calc(100% - 0px) !important;
  height: calc(100% - 0px) !important;
}

.ui.vertical.menu.sidebar-menu .item i.icon {
  float: left;
  margin: 0em 0.5em 0em 0em;
}

.main-content {
  margin-top: 40px;
}

@media ( min-width : 768px) {
  .ui.vertical.menu.sidebar-menu {
    visibility: visible;
    -webkit-transform: translate3d(0, 0, 0);
    transform: translate3d(0, 0, 0);
    width: 15rem !important;
  }
  .main-content {
    margin-left: 15rem;
  }
  .sidebar-menu-toggler {
    display: none !important;
  }
}
.column {
  float: left;
  width: 33.33%;
}

/* Clear float khác sau các cột */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Bố cục linh hoạt: ba cột xếp chồng lên nhau thay vì cạnh nhau khi màn hình 
có chiều rộng dưới 600px */
@media screen and (max-width: 600px) {
  .column {
    width: 100%;
  }
}
</style>
<style>
	div.table-div
	{
		width:80%;
		margin-left: 100px;
		margin-top: 250px;
	}
	div.table-div button
	{
		margin-left: 1100px;
	}
	
 div.table-div img{
  display: block;
  max-width: 100px;
  max-height: 100px;
  
 }
 div.table-div th{

  background-color: #4CAF50;
  color: white;
}

</style>
<meta charset="utf-8">
<title>Quản Lý Trà Sữa</title>
</head>
<body>
${message}

<div class="table-div">
<button  class="ui green button">
<a href ="admin/product/insert.htm">
		  <i class="fa fa-plus"></i>
		  Thêm mới</a>
		</button>
		<table >
		
			<tr>
				<th>Mã SP</th>
				<th>Tên SP</th>
				<th>Size</th>
				<th>Giá </th>
				<th>Hình Ảnh</th>
				<th>Trạng Thái</th>
				<th> </th>
				<th></th>
			</tr>
		
				<c:forEach var="p" items="${products}">
			<tr>
				<td>${p.maTS}</td>
				<td>${p.tenTS}</td>
				<td>${p.size.size}</td>
				<td>${p.gia}</td>
				<td><img src="images/${p.hinhanh}" alt="${p.maTS}" /></td> 
				<td>
				<c:choose>
				<c:when test="${p.trangthai == 1 }">Đang bán </c:when>
				<c:otherwise>Hết bán</c:otherwise>
				</c:choose>
				</td>
				<td> <a href="admin/product/update/${p.maTS}.htm">Sửa</a></td>
				<td> <a href= "admin/product/delete/${p.maTS}.htm">Xóa</a></td>
			</tr>
		
		</c:forEach>
		</table>
</div>

</body>
</html>
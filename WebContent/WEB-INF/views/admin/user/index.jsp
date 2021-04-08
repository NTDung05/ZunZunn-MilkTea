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
	div.table-div th{

  background-color: #4CAF50;
  color: white;
}
	div.table-div button
	{
		margin-left: 1100px;
	}
	


</style>
<meta charset="utf-8">
<title>Quản Lý Trà Sữa</title>
</head>
<body>
${message}

<div class="table-div">

		<table >
		
			<tr>
				<th>Tài Khoản</th>
				<th>Tên Người Dùng</th>
				<th>Mật Khẩu</th>
				<th>Số Điện Thoại</th>
				<th>Email</th>
				<th> </th>
			</tr>
		
				<c:forEach var="u" items="${users}">
				<c:if test="${u.quyen==0}" >
			<tr>
				<td>${u.taikhoan}</td>
				<td>${u.tenNV}</td>
				<td>${u.matkhau}</td>
				<td>${u.sdt}</td>
				<td> ${u.email }</td>
				<td> <a href= "admin/user/delete/${u.taikhoan}.htm">Xóa</a></td>		
		</tr>
		</c:if>
		</c:forEach>
		</table>
</div>

</body>
</html>
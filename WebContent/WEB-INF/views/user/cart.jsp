<%@ page   pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
   <!-- Start Cart  -->
    <div class="cart-box-main">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="table-main table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Hình Ảnh</th>
                                    <th>Tên Sản Phẩm</th> 
                                    <th>Size</th>
                                    <th>Giá</th>
                                    <th>Số Lượng</th>
                                    <th>Tổng Cộng</th>
                                    <th>Bỏ Chọn</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach  var="sp" items="${sessionScope.cart}"> 
                           <c:forEach  var="p" items="${sessionScope.cartdetail}"> 
                                
                            
                             <c:if test="${p.key==sp.key}"> 
                           
                               
                                 <tr>
                              
                                    <td class="thumbnail-img">
                                        <a href="#">
                                        
									<img class="img-fluid" src="images/${p.value.hinhanh}" alt="" />
								</a>
                                    </td>
                                    <td class="name-pr">
                                        <a href="#">
											${p.value.tenTS}
								</a>
                                    </td>
                                    <td>
                                    	${p.value.size.size}
                                    </td>
                                    <td class="price-pr">
                                        <p>${p.value.gia}</p>
                                    </td>
                                  
                                     <!-- <td class="quantity-box"><input type="number" size="4" value="1" min="0" step="1" class="c-input-text qty text"></td> -->
                                    <td class="quantity-box">${sp.value}</td>
                                    <td class="total-pr">
                                        <p> ${sp.value*p.value.gia}</p>
                                    </td>
                                    <td class="remove-pr">
                                        <a href="user/cart/delete/${p.key}.htm">
									<i class="fas fa-times"></i>
								</a>
                                    </td>
                                </tr>
                                </c:if>
                                </c:forEach>
                                </c:forEach>
                                
                               
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="row my-5">
             <!--    <div class="col-lg-6 col-sm-6">
                    <div class="coupon-box">
                        <div class="input-group input-group-sm">
                            <input style=" padding: 20px 15px;" class="form-control" placeholder="Nhập địa chỉ giao hàng" aria-label="Coupon code" type="text">
                            <div class="input-group-append">
                                <button class="btn btn-theme" type="button">Xác Nhận</button>
                            </div>
                        </div>
                    </div>
                </div> -->
                <div class="col-lg-6 col-sm-6" style="margin-left:150px">
                    <div class="update-box" >
                 <a href="user/cart1.htm"><input   value="Cập nhập giỏ hàng" type="submit"></a>
                    </div>
                </div>
            </div>

            <div class="row my-5">
                <div class="col-lg-8 col-sm-12"></div>
                <div class="col-lg-4 col-sm-12">
                    <div class="order-box">
                        <h3>Đơn hàng</h3>
                        
                        
                        <hr class="my-1">
                       
                        <div class="d-flex gr-total">
                            <h5>Tổng Cộng</h5>
                            
                            <div class="ml-auto h5"> ${tonggia } </div>
                        </div>
                        <hr> </div>
                </div>
                <div class="col-12 d-flex shopping-box"><a href="user/checkout.htm" class="ml-auto btn hvr-hover" onclick="myFunction()">Mua Hàng</a> </div>
            </div>

        </div>
    </div>
</body>
<script type="text/javascript">
function myFunction(){
	alert("Đặt Hàng Thành Công")
}

</script>
</html>
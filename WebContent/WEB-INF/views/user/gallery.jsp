<%@ page   pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<!-- Basic -->

<head>
<base href="${pageContext.servletContext.contextPath}/">
  </head>
<body>
    <!-- Start All Title Box -->
    <div class="all-title-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>Sản phẩm</h2>
                    
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Gallery  -->
    <div class="products-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="title-all text-center">
                        <h1>Zunzunn MilkTea Menu</h1>
                        <p><h3>Trà sữa của hạnh phúc</h3></p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="special-menu text-center">
                        <div class="button-group filter-button-group">
                            <button class="active" data-filter="*">Tất Cả</button>
                           
                        </div>
                    </div>
                </div>
            </div>

            <div class="row special-list">
               <c:forEach var="p" items="${products}">
           
                <div class="col-lg-3 col-md-6 special-grid bulbs">
                    <div class="products-single fix">
                        <div class="box-img-hover">
                            <div class="type-lb">
                              <p class="sale">${p.tenTS}</p>
                            </div>
                            <img style="display:block;  max-width: 500px; max-height: 300px;" img src="images/${p.hinhanh}"class="img-fluid" alt="${p.tenTS }">
                            <div class="type-lb">
                              <p style="margin-top: 200px" class="sale">${p.gia} VNĐ</p>
                            </div>
                            <div class="mask-icon">
                                
                                <a class="cart"  href="user/cart/${p.maTS}.htm">Thêm vào giỏ hàng</a>
                            </div>
                        </div>
                    </div>
                </div>
</c:forEach>
      
            </div>
        </div>
    </div>
    <!-- End Gallery  -->

 

    
</body>

</html>
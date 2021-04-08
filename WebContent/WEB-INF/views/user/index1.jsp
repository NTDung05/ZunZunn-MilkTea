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
    <!-- Start Slider -->
    <div id="slides-shop" class="cover-slides">
        <ul class="slides-container">
            <li class="text-center">
                <img src="images/banner-04.jpg" alt="">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="m-b-20"><Muli>Welcome To <br> Zunzunn</Muli></h1>
                            <p class="m-b-40">Với sứ mệnh mang tới niềm vui và hạnh phúc, chúng tôi hy vọng sẽ tạo nên nét đẹp văn hóa <br> giải trí bên cạnh ly trà sữa Ngon-Sạch-Tươi.</p>
                            <p><a class="btn hvr-hover" href="user/gallery.htm">Đặt hàng</a></p>
                           
                        </div>
                    </div>
                </div>
            </li>
            <li class="text-center">
                <img src="images/banner-01.jpg" alt="">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="m-b-20"><Muli>Welcome To <br> Zunzunn</Muli></h1>
                            <p class="m-b-40">Với sứ mệnh mang tới niềm vui và hạnh phúc, chúng tôi hy vọng sẽ tạo nên nét đẹp văn hóa <br> giải trí bên cạnh ly trà sữa Ngon-Sạch-Tươi.</p>
                            <div><h1 style="font-size:200px">${taikhoan.tenNV}</h1></div>
                            <p><a class="btn hvr-hover" href="user/gallery.htm">Đặt hàng</a></p>
                        </div>
                    </div>
                </div>
            </li>
            <li class="text-center">
                <img src="images/banner-03.jpg" alt="">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="m-b-20"><Muli>Welcome To <br> Zunzunn</Muli></h1>
                            <p class="m-b-40">Với sứ mệnh mang tới niềm vui và hạnh phúc, chúng tôi hy vọng sẽ tạo nên nét đẹp văn hóa <br> giải trí bên cạnh ly trà sữa Ngon-Sạch-Tươi.</p>
                            <p><a class="btn hvr-hover" href="user/gallery.htm">Đặt hàng</a></p>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
        <div class="slides-navigation">
            <a href="#" class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
            <a href="#" class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></a>
        </div>
    </div>
    <!-- End Slider -->

    <!-- Start Categories  -->
    <div class="categories-shop">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="shop-cat-box">
                        <img class="img-fluid" src="images/categories_img_04.png" alt="" />
                        <a class="btn hvr-hover" href="user/gallery.htm">Trà Sữa</a>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="shop-cat-box">
                        <img class="img-fluid" src="images/categories_img_06.jpg" alt="" />
                        <a class="btn hvr-hover" href="user/gallery.htm">Trà </a>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="shop-cat-box">
                        <img class="img-fluid" src="images/categories_img_05.jpg" alt="" />
                        <a class="btn hvr-hover" href="user/gallery.htm">Sinh tố</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Categories -->
	

</body>

</html>
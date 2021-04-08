<%@ page   pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
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
                    <h2>Liên Hệ</h2>
                    
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Contact Us  -->
    <div class="contact-box-main">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-sm-12">
                    <div class="contact-form-right">
                        <h2>GÓP Ý</h2>
                        <p>Đừng ngần ngại gửi các ý kiến của bạn cho Zunzunn MilkTea.<br>
                         Mọi ý kiến của bạn đều sẽ giúp Zunzunn MilkTea phát triển tốt hơn. Thanks!</p>
                        <form id="contactForm">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <input type="text" class="form-control" id="name" name="name" placeholder="Tên" required data-error="Vui lòng nhập tên của bạn">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <input type="text" placeholder="Email" id="email" class="form-control" name="name" required data-error="Vui lòng nhập email của bạn">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <input type="text" class="form-control" id="subject" name="name" placeholder="Tiêu đề" required data-error="Vui lòng nhập tiêu đề">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <textarea class="form-control" id="message" placeholder="Nội dung" rows="4" data-error="Write your message" required></textarea>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                    <div class="submit-button text-center">
                                        <button class="btn hvr-hover" id="submit" type="submit">Gửi</button>
                                        <div id="msgSubmit" class="h3 text-center hidden"></div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
				<div class="col-lg-4 col-sm-12">
                    <div class="contact-info-left">
                        <h2>Thông tin liên lạc</h2>
                        <h3><p>Của hàng trà sữa Zunzunn MilkTea </p></h3>
                        <ul>
                            <li>
                                <p><i class="fas fa-map-marker-alt"></i>Address: 79 Man Thiện, Quận 9 <br>Thành Phố Hồ Chí Minh<br> Việt Nam </p>
                            </li>
                            <li>
                                <p><i class="fas fa-phone-square"></i>Điện Thoại: <a href="tel:+84941853368">+84941 853 368</a></p>
                            </li>
                            <li>
                                <p><i class="fas fa-envelope"></i>Email: <a href="ZunzunnMilktea@gmail.com">ZunzunnMilktea@gmail.com</a></p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Cart -->

 
   
</body>

</html>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Quản Lý Bán Hàng</title>
     <base href="${pageContext.servletContext.contextPath}/">
  <!-- BOOTSTRAP STYLES-->
    <link href="css/admin/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="css/admin/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="css/admin/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
     <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


    <style>
        a
        {
        transition-duration: 0.2s;
        }
        a:hover{
          background-color:gray;
          color: black;
        }
      .footer
      {
      font-family:italic;
      font-size:18px;
      background-color:#330033;
      }
      p
      {
       margin: 0px 60px 0px 0px;
      }
      p.address
      {
        margin: 0px 60px 0px 580px;
      }
      .table
      {
        margin: 30px 60px 0px 130px;
      }
      table {
      border-spacing: 2;
      border-collapse: collapse;
      background: white;
      border-radius: 10px;
      overflow: hidden;
      width: 80%;
      margin: 0 auto;
      position: relative;
    }
    table * {
      position: relative;
    }
    table td, table th {
      padding-left: 8px;
    }
    table thead tr {
      height: 60px;
      background: #36304a;
      color:white;
    }
    table tbody tr {
      height: 50px;
    }
    table tbody tr:last-child {
      border: 0;
    }
    table td, table th {
      text-align: left;
    }
    table td.l, table th.l {
      text-align: right;
    }
    table td.c, table th.c {
      text-align: center;
    }
    table td.r, table th.r {
      text-align: center;
    }
	

    .table100-head th{
      font-family: OpenSans-Regular;
      font-size: 18px;
      color: #fff;
      line-height: 1.2;
      font-weight: unset;
    }

    tbody tr:nth-child(even) {
      background-color: #f5f5f5;
    }

    tbody tr {
      font-family: OpenSans-Regular;
      font-size: 18px;
      color: #808080;
      line-height: 1.2;
      font-weight: unset;
    }
     
}

    </style>
    
</head>
<body>
     <div id="wrapper" >
         <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="adjust-nav" style="background-color: #FFFFFF">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                
                <br><br>
             <p><img src="images/logo1.png" class="logo" style="margin-left: 600px" alt=""></p>
           <!--    <p style="color:#fff;font-size: 40px; margin-left: 600px"><Muli>Zunzunn MilkTea</Muli></p>
-->
  
              
                
            </div>
        </div>
        <!-- /. NAV TOP  -->
       
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse" style="margin-top: -100px">
                <ul class="nav" id="main-menu" >
              
                   
                    <li>
                        <a style="color: #04B431" href="admin/user/index.htm"><i class="	fa fa-drivers-license-o"></i>Khách hàng</a>
                    </li>

                    <li>
                        <a style="color: #04B431" href="admin/product/index.htm"><i class="fa fa-glass "></i>Sản phẩm</a>
                    </li>
                    <li>
                        <a style="color: #04B431" href="admin/bill/index.htm"><i class="fa fa-dropbox "></i>Đơn hàng</a>
                    </li>
                    
                    <li> <a style="color: #04B431" href="TRASUA/index.htm"><i class="	fa fa-sign-out"></i>Đăng Xuất</a>
                    </li>
                </ul>
               
             </div>
    
        </nav>
  
            <div class="table">
              <jsp:include page="${param.view}"/>
            </div>
         </div>
        
         <!-- /. PAGE WRAPPER  -->
        


   

</body>
</html>
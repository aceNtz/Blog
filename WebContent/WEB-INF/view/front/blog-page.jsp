<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Blog</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/vendor/font-awesome/css/font-awesome.min.css">
    <!-- Custom icon font-->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/fontastic.css">
    <!-- Google fonts - Open Sans-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <!-- Fancybox-->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/vendor/@fancyapps/fancybox/jquery.fancybox.min.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/favicon.png">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <body>
    <header class="header">
      <!-- Main Navbar-->
      <nav class="navbar navbar-expand-lg">
        <div class="search-area">
          <div class="search-area-inner d-flex align-items-center justify-content-center">
            <div class="close-btn"><i class="icon-close"></i></div>
            <div class="row d-flex justify-content-center">
              <div class="col-md-8">
                <form action="blog-search.html">
                  <div class="form-group">
                    <input type="search" name="search" id="search" placeholder="What are you looking for?">
                    <button type="submit" class="submit"><i class="icon-search-1"></i></button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <div class="container">
          <!-- Navbar Brand -->
          <div class="navbar-header d-flex align-items-center justify-content-between">
            <!-- Navbar Brand --><a href="index-page" class="navbar-brand">Blog</a>
            <!-- Toggle Button-->
            <button type="button" data-toggle="collapse" data-target="#navbarcollapse" aria-controls="navbarcollapse" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler"><span></span><span></span><span></span></button>
          </div>
          <!-- Navbar Menu -->
          <div id="navbarcollapse" class="collapse navbar-collapse">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item"><a href="index-page" class="nav-link">Home</a>
              </li>
              <li class="nav-item"><a href="blog-page" class="nav-link active">Blog</a>
              </li>
              <li class="nav-item"><a href="contact-page" class="nav-link">Contact</a>
              </li>
            </ul>
            <div class="navbar-text"><a href="#" class="search-btn"><i class="icon-search-1"></i></a></div>
          </div>
        </div>
      </nav>
    </header>
    <div class="container">
      <div class="row">
        <!-- Latest Posts -->
        <main class="posts-listing col-lg-8"> 
          <div class="container">
            <div class="row">
            <c:forEach items="${allEnabledBlogPosts }" var="bp">
              <!-- post -->
              <div class="post col-xl-6">
                <div class="post-thumbnail"><a href="#"><img src="${bp.image }" alt="..." class="img-fluid"></a></div>
                <div class="post-details">
                  <div class="post-meta d-flex justify-content-between">
                    <div class="date meta-last">${bp.dateOptionOne }</div>
                    <div class="category"><a href="#">${bp.category }</a></div>
                  </div><a href="#">
                    <h3 class="h4">${bp.name }</h3></a>
                  <p class="text-muted">${bp.description }</p>
                  <footer class="post-footer d-flex align-items-center"><a href="#" class="author d-flex align-items-center flex-wrap">
                      <div class="avatar"><img src="${bp.author.image }" alt="..." class="img-fluid"></div>
                      <div class="title"><span>${bp.author.name}</span></div></a>
                    <div class="date"><i class="icon-clock"></i> ${bp.dateOptionTwo }</div>
                    <div class="comments meta-last"><i class="icon-comment"></i>${bp.comments.size() != null ? bp.comments.size() : '0' }</div>
                  </footer>
                </div>
              </div>
            </c:forEach>
            <!-- Pagination -->
            <nav aria-label="Page navigation example">
              <ul class="pagination pagination-template d-flex justify-content-center">
              
                <c:if test="${pageNum > 0 }">
                  <li class="page-item"><a href="blog-page?pageNum=${pageNum - 1 }" class="page-link"> <i class="fa fa-angle-left"></i></a></li>
                </c:if>
                
                <c:if test="${pageNum <= 0 }">
                  <li class="page-item"><a href="blog-page?pageNum=0" class="page-link"> <i class="fa fa-angle-left"></i></a></li>
                </c:if>
                
                <c:forEach begin="0" end="${numberOfPages - 1 }" var="i">
                <li class="page-item"><a href="blog-page?pageNum=${i }"  class="${i == pageNum ? 'page-link active' : 'page-link' }">${i+1 }</a></li>
                </c:forEach>
                
                <c:if test="${pageNum + 1 < numberOfPages }">
                  <li class="page-item"><a href="blog-page?pageNum=${pageNum + 1 }" class="page-link"> <i class="fa fa-angle-right"></i></a></li>
                </c:if>
                
                <c:if test="${pageNum + 1 >= numberOfPages }">
                  <li class="page-item"><a href="blog-page?pageNum=${numberOfPages - 1}" class="page-link"> <i class="fa fa-angle-right"></i></a></li>
                </c:if>

              </ul>
            </nav>
          </div>
        </main>
        <aside class="col-lg-4">
          <!-- Widget [Search Bar Widget]-->
          <div class="widget search">
            <header>
              <h3 class="h6">Search the blog</h3>
            </header>
            <form action="blog-search.html" class="search-form">
              <div class="form-group">
                <input type="search" placeholder="What are you looking for?">
                <button type="submit" class="submit"><i class="icon-search"></i></button>
              </div>
            </form>
          </div>
          <!-- Widget [Latest Posts Widget]        -->
          <div class="widget latest-posts">
            <header>
              <h3 class="h6">Latest Posts</h3>
            </header>
            <div class="blog-posts">
              <c:forEach items="${threeMostViewedBlogPostsFromLastThirtyDays }" var="bp">
                <a href="#">
                <div class="item d-flex align-items-center">
                  <div class="image"><img src="${bp.image }" alt="..." class="img-fluid"></div>
                  <div class="title"><strong>${bp.name }</strong>
                    <div class="d-flex align-items-center">
                      <div class="views"><i class="icon-eye"></i>${bp.viewCount }</div>
                      <div class="comments"><i class="icon-comment"></i>${bp.comments.size() }</div>
                    </div>
                  </div>
                </div></a>
              </c:forEach>
            </div>
          </div>
          <!-- Widget [Categories Widget]-->
          <div class="widget categories">
            <header>
              <h3 class="h6">Categories</h3>
            </header>
            <c:forEach items="${mostUsedCategories }" var="category">
              <div class="item d-flex justify-content-between"><a href="#">${category.name }</a><span>${category.timesUsed }</span></div>
            </c:forEach>
          </div>
          <!-- Widget [Tags Cloud Widget]-->
          <div class="widget tags">       
            <header>
              <h3 class="h6">Tags</h3>
            </header>
            <ul class="list-inline">
              <c:forEach items="${mostUsedTags }" var="tag">
                <li class="list-inline-item"><a href="#" class="tag">${tag.name }</a></li>
              </c:forEach>
            </ul>
          </div>
        </aside>
      </div>
    </div>
    <!-- Page Footer-->
    <footer class="main-footer">
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <div class="logo">
              <h6 class="text-white">${companyInfo.name}</h6>
            </div>
            <div class="contact-details">
              <p>${companyInfo.streetAndNumber }  ${companyInfo.city }</p>
              <p>Phone: ${companyInfo.phoneOne } </p>
              <p>Phone: ${companyInfo.phoneTwo } </p>
              <p>Email: <a href="#">${companyInfo.email } </a></p>
              <ul class="social-menu">
                <li class="list-inline-item"><a href="${companyInfo.facebook }" target="_blank"><i class="fa fa-facebook"></i></a></li>
                <li class="list-inline-item"><a href="${companyInfo.twitter }" target="_blank"><i class="fa fa-twitter"></i></a></li>
                <li class="list-inline-item"><a href="${companyInfo.instagram }" target="_blank"><i class="fa fa-instagram"></i></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md-4">
            <div class="menus d-flex">
              <ul class="list-unstyled">
                <li> <a href="index-page">Home</a></li>
                <li> <a href="blog-page">Blog</a></li>
                <li> <a href="contact-page">Contact</a></li>
                <li> <a href="administration/">Login</a></li>
              </ul>
              <ul class="list-unstyled">
              <c:forEach items="${importantCategories }" var="category">
                <li> <a href="#">${category.name }</a></li>
              </c:forEach>
              </ul>
            </div>
          </div>
          <div class="col-md-4">
            <div class="latest-posts"><a href="blog-post.html"></a>
            <c:forEach items="${footerBP }" var="blogPost">
                <div class="post d-flex align-items-center">
                  <div class="image"><img src="${blogPost.image }" alt="..." class="img-fluid"></div>
                  <div class="title"><strong>${blogPost.name }</strong><span class="date last-meta">${blogPost.date }</span></div>
                </div><a href="blog-post.html"></a>
            </c:forEach>
            </div>
          </div>
        </div>
      </div>
      <div class="copyrights">
        <div class="container">
          <div class="row">
            <div class="col-md-6">
              <p>&copy; 2017. All rights reserved. ${companyInfo.name }</p>
            </div>
            <div class="col-md-6 text-right">
              <p>Template By <a href="https://bootstrapious.com/p/bootstrap-carousel" class="text-white">Bootstrapious</a>
                <!-- Please do not remove the backlink to Bootstrap Temple unless you purchase an attribution-free license @ Bootstrap Temple or support us at http://bootstrapious.com/donate. It is part of the license conditions. Thanks for understanding :)                         -->
              </p>
            </div>
          </div>
        </div>
      </div>
    </footer>
    <!-- JavaScript files-->
    <script src="${pageContext.request.contextPath }/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="${pageContext.request.contextPath }/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="${pageContext.request.contextPath }/vendor/@fancyapps/fancybox/jquery.fancybox.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/front.js"></script>
  </body>
</html>
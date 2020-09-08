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


    
    <!-- owl carousel 2 stylesheet-->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/owl-carousel2/assets/owl.carousel.min.css" id="theme-stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/owl-carousel2/assets/owl.theme.default.min.css" id="theme-stylesheet">
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
            
              <c:if test="${messageSentConfirmation == true }">
	      		<div class="alert alert-success alert-dismissible">
	                  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">�</button>
	                  Message sent!
	            </div>
	      	  </c:if>
            
              <li class="nav-item"><a href="index-page" class="nav-link active">Home</a>
              </li>
              <li class="nav-item"><a href="blog-page" class="nav-link">Blog</a>
              </li>
              <li class="nav-item"><a href="contact-page" class="nav-link">Contact</a>
              </li>
            </ul>
            <div class="navbar-text"><a href="#" class="search-btn"><i class="icon-search-1"></i></a></div>
          </div>
        </div>
      </nav>
    </header>

    <!--SLIDER-->
    <div id="index-slider" class="owl-carousel owl-loaded owl-drag">
    	<div class="owl-stage=outer">
    		<div class="owl-stage">
			    <c:forEach items="${sliderElementList}" varStatus="i" begin="0" end="${sliderElementList.size() - 1 }">
				    <div class="${i.index == 0  ? 'owl-item active' : 'owl-item'}"> 
				      <section style="background: url(${sliderElementList[i.index].image}); background-size: cover; background-position: center center" class="hero" >
				        <div class="container">
				          <div class="row">
				            <div class="col-lg-7">
				              <h1>${sliderElementList[i.index].name }</h1>
				              <a href="${sliderElementList[i.index].buttonUrl }" target="_blank" class="hero-link">${sliderElementList[i.index].buttonName }</a>
				            </div>
				          </div>
				        </div>
				      </section>
				    </div>
			    </c:forEach>
			</div>
		</div>
    </div>

	
    <!-- Intro Section-->
    <section class="intro">
      <div class="container">
        <div class="row">
          <div class="col-lg-8">
            <h2 class="h3">${frontText.indexIntro}</h2>
            <p class="text-big">${frontText.indexText1} <strong>${frontText.indexText2}</strong> ${frontText.indexText3} <strong>${frontText.indexText4}</strong>.</p>
          </div>
        </div>
      </div>
    </section>
    <section class="featured-posts no-padding-top">
      <div class="container">
      <c:if test="${importantBP != null }">
      <c:forEach  begin="0" end="${importantBP.size()-1 }" var="i">
        <!-- Post-->
        <c:if test="${i % 2 == 0 }">
        <div class="row d-flex align-items-stretch">
          <div class="text col-lg-7">
            <div class="text-inner d-flex align-items-center">
              <div class="content">
                <header class="post-header">
                  <div class="category"><a href="${pageContext.request.contextPath }/blog-category.html">${importantBP[i].category.name }</a></div><a href="${pageContext.request.contextPath }/blog-post.html">
                    <h2 class="h4">${importantBP[i].name}</h2></a>
                </header>
                <p>${importantBP[i].description }</p>
                <footer class="post-footer d-flex align-items-center"><a href="blog-author.html${pageContext.request.contextPath }/" class="author d-flex align-items-center flex-wrap">
                    <div class="avatar"><img src="${importantBP[i].author.image }" alt="..." class="img-fluid"></div>
                    <div class="title"><span>${importantBP[i].author.name }  ${importantBP[i].author.surname }</span></div></a>
                  <div class="date"><i class="icon-clock"></i> ${importantBP[i].dateOptionOne }</div>
                  <div class="comments"><i class="icon-comment"></i>${importantBP[i].comments.size() }</div>
                </footer>
              </div>
            </div>
          </div>
          <div class="image col-lg-5"><img src="${importantBP[i].image }" alt="..."></div>
        </div>
        </c:if>
        <!-- Post        -->
        <c:if test="${i % 2 != 0 }">
        <div class="row d-flex align-items-stretch">
          <div class="image col-lg-5"><img src="${importantBP[i].image }" alt="..."></div>
          <div class="text col-lg-7">
            <div class="text-inner d-flex align-items-center">
              <div class="content">
                <header class="post-header">
                  <div class="category"><a href="${pageContext.request.contextPath }/blog-category.html">${importantBP[i].category.name }</a></div><a href="${pageContext.request.contextPath }/blog-post.html">
                    <h2 class="h4">${importantBP[i].name }</h2></a>
                </header>
                <p>${importantBP[i].description }</p>
                <footer class="post-footer d-flex align-items-center"><a href="${pageContext.request.contextPath }/blog-author.html" class="author d-flex align-items-center flex-wrap">
                    <div class="avatar"><img src="${importantBP[i].author.image }" alt="..." class="img-fluid"></div>
                    <div class="title"><span>${importantBP[i].author.name }  ${importantBP[i].author.surname }</span></div></a>
                  <div class="date"><i class="icon-clock"></i> ${importantBP[i].dateOptionOne }</div>
                  <div class="comments"><i class="icon-comment"></i>${importantBP[i].comments.size() }</div>
                </footer>
              </div>
            </div>
          </div>
        </div>
        </c:if>
        </c:forEach>
        </c:if>
      </div>
    </section>
    <!-- Divider Section-->
    <section style="background: url(img/divider-bg.jpg); background-size: cover; background-position: center bottom" class="divider">
      <div class="container">
        <div class="row">
          <div class="col-md-7">
            <h2>${frontText.slogan}</h2>
            <a href="contact-page" class="hero-link">Contact Us</a>
          </div>
        </div>
      </div>
    </section>
    <!-- Latest Posts -->
    <section class="latest-posts"> 
      <div class="container">
        <header> 
          <h2>Latest from the blog</h2>
          <p class="text-big">${frontText.latestFromTheBlogIntro }</p>
        </header>
        <div class="owl-carousel" id="latest-posts-slider">
          <c:forEach items="${recentBP}" var="bl" varStatus="loop">
          
          	<c:if test="${loop.index % 3 == 0}">
		        <div class="row">
		        
		          <c:forEach items="${recentBP}" var="blog" begin="${loop.index}" end="${loop.index+2}" >
		          
		            <div class="post col-md-4">
		              <div class="post-thumbnail"><a href="#"><img src="${blog.image}" alt="..." class="img-fluid"></a></div>
		              <div class="post-details">
		                <div class="post-meta d-flex justify-content-between">
		                  <div class="date">${blog.dateOptionOne}</div>
		                  <div class="category">
		                  	
		                  	<c:if test="${blog.category.id != null}">
		                  		<a href="#">${blog.category.getName()}</a>
		                    </c:if>
		                    
		                    <c:if test="${blog.category.id == null}">
		                  		<a>UNCATEGORIZED</a>
		                    </c:if>
		                  	
		                  </div>
		                </div><a href="#">
		                  <h3 class="h4">${blog.name}</h3></a>
		                <p class="text-muted">${blog.description}</p>
		              </div>
		            </div>
		            
		          </c:forEach>
		          
		        </div>
		        
	        </c:if>
	          
          </c:forEach>
          
        </div>
      </div>
    </section>
    <!-- Gallery Section-->
    <section class="gallery no-padding">    
      <div class="row">
        <div class="mix col-lg-3 col-md-3 col-sm-6">
          <div class="item">
            <a href="${pageContext.request.contextPath }/img/gallery-1.jpg" data-fancybox="gallery" class="image">
              <img src="${pageContext.request.contextPath }/img/gallery-1.jpg" alt="gallery image alt 1" class="img-fluid" title="gallery image title 1">
              <div class="overlay d-flex align-items-center justify-content-center"><i class="icon-search"></i></div>
            </a>
          </div>
        </div>
        <div class="mix col-lg-3 col-md-3 col-sm-6">
          <div class="item">
            <a href="${pageContext.request.contextPath }/img/gallery-2.jpg" data-fancybox="gallery" class="image">
              <img src="${pageContext.request.contextPath }/img/gallery-2.jpg" alt="gallery image alt 2" class="img-fluid" title="gallery image title 2">
              <div class="overlay d-flex align-items-center justify-content-center"><i class="icon-search"></i></div>
            </a>
          </div>
        </div>
        <div class="mix col-lg-3 col-md-3 col-sm-6">
          <div class="item">
            <a href="${pageContext.request.contextPath }/img/gallery-3.jpg" data-fancybox="gallery" class="image">
              <img src="${pageContext.request.contextPath }/img/gallery-3.jpg" alt="gallery image alt 3" class="img-fluid" title="gallery image title 3">
              <div class="overlay d-flex align-items-center justify-content-center"><i class="icon-search"></i></div>
            </a>
          </div>
        </div>
        <div class="mix col-lg-3 col-md-3 col-sm-6">
          <div class="item">
            <a href="${pageContext.request.contextPath }/img/gallery-4.jpg" data-fancybox="gallery" class="image">
              <img src="${pageContext.request.contextPath }/img/gallery-4.jpg" alt="gallery image alt 4" class="img-fluid" title="gallery image title 4">
              <div class="overlay d-flex align-items-center justify-content-center"><i class="icon-search"></i></div>
            </a>
          </div>
        </div>
        
      </div>
    </section>
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
              <p>Email: <a href="mailto:info@company.com">${companyInfo.email } </a></p>
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
                  <div class="title"><strong>${blogPost.name }</strong><span class="date last-meta">${blogPost.dateOptionOne }</span></div>
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


    <script src="${pageContext.request.contextPath }/plugins/owl-carousel2/owl.carousel.min.js"></script>
    <script>
      $("#index-slider").owlCarousel({
        "items": 1,
        "loop": true,
        "autoplay": true,
        "autoplayHoverPause": true
      });

      $("#latest-posts-slider").owlCarousel({
        "items": 1,
        "loop": true,
        "autoplay": true,
        "autoplayHoverPause": true
      });
    </script>
    
  </body>
</html>
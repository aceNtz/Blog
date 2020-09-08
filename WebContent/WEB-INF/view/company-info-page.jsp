<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

  <title>Blog - All messages</title>

  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">

  <link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/jquery-ui/jquery-ui.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/jquery-ui/jquery-ui.theme.min.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
    </ul>

    
    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
      <!-- Messages Dropdown Menu -->
      <!-- Notifications -->
	  <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-comments"></i>
          <span class="badge badge-danger navbar-badge">${unreadCounter }</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <a href="message-unread-list" class="dropdown-item dropdown-footer">See Unread Messages</a>
        </div>
      </li>
	  <!--  LOGIN -->
      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-user"></i>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <a href="blogger-profile" class="dropdown-item">
            <!-- Message Start -->
            <div class="media align-items-center">
              <img src="${user.image }" alt="User Avatar" class="img-size-50 mr-3 img-circle">
              <div class="media-body">
              	${user.username }
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          <a href="blogger-change-password" class="dropdown-item">
            <i class="fas fa-user"></i> Change Password
          </a>
          <div class="dropdown-divider"></div>
          <a href="${pageContext.request.contextPath }/login.html" class="dropdown-item">
              
			<form:form action="${pageContext.request.contextPath }/logout">
			  <input type="submit" value="Log out">
			</form:form>

          </a>
        </div>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="front-index" target="_blank" class="brand-link">
      <img src="${pageContext.request.contextPath }/dist/img/blog.png" alt="Cubes School Logo" class="brand-image img-circle elevation-3"
           style="opacity: .8">
      <span class="brand-text font-weight-light">Blog</span>
    </a>

    <div class="sidebar">
	  <!-- Sidebar Menu -->
	  <nav class="mt-2">
	    <ul class="nav nav-pills nav-sidebar flex-column" data-accordion="false" data-widget="treeview" role="menu">
	      <!-- Add icons to the links using the .nav-icon class
	                   with font-awesome or any other icon font library -->
	      <sec:authorize access="hasRole('admin')">
	      <li class="nav-item has-treeview">
	        <a class="nav-link" href="#"><i class="fas fa-align-justify"></i>
	        <p>Slider <i class="right fas fa-angle-left"></i></p></a>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="slider-element-list"><i class="far fa-circle nav-icon"></i>
	            <p>Slider elements</p></a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="slider-element-form"><i class="far fa-circle nav-icon"></i>
	            <p>Add slider element</p></a>
	          </li>
	        </ul>
	      </li>
	      </sec:authorize>
	      <sec:authorize access="hasRole('admin')">
	      <li class="nav-item has-treeview">
	        <a class="nav-link" href=""><i class="fas fa-align-justify"></i>
	        <p>Messages <i class="right fas fa-angle-left"></i></p></a>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="message-list"><i class="far fa-circle nav-icon"></i>
	            <p>All messages</p></a>
	          </li>
	        </ul>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="message-unread-list"><i class="far fa-circle nav-icon"></i>
	            <p>Unread messages</p></a>
	          </li>
	        </ul>
	      </li>
	      </sec:authorize>
	      <sec:authorize access="hasRole('admin')">
	      <li class="nav-item has-treeview">
	        <a class="nav-link" href=""><i class="fas fa-align-justify"></i>
	        <p>Bloggers <i class="right fas fa-angle-left"></i></p></a>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="blogger-list"><i class="far fa-circle nav-icon"></i>
	            <p>All bloggers</p></a>
	          </li>
	        </ul>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="blogger-form"><i class="far fa-circle nav-icon"></i>
	            <p>Add blogger</p></a>
	          </li>
	        </ul>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="blogger-banned-list"><i class="far fa-circle nav-icon"></i>
	            <p>Banned bloggers</p></a>
	          </li>
	        </ul>
	      </li>
	      </sec:authorize>
	      <li class="nav-item has-treeview">
	        <a class="nav-link" href=""><i class="fas fa-align-justify"></i>
	        <p>Blog Posts <i class="right fas fa-angle-left"></i></p></a>
	        <ul class="nav nav-treeview">
	          <sec:authorize access="hasRole('admin')">
	          <li class="nav-item">
	            <a class="nav-link" href="blog-post-list"><i class="far fa-circle nav-icon"></i>
	            <p>All blog posts</p></a>
	          </li>
	          </sec:authorize>
	        </ul>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="blog-post-my-list"><i class="far fa-circle nav-icon"></i>
	            <p>My blog posts</p></a>
	          </li>
	        </ul>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="blog-post-form"><i class="far fa-circle nav-icon"></i>
	            <p>Add blog post</p></a>
	          </li>
	        </ul>
	      </li>
	      <sec:authorize access="hasRole('admin')">
	      <li class="nav-item has-treeview">
	        <a class="nav-link" href=""><i class="fas fa-align-justify"></i>
	        <p>Categories <i class="right fas fa-angle-left"></i></p></a>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="category-list"><i class="far fa-circle nav-icon"></i>
	            <p>All categories</p></a>
	          </li>
	        </ul>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="category-form"><i class="far fa-circle nav-icon"></i>
	            <p>Add category</p></a>
	          </li>
	        </ul>
	      </li>
	      </sec:authorize>
	      <sec:authorize access="hasRole('admin')">
	      <li class="nav-item has-treeview">
	        <a class="nav-link" href=""><i class="fas fa-align-justify"></i>
	        <p>Tags <i class="right fas fa-angle-left"></i></p></a>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="tag-list"><i class="far fa-circle nav-icon"></i>
	            <p>All tags</p></a>
	          </li>
	        </ul>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="tag-form"><i class="far fa-circle nav-icon"></i>
	            <p>Add tag</p></a>
	          </li>
	        </ul>
	      </li>
	      </sec:authorize>
	      <sec:authorize access="hasRole('admin')">
	      <li class="nav-item has-treeview">
	        <a class="nav-link" href=""><i class="fas fa-align-justify"></i>
	        <p>Comments <i class="right fas fa-angle-left"></i></p></a>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="comment-list"><i class="far fa-circle nav-icon"></i>
	            <p>All comments</p></a>
	          </li>
	        </ul>
	      </li>
	      </sec:authorize>
	      <sec:authorize access="hasRole('admin')">
	      <li class="nav-item has-treeview">
	        <a class="nav-link" href=""><i class="fas fa-align-justify"></i>
	        <p>Front<i class="right fas fa-angle-left"></i></p></a>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="front-text"><i class="far fa-circle nav-icon"></i>
	            <p>Front text</p></a>
	          </li>
	        </ul>
	      </li>
	      </sec:authorize>
	      <sec:authorize access="hasRole('admin')">
	      <li class="nav-item has-treeview">
	        <a class="nav-link" href=""><i class="fas fa-align-justify"></i>
	        <p>Company <i class="right fas fa-angle-left"></i></p></a>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="company-info"><i class="far fa-circle nav-icon"></i>
	            <p>Company Info</p></a>
	          </li>
	        </ul>
	      </li>
	      </sec:authorize>
	    </ul>
	  </nav><!-- /.sidebar-menu -->
	</div><!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Company Info</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Company</a></li>
              <li class="breadcrumb-item active">Company Info</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Company Info</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table class="table table-bordered">
                  <thead>                  
                    <tr>
                      <th class="text-center">Name</th>
                      <th class="text-center">City</th>
                      <th class="text-center">Street&Number</th>
                      <th class="text-center">Zip</th>
                      <th class="text-center">Phone 1</th>
                      <th class="text-center">Phone 2</th>
                      <th class="text-center">Email</th>
                      <th class="text-center">Social</th>
                      <th class="text-center">Actions</th>
                    </tr>
                  </thead>
                  <tbody id="sort-list">
	                    <tr>
	                      <td>
	                        ${company.name }
	                      </td>
	                      <td>
	                        ${company.city }
	                      </td>
	                      <td>
	                        ${company.streetAndNumber }
	                      </td>
	                      <td>
	                        ${company.zipCode }
	                      </td>
	                      <td>
	                        ${company.phoneOne }
	                      </td>
	                      <td>
	                        ${company.phoneTwo }
	                      </td>
	                      <td>
	                        ${company.email }
	                      </td>
	                      <td class="text-center">
	                        <div class="btn-group"> 
	                          <a href="${company.instagram }" target="_blank" class="btn btn-info">
                            	<i class="fab fa-instagram"></i>
                              </a>
                              <a href="${company.facebook }" target="_blank" class="btn btn-info">
                            	<i class="fab fa-facebook-f"></i>
                              </a>
                              <a href="${company.twitter }" target="_blank" class="btn btn-info">
                            	<i class="fab fa-twitter"></i>
                              </a>
	                        </div>
	                      </td>
	                      <td class="text-center">
	                        <div class="btn-group"> 
	                          <a href="company-info-update" class="btn btn-info">
                            	<i class="fas fa-edit"></i>
                              </a>
	                        </div>
	                      </td>
	                    </tr>
	                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <!-- Default to the left -->
    <strong>Copyright &copy; 2019 <a href="https://cubes.edu.rs">Cubes School</a>.</strong> All rights reserved.
  </footer>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath }/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath }/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath }/dist/js/adminlte.min.js"></script>
<script src="${pageContext.request.contextPath }/plugins/jquery-ui/jquery-ui.min.js"></script>
</body>
</html>


</body>
</html>
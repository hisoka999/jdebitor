<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
<!--
	
//-->
function dateFormatter(value){
  var a = new Date(value);
  var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
  var year = a.getFullYear();
  var month = months[a.getMonth()];
  var date = a.getDate();
  var time = date + ' ' + month + ' ' + year;
  //return value;
  return time;
}
</script>
<div class="row">
	<ol class="breadcrumb">
		<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
		<li >Invoice</li>
		<li class="active">Create</li>
	</ol>
</div>
<!--/.row-->

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Create Invoice</h1>
	</div>
</div>
<!--/.row-->


<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Create Customer</div>
			<div class="panel-body">
				<div class="col-md-6">
					<c:url value='/customer/add' var="addUrl"/>
					<form:form role="form" method="POST"
						action="${addUrl}" modelAttribute="customerForm">

						<div class="form-group">
							<label>Firstname</label> <form:input path="firstName" cssClass="form-control" />
								<form:errors path="firstName" />
						</div>

						<div class="form-group">
							<label>last name</label> <input class="form-control"
								placeholder="last name" name="lastName">
								<form:errors path="lastName" />
						</div>
						
						<div class="form-group">
							<label>birthDate</label> <input class="form-control" type="date"
								placeholder="last name" name="birthDate" />
								<form:errors path="birthDate" />
						</div>
						
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />

						<button type="submit" class="btn btn-primary">Create</button>
						<button type="reset" class="btn btn-default">Reset</button>
					</form:form>
				</div>
			</div>
		</div>
		<!-- /.col-->
	</div>
	<!-- /.row -->
</div>
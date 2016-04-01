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
		<li class="active">Invoices</li>
	</ol>
</div>
<!--/.row-->

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Invoices</h1>
	</div>
</div>
<!--/.row-->


<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">All Invoices</div>
			<div class="panel-body">
				<table data-toggle="table"
					data-url="<c:url value='/invoice/json/allOpen'/>"
					data-show-refresh="true" data-show-toggle="true"
					data-show-columns="true" data-search="true"
					data-select-item-name="toolbar1" data-pagination="true"
					data-sort-name="name" data-sort-order="desc">
					<thead>
						<tr>
							<th data-field="id" data-checkbox="true">Invoice ID</th>
							<th data-field="product" data-sortable="true">Product</th>
							<th data-field="price" data-sortable="true">Price</th>
							<th data-field="dueDate" data-sortable="true" data-formatter="dateFormatter">DueDate</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</div>
<!--/.row-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
			<div class="panel-heading">Create Invoice</div>
			<div class="panel-body">
				<div class="col-md-6">
					<c:url value='/invoice/add' var="addUrl"/>
					<form:form role="form" method="POST"
						action="${addUrl}" modelAttribute="invoiceForm">

						<div class="form-group">
							<label>Customer</label> <form:input path="customer" cssClass="form-control" />
								<form:errors path="customer" />
						</div>

						<div class="form-group">
							<label>Currency</label> 
								
						</div>
						
						<div class="form-group">
							<label>Due Date</label> <input class="form-control" type="date"
								 name="dueDate" />
								<form:errors path="dueDate" />
						</div>
						
						<div class="form-group">
							<table>
								<tr>
									<th>Product</th>
									<th>Net Amount</th>
									<th>Tax</th>
									<th>Currency</th>
								</tr>
						    <c:forEach items="${invoiceForm.invoiceItems}" var="invoiceItem" varStatus="status">
						        <tr>
						            <td><input name="invoiceItems[${status.index}].product" value="${invoiceItem.product}"/></td>
						            <td><input name="invoiceItems[${status.index}].netAmount" value="${invoiceItem.netAmount}"/></td>
						            <td><input name="invoiceItems[${status.index}].tax" value="${invoiceItem.tax}"/></td>
						            <td><input name="invoiceItems[${status.index}].currency" value="${invoiceItem.currency}"/></td>
						        </tr>
						    </c:forEach>
						        <tr>
						            <td><input name="invoiceItems[${fn:length(invoiceForm.invoiceItems)+1}].product" value="${invoiceItem.product}"/></td>
						            <td><input name="invoiceItems[1].netAmount" value="${invoiceItem.netAmount}"/></td>
						            <td><input name="invoiceItems[1].tax" value="${invoiceItem.tax}"/></td>
						            <td><input name="invoiceItems[1].currency" value="${invoiceItem.currency}"/></td>
						        </tr>
							</table>
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
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:choose>
		<c:when test="${bookForm['new']}">
			<h1>Add Book</h1>
		</c:when>
		<c:otherwise>
			<h1>Update Book</h1>
		</c:otherwise>
	</c:choose>
	<br />

	<spring:url value="/books" var="bookActionUrl" />

	<form:form class="form-horizontal" method="post" modelAttribute="bookForm" action="${bookActionUrl}">

		<form:hidden path="id" />

		<spring:bind path="title">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">title</label>
				<div class="col-sm-10">
					<form:input path="title" type="text" class="form-control " id="title" placeholder="Title" />
					<form:errors path="title" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="year">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Year</label>
				<div class="col-sm-10">
					<form:input path="year" class="form-control" id="year" placeholder="Year" />
					<form:errors path="year" class="control-label" />
				</div>
			</div>
		</spring:bind>

		<spring:bind path="author">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Author</label>
				<div class="col-sm-10">
					<form:textarea path="author" rows="5" class="form-control" id="author" placeholder="author" />
					<form:errors path="author" class="control-label" />
				</div>
			</div>
		</spring:bind>
		
		<spring:bind path="category">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Category</label>
				<div class="col-sm-5">
					<form:select path="category" class="form-control">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${categoryList}" />
					</form:select>
					<form:errors path="category" class="control-label" />
				</div>
				<div class="col-sm-5"></div>
			</div>
		</spring:bind>

		<spring:bind path="cover">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Cover</label>
				<div class="col-sm-10">
					<form:textarea path="cover" rows="5" class="form-control" id="cover" placeholder="cover" />
					<form:errors path="cover" class="control-label" />
				</div>
			</div>
		</spring:bind>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${bookForm['new']}">
						<button type="submit" class="btn-lg btn-primary pull-right">Add</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn-lg btn-primary pull-right">Update</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<div class="container">

	<c:if test="${not empty msg}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<h1>Book Detail</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">${book.id}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Title</label>
		<div class="col-sm-10">${book.title}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Year</label>
		<div class="col-sm-10">${book.year}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Author</label>
		<div class="col-sm-10">${book.author}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Category</label>
		<div class="col-sm-10">${book.category}</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Cover</label>
		<div class="col-sm-10">${book.cover}</div>
	</div>

</div>

<jsp:include page="../fragments/footer.jsp" />

</body>
</html>
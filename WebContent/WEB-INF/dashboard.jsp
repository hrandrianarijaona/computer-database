<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="pg" tagdir="/WEB-INF/tags/Pagination"%>
<jsp:include page="../include/header.jsp" />

<section id="main">
	<h1 id="homeTitle">${ nbComputer } Computers found</h1>

	<div id="actions">
		<form action="RedirectIndexServlet" method="GET">
			<input type="search" id="searchbox" name="filter" value=""
				placeholder="Search name"> <input type="submit"
				id="searchsubmit" value="Filter by name" class="btn btn-primary">
		</form>
		<a class="btn btn-success" id="add" href="RedirectAddComputerServlet">Add
			Computer</a>
	</div>

	<table class="table table-bordered">
		<thead>
			<tr>
				<!-- Variable declarations for passing labels as parameters -->
				<!-- Table header for Computer Name -->
				<th>Computer Name <a class="btn btn-default btn-xs"
					id="sortDesc" href="RedirectIndexServlet?codeTri=0"><span
						class="glyphicon glyphicon-sort-by-alphabet"></span></a> <a
					class="btn btn-default btn-xs" id="sortDesc"
					href="RedirectIndexServlet?codeTri=1"><span
						class="glyphicon glyphicon-sort-by-alphabet-alt"></span></a>

				</th>
				<th>Introduced Date <a class="btn btn-default btn-xs"
					id="sortDesc" href="RedirectIndexServlet?codeTri=2"><span
						class="glyphicon glyphicon-arrow-down"></span></a> <a
					class="btn btn-default btn-xs" id="sortDesc"
					href="RedirectIndexServlet?codeTri=3"><span
						class="glyphicon glyphicon-arrow-up"></span></a></th>
				<!-- Table header for Discontinued Date -->
				<th>Discontinued Date <a class="btn btn-default btn-xs"
					id="sortDesc" href="RedirectIndexServlet?codeTri=4"><span
						class="glyphicon glyphicon-arrow-down"></span></a> <a
					class="btn btn-default btn-xs" id="sortDesc"
					href="RedirectIndexServlet?codeTri=5"><span
						class="glyphicon glyphicon-arrow-up"></span></a></th>
				<!-- Table header for Company -->
				<th>Company <a class="btn btn-default btn-xs" id="sortDesc"
					href="RedirectIndexServlet?codeTri=6"><span
						class="glyphicon glyphicon-sort-by-alphabet"></span></a> <a
					class="btn btn-default btn-xs" id="sortDesc"
					href="RedirectIndexServlet?codeTri=7"><span
						class="glyphicon glyphicon-sort-by-alphabet-alt"></span></a></th>
				<th></th>
			</tr>
		</thead>
		<tbody>


			<c:forEach items="${ computerList }" var="comp">
				<tr>
					<td><a href="#"><c:out value="${comp.name}" /></td>
					<td><c:out value="${comp.getIntroducedDateString()}" /></td>
					<td><c:out value="${comp.getDiscontinuedDateString()}" /></td>
					<td><c:out value="${comp.company.name}" /></td>
					<form action="EditComputerServlet" method="get">
						<input type="hidden" name="id" value="${ comp.id }">
						<td><input type="submit" id="editsubmit" value="Edit"
							class="btn btn-info"></td>
					</form>
					<form action="DeleteComputerServlet" method="post">
						<input type="hidden" name="id" value="${ comp.id }">
						<td><input type="submit" id="deletesubmit" value="Delete"
							class="btn btn-danger"></td>
					</form>

				</tr>
			</c:forEach>

		</tbody>
	</table>

	<pg:pagination computers="${ computerList }" total="${ nbComputer }"
		pageEnCours="${ page }"	filterText="${ filterText }" codeTri="${ codeTri }" interval="${ interval }" nbPage="${ nbPage }" />
 
	<!-- 
	<center>
		<div id="navPagination">
			<ul class="pagination">
				<li><a href="#">&laquo;</a></li>


				<c:forEach var="i" begin="1" end="${nbPage}" step="1">
					<li><a
						href="<c:url value="RedirectIndexServlet">
							<c:param name="page" value="${ i }" />
							<c:param name="interval" value="20" />
						</c:url>">${ i }</a>

					</li>
				</c:forEach>

				<li><a href="#">&raquo;</a></li>
			</ul>
		</div>
	</center>
 -->


	<p id="msg_err">${ msg }</p>
</section>

<jsp:include page="../include/footer.jsp" />

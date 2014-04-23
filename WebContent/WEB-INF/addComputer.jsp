<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../include/header.jsp" />
<script type="text/javascript" src="jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="jquery.validate.min.js"></script>

<script>
jQuery(document).ready(function() {
	   jQuery("#formStep").validate({
	      rules: {
	         "montextarea":{
	            "required": true,
	            "minlength": 2,
	            "maxlength": 60000
	         },
	         "monemail": {
	            "email": true,
	            "maxlength": 255
	         },
	         "montelephone": {
	            "required": true
	         }
	  	  }
	});

</script>

<section id="main">

	<h1>Add Computer</h1>

	<form id="addComputerForm" action="AddComputerServlet" method="POST">
		<fieldset>
			<div class="clearfix">
				<label for="name">Computer name:</label>
				<div class="input-group">
					<input class="form-control" type="text" name="name" /> <span
						class="input-group-addon">Required</span>
				</div>
			</div>

			<div class="clearfix">
				<label for="introduced">Introduced date:</label>
				<div class="input-group">
					<input class="form-control" type="date" name="introducedDate"
						pattern="\d{4}-\d{1,2}-\d{1,2}" /> <span
						class="input-group-addon">YYYY-MM-DD</span>
				</div>
			</div>
			<div class="clearfix">
				<label for="discontinued">Discontinued date:</label>
				<div class="input-group">
					<input class="form-control" type="date" name="introducedDate"
						pattern="\d{4}-\d{1,2}-\d{1,2}" /> <span
						class="input-group-addon">YYYY-MM-DD</span>
				</div>
			</div>
			<div class="clearfix">
				<label for="company">Company Name:</label>
				<div class="input-group">
					<select name="company">
						<option value="0">--</option>
						<c:forEach items="${ companyList }" var="comp">
							<option value="${ comp.id }"><c:out
									value="${ comp.name }" /></option>
						</c:forEach>
					</select>
				</div>
			</div>
		</fieldset>
		<div class="actions">
			<input type="submit" value="Add" class="btn btn-info"> or <a
				href="RedirectIndexServlet" class="btn btn-default">Cancel</a>
		</div>
	</form>
	<script>
		$(document).ready(function(){
			$("#addComputerForm").validate();
		}				
		);
	</script>
	<p id="msg_err">${ msg }</p>
</section>

<jsp:include page="../include/footer.jsp" />
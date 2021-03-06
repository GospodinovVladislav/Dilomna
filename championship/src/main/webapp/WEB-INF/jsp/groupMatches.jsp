<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.divWithBorder {
	float: left;
	border: 1px solid black;
	width: 142px;
	height: 190px;
}

.bottom-margin {
	margin-bottom: 100px;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<center>

		<c:forEach items="${listMatches}" var="match">
		
			<div class="container col-lg-5 bottom-margin">

				<div id="host" class="divWithBorder">
					<img src="../images/${match.host.photoFileName}" height="140"
						width="140" /> <br>
					<center>${match.host.firstName}
						<br> ${match.host.lastName}
					</center>
				</div>

				<div id="score" class="divWithBorder">
					<center>
						<br> <b>Score: <br> <br> <br> 0-0
						</b> <br>
						<br><br><br><br><br>
						<shiro:hasRole name="admin">
							<a data-toggle="modal" class="btn btn-info" href="/championship/app/matches/${match.id}/editMatchScore" data-target="#myModal">Edit Score</a>
						</shiro:hasRole>
					</center>
				</div>

				<div id="guest" class="divWithBorder">
					<img src="../images/${match.guest.photoFileName}" height="140"
						width="140" /> <br>
					<center>${match.guest.firstName}
						<br> ${match.guest.lastName}
					</center>
				</div>
			</div>
		</c:forEach>

	</center>
	
	
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
        </div> <!-- /.modal-content -->
    </div> <!-- /.modal-dialog -->
</div> <!-- /.modal -->


<script type="text/javascript">
	
$('body').on('hidden.bs.modal', '.modal', function () {
    $(this).removeData('bs.modal');
});
	
</script>

</body>
</html>
<%@ page pageEncoding="UTF-8"%>

<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>



<html>
<head>
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Championship - Groups</title>

<%@include file="header.jsp"%>

</head>

<body>
	<h1 style="color: purple" class="text-center">Groups</h1>

	<shiro:hasRole name="admin">
		<button class="createGroup center btn btn-lg btn-success center-block">Create
			New Group</button>
	</shiro:hasRole>


	<br>


	<div class="container">
		<display:table id="group" name="groups" class="table">
			<display:column property="id" title="ID" class="hidden id"
				headerClass="hidden" media="html"></display:column>
			<display:column title="" property="groupName" class="groupName" />

			<display:column>
				<display:table requestURI="groups"  id="participants" name="${group.participants}"
					class="table  table-hover">
					<display:column>
						<img src="../images/${participants.photoFileName}" height="50"
							width="50" />
					</display:column>
					<display:column title="First name"  property="firstName"
						class="firstName" />
					<display:column title="Last name" property="lastName"
						class="lastName" />
					<display:column title="Matches Won" sortable="true" property="score.matchesWon"
						class="matchesWon" />
					<display:column title="Matches Lost" sortable="true" property="score.matchesLost"
						class="matchesLost" />
					<display:column title="Points Made" sortable="true" property="score.pointsMade"
						class="pointsMade" />
					<display:column title="Points Taken" sortable="true" property="score.pointsTaken"
						class="pointsTaken" />
					<display:column title="Score" sortable="true" property="score.score" class="score" />
				</display:table>
				<br>
				<br>
				<br>
			</display:column>

			<shiro:hasRole name="admin">
				<display:column>
					<a href='#' class="editGroup">Edit</a>
				</display:column>
				<display:column>
					<a href='#' class="deleteGroup">Delete</a>
				</display:column>
			</shiro:hasRole>

		</display:table>
	</div>

	<link rel="stylesheet"
		href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

	<script type="text/javascript">
	
	
		<jsp:include page="/js/deleteGroup.js"/>
		<jsp:include page="/js/addNewGroup.js"/>
		<jsp:include page="/js/editGroup.js"/>
	</script>

</body>
</html>
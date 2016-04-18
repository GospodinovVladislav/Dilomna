<style>
.center {
	float: left;
	border: 1px solid black;
	width: 265px;
	height: 190px;
	text-align: center;
}

.participants {
	float: left;
	border: 1px solid black;
	width: 142px;
	height: 190px;
	text-align: center;
}
</style>


<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal"
		aria-hidden="true">&times;</button>
	<h4 class="modal-title">Edit Match Score</h4>
</div>
<!-- /modal-header -->

<div class="modal-body">

	<input type="hidden" id="matchID" value="${match.id}">

	<div class="container bottom-margin">

		<div id="host" class="participants">
			<img src="../images/${match.host.photoFileName}" height="140"
				width="140" /> <br> ${match.host.firstName} <br>
			${match.host.lastName}

		</div>

		<div id="score" class="center">

			<br>
			
					<div class="form-group">
  							<div class="col-md-4">
  								<input id="setOneHost" min="0" max="50" value="0"  type="number" class="form-control input-md">
							</div>
  						<label class="col-md-4 control-label" for="textinput">Set 1</label>  
  						<div class="col-md-4">
  								<input id="setOneGuest" min="0" max="50" value="0"  type="number" class="form-control input-md">
						</div>
					</div>
					
					<br><br>
					
					<div class="form-group">
  							<div class="col-md-4">
  								<input id="setTwoHost" min="0" max="50" value="0"  type="number" class="form-control input-md">
							</div>
  						<label class="col-md-4 control-label" for="textinput" >Set 2</label>  
  						<div class="col-md-4">
  								<input id="setTwoGuest" min="0" max="50" value="0"  type="number" class="form-control input-md">
						</div>
					</div>
					
					<br><br>
					
					<div class="form-group">
  							<div class="col-md-4">
  								<input id="setThreeHost" min="0" max="50" value="0"  type="number" class="form-control input-md">
							</div>
  						<label class="col-md-4 control-label" for="textinput">Set 3</label>  
  						<div class="col-md-4">
  								<input id="setThreeGuest" min="0" max="50" value="0"  type="number" class="form-control input-md">
						</div>
					</div>
			

		</div>

		<div id="guest" class="participants">
			<img src="../images/${match.guest.photoFileName}" height="140"
				width="140" /> <br> ${match.guest.firstName} <br>
			${match.guest.lastName}

		</div>
	</div>

<script type="text/javascript">


$('#update').on('click', function() {
	
	var setOneHost = $("#setOneHost").val();
	var setOneGuest = $("#setOneGuest").val();
	
	var setTwoHost = $("#setTwoHost").val();
	var setTwoGuest = $("#setTwoGuest").val();
	
	var setThreeHost = $("#setThreeHost").val();
	var setThreeGuest = $("#setThreeGuest").val();
	
	var matchID = $("#matchID").val();
	
	$.ajax({
		type : "GET",
		url : "/championship/app/matches/" + matchID + "/editMatchScore/" + setOneHost  + "/" + setOneGuest
													 + "/" + setTwoHost  + "/" + setTwoGuest
													 + "/" + setThreeHost  + "/" + setThreeGuest,
	});
});

</script>

</div>
<!-- /modal-body -->


<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	<button type="button" id="update" class="btn btn-primary" >Save changes</button>
</div>




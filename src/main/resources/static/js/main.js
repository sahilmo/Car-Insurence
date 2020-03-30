$(document).ready(function() {
	$("#search-form").submit(function(event) {

		// stop submit the form, we will post it manually.
		event.preventDefault();

		fire_ajax_submit();
		showLoader();
	});

});
document.addEventListener('DOMContentLoaded', function() {
	hideLoader();
}, false);
function fire_ajax_submit() {

	var search = {}
	search["keyword"] = $("#keyword").val();

	$("#btn-search").prop("disabled", true);

	$.ajax({
		type : "POST",
		url : "/find",
		contentType : "application/json",
		data : JSON.stringify(search),
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {
			alert(data.msg);
			var json = "<div style='border:3px; border-style:solid; border-color:#FF0000; padding: 1em;'><h4>Ajax Response</h4>" + JSON.stringify(data, null, 4)
					+ "</div>";
			$('#resultData').html(json);

			console.log("SUCCESS : ", data);
			$("#btn-search").prop("disabled", false);
			hideLoader();
		},
		error : function(e) {
			alert(data.msg);
			var json = "<h4>Ajax Response</h4>&lt;pre&gt;" + e.responseText
					+ "&lt;/pre&gt;";
			$('#feedback').html(json);

			console.log("ERROR : ", e);
			$("#btn-search").prop("disabled", false);
			hideLoader();
		}
	});
	
}	
function showLoader() {
	document.getElementById("loader").style.display = "block";
}
function hideLoader() {
	document.getElementById("loader").style.display = "none";
}
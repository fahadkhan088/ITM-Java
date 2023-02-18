$(document).ready(
		function() {

			// SUBMIT FORM
			$("#request").click(function(event) {
				// Prevent the form from submitting via the browser.
				$("#request").html("requested");
				
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					book_id : $("#bookid").val(),
					user_id : $("#userid").val(),
					status  : 0
				}
				
				console.log(formData);

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/addrequest",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						console.log("request sent to the administration !!!")
					},
					error : function(e) {
						console.log("ERROR !!!")
					}
				});

			}

})
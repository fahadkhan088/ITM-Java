$(document).ready(
		function() {

			// SUBMIT FORM
			$("#signup").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					first_name : $("#firstname").val(),
					last_name : $("#lastname").val(),
					age : $("#age").val(),
					email : $("#email").val(),
					password : $("#password").val()
				}

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/signup",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						//if (result.status == "success") {
							$("#response").html(
									"" + result.first_name
											+ " Added Successfully! <br>"
											+ "---> Congrats !!" + "</p>");
						//} else {
						//	$("#response").html("<strong>Error</strong>");
						//}
						console.log(result);
					},
					error : function(e) {
						$("#response").html("Email already exists !!!")
					}
				});

			}

})
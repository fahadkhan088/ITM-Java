$(document).ready(
		function() {

			// SUBMIT FORM
			$("#loginform").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					email : $("#email").val(),
					password : $("#password").val()
				}

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/login",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						let i=result.id;
						let j=i.toString();
						console.log(j);
						
					    window.location = "/dash/"+j;
					},
					error : function(e) {
						$("#response").html("Invalid Username or password !!!")
					}
				});

			}

})
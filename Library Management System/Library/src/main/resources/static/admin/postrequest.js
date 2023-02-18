$(document).ready(
		function() {

			// SUBMIT FORM
			$("#adminform").submit(function(event) {
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
                //console.log(formData)
				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/adminlogin",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						let i=result.id;
						let j=i.toString();
						console.log(j);
						
					    window.location = "/admin/login/dash";
					},
					error : function(e) {
						$("#response").html("Invalid Username or password !!!")
					}
				});

			}

})
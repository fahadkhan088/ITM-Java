$(document).ready(
		function() {
            
			// SUBMIT FORM
			$("#updateform").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					id: $("#id").val(),
					email : $("#email").val(),
					password : $("#password").val(),
					first_name : $("#firstname").val(),
					last_name : $("#lastname").val(),
					age : $("#age").val()
				}
				
				
				let j=formData.id.toString();
				//console.log(j);
				
				

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					
					url : "/profile/"+j,
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						$("#response").html("Update Successdully !!!")
					},
					error : function(e) {
						$("#response").html("Email already exists !!!")
					}
				});

			}

})
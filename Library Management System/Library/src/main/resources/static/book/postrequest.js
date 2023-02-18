$(document).ready(
		function() {

			// SUBMIT FORM
			$("#addbookform").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					book_name : $("#bookname").val(),
					author_name : $("#authorname").val(),
					publishyear : $("#year").val()
					
				}

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/addbook",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						//if (result.status == "success") {
							$("#response").html(
									"" + result.book_name
											+ " Added Successfully! <br>"
											+ "---> Congrats !!" + "</p>");
						//} else {
						//	$("#response").html("<strong>Error</strong>");
						//}
						console.log(result);
					},
					error : function(e) {
						$("#response").html("Error please try different name!!!")
					}
				});

			}

})
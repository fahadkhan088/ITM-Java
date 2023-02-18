$(document).ready(
		function() {

			// SUBMIT FORM
			$("#updatebookform").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					id: $("#id").val(),
					book_name : $("#bookname").val(),
					author_name : $("#authorname").val(),
					publishyear : $("#year").val()
					
				}
				
				let j=formData.id.toString();

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/updatebook/"+j,
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						//if (result.status == "success") {
							$("#response").html(
									"" + result.book_name
											+ " Updated Successfully! <br>"
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
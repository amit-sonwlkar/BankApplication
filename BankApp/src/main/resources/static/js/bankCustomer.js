/**
 * 
 */
$(document).ready(function(){
	$("#customer-Form").submit(function (event) {
		event.preventDefault();
		var customerObj = new Object();
		customerObj["firstName"] = $("#firstName").val();
		customerObj["lastName"] = $("#lastName").val();
		customerObj["address"] = $("#address").val();
		customerObj["accountType"] = $("#selAccType").val();
		customerObj["customerId"] = $("#id").val();
		$("#btnCreateCustomer").prop("disabled", true);
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "createCustomer",
			data: JSON.stringify(customerObj),
			dataType: 'json',
			cache: false,
			timeout: 600000,
			success: function (data) {
				showCustomerView(data)
				$("#btnCreateCustomer").prop("disabled", false);
			},
			error: function (e) {
				console.log("ERROR : ", e);
				$("#btnCreateCustomer").prop("disabled", false);

			}
		});
	});
	
	$('.clsEditCustomer').click(function(){
			customerId = $(this).attr('data-customerId');
			editCustomer(customerId);
	});
});
function editCustomer(customerId){
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "edit/"+customerId,
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function (data) {
			if(data){
				 $("#firstName").val(data.firstName);
				 $("#lastName").val(data.lastName);
				 $("#address").val(data.address);
				 $("#selAccType").val(data.bankAccountList.accountType);
				 $("#id").val(data.customerId);
			}
		},
		error: function (e) {
		}
	});
}
function showCustomerView(data){debugger;
location.href = "customerView"
}
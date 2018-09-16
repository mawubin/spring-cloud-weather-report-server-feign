/**
 *
 */

$(function(){
	$("#selectcityID").change(function(){
		var cityID=$("#selectcityID").val();
		var url = "/report/cityId/"+cityID;
		window.location.href=url;
	});
	
	
});
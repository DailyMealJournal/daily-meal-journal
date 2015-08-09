$(function() {
    retrieveMealList();
    
	$('select').material_select();
	
	$('#btn_add_meal').click(function(){
		$('#form_add_meal').submit();
	});
	
	$("#btn_add_new_meal").click(function () {
		$("#modal_add_new_meal").openModal();
	});

	$("#btn_add_new_meal_close").click(function () {
		$("#modal_add_new_meal").closeModal();
	});
	
	$('.add_meal_filter_food').click(function(){
		var name = $(this).attr('id');
		name = substring(6);
		
		alert(name);
	});

	if($('#category_btn').length > 0) {
		category_btn = $('#category_btn');
		clone = $('#category_btn').clone();
		$('.btn-responsive').append(clone);
		clone.removeClass('hide');
		clone.sideNav({edge: 'right'})
		category_btn.remove();
	}

 	$('#list_meals').hide();
 	$('.grid-view').addClass('active')
 	$('#loader').hide();
	$('.grid-view').click(function(e){
		e.preventDefault();
		if(!$(this).hasClass('active')) {
			$(this).addClass('blue-text')
			$(this).addClass('active');
			$('.list-view').removeClass('blue-text');
			$('.list-view').removeClass('active');
			$('#list_meals').fadeOut(100);	
			$('#loader').fadeIn(500).delay(800).fadeOut(100);
			$('#grid_meals').delay(1350).fadeIn(200);
		}
	});
	
	$('.list-view').click(function(e){
		e.preventDefault();
		if(!$(this).hasClass('active')) {
			$(this).addClass('blue-text')
			$(this).addClass('active');
			$('.grid-view').removeClass('blue-text');
			$('.grid-view').removeClass('active');
			$('#grid_meals').fadeOut(100);
			$('#loader').fadeIn(500).delay(800).fadeOut(100);
			$('#list_meals').delay(1350).fadeIn(200);
		}
	})
});

var meal_management = angular.module("myMeals", []);

function retrieveMealList(successMessage) {
	
    jsonData = {
                    data: JSON.stringify({
                        selection: "all"
                    })
               };
    
	$.ajax({
		url: 'read',
		type: 'GET',
		data: jsonData,
		success: function(data, status, jqXHR){            
            var mealList = "";
            
            $.each(data.mealList, function(index, value) {
                mealList += "<tr>" + 
                                "<td>"+value.id+"</td>" +
                                "<td>"+value.name+"</td>" +
                                "<td>"+value.def_quantity+"</td>" +
                                "<td>"+value.unit+"</td>" +
                                "<td>"+value.calories+"</td>" +
                                "<td>"+value.description+"</td>" +
                                "<td>"+value.picture+"</td>" +
                                "<td><button class='btn modal-edit-meal' data-id=''><i class='small material-icons'>reorder</i><span>Edit</span></button>&nbsp;<button class='btn modal-delete-meal' data-id=''><i class='small material-icons'>delete</i><span>Delete</span></button></td></tr>";
            });			
            
            $("#testBody").append(mealList);
		},
		error: function(jqXHR, status, error) {
			
		}
	});
}










$(function() {
	$("#btn_add_new_meal").click(function () {
		$("#modal_add_new_meal").openModal();
	});

	$("#btn_add_new_meal_close").click(function () {
		$("#modal_add_new_meal").closeModal();
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
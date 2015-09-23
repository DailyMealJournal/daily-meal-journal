$(function(){
	$('#btn_add_new_meal').click(function(){
		$(this).openModal();
	});

	$('#btn_add_new_meal_close').click(function(){
		$(this).closeModal();
	});

	$("#add_meal").click(function(){
		$(this).addClass('hidden');
		$('#list_meals').addClass('hidden');
		$('#show_journals').removeClass('hidden');
		$('#meal_option').removeClass('hidden');
	});	

	$("#show_journals").click(function(){
		$(this).addClass('hidden');
		$('#meal_option').addClass('hidden');
		$('#add_meal').removeClass('hidden');
		$('#list_meals').removeClass('hidden');
	});	
})
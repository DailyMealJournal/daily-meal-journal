var meal_journal = angular.module("myJournal", []);

meal_journal.controller('MealJournalController', ['$scope', function($scope) {
	$scope.journal  = { 
						meals: [{
							header: 'Breakfast at Tiffany'+"'"+'s',
							desc: 'Eat your heart out!',
							food_list: [{
											name: 'Carbonara',
											no_of_servings: 2,
											unit: 'Plate',
											calories: 500
										},
										{
											name: 'Samgyupsal',
											no_of_servings: 1,
											unit: 'Bowl',
											calories: 500
										}
										],
							total_calories: 1500

							},
							{
								header: 'Tea Time',
								desc: 'Just Chillin',
								food_list: [{
												name: 'Green Tea',
												no_of_servings: 1,
												unit: 'Bottle',
												calories: 50
											},
											{
												name: 'Wheat Bread',
												no_of_servings: 3,
												unit: 'Slice',
												calories: 150
											},
											{
												name: 'Omellete',
												no_of_servings: 1,
												unit: 'Plate',
												calories: 120
											},
											{
												name: 'Yogurt',
												no_of_servings: 1,
												unit: 'Cup',
												calories: 100
											}
											],
								total_calories: 720

							}],
						date: 'Friday, July 17, 2015',
						calories_consumed: 2220,
						calorie_limit: 2000
				    };
}]);

meal_journal.directive('backImg', function(){
    return function(scope, element, attrs){
        attrs.$observe('backImg', function(value) {
            element.css({
                'background-image': 'url(' + value +')',
                'background-size' : 'cover'
            });
        });
    };
});

 $(document).ready(function(){
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
})
var meal_management = angular.module("myMeals", []);

meal_management.controller('MealsController', ['$scope', function($scope) {
	$scope.meals = [
					{
						image: base_url + 'assets/img/food/k8.jpg',
						header: 'Sushi',
						meta_calorie: 40,
						meta_unit: 'per piece',
						desc: 'Classic Japanese Cuisine. Raw and unsavory flavor, tread carefully or else.'
					},

					{
						image: base_url + 'assets/img/food/g4.jpg',
						header: 'Skewered Pork Salad',
						meta_calorie: 200,
						meta_unit: 'per serving',
						desc: 'This dish is carefully constructed salad that provides plenty of nutrients by the day.'
					},

					{
						image: base_url + 'assets/img/food/g1.jpg',
						header: 'Roasted Chicken Salad',
						meta_calorie: 110,
						meta_unit: 'per serving',
						desc: 'This dish is carefully constructed salad that provides plenty of nutrients by the day.'
					},

					{
						image: base_url + 'assets/img/food/pic10.jpg',
						header: 'Assorted Fruit Salad',
						meta_calorie: 110,
						meta_unit: 'per serving',
						desc: 'Cleanse your body with fruit diet. Perfectly sustainable nutrients for short term diet cleansing.'
					},


				  ];

}]);

meal_management.controller('AllController', ['$scope', function($scope) {

}]);
meal_management.controller('MealCategoryController', ['$scope', function($scope) {
	$scope.categories = [
							{
								image: base_url + 'assets/img/icons/32px/61.png',
								name: 'Poultry',
								filters: ['Chicken', 'Duck']
							},
                            {
								image: base_url + 'assets/img/icons/32px/66.png',
								name: 'Meat',
								filters: ['Beef', 'Pork']
							},
                            {
								image: base_url + 'assets/img/icons/32px/127.png',
								name: 'Seafood',
								filters: ['Fish', 'Crab']
							},
                            {
								image: base_url + 'assets/img/icons/32px/51.png',
								name: 'Fruits & Vegetables',
								filters: ['Apples', 'Mangoes', 'Carrots', 'Potatoes']
							},
                            {
								image: base_url + 'assets/img/icons/32px/57.png',
								name: 'Dairy',
								filters: ['Milk', 'Yogurt', 'Cheese']
							},
                            {
								image: base_url + 'assets/img/icons/32px/122.png',
								name: 'Dessert',
								filters: ['Chocolate', 'Ice Cream']
							},
                            {
								image: base_url + 'assets/img/icons/32px/100.png',
								name: 'Beverage',
								filters: ['Protein Shake', 'Fruit Shake', 'Wine', 'Soda']
							},
                            {
								image: base_url + 'assets/img/icons/32px/143.png',
								name: 'Snacks',
								filters: ['Chips', 'Fries']
							}


						];
}]);

meal_management.directive('backImg', function(){
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
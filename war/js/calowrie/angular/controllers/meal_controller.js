meal_management.controller('MealsController', ['$scope', function($scope) {
	
	$scope.addMeal = function(e) {
		console.log(e)
		var request = $http({
		    method: $('#add_meal').attr('method'),
		    url: $('#add_meal').attr('xurl'),
		    transformRequest: transformRequestAsFormPost,
		    data: $('#add_meal').serialize()
		});
	}

	$scope.meals = [
					{
						Picture: base_url + 'assets/img/food/k8.jpg',
						MealName: 'Sushi',
						CalorieCount: 40,
						Unit: 'per piece',
						Description: 'Classic Japanese Cuisine. Raw and unsavory flavor, tread carefully or else.'
					},

					{
						Picture: base_url + 'assets/img/food/g4.jpg',
						MealName: 'Skewered Pork Salad',
						CalorieCount: 200,
						Unit: 'per serving',
						Description: 'This dish is carefully constructed salad that provides plenty of nutrients by the day.'
					},

					{
						Picture: base_url + 'assets/img/food/g1.jpg',
						MealName: 'Roasted Chicken Salad',
						CalorieCount: 110,
						Unit: 'per serving',
						Description: 'This dish is carefully constructed salad that provides plenty of nutrients by the day.'
					},

					{
						Picture: base_url + 'assets/img/food/pic10.jpg',
						MealName: 'Assorted Fruit Salad',
						CalorieCount: 110,
						Unit: 'per serving',
						Description: 'Cleanse your body with fruit diet. Perfectly sustainable nutrients for short term diet cleansing.'
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
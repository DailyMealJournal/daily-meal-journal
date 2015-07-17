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

meal_management.controller('MealCategoryController', ['$scope', function($scope) {
	$scope.categories = [
							{
								image: base_url + 'assets/img/food/category/all_vegtables.png',
								name: 'Pure Vegtables'
							},

							{
								image: base_url + 'assets/img/food/category/all_meat.png',
								name: 'Pure Meat'
							},


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
var meal_journal = angular.module("myJournal", []);

meal_journal.controller('MealJournalController', ['$scope', function($scope) {
	$scope.journal  = { 
						meals: [{
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
					],
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

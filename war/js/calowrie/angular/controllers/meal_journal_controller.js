var meal_journal = angular.module("myJournal", []);

meal_journal.controller('MealJournalController', ['$scope', '$http', '$filter', '$httpParamSerializer', function($scope, $http, $filter, $httpParamSerializer) {



	/**
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
	**/

	$scope.date = new Date();



	$scope.init = function() {
		this.getAllMeals();
		this.getJournalEntry();
	}


	$scope.getAllMeals = function()
	{
		requestMeals = $http.get(base_url + 'meal_management/read',
			{
				params: { 
						selection: 'all' 
					}
			}
		);

		requestMeals.success(function(data, status, headers, config) {
			$scope.meals  =  data.mealList;
		});

		requestMeals.error(function(data, status, headers, config) {

		});

	}

	$scope.getJournalEntry = function()
	{
		var jsonData = {
					journal_date: $filter('date')(this.date ,'yyyy-MM-dd'),
					user_id: session_data['id']
		};
		getJournal(jsonData); 
	}

	$scope.scopeDay = function(value)
	{
		$scope.date.setDate($scope.date.getDate() + value);
		var jsonData = {
					journal_date: $filter('date')($scope.date ,'yyyy-MM-dd'),
					user_id: session_data['id']
		};
		getJournal(jsonData);		
	}
	$scope.newEntry = function() {

		var jsonData = {
			journal_date: $filter('date')(this.date ,'yyyy-MM-dd'),
			user_id: session_data['id']
		};
		newJournalEntry = $http.post(base_url + 'meal_journal/create', $httpParamSerializer(jsonData),

			{
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			}
		);

		newJournalEntry.success(function(data, status, headers, config) {
			if(typeof data.success != 'undefined') {
				$scope.hasEntry = 'hidden';
			} else {
				$scope.hasEntry = '';
			}

		});

		newJournalEntry.error(function(data, status, headers, config) {

		});
	}


	function getJournal(jsonData) {
		journalMealEntry = $http.get(base_url + 'meal_journal/read', { params: jsonData });

		journalMealEntry.success(function(data,status, headers, config) {
			console.log(data);
			if(typeof data.success != 'undefined') {
				$scope.hasEntry = 'hidden';
			} else {
				$scope.hasEntry = '';
			}
		});
	}
	

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

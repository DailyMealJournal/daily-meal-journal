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
	$scope.journal = {meals: []};
	$scope.date = new Date();



	$scope.init = function() {
		this.getAllMeals();
		this.getJournalEntry();
		this.journal.meals = '';
		this.total_calories = '-';
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
				$scope.journalId = data.journal_id;
				$scope.total_calories = 0;
			} else {
				$scope.hasEntry = '';
			}
			console.log(data)
		});

		newJournalEntry.error(function(data, status, headers, config) {

		});
	}

	$scope.deleteEntry = function() {

		var jsonData = {
			journal_id: $scope.journalId
		};	

		deleteJournalEntry = $http.post(base_url + 'meal_journal/delete', $httpParamSerializer(jsonData),

			{
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			}
		);

		deleteJournalEntry.success(function(data, status, headers, config) {
			if(typeof data.success != 'undefined') {
				$scope.hasEntry = '';
				$scope.journalId = '';
				$scope.total_calories = '-';
			} else {
				$scope.hasEntry = 'hidden';
			}

		});

		deleteJournalEntry.error(function(data, status, headers, config) {

		});

	}

	$scope.addMealToJournal = function ( meal_id ) {

		var jsonData = {
			meal_id: meal_id,
			journal_id: $scope.journalId
		}

		addJournalMeal = $http.post(base_url + 'journal_meal/create', $httpParamSerializer(jsonData),

			{
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			}
		);

		addJournalMeal .success(function(data, status, headers, config) {
			if(typeof data.success != 'undefined') {
				$scope.getJournalMeals();
			}

		});
	}

	$scope.getJournalMeals = function () {
		var jsonData = {
			journal_id: $scope.journalId
		}
		getJournalMeal = $http.get(base_url + 'journal_meal/scopeJournal', { params: jsonData });

		getJournalMeal.success(function(data,status, headers, config) {	
			var mealsScope = [];
			var total_calories = 0;
			if(typeof data.success != 'undefined') {
				var ndx = 0;
				var index = 0;
				var journalMealList = data.journalMealList;
				for(var i in journalMealList) {
					ndx = 0;
					mealsScope[index] = {meals: '', main: ''}
					for(var j in journalMealList[i]) {
						if(ndx == 0) {
							if(journalMealList[i][j].picture == '') {
								journalMealList[i][j].picture = "/assets/img/food/pic10.jpg";
							}
							mealsScope[index].meals =  journalMealList[i][j];
						} else  if( ndx == 1){
							mealsScope[index].main = journalMealList[i][j];
							if(typeof(journalMealList[i][j].total_calories) != 'undefined') {
								total_calories += journalMealList[i][j].total_calories;
							}
						}	
						ndx++;
					}
					index++;
				}
			}
			$scope.journal.meals = mealsScope;
			$scope.total_calories = total_calories;
		});
	}

	$scope.deleteJournalMeal = function( journal_meal_id ) {
		var jsonData = {
			id: journal_meal_id
		}

		deleteJournalMeal = $http.post(base_url + 'journal_meal/delete', $httpParamSerializer(jsonData),

			{
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			}
		);

		deleteJournalMeal.success(function(data,status, headers, config) {
			$scope.getJournalMeals();
		});
	}

	function getJournal(jsonData) {
		journalMealEntry = $http.get(base_url + 'meal_journal/read', { params: jsonData });

		journalMealEntry.success(function(data,status, headers, config) {
			if(typeof data.success != 'undefined') {
				$scope.hasEntry = 'hidden';
				$scope.journalId = data.journal_id;
				$scope.isDelJournalDisabled = '';
				$scope.getJournalMeals();
			} else {
				$scope.hasEntry = '';
				$scope.journalId = '';
				$scope.isDelJournalDisabled = 'disabled';
				$scope.journal.meals = '';
				$scope.total_calories = '-';
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

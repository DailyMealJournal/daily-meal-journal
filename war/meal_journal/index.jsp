<jsp:include page="/layout-header.jsp" />

<%-- Page Title --%>
<pagetitle name="Meal Journal"></pagetitle>

<%-- Style URL ../css us bit required --%>
<styleurl url="calowrie/meal_journal/index.css"></styleurl>
<div ng-module="myJournal" ng-controller="MealJournalController" data-ng-init="init()">
	<div class="row">
		<div class="col s2 m1 offset-s4 offset-m1 arrow-left">
			<a class="waves-effect waves-red accent-1 btn-flat-large red-text text-accent-1" ng-click="scopeDay(-1)"><i class="material-icons">arrow_back</i></a>
		</div>
		<div class="col s4">
			<h5 class="center-align" id="date">{{ date | date:'longDate'}}</h5>
		</div>
		<div class="col s2 m1 offset-s1 offset-m1 arrow-right">
			<a class="waves-effect waves-red accent-1 btn-flat-large red-text text-accent-1" ng-click="scopeDay(1)"><i class="material-icons">arrow_forward</i></a>
		</div>
	</div>
	<div class="errors row">
		<div class="col s12 offset-s2 red-text" ng-repeat="error in errors">
			<p> {{ error }}</p>
		</div>
	</div>
	<div class="row">
		<div class="col s10 m7 offset-m2" id="list_meals">
			<div class="section"
				ng-repeat="journal_meal in journal.meals | filter: global.search">
				<div class="row">
					<h3 class="title">{{ journal_meal.meals.name }}</h3>
					<a class="waves-effect waves-light btn btn-floating red right" ng-click="deleteJournalMeal(journal_meal.main.id)"><i class="material-icons left">delete</i></a>
					<button class="waves-effect waves-light btn btn-floating green right" ng-click="enableEdit(journal_meal.main.id)"><i class="material-icons">edit</i></button>
					<div class="col s12 m6 l4">
						<img class="responsive-img materialboxed z-depth-2 list-meal"
							ng-src="{{ journal_meal.meals.picture }}">
					</div>
					<div class="col s8">
						<p>
							Calorie Power: <br> {{ journal_meal.meals.calories}} per <span
								class="unit">{{ journal_meal.meals.unit  }}</span>
						</p>
						<p ng-show="mode[journal_meal.main.id] != 'edit'">
							Quantity:<br> {{ journal_meal.main.quantity }}
						</p>
						<p ng-show="mode[journal_meal.main.id] == 'edit' ">
							Quantity:<br> <input class="edit-input" type="text" ng-model="journal_meal.main.quantity"> 
							<button class="waves-effect waves-light btn  green right" ng-disabled="!isNumeric(journal_meal.main.quantity) || journal_meal.main.quantity == '' || journal_meal.main.quantity > 10 || journal_meal.main.quantity < 1" ng-click="updateJournalMeal(journal_meal.main.id, journal_meal.main.journal_id, journal_meal.main.quantity)"><i class="material-icons">edit</i></button>
						</p>
						<div class="description">
							Description: 
							<p>{{ journal_meal.meals.description }}</p>
						</div>
					</div>
				</div>
				<div class="divider"></div>
			</div>
			<div class="center-align no-meals" ng-hide="(journal.meals | filter: global.search).length">
				<input type="hidden" ng-model="hasEntry">
				<a class="btn waves-effect waves-light teal lighten-1" ng-class="hasEntry"	 create-url="${base_url}meal_journal/create" ng-click="newEntry()">New Entry</a>
				<p ng-show="hasEntry == 'hidden'">
				No Records Found
				</p>
			</div>
		</div>

		<div class="col s10 m7 offset-m2 hidden" id="meal_option">
			<div class="section" ng-repeat="meal in meals | filter: global.search">
				<div class="row">
					<h3 class="title">{{ meal.name }}</h3>
					<button class="waves-effect waves-light btn btn-floating red right" ng-disabled="!isNumeric(meal_quantity[meal.id]) || meal_quantity[meal.id] == '' || meal_quantity[meal.id] > 10 || meal_quantity[meal.id] < 1" ng-click="addMealToJournal(meal.id)"><i class="material-icons left">add</i></button>
					<div class="quantity-meal input-field right"> 
						<input id="quantity_{{meal.id}}" type="text" ng-model="meal_quantity[meal.id]"  class="validate" ng-class="(meal_quantity[meal.id] == '') ? '' : (!isNumeric(meal_quantity[meal.id]) || meal_quantity[meal.id] > 10 || meal_quantity[meal.id] < 1)  ? 'invalid' : 'valid' ">
						<label for="quantity_{{meal.id}}">Enter Quantity</label>
					</div>
					<div class="col s12 m6 l4">
						<img class="responsive-img materialboxed z-depth-2 list-meal"
							ng-src="{{ meal.picture || '/assets/img/food/pic2.jpg'  }}">
					</div>
					<div class="col s8">
						<p>
							Calorie Power: <br> {{ meal.calories }} <span class="unit"> per {{ meal.unit }}</span>
						</p>
						<div class="description">
							Description: 
							<p>{{ meal.description }}</p>
						</div>
					</div>
				</div>
				<div class="divider"></div>
			</div>
			<div class="center-align no-meals" ng-hide="(meals | filter: global.search).length">
				No Meals Found!
			</div>
		</div>

		<div class="fixed col s3">
			<input type="hidden" ng-model="journalId">
			<div class="input-field fixed-pos search-side">
				<i class="material-icons prefix">search</i> <input id="search"
					type="text" class="validate" ng-model="global.search"
					ng-change="apiSearch()"> <label for="search">Search</label>
			</div>
			<div class="card-panel fixed-pos cal-info">
				<p class="total-cal-info">TOTAL CALORIES</p>
				<p class="center-align total-cal-info-sub">for the day</p>
				<p class="teal-text text-darken-4 calorie-consumed center-align">
					<b>{{ total_calories }}</b>
				</p>
				<p class="cal-sub-text center-align"> Calories <br>
					<h7>Out of  2000</h7>
				</p>
				<div class="divider"></div>
				<div class="row">
					<div class="col s12">
						<center>
							<a class="waves-effect waves-teal btn-flat red-text text-accent-1">Daily View</a>
						</center>
					</div>
					<div class="col s12">
						<div></div>
						<center>

							<a class="waves-effect waves-light btn" id="add_meal" ng-show="journalId != '' && (total_calories != '-' && total_calories < 2000 )">Add a Meal</a>
						</center>
						<div></div>
						<center>
							<a class="waves-effect waves-light btn hidden" id="show_journals">Back to Journals</a>
						</center>
					</div>
				</div>
				<div class="row">
					<div class="col s12">
						<center>
							<button class="waves-effect waves-light btn red" id="delete_journal" ng-click="deleteEntry()" ng-disabled="journalId == '' || journal.meals != ''">Delete Entry</button>
						</center>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%-- Put JS Scripts ../css is not required --%>
<jsscript src="calowrie/angular/controllers/meal_journal_controller.js"></jsscript>
<jsscript src="calowrie/meal_journal/index.js"></jsscript>
<jsp:include page="/layout-footer.jsp" />
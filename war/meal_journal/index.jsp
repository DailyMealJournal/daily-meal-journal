<jsp:include page="/layout-header.jsp" />

<%-- Page Title --%>
<pagetitle name="Meal Journal"></pagetitle>

<%-- Style URL ../css us bit required --%>
<styleurl url="calowrie/meal_journal/index.css"></styleurl>
<div ng-module="myJournal" ng-controller="MealJournalController">
	<div class="row">
		<div class="offset-s3 col s1 arrow-left">
			<a class="waves-effect waves-red accent-1 btn-flat-large red-text text-accent-1"><i class="material-icons">arrow_back</i></a>
		</div>
		<div class="col s4">
			<h5 class="center-align">{{ journal.date }}</h5>
		</div>
		<div class="col s1 arrow-right">
			<a class="waves-effect waves-red accent-1 btn-flat-large red-text text-accent-1"><i class="material-icons">arrow_forward</i></a>
		</div>
	</div>
	<div class = "row">
		<div class="col s7 offset-s2"  id="list_meals">
	      <div class="section" ng-repeat="meal in journal.meals | filter: global.search">
	        <div class="row">
	          <h3 class="title">{{ meal.MealName }}</h3>
	          <a class="waves-effect waves-light btn btn-floating red right"><i class="material-icons left">delete</i></a>
	          <div class="col s12 m6 l4">   
	            <img class="responsive-img materialboxed z-depth-2 list-meal" ng-src="{{ meal.Picture }}">
	          </div>
	          <div class="col s8">
	            <p>Calorie Power: <br> {{ meal.CalorieCount }} <span class="unit">{{ meal.Unit }}</span></p>
	            <div class="description">
	              <p>{{ meal.Description }}</p>
	            </div>
	          </div>
	        </div>
	        <div class="divider"></div>
	      </div>
	      <div class="center-align no-meals" ng-hide="(journal.meals | filter: global.search).length">No Meals Found</div>
	    </div>
		<div class="fixed col s3">
			<div class="input-field fixed-pos search-side">
				<i class="material-icons prefix">search</i>
			     <input id="search" type="text" class="validate" ng-model="global.search" ng-change="apiSearch()">
			    <label for="search">Search</label>
	         </div>
		     <div  class="card-panel fixed-pos cal-info">
		     	<p class="total-cal-info">TOTAL CALORIES</p>
		     	<p class="center-align total-cal-info-sub">for the day</p>
		     	<p  class="teal-text text-darken-4 calorie-consumed center-align">
		     		<b>{{ journal.calories_consumed }}</b>
		     	</p>
		     	<p class="cal-sub-text center-align">
		     		Calories 
		     		<br> 		     	
		     		<h7>Out of {{ journal.calorie_limit }} </h7>
		     	</p>
		     	<div class="divider"></div>
		     	<center><a class="waves-effect waves-teal btn-flat red-text text-accent-1">Daily View</a>
		     	<a class="waves-effect waves-light btn">Add a Meal</a></center>
		     </div>
		</div>
	</div>
</div>

<%-- Put JS Scripts ../css is not required --%>
<jsscript src="calowrie/angular/controllers/meal_journal_controller.js"></jsscript>
<jsscript src="calowrie/meal_journal/index.js"></jsscript>
<jsp:include page="/layout-footer.jsp" />
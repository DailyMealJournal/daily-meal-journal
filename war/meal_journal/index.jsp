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
		<div class="col s7 offset-s2">
			<div class="divider"></div>
			<div ng-repeat="meal in journal.meals">
				<div class = "section">
					<div class="row meal">
						<div class="col s10">
							<h4 class="meal-header">{{ meal.header }}</h4>
							<p class="grey-text text-darken-1">{{ meal.desc }}</p>
						</div>
						<div class="journal-action-btn">
							<a class="btn-floating btn-medium waves-effect waves-light teal"><i class="material-icons">mode_edit</i></a>
							<a class="btn-floating btn-medium waves-effect waves-light red"><i class="material-icons">delete</i></a>
						</div>
					</div>
					<div class="row">
						<table class="centered bordered card-panel table-journal">
							<thead>
								<tr>
									<th>No. of Servings</th>
									<th>Unit</th>
									<th>Name of Food</th>
									<th>Calories</th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="food in meal.food_list">
									<td>{{ food.no_of_servings }}</td>
									<td>{{ food.unit }}</td>
									<td><a class="red-text text-accent-2" href="#">{{ food.name }}</a></td>
									<td>{{ food.calories}}</td>
								</tr>
								<tr class="total-cal">
									<td colspan="2"></td>
									<td class="right-align"><b>TOTAL CALORIES: </b></td>
									<td class="teal-text text-lighten-1"><b>{{ meal.total_calories }} Calories</b></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="divider"></div>
			</div>
		</div>
		<div class="fixed col s3">
			<div class="input-field fixed-pos search-side">
				<i class="material-icons prefix">search</i>
			    <input id="search" type="text" class="validate">
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
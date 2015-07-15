<jsp:include page="/layout-header.jsp" />

<%--  Page Title --%>
<pagetitle name="Calowrie - Meal Management"></pagetitle>

<%--  Style URL ../css is not required --%>
<styleurl url="calowrie/meal_management/index.css"></styleurl>

<div class="meal-management container row"  ng-modules="myMeals">

      <div class="col s9"  ng-controller="MealsController">
        <div class="row">
          <div class="col s12 m6 l4" ng-repeat="meal in meals">   
            <div class="card small hoverable">
              <div class="card-image waves-effect waves-block waves-light">
                <img class="activator" ng-src="{{ meal.image }}">
                <span class="card-title">{{ meal.header }}</span>
              </div>
              <div class="card-content">
                <span class="card-title activator grey-text text-darken-4"><i class="material-icons right">more_vert</i></span>
                 <p>Calorie Power: {{ meal.meta_calorie }} <span class="unit">{{ meal.meta_unit }}</span></p>
                 <p>{{ meal.desc }} </p>
              </div>
              <div class="card-reveal">
                <span class="card-title grey-text text-darken-4 ">{{ meal.header }}<i class="material-icons right">close</i></span>
                <div class="description">
                    <p>{{ meal.desc }} </p>
                </div>
                <a class="waves-effect waves-light btn right"><i class="material-icons left"></i>Add Meal</a>
              </div>
            </div>
          </div>
        </div>
      </div>

    <div class="col s3">
      <div class="row"  ng-controller="MealCategoryController">
          <div class="col s12"   ng-repeat="category in categories">
            <h2 class="title">  </h2>
              <div class="ui items">
                <a class="item">
                  <div class="ui middle  content ">
                    <div back-img="{{ category.image }}" class="wide-div"> <span class="item-text">{{ category.name }}</span> </div>
                  </div>
                </a>
              </div>
          </div>
      </div>
    </div>
</div>
<%--  Put JS Scripts ../js is not required --%>
<jsscript src="calowrie/meal_management/index.js"></jsscript>

<jsp:include page="/layout-footer.jsp" />

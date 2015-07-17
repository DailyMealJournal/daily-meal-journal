<jsp:include page="/layout-header.jsp" />

<%--  Page Title --%>
<pagetitle name="Calowrie - Meal Management"></pagetitle>

<%--  Style URL ../css is not required --%>
<styleurl url="calowrie/meal_management/index.css"></styleurl>

<div class="meal-management container section row"  ng-modules="myMeals">
      <div class="col s12">
        <div class="row">
          <div class=" col s3 center-aligned">
            <div class="center-aligned">
              <i class="material-icons prefix input-field">reorder</i>
              <i class="material-icons prefix input-field">dashboard</i>
            </div>
          </div>
          <div class="input-field col s3 offset-s3">
          <i class="material-icons prefix">search</i>
            <input id="search" type="text" class="validate">
            <label for="search">Search</label>
          </div>
        </div>
      </div>
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
                 <p>Calorie Power: <br> {{ meal.meta_calorie }} <span class="unit">{{ meal.meta_unit }}</span></p>
                 <p class="truncate">{{ meal.desc }} </p>
              </div>
              <div class="card-reveal">
                <span class="card-title text-size-16 grey-text text-darken-4 ">{{ meal.header }}<i class="material-icons right">close</i></span>
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
      <div class="collection fixed-pos"  ng-controller="MealCategoryController">
          <div class="collection-item"   ng-repeat="category in categories">
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

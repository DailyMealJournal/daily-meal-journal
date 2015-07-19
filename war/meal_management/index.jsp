<jsp:include page="/layout-header.jsp" />

<%--  Page Title --%>
<pagetitle name="Meal Management"></pagetitle>

<%--  Style URL ../css is not required --%>
<styleurl url="calowrie/meal_management/index.css"></styleurl>

<div class="meal-management container section row"  ng-module="myMeals">
  <div ng-controller="AllController">
        <div class="col s12">
          <div class="row">
            <div class=" col s3 center-aligned">
              <div class="center-aligned">
                <a class="view-type list-view btn-flat"><i class="material-icons prefix input-field">reorder</i></a>
                <a class="view-type grid-view btn-flat blue-text"><i class="material-icons prefix input-field">dashboard</i></a>
              </div>
            </div>
            <div class="input-field col s3 offset-s3 hide-on-large-only">
            <i class="material-icons prefix">search</i>
              <input id="search" type="text" class="validate" ng-model="global.search" ng-change="apiSearch()">
              <label for="search">Search</label>
            </div>
          </div>
        </div>
        <div class="col s9 center-align"  id="loader">
          <div class="preloader-wrapper big active">
            <div class="spinner-layer spinner-red-only">
              <div class="circle-clipper left">
                <div class="circle"></div>
              </div><div class="gap-patch">
                <div class="circle"></div>
              </div><div class="circle-clipper right">
                <div class="circle"></div>
              </div>
            </div>
          </div>
        </div>
        <div class="col s9"  id="grid_meals" ng-controller="MealsController">
          <div class="row">
            <div class="col s12  l6" ng-repeat="meal in meals | filter: global.search">   
              <div class="card small hoverable">
                <div class="card-image waves-effect waves-block waves-light">
                  <img class="activator responsive-img" ng-src="{{ meal.image }}">
                  <span class="card-title">{{ meal.header }}</span>
                </div>
                <div class="card-content">
                  <span class="card-title activator grey-text text-darken-4"><i class="material-icons right">more_vert</i></span>
                   <p>Calorie Power: <br> {{ meal.meta_calorie }} <span class="unit">{{ meal.meta_unit }}</span></p>
                   <p class="truncate">{{ meal.desc }} </p>
                </div>
                <div class="card-reveal">
                  <div class="row reveal-row">
                    <span class="card-title text-size-16 grey-text text-darken-4 row">
                      <i class="col s9">{{ meal.header }}</i>
                      <i class="material-icons right col s3">close</i>
                    </span>
                    <div class="description">
                        <p>{{ meal.desc }} </p>
                    </div>
                  </div>
                  <a class="waves-effect waves-light btn btn-floating right"><i class="material-icons left">add</i></a>
                </div>
              </div>
            </div>
            <div class="center-align no-meals" ng-hide="(meals | filter: global.search).length">No Meals Found</div>
          </div>
        </div>

        <div class="col s9"  id="list_meals" ng-controller="MealsController">
          <div class="section" ng-repeat="meal in meals | filter: global.search">
            <div class="row">
              <h3 class="title">{{ meal.header }}</h3>
              <a class="waves-effect waves-light btn btn-floating right"><i class="material-icons left">add</i></a>
              <div class="col s12 m6 l4">   
                <img class="responsive-img materialboxed z-depth-2 list-meal" ng-src="{{ meal.image }}">
              </div>
              <div class="col s8">
                <p>Calorie Power: <br> {{ meal.meta_calorie }} <span class="unit">{{ meal.meta_unit }}</span></p>
                <div class="description">
                  <p>{{ meal.desc }}</p>
                </div>
              </div>
            </div>
            <div class="divider"></div>
          </div>
          <div class="center-align no-meals" ng-hide="(meals | filter: global.search).length">No Meals Found</div>
        </div>

        <jsp:include page="/meal_management/category.jsp"/>
  </div>
</div>
<%--  Put JS Scripts ../js is not required --%>
<jsscript src="calowrie/meal_management/angular_index.js"></jsscript>
<jsscript src="calowrie/meal_management/index.js"></jsscript>

<jsp:include page="/layout-footer.jsp" />

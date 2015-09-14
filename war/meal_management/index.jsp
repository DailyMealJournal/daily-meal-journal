<jsp:include page="/layout-header.jsp" />

<%--  Page Title --%>
<pagetitle name="Meal Management"></pagetitle>

<%--  Style URL ../css is not required --%>
<styleurl url="calowrie/meal_management/index.css"></styleurl>

<div class="meal-management section row"  ng-module="myMeals">
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
            <div class="col s3 offset-s3 hide-on-med-and-down right-align add-meal">
               <a id="btn_add_new_meal" data-target="modal_add_new_meal" class="btn modal-trigger btn-floating"><i class="material-icons">add</i></a>
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
      
      <div ng-controller="MealsController" ng-init="init()">
        <div class="col s9"  id="grid_meals">
          <div class="row">
            <div class="col s12  l6" ng-repeat="meal in meals | filter: global.search">   
              <div class="card small hoverable">
                <div class="card-image waves-effect waves-block waves-light">
                  <img class="activator responsive-img" ng-src="{{ meal.picture }}">
                  <span class="card-title" style="">{{ meal.name }}</span>
                </div>
                <div class="card-content">
                  <span class="card-title activator grey-text text-darken-4"><i class="material-icons right">more_vert</i></span>
                   <p>Calorie Power: {{ meal.calories }} per <span class="unit">{{ meal.unit }}</span></p>
                   <p class="truncate">{{ meal.description }} </p>
                    <button ng-click="delete(meal.id)">delete</button>
                </div>
                <div class="card-reveal">
                  <div class="row reveal-row">
                    <span class="card-title text-size-16 grey-text text-darken-4 row">
                      <i class="col s9">{{ meal.name }}</i>
                      <i class="material-icons right col s3">close</i>
                    </span>
                    <div class="description">
                        <p>{{ meal.description }} </p>
                    </div>
                  </div>
                  <a class="waves-effect waves-light btn btn-floating right"><i class="material-icons left">add</i></a>
                </div>
              </div>
            </div>
            <div class="center-align no-meals" ng-hide="(meals | filter: global.search).length">No Meals Found</div>
          </div>
        </div>

        <div class="col s9"  id="list_meals">
          <div class="section" ng-repeat="meal in meals | filter: global.search">
            <div class="row">
              <h3 class="title">{{ meal.name }}</h3>
              <a class="waves-effect waves-light btn btn-floating right"><i class="material-icons left">add</i></a>
              <div class="col s12 m6 l4">   
                <img class="responsive-img materialboxed z-depth-2 list-meal" ng-src="{{ meal.picture }}">
              </div>
              <div class="col s8">
                <p>Calorie Power: <br> {{ meal.calories }} per <span class="unit">{{ meal.unit }}</span></p>
                <div class="description">
                  <p>{{ meal.description }}</p>
                </div>
              </div>
            </div>
            <div class="divider"></div>
          </div>
          <div class="center-align no-meals" ng-hide="(meals | filter: global.search).length">No Meals Found</div>
        </div>
      </div>
        

        <jsp:include page="/meal_management/category.jsp"/>
  </div>

	
    <!--<div class="container">
        <div class="row">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Default Quantity</th>
                        <th>Unit</th>
                        <th>Calories</th>
                        <th>Description</th>
                        <th>Picture</th>
                        <th>&nbsp;</th>
                    </tr>
                </thead>
                <tbody id="testBody">
                    <tr>
                        <td>1</td>
                        <td>Chicken</td>
                        <td>Poultry</td>
                        <td>1</td>
                        <td>Piece</td>
                        <td>200</td>
                        <td>A scrumptious chicken piece</td>
                        <td>No picture</td>
                        <td><button class="btn"><i class="small material-icons">reorder</i></button>&nbsp;<button class="btn" style="display: inline; vertical-align:middle"><i class="small material-icons">delete</i></button></td>
                    </tr>
                     loop here 
                    
                </tbody>
            </table>
        </div>
    </div>-->
    
    <!--<script type="text/javascript" src="calowrie/meal_management/index.js"></script>-->
    
</div>
<%--  Put JS Scripts ../js is not required --%>
<jsscript src="calowrie/meal_management/index.js"></jsscript>
<jsscript src="calowrie/angular/controllers/meal_controller.js"></jsscript>
<jsscript src="calowrie/angular/controllers/all_controller.js"></jsscript>
<jsscript src="calowrie/angular/controllers/category_controller.js"></jsscript>

<jsp:include page="/layout-footer.jsp" />

<jsp:include page="/layout-header.jsp" />

<%--  Page Title --%>
<pagetitle name="Calowrie - Meal Management"></pagetitle>

<%--  Style URL ../css is not required --%>
<styleurl url="calowrie/meal_management/index.css"></styleurl>

<div class="ui equal width grid"  ng-app="myMeals">
    <div class="five column doubling ui grid"  ng-controller="MealCategoryController">
      <div class="column">
        <div class="ui segment category"   ng-repeat="category in categories">
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
    <div class="equal height stretched row">
      <div class="column">
      </div>
      <div class="eight wide column"  ng-controller="MealsController">
        <div class="ui segment cards">
    			  <div class="card"  ng-repeat="meal in meals">
    			    <a class="image">
    			      <img ng-src="{{ meal.image }}">
    			    </a>
    			    <div class="content">
    			      <div class="header">{{ meal.header }}</div>
    			      <div class="meta">
    			        <p>Calorie Power: {{ meal.meta_calorie }} <span class="unit">{{ meal.meta_unit }}</span></p>
    			      </div>
    			      <div class="description">
    			       {{ meal.desc }} 
    			      </div>
    			    </div>
    			  </div>
        </div>
      </div>
    </div>
  </div>
	

<%--  Put JS Scripts ../js is not required --%>
<jsscript src="calowrie/meal_management/index.js"></jsscript>

<jsp:include page="/layout-footer.jsp" />

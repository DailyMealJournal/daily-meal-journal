
<div class="col s3 fixed hide-on-med-and-down">
    <div class="fixed-pos filters">
        <div class="input-field">
            <i class="material-icons prefix">search</i>
            <input id="search" type="text" class="validate" ng-model="global.search" ng-change="apiSearch()">
            <label for="search">Search</label>
        </div>
        <div class="collection"  ng-controller="MealCategoryController">
            <div class="collection-item">
                <h5>Filters</h5>
                <ul class="collapsible" data-collapsible="accordion" id="filters_list">
                    <li ng-repeat="category in categories">
                        <div class="collapsible-header"><img class="accordion-header-img" ng-src="{{ category.image }}"> {{ category.name }}</div>
                        <div class="collapsible-body">
                            <div class="accordion-list">
                                <div ng-repeat="filter in category.filters">
                                    <input type=checkbox id="food_{{filter}}" />
                                    <label for="food_{{filter}}">{{ filter }}</label>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="collection-item">
                <!-- Modal Trigger -->
            </div>
        </div>
    </div>
</div> 

<div id="category_btn" class="container hide full hide-on-large-only">
    <a href="#" class="button-collapse top-nav sidebar-btn hide-on-large-only" data-activates="cat_sidebar">
        <i class="material-icons">dns</i>
    </a>
</div>


<!-- RESPONSIVE SIDEBAR RIGHT -->
<div class="right fixed side-nav category-sidebar  right white lighten-1 hide-on-large-only" id="cat_sidebar">
    <div class="collection"  ng-controller="MealCategoryController">
        <div class="collection-item">
            <h5>Filters</h5>
            <ul class="collapsible" data-collapsible="accordion" id="filters_list">
                <li ng-repeat="category in categories">
                    <div class="collapsible-header"><img class="accordion-header-img" ng-src="{{ category.image }}"> {{ category.name }}</div>
                    <div class="collapsible-body">
                        <div class="accordion-list">
                            <div ng-repeat="filter in category.filters">
                                <input type=checkbox class="add_meal_filter_food" id="food_{{filter}}" />
                                <label for="food_{{filter}}">{{ filter }}</label>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <div class="collection-item">
            <!-- Modal Trigger -->
            <button id="btn_add_new_meal" data-target="modal_add_new_meal" class="btn modal-trigger">Add New Meal</button>
        </div>
    </div>
</div>
<!-- RESPONSIVE RIGHT SIDEBAR END -->


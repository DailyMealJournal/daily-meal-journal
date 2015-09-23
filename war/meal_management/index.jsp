<jsp:include page="/layout-header.jsp" />

<%--  Page Title --%>
<pagetitle name="Meal Management"></pagetitle>

<%--  Style URL ../css is not required --%>
<styleurl url="calowrie/meal_management/index.css"></styleurl>

<div class="meal-management section row"  ng-module="myMeals" ng-controller="MealsController">
  <div>
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
      
      <div ng-init="init()">
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
                   <div class="right card-modify-buttons">
                   	<a class="btn btn-floating waves-effect waves-light" title="Edit" ng-click="preEdit(meal.id)"><i class="material-icons small">reorder</i></a>
                   	<a class="btn btn-floating waves-effect waves-light" title="Delete" ng-click="preDelete(meal.id)"><i class="material-icons small">delete</i></a>
                   </div>
                   
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
                  <div class="left">
                   	<a class="btn btn-floating waves-effect waves-light" title="Edit" ng-click="preEdit(meal.id)"><i class="material-icons small">reorder</i></a>
                   	<a class="btn btn-floating waves-effect waves-light" title="Delete" ng-click="preDelete(meal.id)"><i class="material-icons small">delete</i></a>
                   	<a class="btn btn-floating waves-effect waves-light" title="Add to today's Journal"><i class="material-icons left">add</i></a>
                   </div>
                </div>
              </div>
            </div>
            <div class="center-align no-meals" ng-hide="(meals | filter: global.search).length">No Meals Found</div>
          </div>
        </div>

        <div class="col s9" id="list_meals">
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
                <div class="left card-modify-buttons">
					<a class="btn btn-floating waves-effect waves-light" title="Edit" ng-click="preEdit(meal.id)"><i class="material-icons small">reorder</i></a>
					<a class="btn btn-floating waves-effect waves-light" title="Delete" ng-click="preDelete(meal.id)"><i class="material-icons small">delete</i></a>
				</div>
              </div>
            </div>
            <div class="divider"></div>
          </div>
          <div class="center-align no-meals" ng-hide="(meals | filter: global.search).length">No Meals Found</div>
        </div>
      </div>
      
      	<!-- DELETE MEAL MODAL -->
		<div id="modal_delete_meal" class="modal modal-fixed-footer" >
			<div class="modal-content container">        
		        <div class="row teal" style="padding: 1% 0%">
		            <h3 style="padding: 1% 0%; padding-left:0.75rem; color: white">Delete Meal</h3>
		        </div>
				<div class="row">
		            <div>
		                <p class="flow-text">Are you sure you want to delete this meal?</p>
		            </div>
				</div>	
			</div>
			<div class="modal-footer">
			    <button id="btn_delete_meal" style="margin-left: 8px; margin-right: 8px" class="btn" ng-click="deleteMeal()">Delete Meal</button>        
			    <button id="btn_delete_meal_close" data-target="modal_delete_meal" class="btn modal-trigger red lighten-2">Cancel</button>
			</div>		
		</div>
	<jsp:include page="/meal_management/category.jsp"/>
  </div>

	
    <!-- ADD MEAL MODAL -->
	<div id="modal_add_new_meal" class="modal modal-fixed-footer" >
		<div class="modal-content container">
	        <div class="row teal" style="padding: 1% 0%">
	            <h3 style="padding: 1% 0%; padding-left:0.75rem; color: white">Add New Meal</h3>
	        </div>
			<div class="row">
				<div class="col s12">
					<form id="form_add_meal" action="create" class="form-meal" method="POST">
						<div class="row">
							<div class="input-field  col s12 m8">
						    	<input id="meal_name" type="text" name="meal_name" class="validate add-field" required="required" ng-model="addMealModel.name">
						    	<label for="meal_name">Meal Name</label>
						    </div>
						    <div class="input-field col s12 m4">
							    <select id="meal_category" class="browser-default add-field" name="meal_category" required="required" ng-model="addMealModel.category">
							    	<option value="" disabled selected>Category</option>
							     	<option value="Poultry">Poultry</option>
							      	<option value="Meat">Meat</option>
							      	<option value="Seafood">Seafood</option>
							      	<option value="Fruits & Vegetables">Fruits & Vegetables</option>
							      	<option value="Dairy">Dairy</option>
							      	<option value="Dessert">Dessert</option>
							      	<option value="Beverage">Beverage</option>
							      	<option value="Snacks">Snacks</option>
							    </select>				    	
						  	</div>
						</div>
					    <div class="row">
					    	<div class="input-field col s12 m4">
	    				        <input id="meal_defQuantity" type="number" min="1" name="meal_defQuantity" ng-model="addMealModel.def_quantity" class="materialize-textarea add-field" required="required">
	    				        <label for="meal_defQuantity">Default Quantity</label>
	    			        </div>
	    			         <div class="input-field col s12 m4">
	    				        <input id="meal_unit" type="text" name="meal_unit" ng-model="addMealModel.unit" class="materialize-textarea add-field" required="required">
	    				        <label for="meal_unit">Unit</label>
	    			        </div>
	    			         <div class="input-field col s12 m4">
	    				        <input id="meal_calories" type="number" min="0" name="meal_calories" ng-model="addMealModel.calories" class="materialize-textarea add-field" required="required">
	    				        <label for="meal_calories">Calories</label>
	    			        </div>
					    </div>
					    <div class="row">
					    	<div class="input-field col s12">
						        <textarea id="meal_description" name="meal_description" ng-model="addMealModel.description" class="materialize-textarea add-field" maxlength="300" placeholder="300 characters"></textarea>
						        <label for="meal_description">Meal Description</label>
					        </div>
			      			<div class="file-field input-field col s12">
							    <div class="btn">
								    <span>Picture</span>
								    <input type="file" accept=".jpg" name=""/>
							    </div>
							    <div class="file-path-wrapper">
							    	<input id="meal_picture" class="file-path validate add-field" type="text" name="meal_picture" ng-model="addMealModel.picture" placeholder="Optional"/>
							    </div>
					    	</div>
					    </div>
			    	</form>
				</div>
			</div>	
			<div class="row">
				<div class="col s12">
					<p>{{addMealModel.error}}</p>
				</div>
			</div>
		</div>
		<div class="modal-footer">
		    <button id="btn_add_meal" style="margin-left: 8px; margin-right: 8px" class="btn" ng-click="addMeal()">Add Meal</button>        
		    <button id="btn_add_new_meal_close" data-target="modal_add_new_meal" class="btn modal-trigger red lighten-2">Cancel</button>
		</div>		
	</div>
    
    <!-- EDIT MEAL MODAL -->
	<div id="modal_edit_meal" class="modal modal-fixed-footer" >
		<div class="modal-content container">        
	        <div class="row teal" style="padding: 1% 0%">
	            <h3 style="padding: 1% 0%; padding-left:0.75rem; color: white">Edit Meal</h3>
	        </div>
			<div class="row">
				<div class="col s12">
					<form id="form_edit_meal" action="update" class="form-meal" method="POST">
	                    <input id="edit_meal_id" type="hidden" name="meal_id" ng-model="editMealModel.id" value="{{editMealModel.id}}">
						<div class="row">
							<div class="input-field  col s12 m8">
						    	<input id="edit_meal_name" type="text" name="meal_name" class="validate" required="required" ng-model="editMealModel.name" value="{{editMealModel.name}}">
						    	<label class="label_edit" for="meal_name">Meal Name</label>
						    </div>
						    <div class="input-field col s12 m4">
							    <select id="edit_meal_category" name="meal_category" required="required" ng-model="editMealModel.category" value="{{editMealModel.category}}">
							     	<option class="editSelectOption" value="Poultry">Poultry</option>
							      	<option class="editSelectOption" value="Meat">Meat</option>
							      	<option class="editSelectOption" value="Seafood">Seafood</option>
							      	<option class="editSelectOption" value="Fruits & Vegetables">Fruits & Vegetables</option>
							      	<option class="editSelectOption" value="Dairy">Dairy</option>
							      	<option class="editSelectOption" value="Dessert">Dessert</option>
							      	<option class="editSelectOption" value="Beverage">Beverage</option>
							      	<option class="editSelectOption" value="Snacks">Snacks</option>
							    </select>				    	
	                            <label>Category</label>
						  	</div>
						</div>
					    <div class="row">
					    	<div class="input-field col s12 m4">
	    				        <input id="edit_meal_defQuantity" type="number" min="1" name="meal_defQuantity" class="materialize-textarea" required="required" ng-model="editMealModel.def_quantity" value="{{editMealModel.def_quantity}}">
	    				        <label class="label_edit" for="meal_defQuantity">Default Quantity</label>
	    			        </div>
	    			         <div class="input-field col s12 m4">
	    				        <input id="edit_meal_unit" type="text" name="meal_unit" class="materialize-textarea" required="required" ng-model="editMealModel.unit" value="{{editMealModel.unit}}">
	    				        <label class="label_edit" for="meal_unit">Unit</label>
	    			        </div>
	    			         <div class="input-field col s12 m4">
	    				        <input id="edit_meal_calories" type="number" min="0" name="meal_calories" class="materialize-textarea" required="required" ng-model="editMealModel.calories" value="{{editMealModel.calories}}">
	    				        <label class="label_edit" for="meal_calories">Calories</label>
	    			        </div>
					    </div>
					    <div class="row">
					    	<div class="input-field col s12">
						        <textarea id="edit_meal_description" name="meal_description" class="materialize-textarea" maxlength="300" placeholder="300 characters" ng-model="editMealModel.description">{{editMealModel.description}}</textarea>
						        <label for="meal_description">Meal Description</label>
					        </div>
			      			<div class="file-field input-field col s12">
							    <div class="btn">
								    <span>Picture</span>
								    <input type="file" accept=".jpg" name=""/>
							    </div>
							    <div class="file-path-wrapper">
							    	<input id="edit_meal_picture" class="file-path validate" type="text" name="meal_picture" placeholder="Optional" ng-model="editMealModel.picture" value="{{editMealModel.picture}}"/>
							    </div>
					    	</div>
					    </div>
					    <div class="row">
					    	<div class="input-field col s12">
					    		<button class="btn" ng-click="clearPhoto()">Clear Photo</button>
					    	</div>
					    </div>
			    	</form>
				</div>
			</div>	
			<div class="row">
				<div class="col s12">
					<p>{{editMealModel.error}}</p>
				</div>
			</div>
		</div>
		<div class="modal-footer">
		    <button id="btn_edit_meal" style="margin-left: 8px; margin-right: 8px" class="btn" ng-click="editMeal()">Edit Meal</button>        
		    <button id="btn_edit_meal_close" data-target="modal_edit_meal" class="btn modal-trigger red lighten-2">Cancel</button>
		</div>		
	</div>
    
    <!--<script type="text/javascript" src="calowrie/meal_management/index.js"></script>-->
    
</div>

<%--  Put JS Scripts ../js is not required --%>
<jsscript src="calowrie/meal_management/index.js"></jsscript>
<jsscript src="calowrie/angular/controllers/meal_controller.js"></jsscript>
<jsscript src="calowrie/angular/controllers/all_controller.js"></jsscript>
<jsscript src="calowrie/angular/controllers/category_controller.js"></jsscript>

<jsp:include page="/layout-footer.jsp" />

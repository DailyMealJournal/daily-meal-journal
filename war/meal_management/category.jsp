
<div class="col s3 fixed hide-on-med-and-down">
	<div class="fixed-pos filters">
		<div class="input-field">
			<i class="material-icons prefix">search</i> <input id="search"
				type="text" class="validate" ng-model="global.search"
				ng-change="apiSearch()"> <label for="search">Search</label>
		</div>
		<div class="collection" ng-controller="MealCategoryController">
			<div class="collection-item">
				<h5>Filters</h5>
				<ul class="collapsible" data-collapsible="accordion"
					id="filters_list">
					<li ng-repeat="category in categories">
						<div class="collapsible-header">
							<img class="accordion-header-img" ng-src="{{ category.image }}">
							{{ category.name }}
						</div>
						<div class="collapsible-body">
							<div class="accordion-list">
								<div ng-repeat="filter in category.filters">
									<input type=checkbox id="food_{{filter}}" /> <label
										for="food_{{filter}}">{{ filter }}</label>
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
	<a href="#"
		class="button-collapse top-nav sidebar-btn hide-on-large-only"
		data-activates="cat_sidebar"> <i class="material-icons">dns</i>
	</a>
</div>


<!-- RESPONSIVE SIDEBAR RIGHT -->
<div
	class="right fixed side-nav category-sidebar  right white lighten-1 hide-on-large-only"
	id="cat_sidebar">
	<div class="collection" ng-controller="MealCategoryController">
		<div class="collection-item">
			<h5>Filters</h5>
			<ul class="collapsible" data-collapsible="accordion"
				id="filters_list">
				<li ng-repeat="category in categories">
					<div class="collapsible-header">
						<img class="accordion-header-img" ng-src="{{ category.image }}">
						{{ category.name }}
					</div>
					<div class="collapsible-body">
						<div class="accordion-list">
							<div ng-repeat="filter in category.filters">
								<input type=checkbox class="add_meal_filter_food"
									id="food_{{filter}}" /> <label for="food_{{filter}}">{{
									filter }}</label>
							</div>
						</div>
					</div>
				</li>
			</ul>
		</div>
		<div class="collection-item">
			<!-- Modal Trigger -->
			<button id="btn_add_new_meal" data-target="modal_add_new_meal"
				class="btn modal-trigger">Add New Meal</button>
		</div>
	</div>
</div>
<!-- RESPONSIVE RIGHT SIDEBAR END -->

<!-- ADD MEAL MODAL -->
<div id="modal_add_new_meal" class="modal modal-fixed-footer">
	<div class="modal-content container">
		<div class="row teal" style="padding: 1% 0%">
			<h3 style="padding: 1% 0%; padding-left: 0.75rem; color: white">Add
				New Meal</h3>
		</div>
		<div class="row">
			<div class="col s12">
				<form id="form_add_meal" action="create" class="form-meal"
					method="POST">
					<div class="row">
						<div class="input-field  col s12 m8">
							<input id="meal_name" type="text" name="meal_name"
								class="validate" required="required"> <label
								for="meal_name">Meal Name</label>
						</div>
						<div class="input-field col s12 m4">
							<select id="meal_category" name="meal_category"
								required="required">
								<option value="Poultry">Poultry</option>
								<option value="Meat">Meat</option>
								<option value="Seafood">Seafood</option>
								<option value="Fruits & Vegetables">Fruits & Vegetables</option>
								<option value="Dairy">Dairy</option>
								<option value="Dessert">Dessert</option>
								<option value="Beverage">Beverage</option>
								<option value="Snacks">Snacks</option>
							</select> <label>Category</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12 m4">
							<input id="meal_defQuantity" type="number" min="1"
								name="meal_defQuantity" class="materialize-textarea"
								required="required"> <label for="meal_defQuantity">Default
								Quantity</label>
						</div>
						<div class="input-field col s12 m4">
							<input id="meal_unit" type="text" name="meal_unit"
								class="materialize-textarea" required="required"> <label
								for="meal_unit">Unit</label>
						</div>
						<div class="input-field col s12 m4">
							<input id="meal_calories" type="number" min="0"
								name="meal_calories" class="materialize-textarea"
								required="required"> <label for="meal_calories">Calories</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<textarea id="meal_description" name="meal_description"
								class="materialize-textarea" maxlength="300"
								placeholder="300 characters"></textarea>
							<label for="meal_description">Meal Description</label>
						</div>
						<div class="file-field input-field col s12">
							<div class="btn">
								<span>Picture</span> <input type="file" accept=".jpg" name="" />
							</div>
							<div class="file-path-wrapper">
								<input class="file-path validate" type="text"
									name="meal_picture" placeholder="Optional" />
							</div>
						</div>
					</div>
				</form>
			</div>

			<!--
			<div class="col s12 m4">
				<ul class="collapsible" data-collapsible="accordion" ng-controller="MealCategoryController">
                    <li ng-repeat="category in categories">
                        <div class="collapsible-header"><img class="accordion-header-img" ng-src="{{ category.image }}"> {{ category.name }}</div>
                        <div class="collapsible-body">
                            <div class="accordion-list">
                                <div ng-repeat="filter in category.filters">
                                    <input type="checkbox" id="food_{{filter}}" />
                                    <label for="food_{{filter}}">{{ filter }}</label>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            -->
		</div>
	</div>
	<div class="modal-footer">
		<button id="btn_add_meal" style="margin-left: 8px; margin-right: 8px"
			class="btn">Add Meal</button>
		<button id="btn_add_new_meal_close" data-target="modal_add_new_meal"
			class="btn modal-trigger red lighten-2">Cancel</button>
	</div>
</div>

<!-- EDIT MEAL MODAL -->
<div id="modal_edit_meal" class="modal modal-fixed-footer">
	<div class="modal-content container">
		<div class="row teal" style="padding: 1% 0%">
			<h3 style="padding: 1% 0%; padding-left: 0.75rem; color: white">Edit
				Meal</h3>
		</div>
		<div class="row">
			<div class="col s12">
				<form id="form_edit_meal" action="update" class="form-meal"
					method="POST">
					<input id="edit_meal_id" type="hidden" name="meal_id" value="">

					<div class="row">
						<div class="input-field  col s12 m8">
							<input id="edit_meal_name" type="text" name="meal_name"
								class="validate" required="required"> <label
								for="meal_name">Meal Name</label>
						</div>
						<div class="input-field col s12 m4">
							<select id="edit_meal_category" name="meal_category"
								required="required">
								<option value="Poultry">Poultry</option>
								<option value="Meat">Meat</option>
								<option value="Seafood">Seafood</option>
								<option value="Fruits & Vegetables">Fruits & Vegetables</option>
								<option value="Dairy">Dairy</option>
								<option value="Dessert">Dessert</option>
								<option value="Beverage">Beverage</option>
								<option value="Snacks">Snacks</option>
							</select> <label>Category</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12 m4">
							<input id="edit_meal_defQuantity" type="number" min="1"
								name="meal_defQuantity" class="materialize-textarea"
								required="required"> <label for="meal_defQuantity">Default
								Quantity</label>
						</div>
						<div class="input-field col s12 m4">
							<input id="edit_meal_unit" type="text" name="meal_unit"
								class="materialize-textarea" required="required"> <label
								for="meal_unit">Unit</label>
						</div>
						<div class="input-field col s12 m4">
							<input id="edit_meal_calories" type="number" min="0"
								name="meal_calories" class="materialize-textarea"
								required="required"> <label for="meal_calories">Calories</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<textarea id="edit_meal_description" name="meal_description"
								class="materialize-textarea" maxlength="300"
								placeholder="300 characters"></textarea>
							<label for="meal_description">Meal Description</label>
						</div>
						<div class="file-field input-field col s12">
							<div class="btn">
								<span>Picture</span> <input type="file" accept=".jpg" name="" />
							</div>
							<div class="file-path-wrapper">
								<input id="edit_meal_picture" class="file-path validate"
									type="text" name="meal_picture" placeholder="Optional" />
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button id="btn_edit_meal" style="margin-left: 8px; margin-right: 8px"
			class="btn">Edit Meal</button>
		<button id="btn_edit_meal_close" data-target="modal_edit_meal"
			class="btn modal-trigger red lighten-2">Cancel</button>
	</div>
</div>

<!-- DELETE MEAL MODAL -->
<div id="modal_delete_meal" class="modal modal-fixed-footer">
	<div class="modal-content container">
		<div class="row teal" style="padding: 1% 0%">
			<h3 style="padding: 1% 0%; padding-left: 0.75rem; color: white">Delete
				Meal</h3>
		</div>
		<div class="row">
			<div class="col s12">
				<form id="form_delete_meal" action="delete" class="form-meal"
					method="POST">
					<input id="delete_meal_id" type="hidden" name="meal_id" value="">
				</form>
			</div>
			<div>
				<p class="flow-text">Are you sure you want to delete this meal?</p>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button id="btn_delete_meal"
			style="margin-left: 8px; margin-right: 8px" class="btn">Delete
			Meal</button>
		<button id="btn_delete_meal_close" data-target="modal_edit_meal"
			class="btn modal-trigger red lighten-2">Cancel</button>
	</div>
</div>
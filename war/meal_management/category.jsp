
    <div class="col s3">
        <div class="collection fixed-pos"  ng-controller="MealCategoryController">
            <div class="collection-item">
                <h5>Filters</h5>
                <div class=""  ng-repeat="category in categories"> 
                    <span class="">{{ category.name }}</span>
                </div>
            </div>
            <div class="collection-item">
                <!-- Modal Trigger -->
                <button id="btn_add_new_meal" data-target="modal_add_new_meal" class="btn modal-trigger">Add New Meal</button>
            </div>
        </div>
    </div>    
<div id="modal_add_new_meal" class="modal modal-fixed-footer">
	<div class="modal-content container">
		<h3>Add New Meal</h3>
		<div class="row">
			<div class="col s12 m8">
				<form>	
				    <div class="input-field">
				    	<input id="meal_name" type="text" class="validate">
				    	<label for="first_name">Meal Name</label>
				    </div>
			        <div class="input-field">
				        <textarea id="textarea1" class="materialize-textarea"></textarea>
				        <label for="textarea1">Meal Description</label>
			        </div>
	      			<div class="file-field input-field col s12">
					    <div class="btn">
						    <span>File</span>
						    <input type="file" />
					    </div>
					    <div class="file-path-wrapper">
					    	<input class="file-path validate" type="text"/>
					    </div>
			    	</div>
		    	</form>
			</div>
			<div class="col s12 m4">
				<ul class="collapsible" data-collapsible="accordion">
					<li>
						<div class="collapsible-header">Poultry</div>
						<div class="collapsible-body">
                            <div class="accordion-list">
                                <div>
                                    <input type="checkbox" id="food_chicken" />
                                    <label for="food_chicken">Chicken</label>
                                </div>
                                <div>
                                    <input type="checkbox" id="food_duck" />
                                    <label for="food_duck">Duck</label>
                                </div>
                            </div>
						</div>
					</li>
					<li>
						<div class="collapsible-header">Meat</div>
						<div class="collapsible-body">	
                            <div class="accordion-list">
                                <div>
                                    <input type="checkbox" id="food_beef" />
                                    <label for="food_beef">Beef</label>
                                </div>
                                <div>
                                    <input type="checkbox" id="food_pork" />
                                    <label for="food_pork">Pork</label>
                                </div>
                            </div>	
						</div>
					</li>
					<li>
						<div class="collapsible-header">Seafood</div>
						<div class="collapsible-body">
                            <div class="accordion-list">
                                <div>
                                    <input type="checkbox" id="food_fish" />
                                    <label for="food_fish">Fish</label>
                                </div>
                                <div>
                                    <input type="checkbox" id="food_crab" />
                                    <label for="food_crab">Crab</label>
                                </div>
                            </div>
						</div>	
					</li>
					<li>
						<div class="collapsible-header">Fruits & Vegetables</div>
						<div class="collapsible-body">
                            <div class="accordion-list">
                                <div>
                                    <input type="checkbox" id="food_apples" />
                                    <label for="food_apples">Apples</label>
                                </div>
                                <div>
                                    <input type="checkbox" id="food_mangoes" />
                                    <label for="food_mangoes">Mangoes</label>
                                </div>
                                <div>
                                    <input type="checkbox" id="food_carrots" />
                                    <label for="food_carrots">Carrots</label>
                                </div>
                                <div>
                                    <input type="checkbox" id="food_potatoes" />
                                    <label for="food_potatoes">Potatoes</label>
                                </div>
                            </div>
						</div>
					</li>
					<li>
						<div class="collapsible-header">Dairy</div>
						<div class="collapsible-body">
                            <div class="accordion-list">
                                <div>
                                    <input type="checkbox" id="food_milk" />
                                    <label for="food_milk">Milk</label>
                                </div>
                                <div>
                                    <input type="checkbox" id="food_yogurt" />
                                    <label for="food_yogurt">Yogurt</label>
                                </div>
                                <div>
                                    <input type="checkbox" id="food_cheese" />
                                    <label for="food_cheese">Cheese</label>
                                </div>
                            </div>
						</div>
					</li>
					<li>
						<div class="collapsible-header">Dessert</div>
						<div class="collapsible-body">
                            <div class="accordion-list">
                                <div>
                                    <input type="checkbox" id="food_chocolate" />
                                    <label for="food_chocolate">Chocolate</label>
                                </div>
                                <div>
                                    <input type="checkbox" id="food_iceCream" />
                                    <label for="food_iceCream">Ice Cream</label>
                                </div>
                            </div>	
						</div>
					</li>
					<li>
						<div class="collapsible-header">Beverage</div>
						<div class="collapsible-body">
                            <div class="accordion-list">
                                <div>
                                    <input type="checkbox" id="food_proteinShake" />
                                    <label for="food_proteinShake">Protein Shake</label>
                                </div>
                                <div>
                                    <input type="checkbox" id="food_fruitShake" />
                                    <label for="food_fruitShake">Fruit Shake</label>
                                </div>
                                <div>
                                    <input type="checkbox" id="food_wine" />
                                    <label for="food_wine">Wine</label>
                                </div>
                                <div>
                                    <input type="checkbox" id="food_soda" />
                                    <label for="food_soda">Soda</label>
                                </div>
                            </div>
						</div>
					</li>
					<li>
						<div class="collapsible-header">Snacks</div>
						<div class="collapsible-body">
                            <div class="accordion-list">
                                <div>
                                    <input type="checkbox" id="food_chips" />
                                    <label for="food_chips">Chips</label>
                                </div>
                                <div>
                                    <input type="checkbox" id="food_frenchFries" />
                                    <label for="food_frenchFries">French Fries</label>
                                </div>
                            </div>
						</div>
					</li>
				</ul>
			</div>
		</div>	
	</div>
	<div class="modal-footer">
        <button id="btn_add_new_meal_close" data-target="modal_add_new_meal" class="btn modal-trigger red lighten-2">Cancel</button>
        <button id="btn_add_new_meal_close" data-target="modal_add_new_meal" class="btn modal-trigger">Add Meal</button>
	</div>		
</div>
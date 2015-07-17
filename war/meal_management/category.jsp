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
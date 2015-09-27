<jsp:include page="/layout-header.jsp" />

<%-- Page Title --%>
<pagetitle name="Account"></pagetitle>

<%-- Style URL ../css us bit required --%>
<style type="text/css">
	.fieldTitle{
		font-size: 18px;
		font-weight: bold;
	}
	.field{
		font-size: 18px;
	}
	
	.upload{
		margin-top: 18px;	
	}
	
	.content{
		margin-top: 42px;	
	}

</style>
<styleurl url="calowrie/main.css"></styleurl>
<styleurl url="calowrie/meal_journal/index.css"></styleurl>

<div ng-module="myProfile">
<div class="content" ng-controller="editAccount">
	<div class="row">
		<div class="offset-s2 col s9">
			<div class="col s2">
				<p class="fieldTitle">Username</p>
			</div>
			<div class="col s7">
				<p class="field" ng-show="field">{{userProfile.username}}</p>
			</div>
			<div class="col s7" ng-show="editField">
				<input type="text" ng-model="editAccountModel.username" value="{{editAccountModel.username}}"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="offset-s2 col s9">
			<div class="col s2">
				<p class="fieldTitle">Password</p>
			</div>
			<div class="col s7">
				<p class="field" ng-show="field">********</p>
			</div>
			<div class="col s7" ng-show="editField">
				<input ng-model="editAccountModel.password" type="password" value="{{editAccountModel.password}}"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="offset-s2 col s9">
			<div class="col s2">
				<p class="fieldTitle">First Name</p>
			</div>
			<div class="col s7">
				<p class="field" ng-show="field">{{ userProfile.firstName }}</p>
			</div>
			<div class="col s7" ng-show="editField">
				<input ng-model="editAccountModel.firstname" type="text" value="{{editAccountModel.firstName}}"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="offset-s2 col s9">
			<div class="col s2">
				<p class="fieldTitle">Last Name</p>
			</div>
			<div class="col s7">
				<p class="field" ng-show="field">{{ userProfile.lastName }}</p>
			</div>
			<div class="col s7" ng-show="editField">
				<input ng-model="editAccountModel.lastname" type="text" value="{{editAccountModelm.lastName }}"/>
			</div>
		</div>
	</div>
	<div class="row" ng-show="editField">
		<div class="offset-s2 col s9">
			<div class="col s2">
				<p class="fieldTitle">Upload Picture</p>
			</div>
			<div class="col s7">
				<div class="file-field input-field">
			      <div class="red lighten-2 btn">
			        <span>File</span>
			        <input type="file">
			      </div>
			      <div class="file-path-wrapper">
			        <input class="file-path validate" type="text">
			      </div>
			    </div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="offset-s2 col s9">
			<a ng-show="editButton" ng-click="toggleFields()" class="waves-effect waves-light btn"><i class="material-icons right">edit</i>EDIT ACCOUNT</a>
			<a ng-show="saveButton" ng-click="updateClick()" class="waves-effect waves-light btn"><i class="material-icons right">done</i>save</a>
			<a ng-show="cancelButton" ng-click="toggleFields()" class="waves-effect waves-light btn"><i class="material-icons right">clear</i>cancel</a>
		</div>
	</div>
</div>
</div>
<%-- Put JS Scripts ../css is not required --%>
<jsscript src="calowrie/angular/controllers/user_management_controller.js"></jsscript>
<jsscript src="calowrie/meal_journal/index.js"></jsscript>
<jsp:include page="/layout-footer.jsp" />
<ul class="side-nav fixed  teal lighten-1" id="nav_mobile"
	ng-module="sidebar">
	<div class="sidebar-profile" ng-controller="SidebarController">
		<div class="card">
			<input type="hidden" name="user_id" ng-model="sidebarId" value="{{ sidebarProfile.id }}">
			<div class="card-image waves-effect waves-block waves-light">
				<img class="activator" ng-src="{{ sidebarProfile.image }}">
			</div>
			<div class="card-content">
				<span class="card-title activator grey-text text-darken-4">{{
					sidebarProfile.firstName }}<i class="material-icons right">subject</i>
				</span>
			</div>
			<div class="card-reveal">
				<span class="card-title grey-text text-darken-4 ">{{
					sidebarProfile.firstName }} {{ sidebarProfile.lastName }}<i
					class="material-icons right">face</i>
				</span>
				<li><a class="black-text btn btn-flat">Account </a></li>
				<li><a class="black-text btn btn-flat"
					href="${base_url}user_management/logout">Log Out</a></li>

			</div>
		</div>
	</div>
	<li><a class="waves-effect waves-teal white-text text-lighten-1"
		href="/"> <i class="material-icons left">home</i> Home
	</a></li>
	<li><a class="waves-effect waves-teal white-text text-lighten-1"
		href="${base_url}meal_journal"> <i class="material-icons left ">book</i>
			Meal Journal
	</a></li>
	<li><a class="waves-effect waves-teal white-text text-lighten-1"
		href="${base_url}meal_management"> <i class="material-icons left ">work</i>
			Meal Management
	</a></li>
	<div class="hide" id="include_content"></div>
</ul>
<header>
	<nav class="top-nav red lighten-2">
		<div class="btn-responsive white-text">
			<div class="container full hide-on-large-only">
				<a href="#"
					class="button-collapse top-nav sidebar-btn hide-on-large-only"
					data-activates="nav_mobile"> <i class="mdi-navigation-menu"></i>
				</a>
			</div>
		</div>
		<div class="nav-wrapper center-align">
			<a class="page-title">Meal Management</a>
		</div>
	</nav>
</header>

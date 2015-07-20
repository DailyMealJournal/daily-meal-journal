<jsp:include page="../layout-header.jsp" />

<%--  Page Title --%>
<pagetitle name="Home"></pagetitle>

<%--  Style URL ../css is not required --%>
<styleurl url="calowrie/main.css"></styleurl>
<div class="parallax-container">
	<div class="parallax"><img src="${base_url}assets/img/backgrounds/main.jpg"></div>
</div>
<div class="login">
	<div class="row logo">
		<div class="col s6 right-align">
			<img class="responsive-img" src="${base_url}assets/img/log.png"/>
		</div>
		<div class="col s6 left-align white-text">
			<h4>Calowrie</h4>
		</div>
		<div class="col s12 center-align white-text">
			<h6>It's not just a choice. It's a <i>lifestyle</i>.</h6>
		</div>
	</div>
	<form id="login">
		<div class="row">
			<div class="input-field col s12 white-text">
				<input id="username" type="text" class="validate">
				<label for="username" class="white-text">Username</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12 white-text">
				<input id="password" type="password" class="validate">
				<label for="password" class="white-text">Password</label>
			</div>
		</div>
		<div class="row btn-login center-align">
			<div class="col s12 m4 l5 offset-m2 offset-l1">
				<a href="#" class="waves-effect waves-light btn" id="btn_signup">Sign up</a>
			</div>
			<div class="col s12 m4 l5">
				<a class="waves-effect waves-light btn" href="${base_url}meal_journal">Login</a>
			</div>
		</div>
	</form>
	<form id="register" class="hide" action="${base_url}register" method="POST">
		<div class="row">
			<div class="input-field col s12 white-text">
				<input id="username" type="text" class="validate" name="username" placeholder="Minimum 8 characters">
				<label for="username" class="white-text">Username</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12 white-text">
				<input id="password" type="password" class="validate" name="password" placeholder="Minimum 8 characters">
				<label for="password" class="white-text">Password</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12 white-text">
				<input id="conf_password" type="password" class="validate" name="conf_password">
				<label for="conf_password" class="white-text">Confirm Password</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12 white-text">
				<input id="firstname" type="text" class="validate" name="firstname" >
				<label for="firstname" class="white-text">First Name</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12 white-text">
				<input id="lastname" type="text" class="validate" name="lastname">
				<label for="lastname" class="white-text">Last Name</label>
			</div>
		</div>
		<div class="row btn-login center-align">
			<div class="col s12 m4 l5 offset-m2 offset-l1">
				<a href="#" class="waves-effect waves-light btn" id="btn_back">Back</a>
			</div>
			<div class="col s12 m4 l5">
				<a class="waves-effect waves-light btn" href="#" id="btn_register">Register</a>
			</div>
		</div>
	</form>
</div>
<div class="row left-align team-header">
	<div class="col s12">
		<h2>Meet The Team</h2>
	</div>
</div>
<div class="row center-align team-members">
	<div class="col s12 m4 l2 team-member">
		<div class="center-align">
			<h5>Rafael</h5>
		</div>
		<img src="${base_url}assets/img/team/rafael.jpg" alt="" class="circle responsive-img">
	</div>
	<div class="col s1 red-text loading-pin hide-on-med-and-down">
		<i class="material-icons team-member">adjust</i>
		<i class="material-icons team-member">adjust</i>
		<i class="material-icons team-member">adjust</i>
	</div>
	<div class="col s12 m4 l2 team-member">
		<div class="center-align">
			<h5>Louiz</h5>
		</div>
		<img src="${base_url}assets/img/team/louiz.jpg" alt="" class="circle responsive-img">
	</div>
	<div class="col s1 red-text loading-pin hide-on-med-and-down">
		<i class="material-icons team-member">adjust</i>
		<i class="material-icons team-member">adjust</i>
		<i class="material-icons team-member">adjust</i>
	</div>
	<div class="col s12 m4 l2 team-member">
		<div class="center-align">
			<h5>Sonia</h5>
		</div>
		<img src="${base_url}assets/img/team/sonia.jpg" alt="" class="circle responsive-img">
	</div>
	<div class="col s1 red-text loading-pin hide-on-med-and-down">
		<i class="material-icons team-member">adjust</i>
		<i class="material-icons team-member">adjust</i>
		<i class="material-icons team-member">adjust</i>
	</div>
	<div class="col s12 m4 l2 team-member">
		<div class="center-align">
			<h5>Klifford</h5>
		</div>
		<img src="${base_url}assets/img/team/klifford.jpg" alt="" class="circle responsive-img">
	</div>
	<div class="col s1 red-text loading-pin hide-on-med-and-down offset-l2 empty-space">
	  ..
	</div>
	<div class="col s12 m4 l2 second-row team-member">
		<div class="center-align">
			<h5>Pal</h5>
		</div>
		<img src="${base_url}assets/img/team/pal.jpg" alt="" class="circle responsive-img">
	</div>
	<div class="col s1 red-text loading-pin hide-on-med-and-down second-row">
		<i class="material-icons team-member">adjust</i>
		<i class="material-icons team-member">adjust</i>
		<i class="material-icons team-member">adjust</i>
	</div>
	<div class="col s12 m4 l2 second-row team-member">
		<div class="center-align">
			<h5>Ralp</h5>
		</div>
		<img src="${base_url}assets/img/team/ralp.jpg" alt="" class="circle responsive-img">
	</div>
</div>
	

<%--  Put JS Scripts ../js is not required --%>
<jsscript src="calowrie/home/index.js"></jsscript>


<jsp:include page="/layout-footer.jsp" />
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
	<form>
		<div class="row">
			<div class="input-field col s12 white-text">
				<input id="email" type="email" class="validate">
				<label for="email" class="white-text">Email</label>
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
				<a class="waves-effect waves-light btn">Sign up</a>
			</div>
			<div class="col s12 m4 l5">
				<a class="waves-effect waves-light btn" href="${base_url}meal_journal">Login</a>
			</div>
		</div>
	</form>
</div>
	

<%--  Put JS Scripts ../js is not required --%>
<jsscript src="calowrie/home/index.js"></jsscript>


<jsp:include page="/layout-footer.jsp" />
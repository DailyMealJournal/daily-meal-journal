<jsp:include page="../layout-header.jsp" />

<%--  Page Title --%>
<pagetitle name="Home"></pagetitle>

<%--  Style URL ../css is not required --%>
<styleurl url="calowrie/main.css"></styleurl>

<div class="main-fold ">
	<div class="centered row">
		<div class="column height-top"></div>
	</div>
	<div class=" stackable ui grid">
		<div class="two column row">
			<div class="column">
				<div class="introduction">
					<h1 class="ui inverted header meal-title"> 
						<img src="../assets/img/ico.png"/>
						Calowrie
					</h1>
					<h2 class="sub-title">
						Web's Most Advance Calorie Counter
					</h2>
						<p>
							Started in 2015 by a group of students <br>
						We now present to you one of the most advance<br>
						calorie counter in the market<br>
						Mobile coming soon!
					</p>
				</div>
			 </div>
			 <div class="column">
				<div class="signup box">
					<form class="ui form">
						<h4 class="ui inverted header">Create an Account</h4>

						<div class="field">
							<input type="text" name="username" placeholder="Username">
						</div>
						<div class="field">
							<input type="password" name="password" placeholder="Password">
						</div>
						<div class="field">
							<input type="text" name="email_address" placeholder="Email">
						</div>
						<div class="field frm-btn">
							 <div class="ui inverted button" id="signup-btn">Sign Up</div>
		
							 <div class="ui inverted green button" id="login-btn">Log In</div>
						 </div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="three column stackable ui grid">
		<div class="column"></div>
		<div class="column">
		</div>
		<div class="column">
				<img src="../assets/img/others/prototype_app.png" class="phone phone-app hidden"/>
		</div>
	</div>
</div>
	

<%--  Put JS Scripts ../js is not required --%>
<jsscript src="calowrie/home/index.js"></jsscript>

<<<<<<< HEAD
<jsp:include page="layout-footer.jsp" />

=======
<jsp:include page="../layout-footer.jsp" />
>>>>>>> origin/master

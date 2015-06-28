<jsp:include page="layout-header.jsp" />

<%--  Page Title --%>
<pagetitle name="Home"></pagetitle>

<%--  Style URL ../css is not required --%>
<styleurl url="calowrie/main.css"></styleurl>




<div class="main-fold segment">
	<div class="centered row">
		<div class="column height-top"></div>
	</div>
	<div class="centered row">
		<div class="column">
		 	<div class="introduction">
		 		<h1 class="ui inverted header meal-title"> 
		 			<img src="../assets/img/ico.png"/>
		 			Calowrie
		 		</h1>
		 	</div>
		 </div>
	</div>
	<div class="ui right aligned grid">
		<div class="column">
			<img src="../assets/img/others/prototype_app.png" class="phone hidden"/>
		</div>
	</div>
</div>

<div class="sub-fold segment">

	<div class="centered row titles">
		<div class="column">
		    <h2> See List of Meals Below </h2>
		</div>
	 </div>
</div>
	





<%--  Put JS Scripts ../js is not required --%>
<jsscript src="calowrie/home/index.js"></jsscript>

<jsp:include page="layout-footer.jsp" />

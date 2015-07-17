<jsp:include page="/layout-header(1).jsp" />

<%-- Page Title --%>
<pagetitle name="Meal Journal"></pagetitle>

<%-- Style URL ../css us bit required --%>
<div class = "row"></div>
<div class = "row"></div>
<div class = "row"></div>
<div class = "row">
	<div class="col s7 offset-s2">
		<div class="row" style="margin-bottom:0px;">
			<div class="col s1" style="margin-top:15px; margin-left:30px;">
				<a class="waves-effect waves-red accent-1 btn-flat-large red-text text-accent-1"><i class="material-icons">arrow_back</i></a>
			</div>
			<div class="col s9">
				<h5 style="text-align: center;">Friday, July 17, 2015</h5>
			</div>
			<div class="col s1" style="margin-top:15px; margin-right:25px;">
				<a class="waves-effect waves-red accent-1 btn-flat-large red-text text-accent-1"><i class="material-icons">arrow_forward</i></a>
			</div>
		</div>
		<div class="divider"></div>
		<div class = "section">
			<div class="row" style="margin:20px;">
				<div class="col s10">
					<h4 style="margin-top:0px;">Breakfast at Tiffany's</h4>
					<p class="grey-text text-darken-1">Eat your heart out!</p>
				</div>
				<div>
					<a style="margin-top:5px; margin-right:5px; z-index:-1;" class="btn-floating btn-medium waves-effect waves-light teal"><i class="material-icons">mode_edit</i></a>
					<a style="margin-top:5px; z-index:-1;" class="btn-floating btn-medium waves-effect waves-light red"><i class="material-icons">delete</i></a>
				</div>
			</div>
			<div class="row">
				<table class="centered bordered card-panel" style="width:95%; margin: 0 auto;">
					<thead>
						<tr>
							<th>No. of Servings</th>
							<th>Name of Food</th>
							<th>Calories</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>2</td>
							<td><a class="red-text text-accent-2" href="#">Carbonara</a></td>
							<td>1,000 Calories</td>
						</tr>
						<tr>
							<td>1</td>
							<td><a class="red-text text-accent-2" href="#">Samgyupsal</a></td>
							<td>500 Calories</td>
						</tr>
						<tr style="border-top: thin double; border-bottom: 0px; border-color:#ffcdd2;">
							<td colspan="2" style="text-align:right;"><b>TOTAL CALORIES: </b></td>
							<td class="teal-text text-lighten-1"><b>1,500 Calories</b></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="divider"></div>
		<div class = "section">
			<div class="row" style="margin:20px;">
				<div class="col s10">
					<h4 style="margin-top:0px;">Tea Time</h4>
					<p class="grey-text text-darken-1">Just chillin'</p>
				</div>
				<div>
					<a style="margin-top:5px; margin-right:5px; z-index:-1;" class="btn-floating btn-medium waves-effect waves-light teal"><i class="material-icons">mode_edit</i></a>
					<a style="margin-top:5px; z-index:-1;" class="btn-floating btn-medium waves-effect waves-light red"><i class="material-icons">delete</i></a>
				</div>
			</div>
			<div class="row">
				<table class="centered bordered card-panel" style="width:95%; margin: 0 auto;">
					<thead>
						<tr>
							<th>No. of Servings</th>
							<th>Name of Food</th>
							<th>Calories</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td><a class="red-text text-accent-2" href="#">Green Tea</a></td>
							<td>50 Calories</td>
						</tr>
						<tr>
							<td>3</td>
							<td><a class="red-text text-accent-2" href="#">Wheat Bread (Slice)</a></td>
							<td>150 Calories</td>
						</tr>
						<tr>
							<td>1</td>
							<td><a class="red-text text-accent-2" href="#">Omelette</a></td>
							<td>120 Calories</td>
						</tr>
						<tr>
							<td>1</td>
							<td><a class="red-text text-accent-2" href="#">Yogurt</a></td>
							<td>100 Calories</td>
						</tr>
						<tr style="border-top: thin double; border-bottom: 0px; border-color:#ffcdd2;">
							<td colspan="2" style="text-align:right;"><b>TOTAL CALORIES: </b></td>
							<td class="teal-text text-lighten-1"><b>420 Calories</b></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		
	</div>
	<div class="fixed col s3">
		<div class="input-field" style="position:fixed; width:21%;">
			<i class="material-icons prefix" style="margin-left:12px; margin-top:10px;">search</i>
		    <input id="search" type="text" class="validate">
		    <label for="search">Search</label>
         </div>
	     <div  class="card-panel" style="position:fixed; margin-top: 90px; width:23%;">
	     	<p style="text-align:center; font-size:24px; margin-bottom:0px; margin-top:6px;">TOTAL CALORIES</p>
	     	<p style="text-align:center; margin-top:1px;">for the day</p>
	     	<p  class="teal-text text-darken 4" style="text-align:center; font-size:72px; margin-bottom:0px; margin-top:-14px;"><b>1,920</b></p>
	     	<p style="text-align:center; font-size:24px; margin-top:-14px;">Calories</p>
	     	<div class="divider"></div>
	     	<center><a class="waves-effect waves-teal btn-flat red-text text-accent-1">Monthly View</a>
	     	<a class="waves-effect waves-light btn">Add a Meal</a></center>
	     </div>
	</div>
</div>

<%-- Put JS Scripts ../css is not required --%>

<jsp:include page="/layout-footer.jsp" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<sheetsstyler>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${base_url}css/lib/materialize.min.css" />
<link rel="stylesheet" type="text/css"
	href="${base_url}css/lib/global.css" />
</sheetsstyler>
</head>
<body class="pushable item hide" ng-app="Calowrie">
	<div class="hidden" id="session_data">
		<c:out value="${sessionScope.user.id}" index-val="id"></c:out>
		<c:out value="${sessionScope.user.first_name}" index-val="first_name"></c:out>
		<c:out value="${sessionScope.user.last_name}" index-val="last_name"></c:out>
		<c:out value="${sessionScope.user.username}" index-val="user_name"></c:out>
	</div>
	<jsp:include page="sidebar.jsp" />
	<!--<div class="ui inverted green basic big launch right attached fixed toggle button">
	    <i class="content icon"></i>
	    <span class="text">Dashboard</span>
  	</div> -->
	<main class=" main-content pusher">
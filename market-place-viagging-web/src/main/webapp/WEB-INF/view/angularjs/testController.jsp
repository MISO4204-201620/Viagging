<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>

<html>
<title>
     AngularJS by Google and HTML5 with Java Spring MVC Framework
    </title>
    
    <head>
<spring:url value="/resources/css/bootstrap.css" var="bootstrap" />
<spring:url value="/resources/css/starter-template.css" var="startertemplate" />

<link href="${bootstrap}" rel="stylesheet" />
<link href="${startertemplate}" rel="stylesheet"/>

<spring:url value="/resources/js/jquery-2.1.4.min.js" var="jqueryjs" />
<script src="${jqueryjs}" type="text/javascript"></script>

<spring:url value="/resources/js/bootstrap.min.js" var="js" />
<script src="${js}"></script>

<!-- AngularJS min production framework -->
  <spring:url value="/resources/angularjs/angular.min.js" var="angularjs" />
<script src="${angularjs}"></script>


<!-- AngularJS min production routing framework -->
  <spring:url value="/resources/angularjs/angular-route.min.js" var="angularroute" />
<script src="${angularroute}"></script>

<!-- AngularJS min production resource -->
  <spring:url value="/resources/angularjs/angular-resource.min.js" var="angularresource" />
<script src="${angularresource}"></script>

<spring:url value="/resources/angularjs/controllers/testController.js" var="angularresource2" />
<script src="${angularresource2}"></script>

</head>


    <body>	
    <figure style="text-align: left">
  <img style="border-radius: 15px;" width="200" src="${pageContext.request.contextPath}/resources/images/AngularJS.png">      <figcaption><br/><b><a href="${about}">Promo</a></b></figcaption>
     </figure>	
    <div ng-app="sampleapp" ng-controller="samplecontroller">

    
    <input ng-model="name"></input>
    <input ng-model="lastName"></input>
    <button ng-click="test()">Click Me!</button>
</div>

</body>
</html>
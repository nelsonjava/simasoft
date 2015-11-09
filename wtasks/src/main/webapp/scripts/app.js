'use strict';

angular.module('tasks',['ngRoute','ngResource'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/',{templateUrl:'views/landing.html',controller:'LandingPageController'})
      .when('/Activities',{templateUrl:'views/Activities/search.html',controller:'SearchActivitiesController'})
      .when('/Activities/new',{templateUrl:'views/Activities/detail.html',controller:'NewActivitiesController'})
      .when('/Activities/edit/:ActivitiesId',{templateUrl:'views/Activities/detail.html',controller:'EditActivitiesController'})
      .when('/ActivitiesTypes',{templateUrl:'views/ActivitiesTypes/search.html',controller:'SearchActivitiesTypesController'})
      .when('/ActivitiesTypes/new',{templateUrl:'views/ActivitiesTypes/detail.html',controller:'NewActivitiesTypesController'})
      .when('/ActivitiesTypes/edit/:ActivitiesTypesId',{templateUrl:'views/ActivitiesTypes/detail.html',controller:'EditActivitiesTypesController'})
      .when('/Calendars',{templateUrl:'views/Calendars/search.html',controller:'SearchCalendarsController'})
      .when('/Calendars/new',{templateUrl:'views/Calendars/detail.html',controller:'NewCalendarsController'})
      .when('/Calendars/edit/:CalendarsId',{templateUrl:'views/Calendars/detail.html',controller:'EditCalendarsController'})
      .when('/Guides',{templateUrl:'views/Guides/search.html',controller:'SearchGuidesController'})
      .when('/Guides/new',{templateUrl:'views/Guides/detail.html',controller:'NewGuidesController'})
      .when('/Guides/edit/:GuidesId',{templateUrl:'views/Guides/detail.html',controller:'EditGuidesController'})
      .when('/Persons',{templateUrl:'views/Persons/search.html',controller:'SearchPersonsController'})
      .when('/Persons/new',{templateUrl:'views/Persons/detail.html',controller:'NewPersonsController'})
      .when('/Persons/edit/:PersonsId',{templateUrl:'views/Persons/detail.html',controller:'EditPersonsController'})
      .when('/Sections',{templateUrl:'views/Sections/search.html',controller:'SearchSectionsController'})
      .when('/Sections/new',{templateUrl:'views/Sections/detail.html',controller:'NewSectionsController'})
      .when('/Sections/edit/:SectionsId',{templateUrl:'views/Sections/detail.html',controller:'EditSectionsController'})
      .when('/Sites',{templateUrl:'views/Sites/search.html',controller:'SearchSitesController'})
      .when('/Sites/new',{templateUrl:'views/Sites/detail.html',controller:'NewSitesController'})
      .when('/Sites/edit/:SitesId',{templateUrl:'views/Sites/detail.html',controller:'EditSitesController'})
      .when('/SitesTypes',{templateUrl:'views/SitesTypes/search.html',controller:'SearchSitesTypesController'})
      .when('/SitesTypes/new',{templateUrl:'views/SitesTypes/detail.html',controller:'NewSitesTypesController'})
      .when('/SitesTypes/edit/:SitesTypesId',{templateUrl:'views/SitesTypes/detail.html',controller:'EditSitesTypesController'})
      .when('/Tasks',{templateUrl:'views/Tasks/search.html',controller:'SearchTasksController'})
      .when('/Tasks/new',{templateUrl:'views/Tasks/detail.html',controller:'NewTasksController'})
      .when('/Tasks/edit/:TasksId',{templateUrl:'views/Tasks/detail.html',controller:'EditTasksController'})
      .otherwise({
        redirectTo: '/'
      });
  }])
  .controller('LandingPageController', function LandingPageController() {
  })
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  });

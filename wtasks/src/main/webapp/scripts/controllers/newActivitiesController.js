
angular.module('tasks').controller('NewActivitiesController', function ($scope, $location, locationParser, flash, ActivitiesResource , PersonsResource, TasksResource, SectionsResource, CalendarsResource, ActivitiesResource, SitesResource, ActivitiesTypesResource, GuidesResource, ActivitiesResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.activities = $scope.activities || {};
    
    $scope.personsList = PersonsResource.queryAll(function(items){
        $scope.personsSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("personsSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.activities.persons = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.activities.persons.push(collectionItem);
            });
        }
    });

    $scope.tasksList = TasksResource.queryAll(function(items){
        $scope.tasksSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("tasksSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.activities.tasks = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.activities.tasks.push(collectionItem);
            });
        }
    });

    $scope.sectionsList = SectionsResource.queryAll(function(items){
        $scope.sectionsSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("sectionsSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.activities.sections = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.activities.sections.push(collectionItem);
            });
        }
    });

    $scope.calendarsList = CalendarsResource.queryAll(function(items){
        $scope.calendarsSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("calendarsSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.activities.calendars = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.activities.calendars.push(collectionItem);
            });
        }
    });

    $scope.objHijosList = ActivitiesResource.queryAll(function(items){
        $scope.objHijosSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("objHijosSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.activities.objHijos = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.activities.objHijos.push(collectionItem);
            });
        }
    });

    $scope.sitesList = SitesResource.queryAll(function(items){
        $scope.sitesSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("sitesSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.activities.sites = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.activities.sites.push(collectionItem);
            });
        }
    });

    $scope.activitiesTypesList = ActivitiesTypesResource.queryAll(function(items){
        $scope.activitiesTypesSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("activitiesTypesSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.activities.activitiesTypes = {};
            $scope.activities.activitiesTypes.id = selection.value;
        }
    });
    
    $scope.guidesList = GuidesResource.queryAll(function(items){
        $scope.guidesSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("guidesSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.activities.guides = {};
            $scope.activities.guides.id = selection.value;
        }
    });
    
    $scope.objPadreList = ActivitiesResource.queryAll(function(items){
        $scope.objPadreSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("objPadreSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.activities.objPadre = {};
            $scope.activities.objPadre.id = selection.value;
        }
    });
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The activities was created successfully.'});
            $location.path('/Activities');
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        ActivitiesResource.save($scope.activities, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Activities");
    };
});
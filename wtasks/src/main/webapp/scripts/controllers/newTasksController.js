
angular.module('tasks').controller('NewTasksController', function ($scope, $location, locationParser, flash, TasksResource , PersonsResource, SitesResource, ActivitiesResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.tasks = $scope.tasks || {};
    
    $scope.personsList = PersonsResource.queryAll(function(items){
        $scope.personsSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("personsSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.tasks.persons = {};
            $scope.tasks.persons.id = selection.value;
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
            $scope.tasks.sites = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.tasks.sites.push(collectionItem);
            });
        }
    });

    $scope.activitiesList = ActivitiesResource.queryAll(function(items){
        $scope.activitiesSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("activitiesSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.tasks.activities = {};
            $scope.tasks.activities.id = selection.value;
        }
    });
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The tasks was created successfully.'});
            $location.path('/Tasks');
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        TasksResource.save($scope.tasks, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Tasks");
    };
});
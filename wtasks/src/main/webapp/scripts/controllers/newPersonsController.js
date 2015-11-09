
angular.module('tasks').controller('NewPersonsController', function ($scope, $location, locationParser, flash, PersonsResource , SectionsResource, TasksResource, ActivitiesResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.persons = $scope.persons || {};
    
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
            $scope.persons.sections = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.persons.sections.push(collectionItem);
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
            $scope.persons.tasks = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.persons.tasks.push(collectionItem);
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
        if (typeof selection != 'undefined') {
            $scope.persons.activities = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.persons.activities.push(collectionItem);
            });
        }
    });


    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The persons was created successfully.'});
            $location.path('/Persons');
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        PersonsResource.save($scope.persons, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Persons");
    };
});
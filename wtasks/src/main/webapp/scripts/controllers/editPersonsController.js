

angular.module('tasks').controller('EditPersonsController', function($scope, $routeParams, $location, flash, PersonsResource , SectionsResource, TasksResource, ActivitiesResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.persons = new PersonsResource(self.original);
            SectionsResource.queryAll(function(items) {
                $scope.sectionsSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.persons.sections){
                        $.each($scope.persons.sections, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.sectionsSelection.push(labelObject);
                                $scope.persons.sections.push(wrappedObject);
                            }
                        });
                        self.original.sections = $scope.persons.sections;
                    }
                    return labelObject;
                });
            });
            TasksResource.queryAll(function(items) {
                $scope.tasksSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.persons.tasks){
                        $.each($scope.persons.tasks, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.tasksSelection.push(labelObject);
                                $scope.persons.tasks.push(wrappedObject);
                            }
                        });
                        self.original.tasks = $scope.persons.tasks;
                    }
                    return labelObject;
                });
            });
            ActivitiesResource.queryAll(function(items) {
                $scope.activitiesSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.persons.activities){
                        $.each($scope.persons.activities, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.activitiesSelection.push(labelObject);
                                $scope.persons.activities.push(wrappedObject);
                            }
                        });
                        self.original.activities = $scope.persons.activities;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The persons could not be found.'});
            $location.path("/Persons");
        };
        PersonsResource.get({PersonsId:$routeParams.PersonsId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.persons);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The persons was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.persons.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Persons");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The persons was deleted.'});
            $location.path("/Persons");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.persons.$remove(successCallback, errorCallback);
    };
    
    $scope.sectionsSelection = $scope.sectionsSelection || [];
    $scope.$watch("sectionsSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.persons) {
            $scope.persons.sections = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.persons.sections.push(collectionItem);
            });
        }
    });
    $scope.tasksSelection = $scope.tasksSelection || [];
    $scope.$watch("tasksSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.persons) {
            $scope.persons.tasks = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.persons.tasks.push(collectionItem);
            });
        }
    });
    $scope.activitiesSelection = $scope.activitiesSelection || [];
    $scope.$watch("activitiesSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.persons) {
            $scope.persons.activities = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.persons.activities.push(collectionItem);
            });
        }
    });
    
    $scope.get();
});


angular.module('tasks').controller('EditTasksController', function($scope, $routeParams, $location, flash, TasksResource , PersonsResource, SitesResource, ActivitiesResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.tasks = new TasksResource(self.original);
            PersonsResource.queryAll(function(items) {
                $scope.personsSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.tasks.persons && item.id == $scope.tasks.persons.id) {
                        $scope.personsSelection = labelObject;
                        $scope.tasks.persons = wrappedObject;
                        self.original.persons = $scope.tasks.persons;
                    }
                    return labelObject;
                });
            });
            SitesResource.queryAll(function(items) {
                $scope.sitesSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.tasks.sites){
                        $.each($scope.tasks.sites, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.sitesSelection.push(labelObject);
                                $scope.tasks.sites.push(wrappedObject);
                            }
                        });
                        self.original.sites = $scope.tasks.sites;
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
                    if($scope.tasks.activities && item.id == $scope.tasks.activities.id) {
                        $scope.activitiesSelection = labelObject;
                        $scope.tasks.activities = wrappedObject;
                        self.original.activities = $scope.tasks.activities;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The tasks could not be found.'});
            $location.path("/Tasks");
        };
        TasksResource.get({TasksId:$routeParams.TasksId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.tasks);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The tasks was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.tasks.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Tasks");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The tasks was deleted.'});
            $location.path("/Tasks");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.tasks.$remove(successCallback, errorCallback);
    };
    
    $scope.$watch("personsSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.tasks.persons = {};
            $scope.tasks.persons.id = selection.value;
        }
    });
    $scope.sitesSelection = $scope.sitesSelection || [];
    $scope.$watch("sitesSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.tasks) {
            $scope.tasks.sites = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.tasks.sites.push(collectionItem);
            });
        }
    });
    $scope.$watch("activitiesSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.tasks.activities = {};
            $scope.tasks.activities.id = selection.value;
        }
    });
    
    $scope.get();
});
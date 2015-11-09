

angular.module('tasks').controller('EditActivitiesTypesController', function($scope, $routeParams, $location, flash, ActivitiesTypesResource , ActivitiesResource, SitesResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.activitiesTypes = new ActivitiesTypesResource(self.original);
            ActivitiesResource.queryAll(function(items) {
                $scope.activitiesSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.activitiesTypes.activities){
                        $.each($scope.activitiesTypes.activities, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.activitiesSelection.push(labelObject);
                                $scope.activitiesTypes.activities.push(wrappedObject);
                            }
                        });
                        self.original.activities = $scope.activitiesTypes.activities;
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
                    if($scope.activitiesTypes.sites){
                        $.each($scope.activitiesTypes.sites, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.sitesSelection.push(labelObject);
                                $scope.activitiesTypes.sites.push(wrappedObject);
                            }
                        });
                        self.original.sites = $scope.activitiesTypes.sites;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The activitiesTypes could not be found.'});
            $location.path("/ActivitiesTypes");
        };
        ActivitiesTypesResource.get({ActivitiesTypesId:$routeParams.ActivitiesTypesId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.activitiesTypes);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The activitiesTypes was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.activitiesTypes.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/ActivitiesTypes");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The activitiesTypes was deleted.'});
            $location.path("/ActivitiesTypes");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.activitiesTypes.$remove(successCallback, errorCallback);
    };
    
    $scope.activitiesSelection = $scope.activitiesSelection || [];
    $scope.$watch("activitiesSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.activitiesTypes) {
            $scope.activitiesTypes.activities = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.activitiesTypes.activities.push(collectionItem);
            });
        }
    });
    $scope.sitesSelection = $scope.sitesSelection || [];
    $scope.$watch("sitesSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.activitiesTypes) {
            $scope.activitiesTypes.sites = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.activitiesTypes.sites.push(collectionItem);
            });
        }
    });
    
    $scope.get();
});
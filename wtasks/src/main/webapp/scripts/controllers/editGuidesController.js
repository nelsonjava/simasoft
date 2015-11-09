

angular.module('tasks').controller('EditGuidesController', function($scope, $routeParams, $location, flash, GuidesResource , ActivitiesResource, SitesResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.guides = new GuidesResource(self.original);
            ActivitiesResource.queryAll(function(items) {
                $scope.activitiesSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.guides.activities){
                        $.each($scope.guides.activities, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.activitiesSelection.push(labelObject);
                                $scope.guides.activities.push(wrappedObject);
                            }
                        });
                        self.original.activities = $scope.guides.activities;
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
                    if($scope.guides.sites){
                        $.each($scope.guides.sites, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.sitesSelection.push(labelObject);
                                $scope.guides.sites.push(wrappedObject);
                            }
                        });
                        self.original.sites = $scope.guides.sites;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The guides could not be found.'});
            $location.path("/Guides");
        };
        GuidesResource.get({GuidesId:$routeParams.GuidesId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.guides);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The guides was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.guides.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Guides");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The guides was deleted.'});
            $location.path("/Guides");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.guides.$remove(successCallback, errorCallback);
    };
    
    $scope.activitiesSelection = $scope.activitiesSelection || [];
    $scope.$watch("activitiesSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.guides) {
            $scope.guides.activities = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.guides.activities.push(collectionItem);
            });
        }
    });
    $scope.sitesSelection = $scope.sitesSelection || [];
    $scope.$watch("sitesSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.guides) {
            $scope.guides.sites = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.guides.sites.push(collectionItem);
            });
        }
    });
    
    $scope.get();
});
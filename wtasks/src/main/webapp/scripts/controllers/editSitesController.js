

angular.module('tasks').controller('EditSitesController', function($scope, $routeParams, $location, flash, SitesResource , TasksResource, GuidesResource, SitesTypesResource, ActivitiesResource, ActivitiesTypesResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.sites = new SitesResource(self.original);
            TasksResource.queryAll(function(items) {
                $scope.tasksSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.sites.tasks){
                        $.each($scope.sites.tasks, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.tasksSelection.push(labelObject);
                                $scope.sites.tasks.push(wrappedObject);
                            }
                        });
                        self.original.tasks = $scope.sites.tasks;
                    }
                    return labelObject;
                });
            });
            GuidesResource.queryAll(function(items) {
                $scope.guidesSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.sites.guides){
                        $.each($scope.sites.guides, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.guidesSelection.push(labelObject);
                                $scope.sites.guides.push(wrappedObject);
                            }
                        });
                        self.original.guides = $scope.sites.guides;
                    }
                    return labelObject;
                });
            });
            SitesTypesResource.queryAll(function(items) {
                $scope.sitesTypesSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.sites.sitesTypes){
                        $.each($scope.sites.sitesTypes, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.sitesTypesSelection.push(labelObject);
                                $scope.sites.sitesTypes.push(wrappedObject);
                            }
                        });
                        self.original.sitesTypes = $scope.sites.sitesTypes;
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
                    if($scope.sites.activities){
                        $.each($scope.sites.activities, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.activitiesSelection.push(labelObject);
                                $scope.sites.activities.push(wrappedObject);
                            }
                        });
                        self.original.activities = $scope.sites.activities;
                    }
                    return labelObject;
                });
            });
            ActivitiesTypesResource.queryAll(function(items) {
                $scope.activitiesTypesSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.sites.activitiesTypes){
                        $.each($scope.sites.activitiesTypes, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.activitiesTypesSelection.push(labelObject);
                                $scope.sites.activitiesTypes.push(wrappedObject);
                            }
                        });
                        self.original.activitiesTypes = $scope.sites.activitiesTypes;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The sites could not be found.'});
            $location.path("/Sites");
        };
        SitesResource.get({SitesId:$routeParams.SitesId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.sites);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The sites was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.sites.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Sites");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The sites was deleted.'});
            $location.path("/Sites");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.sites.$remove(successCallback, errorCallback);
    };
    
    $scope.tasksSelection = $scope.tasksSelection || [];
    $scope.$watch("tasksSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.sites) {
            $scope.sites.tasks = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.sites.tasks.push(collectionItem);
            });
        }
    });
    $scope.guidesSelection = $scope.guidesSelection || [];
    $scope.$watch("guidesSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.sites) {
            $scope.sites.guides = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.sites.guides.push(collectionItem);
            });
        }
    });
    $scope.sitesTypesSelection = $scope.sitesTypesSelection || [];
    $scope.$watch("sitesTypesSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.sites) {
            $scope.sites.sitesTypes = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.sites.sitesTypes.push(collectionItem);
            });
        }
    });
    $scope.activitiesSelection = $scope.activitiesSelection || [];
    $scope.$watch("activitiesSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.sites) {
            $scope.sites.activities = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.sites.activities.push(collectionItem);
            });
        }
    });
    $scope.activitiesTypesSelection = $scope.activitiesTypesSelection || [];
    $scope.$watch("activitiesTypesSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.sites) {
            $scope.sites.activitiesTypes = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.sites.activitiesTypes.push(collectionItem);
            });
        }
    });
    
    $scope.get();
});
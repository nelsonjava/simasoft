

angular.module('tasks').controller('EditSitesTypesController', function($scope, $routeParams, $location, flash, SitesTypesResource , SitesTypesResource, SitesResource, SitesTypesResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.sitesTypes = new SitesTypesResource(self.original);
            SitesTypesResource.queryAll(function(items) {
                $scope.objHijosSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.sitesTypes.objHijos){
                        $.each($scope.sitesTypes.objHijos, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.objHijosSelection.push(labelObject);
                                $scope.sitesTypes.objHijos.push(wrappedObject);
                            }
                        });
                        self.original.objHijos = $scope.sitesTypes.objHijos;
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
                    if($scope.sitesTypes.sites){
                        $.each($scope.sitesTypes.sites, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.sitesSelection.push(labelObject);
                                $scope.sitesTypes.sites.push(wrappedObject);
                            }
                        });
                        self.original.sites = $scope.sitesTypes.sites;
                    }
                    return labelObject;
                });
            });
            SitesTypesResource.queryAll(function(items) {
                $scope.objPadreSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.sitesTypes.objPadre && item.id == $scope.sitesTypes.objPadre.id) {
                        $scope.objPadreSelection = labelObject;
                        $scope.sitesTypes.objPadre = wrappedObject;
                        self.original.objPadre = $scope.sitesTypes.objPadre;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The sitesTypes could not be found.'});
            $location.path("/SitesTypes");
        };
        SitesTypesResource.get({SitesTypesId:$routeParams.SitesTypesId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.sitesTypes);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The sitesTypes was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.sitesTypes.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/SitesTypes");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The sitesTypes was deleted.'});
            $location.path("/SitesTypes");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.sitesTypes.$remove(successCallback, errorCallback);
    };
    
    $scope.objHijosSelection = $scope.objHijosSelection || [];
    $scope.$watch("objHijosSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.sitesTypes) {
            $scope.sitesTypes.objHijos = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.sitesTypes.objHijos.push(collectionItem);
            });
        }
    });
    $scope.sitesSelection = $scope.sitesSelection || [];
    $scope.$watch("sitesSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.sitesTypes) {
            $scope.sitesTypes.sites = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.sitesTypes.sites.push(collectionItem);
            });
        }
    });
    $scope.$watch("objPadreSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.sitesTypes.objPadre = {};
            $scope.sitesTypes.objPadre.id = selection.value;
        }
    });
    
    $scope.get();
});
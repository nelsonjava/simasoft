
angular.module('tasks').controller('NewSitesTypesController', function ($scope, $location, locationParser, flash, SitesTypesResource , SitesTypesResource, SitesResource, SitesTypesResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.sitesTypes = $scope.sitesTypes || {};
    
    $scope.objHijosList = SitesTypesResource.queryAll(function(items){
        $scope.objHijosSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("objHijosSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.sitesTypes.objHijos = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.sitesTypes.objHijos.push(collectionItem);
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
            $scope.sitesTypes.sites = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.sitesTypes.sites.push(collectionItem);
            });
        }
    });

    $scope.objPadreList = SitesTypesResource.queryAll(function(items){
        $scope.objPadreSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("objPadreSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.sitesTypes.objPadre = {};
            $scope.sitesTypes.objPadre.id = selection.value;
        }
    });
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The sitesTypes was created successfully.'});
            $location.path('/SitesTypes');
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        SitesTypesResource.save($scope.sitesTypes, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/SitesTypes");
    };
});
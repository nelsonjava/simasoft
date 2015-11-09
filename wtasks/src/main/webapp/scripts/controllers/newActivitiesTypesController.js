
angular.module('tasks').controller('NewActivitiesTypesController', function ($scope, $location, locationParser, flash, ActivitiesTypesResource , ActivitiesResource, SitesResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.activitiesTypes = $scope.activitiesTypes || {};
    
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
            $scope.activitiesTypes.activities = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.activitiesTypes.activities.push(collectionItem);
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
            $scope.activitiesTypes.sites = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.activitiesTypes.sites.push(collectionItem);
            });
        }
    });


    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The activitiesTypes was created successfully.'});
            $location.path('/ActivitiesTypes');
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        ActivitiesTypesResource.save($scope.activitiesTypes, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/ActivitiesTypes");
    };
});
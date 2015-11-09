
angular.module('tasks').controller('NewGuidesController', function ($scope, $location, locationParser, flash, GuidesResource , ActivitiesResource, SitesResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.guides = $scope.guides || {};
    
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
            $scope.guides.activities = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.guides.activities.push(collectionItem);
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
            $scope.guides.sites = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.guides.sites.push(collectionItem);
            });
        }
    });


    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The guides was created successfully.'});
            $location.path('/Guides');
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        GuidesResource.save($scope.guides, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Guides");
    };
});
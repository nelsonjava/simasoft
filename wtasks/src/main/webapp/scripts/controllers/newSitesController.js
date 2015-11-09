
angular.module('tasks').controller('NewSitesController', function ($scope, $location, locationParser, flash, SitesResource , TasksResource, GuidesResource, SitesTypesResource, ActivitiesResource, ActivitiesTypesResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.sites = $scope.sites || {};
    
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
            $scope.sites.tasks = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.sites.tasks.push(collectionItem);
            });
        }
    });

    $scope.guidesList = GuidesResource.queryAll(function(items){
        $scope.guidesSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("guidesSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.sites.guides = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.sites.guides.push(collectionItem);
            });
        }
    });

    $scope.sitesTypesList = SitesTypesResource.queryAll(function(items){
        $scope.sitesTypesSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("sitesTypesSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.sites.sitesTypes = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.sites.sitesTypes.push(collectionItem);
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
            $scope.sites.activities = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.sites.activities.push(collectionItem);
            });
        }
    });

    $scope.activitiesTypesList = ActivitiesTypesResource.queryAll(function(items){
        $scope.activitiesTypesSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("activitiesTypesSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.sites.activitiesTypes = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.sites.activitiesTypes.push(collectionItem);
            });
        }
    });


    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The sites was created successfully.'});
            $location.path('/Sites');
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        SitesResource.save($scope.sites, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Sites");
    };
});
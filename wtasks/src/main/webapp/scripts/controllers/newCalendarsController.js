
angular.module('tasks').controller('NewCalendarsController', function ($scope, $location, locationParser, flash, CalendarsResource , ActivitiesResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.calendars = $scope.calendars || {};
    
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
            $scope.calendars.activities = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.calendars.activities.push(collectionItem);
            });
        }
    });


    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The calendars was created successfully.'});
            $location.path('/Calendars');
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        CalendarsResource.save($scope.calendars, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Calendars");
    };
});
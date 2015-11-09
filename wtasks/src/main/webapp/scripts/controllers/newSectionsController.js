
angular.module('tasks').controller('NewSectionsController', function ($scope, $location, locationParser, flash, SectionsResource , SectionsResource, PersonsResource, ActivitiesResource, SectionsResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.sections = $scope.sections || {};
    
    $scope.objHijosList = SectionsResource.queryAll(function(items){
        $scope.objHijosSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("objHijosSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.sections.objHijos = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.sections.objHijos.push(collectionItem);
            });
        }
    });

    $scope.personsList = PersonsResource.queryAll(function(items){
        $scope.personsSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("personsSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.sections.persons = {};
            $scope.sections.persons.id = selection.value;
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
            $scope.sections.activities = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.sections.activities.push(collectionItem);
            });
        }
    });

    $scope.objPadreList = SectionsResource.queryAll(function(items){
        $scope.objPadreSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.orden
            });
        });
    });
    $scope.$watch("objPadreSelection", function(selection) {
        if ( typeof selection != 'undefined') {
            $scope.sections.objPadre = {};
            $scope.sections.objPadre.id = selection.value;
        }
    });
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The sections was created successfully.'});
            $location.path('/Sections');
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        SectionsResource.save($scope.sections, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Sections");
    };
});
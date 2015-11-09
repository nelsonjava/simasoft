

angular.module('tasks').controller('EditSectionsController', function($scope, $routeParams, $location, flash, SectionsResource , SectionsResource, PersonsResource, ActivitiesResource, SectionsResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.sections = new SectionsResource(self.original);
            SectionsResource.queryAll(function(items) {
                $scope.objHijosSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.sections.objHijos){
                        $.each($scope.sections.objHijos, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.objHijosSelection.push(labelObject);
                                $scope.sections.objHijos.push(wrappedObject);
                            }
                        });
                        self.original.objHijos = $scope.sections.objHijos;
                    }
                    return labelObject;
                });
            });
            PersonsResource.queryAll(function(items) {
                $scope.personsSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.sections.persons && item.id == $scope.sections.persons.id) {
                        $scope.personsSelection = labelObject;
                        $scope.sections.persons = wrappedObject;
                        self.original.persons = $scope.sections.persons;
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
                    if($scope.sections.activities){
                        $.each($scope.sections.activities, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.activitiesSelection.push(labelObject);
                                $scope.sections.activities.push(wrappedObject);
                            }
                        });
                        self.original.activities = $scope.sections.activities;
                    }
                    return labelObject;
                });
            });
            SectionsResource.queryAll(function(items) {
                $scope.objPadreSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.sections.objPadre && item.id == $scope.sections.objPadre.id) {
                        $scope.objPadreSelection = labelObject;
                        $scope.sections.objPadre = wrappedObject;
                        self.original.objPadre = $scope.sections.objPadre;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The sections could not be found.'});
            $location.path("/Sections");
        };
        SectionsResource.get({SectionsId:$routeParams.SectionsId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.sections);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The sections was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.sections.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Sections");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The sections was deleted.'});
            $location.path("/Sections");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.sections.$remove(successCallback, errorCallback);
    };
    
    $scope.objHijosSelection = $scope.objHijosSelection || [];
    $scope.$watch("objHijosSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.sections) {
            $scope.sections.objHijos = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.sections.objHijos.push(collectionItem);
            });
        }
    });
    $scope.$watch("personsSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.sections.persons = {};
            $scope.sections.persons.id = selection.value;
        }
    });
    $scope.activitiesSelection = $scope.activitiesSelection || [];
    $scope.$watch("activitiesSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.sections) {
            $scope.sections.activities = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.sections.activities.push(collectionItem);
            });
        }
    });
    $scope.$watch("objPadreSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.sections.objPadre = {};
            $scope.sections.objPadre.id = selection.value;
        }
    });
    
    $scope.get();
});
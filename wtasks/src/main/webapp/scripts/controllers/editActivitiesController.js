

angular.module('tasks').controller('EditActivitiesController', function($scope, $routeParams, $location, flash, ActivitiesResource , PersonsResource, TasksResource, SectionsResource, CalendarsResource, ActivitiesResource, SitesResource, ActivitiesTypesResource, GuidesResource, ActivitiesResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;

    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.activities = new ActivitiesResource(self.original);
            PersonsResource.queryAll(function(items) {
                $scope.personsSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.activities.persons){
                        $.each($scope.activities.persons, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.personsSelection.push(labelObject);
                                $scope.activities.persons.push(wrappedObject);
                            }
                        });
                        self.original.persons = $scope.activities.persons;
                    }
                    return labelObject;
                });
            });
            TasksResource.queryAll(function(items) {
                $scope.tasksSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.activities.tasks){
                        $.each($scope.activities.tasks, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.tasksSelection.push(labelObject);
                                $scope.activities.tasks.push(wrappedObject);
                            }
                        });
                        self.original.tasks = $scope.activities.tasks;
                    }
                    return labelObject;
                });
            });
            SectionsResource.queryAll(function(items) {
                $scope.sectionsSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.activities.sections){
                        $.each($scope.activities.sections, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.sectionsSelection.push(labelObject);
                                $scope.activities.sections.push(wrappedObject);
                            }
                        });
                        self.original.sections = $scope.activities.sections;
                    }
                    return labelObject;
                });
            });
            CalendarsResource.queryAll(function(items) {
                $scope.calendarsSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.activities.calendars){
                        $.each($scope.activities.calendars, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.calendarsSelection.push(labelObject);
                                $scope.activities.calendars.push(wrappedObject);
                            }
                        });
                        self.original.calendars = $scope.activities.calendars;
                    }
                    return labelObject;
                });
            });
            ActivitiesResource.queryAll(function(items) {
                $scope.objHijosSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.activities.objHijos){
                        $.each($scope.activities.objHijos, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.objHijosSelection.push(labelObject);
                                $scope.activities.objHijos.push(wrappedObject);
                            }
                        });
                        self.original.objHijos = $scope.activities.objHijos;
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
                    if($scope.activities.sites){
                        $.each($scope.activities.sites, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.sitesSelection.push(labelObject);
                                $scope.activities.sites.push(wrappedObject);
                            }
                        });
                        self.original.sites = $scope.activities.sites;
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
                    if($scope.activities.activitiesTypes && item.id == $scope.activities.activitiesTypes.id) {
                        $scope.activitiesTypesSelection = labelObject;
                        $scope.activities.activitiesTypes = wrappedObject;
                        self.original.activitiesTypes = $scope.activities.activitiesTypes;
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
                    if($scope.activities.guides && item.id == $scope.activities.guides.id) {
                        $scope.guidesSelection = labelObject;
                        $scope.activities.guides = wrappedObject;
                        self.original.guides = $scope.activities.guides;
                    }
                    return labelObject;
                });
            });
            ActivitiesResource.queryAll(function(items) {
                $scope.objPadreSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.orden
                    };
                    if($scope.activities.objPadre && item.id == $scope.activities.objPadre.id) {
                        $scope.objPadreSelection = labelObject;
                        $scope.activities.objPadre = wrappedObject;
                        self.original.objPadre = $scope.activities.objPadre;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The activities could not be found.'});
            $location.path("/Activities");
        };
        ActivitiesResource.get({ActivitiesId:$routeParams.ActivitiesId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.activities);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The activities was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.activities.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Activities");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The activities was deleted.'});
            $location.path("/Activities");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.activities.$remove(successCallback, errorCallback);
    };

    $scope.personsSelection = $scope.personsSelection || [];
    $scope.$watch("personsSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.activities) {
            $scope.activities.persons = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.activities.persons.push(collectionItem);
            });
        }
    });
    $scope.tasksSelection = $scope.tasksSelection || [];
    $scope.$watch("tasksSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.activities) {
            $scope.activities.tasks = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.activities.tasks.push(collectionItem);
            });
        }
    });
    $scope.sectionsSelection = $scope.sectionsSelection || [];
    $scope.$watch("sectionsSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.activities) {
            $scope.activities.sections = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.activities.sections.push(collectionItem);
            });
        }
    });
    $scope.calendarsSelection = $scope.calendarsSelection || [];
    $scope.$watch("calendarsSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.activities) {
            $scope.activities.calendars = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.activities.calendars.push(collectionItem);
            });
        }
    });
    $scope.objHijosSelection = $scope.objHijosSelection || [];
    $scope.$watch("objHijosSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.activities) {
            $scope.activities.objHijos = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.activities.objHijos.push(collectionItem);
            });
        }
    });
    $scope.sitesSelection = $scope.sitesSelection || [];
    $scope.$watch("sitesSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.activities) {
            $scope.activities.sites = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.activities.sites.push(collectionItem);
            });
        }
    });
    $scope.$watch("activitiesTypesSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.activities.activitiesTypes = {};
            $scope.activities.activitiesTypes.id = selection.value;
        }
    });
    $scope.$watch("guidesSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.activities.guides = {};
            $scope.activities.guides.id = selection.value;
        }
    });
    $scope.$watch("objPadreSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.activities.objPadre = {};
            $scope.activities.objPadre.id = selection.value;
        }
    });
    
    $scope.get();
});
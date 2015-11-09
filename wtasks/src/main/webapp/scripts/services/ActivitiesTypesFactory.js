angular.module('tasks').factory('ActivitiesTypesResource', function($resource){
    var resource = $resource('rest/activitiestypes/:ActivitiesTypesId',{ActivitiesTypesId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});
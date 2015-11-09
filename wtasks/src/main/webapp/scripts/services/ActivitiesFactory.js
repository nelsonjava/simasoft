angular.module('tasks').factory('ActivitiesResource', function($resource){
    var resource = $resource('rest/activities/:ActivitiesId',{ActivitiesId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});
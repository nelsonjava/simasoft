angular.module('tasks').factory('SitesTypesResource', function($resource){
    var resource = $resource('rest/sitestypes/:SitesTypesId',{SitesTypesId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});
angular.module('tasks').factory('SectionsResource', function($resource){
    var resource = $resource('rest/sections/:SectionsId',{SectionsId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});
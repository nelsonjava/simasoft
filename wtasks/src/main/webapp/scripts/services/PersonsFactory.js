angular.module('tasks').factory('PersonsResource', function($resource){
    var resource = $resource('rest/persons/:PersonsId',{PersonsId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});
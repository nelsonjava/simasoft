angular.module('tasks').factory('TasksResource', function($resource){
    var resource = $resource('rest/tasks/:TasksId',{TasksId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});
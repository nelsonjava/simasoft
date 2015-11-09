angular.module('tasks').factory('GuidesResource', function($resource){
    var resource = $resource('rest/guides/:GuidesId',{GuidesId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});
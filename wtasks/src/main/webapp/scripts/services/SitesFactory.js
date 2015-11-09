angular.module('tasks').factory('SitesResource', function($resource){
    var resource = $resource('rest/sites/:SitesId',{SitesId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});
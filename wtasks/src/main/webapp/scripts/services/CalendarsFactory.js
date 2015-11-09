angular.module('tasks').factory('CalendarsResource', function($resource){
    var resource = $resource('rest/calendars/:CalendarsId',{CalendarsId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});
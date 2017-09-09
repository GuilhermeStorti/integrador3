//URL PADRÃO DO SERVER
angular.module("app").factory('defaultUrl', function($location) {
    return $location.protocol() + "://" + $location.host()
        + ":" + $location.port() + "/integrador3";
});
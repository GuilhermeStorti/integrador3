//URL PADRÃO DO SERVER
angular.module("app").factory('defaultUrl', function($location) {

    var _getServerUrl = function () {
        return $location.protocol() + "://" + $location.host()
            + ":" + $location.port() + "/integrador3";
    };

    var _getCepUrl = function (cep) {
        return "https://viacep.com.br/ws/" + cep + "/json/";
    };

    return {
        getServerUrl: _getServerUrl,
        getCepUrl: _getCepUrl
    };

});
angular.module("app").factory("contribuinteService", function ($http, defaultUrl) {
    var _getContribuintes = function () {
        return $http.get(defaultUrl.getServerUrl() + "/contribuinte");
    };

    var _saveContribuinte = function (contribuinte) {
        return $http.post(defaultUrl.getServerUrl() + "/contribuinte", contribuinte);
    };

    var _updateContribuinte = function (contribuinte) {
        return $http.put(defaultUrl.getServerUrl() + "/contribuinte" + "/" + contribuinte.id, contribuinte);
    };

    var _getCep = function (cep) {
        return $http.get(defaultUrl.getCepUrl(cep));
    };

    return {
        getContribuintes: _getContribuintes,
        saveContribuinte: _saveContribuinte,
        updateContribuinte: _updateContribuinte,
        getCep: _getCep
    };
});
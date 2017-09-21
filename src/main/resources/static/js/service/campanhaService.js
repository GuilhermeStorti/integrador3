angular.module("app").factory("campanhaService", function ($http, defaultUrl) {
    var _getCampanhas = function () {
        return $http.get(defaultUrl.getServerUrl() + "/campanha");
    };

    var _saveCampanha = function (campanha) {
        return $http.post(defaultUrl.getServerUrl() + "/campanha", campanha);
    };

    var _updateCampanha = function (campanha) {
        return $http.put(defaultUrl.getServerUrl() + "/campanha" + "/" + campanha.id, campanha);
    };

    return {
        getCampanhas: _getCampanhas,
        saveCampanha: _saveCampanha,
        updateCampanha: _updateCampanha
    };
});
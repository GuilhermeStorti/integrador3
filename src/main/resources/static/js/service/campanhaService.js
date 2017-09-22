angular.module("app").factory("campanhaService", function ($http, defaultUrl) {
    var _getCampanhas = function () {
        return $http.get(defaultUrl.getServerUrl() + "/campanha");
    };

    var _findByDescricao = function (descricao) {
        return $http.get(defaultUrl.getServerUrl() + "/campanha/filtroDescricao/" + descricao);
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
        updateCampanha: _updateCampanha,
        findByDescricao: _findByDescricao
    };
});
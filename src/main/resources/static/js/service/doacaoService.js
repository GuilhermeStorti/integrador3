angular.module("app").factory("doacaoService", function ($http, defaultUrl) {
    var _getDoacoes = function () {
        return $http.get(defaultUrl.getServerUrl() + "/doacao");
    };

    var _saveDoacao = function (doacao) {
        return $http.post(defaultUrl.getServerUrl() + "/doacao", doacao);
    };

    var _updateDoacao = function (doacao) {
        return $http.put(defaultUrl.getServerUrl() + "/doacao" + "/" + doacao.numeroRecibo, doacao);
    };

    return {
        getDoacoes: _getDoacoes,
        saveDoacao: _saveDoacao,
        updateDoacao: _updateDoacao
    };
});
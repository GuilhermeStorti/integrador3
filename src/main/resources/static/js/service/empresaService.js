angular.module("app").factory("empresaService", function ($http, defaultUrl) {
    var _getEmpresas = function () {
        return $http.get(defaultUrl.getServerUrl() + "/empresa");
    };

    var _saveEmpresa = function (empresa) {
        return $http.post(defaultUrl.getServerUrl() + "/empresa", empresa);
    };

    var _updateEmpresa = function (empresa) {
        return $http.put(defaultUrl.getServerUrl() + "/empresa" + "/" + empresa.id, empresa);
    };

    var _getCep = function (cep) {
        return $http.get(defaultUrl.getCepUrl(cep));
    };

    return {
        getEmpresas: _getEmpresas,
        saveEmpresa: _saveEmpresa,
        updateEmpresa: _updateEmpresa,
        getCep: _getCep
    };
});
angular.module("app").factory("funcionarioService", function ($http, defaultUrl) {
    var _getFuncionarios = function () {
        return $http.get(defaultUrl.getServerUrl() + "/funcionario");
    };

    var _saveFuncionario = function (funcionario) {
        return $http.post(defaultUrl.getServerUrl() + "/funcionario", funcionario);
    };

    var _updateFuncionario = function (funcionario) {
        return $http.put(defaultUrl.getServerUrl() + "/funcionario" + "/" + funcionario.id, funcionario);
    };

    var _getCep = function (cep) {
        return $http.get("https://viacep.com.br/ws/" + cep + "/json/");
    };

    var _findAtualMotoboy = function () {
        return $http.get(defaultUrl.getServerUrl() + "/funcionario/findAtualMotoboy");
    };

    return {
        getFuncionarios: _getFuncionarios,
        saveFuncionario: _saveFuncionario,
        updateFuncionario: _updateFuncionario,
        getCep: _getCep,
        findAtualMotoboy: _findAtualMotoboy
    };
});
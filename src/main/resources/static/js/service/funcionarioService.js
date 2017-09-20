angular.module("app").factory("funcionarioService", function ($http, defaultUrl) {
    var _getFuncionarios = function () {
        return $http.get(defaultUrl + "/funcionario");
    };

    var _saveFuncionario = function (funcionario) {
        return $http.post(defaultUrl + "/funcionario", funcionario);
    };

    var _updateFuncionario = function (funcionario) {
        return $http.put(defaultUrl + "/funcionario" + "/" + funcionario.id, funcionario);
    };

    var _getCep = function (cep) {
        return $http.get("https://viacep.com.br/ws/" + cep + "/json/");
    };


    return {
        getFuncionarios: _getFuncionarios,
        saveFuncionario: _saveFuncionario,
        updateFuncionario: _updateFuncionario,
        getCep: _getCep
    };
});
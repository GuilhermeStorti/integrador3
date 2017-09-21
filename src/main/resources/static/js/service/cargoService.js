angular.module("app").factory("cargoService", function ($http, defaultUrl) {
    var _getCargos = function () {
        return $http.get(defaultUrl.getServerUrl() + "/cargo");
    };

    var _saveCargo = function (cargo) {
        return $http.post(defaultUrl.getServerUrl() + "/cargo", cargo);
    };

    var _updateCargo = function (cargo) {
        return $http.put(defaultUrl.getServerUrl() + "/cargo" + "/" + cargo.id, cargo);
    };

    var _deleteCargo = function (id) {
        return $http.delete(defaultUrl.getServerUrl() + "/cargo" + "/" + id);
    };

    return {
        getCargos: _getCargos,
        saveCargo: _saveCargo,
        updateCargo: _updateCargo,
        deleteCargo: _deleteCargo
    };
});
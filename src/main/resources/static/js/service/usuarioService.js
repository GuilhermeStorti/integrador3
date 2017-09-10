angular.module("app").factory("usuarioService", function ($http, defaultUrl) {
    var _getUsuarios = function () {
        return $http.get(defaultUrl + "/usuario");
    };

    var _saveUsuario = function (usuario) {
        return $http.post(defaultUrl + "/usuario", usuario);
    };

    var _updateUsuario = function (usuario) {
        return $http.put(defaultUrl + "/usuario" + "/" + usuario.id, usuario);
    };

    return {
        getUsuarios: _getUsuarios,
        saveUsuario: _saveUsuario,
        updateUsuario: _updateUsuario
    };
});
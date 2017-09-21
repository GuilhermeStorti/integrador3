angular.module("app").factory("usuarioService", function ($http, defaultUrl) {
    var _getUsuarios = function () {
        return $http.get(defaultUrl.getServerUrl() + "/usuario");
    };

    var _saveUsuario = function (usuario) {
        return $http.post(defaultUrl.getServerUrl() + "/usuario", usuario);
    };

    var _updateUsuario = function (usuario) {
        return $http.put(defaultUrl.getServerUrl() + "/usuario" + "/" + usuario.id, usuario);
    };

    return {
        getUsuarios: _getUsuarios,
        saveUsuario: _saveUsuario,
        updateUsuario: _updateUsuario
    };
});
angular.module("app").factory("campanhaService", function ($http, defaultUrl) {
    var _getCampanhas = function () {
        return $http.get(defaultUrl + "/campanha");
    };

    var _saveCampanha = function (campanha) {
        return $http.post(defaultUrl + "/campanha", campanha);
    };

    var _updateCampanha = function (campanha) {
        return $http.put(defaultUrl + "/campanha" + "/" + campanha.id, campanha);
    };

    return {
        getCampanhas: _getCampanhas,
        saveCampanha: _saveCampanha,
        updateCampanha: _updateCampanha
    };
});
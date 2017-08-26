/**
 * Created by guilhermeplasma on 26/08/17.
 */
angular.module("App").controller("campanhaCtrl", function ($scope, $http) {
    var url = "http://localhost:8080/integrador3/campanha";

    $scope.mostrar = function () {
        $http.get(url).then(
            function sucesso(response) {
                $scope.campanhas = response.data;
            }, function erro(response) {
                alert("ops!! erro na chamada get campanha");
            }
        )
    };

    $scope.salvar = function () {
        $http.post(url, $scope.campanha).then(
            function sucesso(response) {
                $scope.mostrar();
            }, function erro(response) {
                $scope.update();
            }
        )
    };

    $scope.editar = function () {
        $http.put(url + "/" + $scope.campanha.id, $scope.campanha).then(
            function sucesso(response) {
                $scope.mostrar();
            }, function erro(response) {
                alert("erro ao salvar campanha");
            }
        );
    };

    $scope.deletar = function () {
        $http.delete(url + "/" + $scope.campanha.id).then(
            function (response) {
                $scope.mostrar();
                $scope.limpar();
            }, function (error) {
                alert("erro ao deletar campanha");
            }
        );
    };

    $scope.mostrar();

    $scope.seleciona = function (campanha) {
        $scope.campanha = angular.copy(campanha);
    };

    $scope.limpar = function () {
        $scope.campanha = null;
    };

});
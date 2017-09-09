angular.module("app").controller("campanhaCtrl", function ($scope, $http,defaultUrl) {

    var url = defaultUrl + "/campanha";

    $scope.mostrar = function()	{
        $http.get(url).then(
            function sucesso(response) {
                $scope.campanhas = response.data;
            }, function erro(response) {
                alert("ops!! erro na chamada get campanha");
            }
        )
    };

    $scope.salvar = function()	{
        $http.post(url, $scope.campanha).then(
            function sucesso(response) {
                $scope.mostrar();
                $scope.limpar();
                $scope.changeToList();
            }, function erro(response) {
                alert("ops!! erro ao salvar campanha");
            }
        )
    };

    $scope.editar = function(){
        $http.put(url + "/" + $scope.campanha.id, $scope.campanha).then(
            function sucesso(response) {
                $scope.mostrar();
            },function erro(response) {
                alert("erro ao editar campanha");
            }
        );
    };

    $scope.seleciona = function(campanha) {
        $scope.limpar();
        $scope.campanha = angular.copy(campanha);
        $scope.changeToEdit();
    };

    $scope.limpar = function () {
        $scope.campanha = null;
    };

    $scope.changeToEdit = function () {
        $scope.cadastro = false;
        $scope.listagem = false;
        $scope.edicao = true;

        $scope.titulo = "EDITAR";
    };

    $scope.changeToList = function () {
        $scope.cadastro = false;
        $scope.listagem = true;
        $scope.edicao = false;

        $scope.titulo = "LISTAGEM";
    };

    $scope.changeToSave = function () {
        $scope.cadastro = true;
        $scope.listagem = false;
        $scope.edicao = true;

        $scope.titulo = "CADASTRAR";
    };

    $scope.init = function () {
        $scope.mostrar();
        $scope.changeToList();
    };

    $scope.init();

});
angular.module("app").controller("campanhaCtrl", function ($scope, campanhaService) {

    var mostrar = function()	{
        campanhaService.getCampanhas().success(function (data) {
            $scope.campanhas = data;
        }).error(function (data, status) {
            alert("ops!! erro na chamada get campanha");
        });
    };

    $scope.salvar = function()	{
        campanhaService.saveCampanha($scope.campanha).success(function (data) {
            $scope.limpar();
            mostrar();
            $scope.changeToList();
        });
    };

    $scope.editar = function(){
        campanhaService.updateCampanha($scope.campanha).success(function (data) {
            $scope.limpar();
            mostrar();
            $scope.changeToList();
        });
    };

    $scope.seleciona = function(campanha) {
        $scope.campanha = campanha;
        $scope.campanha.dataInicio = new Date(...campanha.dataInicio.split("-").map((item, indice) => item - indice % 2));
        $scope.campanha.dataFim = new Date(...campanha.dataFim.split("-").map((item, indice) => item - indice % 2));
        $scope.changeToEdit();
    };

    $scope.limpar = function () {
        delete $scope.campanha;
    };

    $scope.changeToEdit = function () {
        $scope.cadastro = false;
        $scope.listagem = false;
        $scope.edicao = true;

        $scope.titulo = "EDITAR";
    };

    $scope.changeToList = function () {
        mostrar();
        $scope.cadastro = false;
        $scope.listagem = true;
        $scope.edicao = false;

        $scope.titulo = "LISTAGEM";
    };

    $scope.changeToSave = function () {
        $scope.limpar();
        $scope.cadastro = true;
        $scope.listagem = false;
        $scope.edicao = false;

        $scope.titulo = "CADASTRAR";
    };

    $scope.changeToList();

});
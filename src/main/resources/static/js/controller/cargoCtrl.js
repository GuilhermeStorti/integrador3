angular.module("app").controller("cargoCtrl", function ($scope, cargoService) {

    var mostrar = function()	{
        cargoService.getCargos().success(function (data) {
            $scope.cargos = data;
        }).error(function (data, status) {
            alert("ops!! erro na chamada get cargo");
        });
    };

    $scope.salvar = function()	{
        cargoService.saveCargo($scope.cargo).success(function (data) {
            $scope.limpar();
            mostrar();
            $scope.changeToList();
        });
    };

    $scope.editar = function(){
        cargoService.updateCargo($scope.cargo).success(function (data) {
            $scope.limpar();
            mostrar();
            $scope.changeToList();
        });
    };

    $scope.seleciona = function(cargo) {
        $scope.cargo = angular.copy(cargo);
        $scope.changeToEdit();
    };

    $scope.limpar = function () {
        delete $scope.cargo;
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

    $scope.sort = function(keyname){
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    };

    $scope.changeToList();

});
angular.module("app").controller("funcionarioCtrl", function ($scope, funcionarioService) {

    $scope.address = {};
    var aux = {};

    var mostrar = function()	{
        funcionarioService.getFuncionarios().success(function (data) {
            $scope.funcionarios = data;
        }).error(function (data, status) {
            alert("ops!! erro ao trazer o funcionarios");
        });
    };

    $scope.salvar = function()	{
        funcionarioService.saveFuncionario($scope.funcionarios).success(function (data) {
            $scope.limpar();
            mostrar();
            $scope.changeToList();
        });
    };

    $scope.buscarCep = function()	{
        funcionarioService.getCep(this.address.cep).success(function (data) {
            aux = data;
            parseAddress(aux);
        }).error(function (data, status) {
            alert("ops!! Aconteceu algum erro");
        });
    };

    function parseAddress( aux) {
        $scope.address.cep = aux.cep;
        $scope.address.logradouro = aux.logradouro;
        $scope.address.bairro = aux.bairro;
        $scope.address.cidade = aux.localidade;
        $scope.address.uf = aux.uf;
    }

    $scope.seleciona = function(funcionario) {
        $scope.funcionarios = angular.copy(funcionario);
        $scope.changeToEdit();
    };

    $scope.limpar = function () {
        delete $scope.funcionarios;
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

    mostrar();
    $scope.changeToList();

});
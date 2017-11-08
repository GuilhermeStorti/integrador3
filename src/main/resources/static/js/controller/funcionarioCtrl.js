angular.module("app").controller("funcionarioCtrl", function ($scope, funcionarioService, cargoService) {

    $scope.address = {};
    $scope.usuario = {};
    $scope.funcionario = {};
    $scope.sex = ["M","F"];

    var aux = {};


    function edit() {
        $scope.address.cep = $scope.funcionario.endereco.cep;
        $scope.address.logradouro = $scope.funcionario.endereco.logradouro;
        $scope.address.bairro = $scope.funcionario.endereco.bairro;
        $scope.address.cidade = $scope.funcionario.endereco.cidade;
        $scope.address.uf = $scope.funcionario.endereco.uf;
       // $scope.numeroResidencia = $scope.funcionario.numeroResidencia;
        //$scope.complementoResidencia = $scope.funcionario.complementoResidencia;
        $scope.cargos.id = $scope.funcionario.cargo.id;
    }
    cargoService.getCargos().success(function (data) {
        $scope.cargos = data;
    }).error(function (data, status) {
        alert("ops!! erro na chamada");
    });


    var mostrar = function()	{
        funcionarioService.getFuncionarios().success(function (data) {
            $scope.funcionarios = data;
        }).error(function (data, status) {
            alert("ops!! erro ao trazer o funcionarios");
        });
    };

    $scope.salvar = function()	{
        $scope.usuario.nome =  $scope.funcionario.nome;
        $scope.funcionario.usuario =  $scope.usuario;
        //$scope.funcionario.numeroResidencia = $scope.numeroResidencia;
       // $scope.funcionario.complementoResidencia = $scope.complementoResidencia;
        funcionarioService.saveFuncionario($scope.funcionario).success(function (data) {
            $scope.limpar();
            mostrar();
            $scope.changeToList();
        });
    };

    $scope.editar = function(){
        $scope.funcionario.numeroResidencia = $scope.numeroResidencia;
        $scope.funcionario.complementoResidencia = $scope.complementoResidencia;
        funcionarioService.updateFuncionario($scope.funcionario).success(function (data) {
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
        $scope.address.cep = aux.cep.replace("-","");;
        $scope.address.logradouro = aux.logradouro;
        $scope.address.bairro = aux.bairro;
        $scope.address.cidade = aux.localidade;
        $scope.address.uf = aux.uf;
        $scope.funcionario.endereco = $scope.address;
        //$scope.funcionario.numeroResidencia = $scope.numeroResidencia;
        //$scope.funcionario.complementoResidencia = $scope.complementoResidencia;
    }

    $scope.seleciona = function(funcionario) {
        $scope.funcionario = angular.copy(funcionario);
        edit();
        $scope.changeToEdit();
    };

    $scope.limpar = function () {
        $scope.funcionario = {};
        $scope.address = {};
        $scope.usuario = {};
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
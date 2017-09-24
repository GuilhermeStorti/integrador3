angular.module("app").controller("funcionarioCtrl", function ($scope, funcionarioService, cargoService) {

    $scope.address = {};
    $scope.funcionarios = { endereco : {}, sexo: "M", situacao:"A", cargo : {}, usuario:{}};
    $scope.cargos = {};
    $scope.usuario = {};
    $scope.sex = ["M","F"]

    var aux = {};


    function edit() {
        $scope.address.cep = $scope.funcionarios.endereco.cep;
        $scope.address.logradouro = $scope.funcionarios.endereco.logradouro;
        $scope.address.bairro = $scope.funcionarios.endereco.bairro;
        $scope.address.cidade = $scope.funcionarios.endereco.cidade;
        $scope.address.uf = $scope.funcionarios.endereco.uf;
        $scope.address.numero = $scope.funcionarios.endereco.numeroResidencia;
        $scope.address.complemento = $scope.funcionarios.endereco.complementoResidencia;
        $scope.usuario = $scope.funcionarios.usuario;
        $scope.confirmacaoSenha = $scope.funcionarios.usuario.senha;


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
        $scope.usuario.nome =  $scope.funcionarios.nome;
        $scope.funcionarios.usuario =  $scope.usuario;
        funcionarioService.saveFuncionario($scope.funcionarios).success(function (data) {
            console.log($scope.funcionarios);
            $scope.limpar();
            mostrar();
            $scope.changeToList();
        });
    };

    $scope.editar = function(){
        funcionarioService.updateFuncionario($scope.funcionarios).success(function (data) {
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
        $scope.address.numeroResidencia = aux.numero;
        $scope.address.complementoResidencia = aux.complemento;
        $scope.funcionarios.endereco = $scope.address;
    }

    $scope.seleciona = function(funcionario) {
        $scope.funcionarios = angular.copy(funcionario);
        edit();
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

    $scope.sort = function(keyname){
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    };

    mostrar();
    $scope.changeToList();

});
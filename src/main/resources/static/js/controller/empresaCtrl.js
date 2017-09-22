angular.module("app").controller("empresaCtrl", function ($scope, empresaService, dateUtils) {

    $scope.address = {};
    var addressRepresentation = {};
    var aux = {};

    var mostrar = function()	{
        empresaService.getEmpresas().success(function (data) {
            $scope.empresas = data;
        }).error(function (data, status) {
            alert("ops!! erro na chamada get empresa");
        });
    };

    $scope.salvar = function()	{
        parseToRepresentation();
        this.empresa.id = 0;
        $scope.empresa.cep = addressRepresentation;
        $scope.empresa.numeroResidencia = parseInt($scope.address.numero);
        $scope.empresa.complementoResidencia = $scope.address.complemento;
        $scope.empresa.situacao = "A";
        empresaService.saveEmpresa($scope.empresa).success(function (data) {
            $scope.limpar();
            mostrar();
            $scope.changeToList();
        }).error(function (data, status) {
            alert("ops!! erro na chamada post empresa");
        });
    };

    $scope.editar = function(){
        empresaService.updateEmpresa($scope.empresa).success(function (data) {
            $scope.limpar();
            mostrar();
            $scope.changeToList();
        }).error(function (data, status) {
            alert("ops!! erro na chamada put empresa");
        });
    };

    $scope.seleciona = function(empresa) {
        $scope.empresa = empresa;
        $scope.address = empresa.cep;
        $scope.address.numero = empresa.numeroResidencia;
        $scope.address.complemento = empresa.complementoResidencia;
        $scope.changeToEdit();
    };

    $scope.buscarCep = function()	{
        empresaService.getCep(this.address.cep).success(function (data) {
            aux = data;
            parseAddress(aux);
        }).error(function (data, status) {
            alert("ops!! Aconteceu algum erro");
        });
    };

    var parseAddress = function(aux) {
        $scope.address.cep = aux.cep.replace("-", "");
        $scope.address.logradouro = aux.logradouro;
        $scope.address.bairro = aux.bairro;
        $scope.address.cidade = aux.localidade;
        $scope.address.uf = aux.uf;
    };

    var parseToRepresentation = function() {
        addressRepresentation.cep = parseInt($scope.address.cep);
        addressRepresentation.logradouro = $scope.address.logradouro;
        addressRepresentation.bairro = $scope.address.bairro;
        addressRepresentation.cidade = $scope.address.cidade;
        addressRepresentation.uf = $scope.address.uf;
    };

    $scope.limpar = function () {
        delete $scope.empresa;
        $scope.address = {};
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
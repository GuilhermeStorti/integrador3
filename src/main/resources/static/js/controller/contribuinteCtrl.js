angular.module("app").controller("contribuinteCtrl", function ($scope, contribuinteService, dateUtils) {

    $scope.address = {};
    $scope.funcionario = {};
    $scope.contribuinte = { numeroResidencia: null, complementoResidencia:null};
    var addressRepresentation = {};
    var aux = {};

    var mostrar = function()	{
        contribuinteService.getContribuintes().success(function (data) {
            $scope.contribuintes = data;
        }).error(function (data, status) {
            alert("ops!! erro na chamada get contribuinte");
        });
    };

    $scope.salvar = function()	{
        parseToRepresentation();
        this.contribuinte.id = 0;
        $scope.contribuinte.cep = addressRepresentation;
        this.contribuinte.numeroResidencia = parseInt(this.funcionario.numeroResidencia);
        this.contribuinte.complementoResidencia = this.funcionario.complementoResidencia;
        $scope.contribuinte.situacao = "A";
        contribuinteService.saveContribuinte($scope.contribuinte).success(function (data) {
            $scope.limpar();
            mostrar();
            $scope.changeToList();
        }).error(function (data, status) {
            alert("ops!! erro na chamada post contribuinte");
        });
    };

    $scope.editar = function(){
        contribuinteService.updateContribuinte($scope.contribuinte).success(function (data) {
            $scope.limpar();
            mostrar();
            $scope.changeToList();
        }).error(function (data, status) {
            alert("ops!! erro na chamada put contribuinte");
        });
    };

    $scope.seleciona = function(contribuinte) {
        $scope.contribuinte = contribuinte;
        $scope.contribuinte.dataNascimento = dateUtils.timestampToDate(contribuinte.dataNascimento);
        $scope.address = contribuinte.cep;
        $scope.address.numero = contribuinte.numeroResidencia;
        $scope.address.complemento = contribuinte.complementoResidencia;
        $scope.changeToEdit();
    };

    $scope.buscarCep = function()	{
        contribuinteService.getCep(this.address.cep).success(function (data) {
            aux = data;
            parseAddress(aux);
        }).error(function (data, status) {
            alert("ops!! Aconteceu algum erro");
        });
    };

    var parseAddress = function(aux) {
        $scope.address.cep = aux.cep.toString().replace("-", "");
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
        delete $scope.contribuinte;
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
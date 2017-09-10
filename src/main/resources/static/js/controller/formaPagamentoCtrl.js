angular.module("app").controller("formaPagamentoCtrl", function ($scope, formaPagamentoService) {

    var mostrar = function()	{
        formaPagamentoService.getFormaPagamentos().success(function (data) {
            $scope.formaPagamentos = data;
        }).error(function (data, status) {
            alert("ops!! erro na chamada get formaPagamento");
        });
    };

    $scope.salvar = function()	{
        formaPagamentoService.saveFormaPagamento($scope.formaPagamento).success(function (data) {
            $scope.limpar();
            mostrar();
            $scope.changeToList();
        });
    };

    $scope.editar = function(){
        formaPagamentoService.updateFormaPagamento($scope.formaPagamento).success(function (data) {
            $scope.limpar();
            mostrar();
            $scope.changeToList();
        });
    };

    $scope.seleciona = function(formaPagamento) {
        $scope.formaPagamento = angular.copy(formaPagamento);
        $scope.changeToEdit();
    };

    $scope.limpar = function () {
        delete $scope.formaPagamento;
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
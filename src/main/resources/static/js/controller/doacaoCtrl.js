angular.module("app").controller("doacaoCtrl", function ($scope, doacaoService, campanhaService, contribuinteService, funcionarioService, dateUtils, formaPagamentoService) {

    var carregarListas = function () {
        campanhaService.getCampanhas().success(function (data) {
            $scope.campanhas = data;
        }).error(function (data, status) {
            alert("ops!! erro na chamada getCampanhas");
        });
        contribuinteService.getContribuintes().success(function (data) {
            $scope.contribuintes = data;
        }).error(function (data, status) {
            alert("ops!! erro na chamada getContribuintes");
        });
        funcionarioService.getFuncionarios().success(function (data) {
            $scope.funcionarios = data;
        }).error(function (data, status) {
            alert("ops!! erro ao trazer o funcionarios");
        });
        formaPagamentoService.getFormaPagamentos().success(function (data) {
            $scope.formaPagamentos = data;
        }).error(function (data, status) {
            alert("ops!! erro na chamada getFormaPagamentos");
        });
    };

    var parse = function (){
        $scope.doacao.campanha = JSON.parse($scope.doacao.campanha);
        $scope.doacao.funcionarioMotoboy = JSON.parse($scope.doacao.funcionarioMotoboy);
        $scope.doacao.contribuinte = JSON.parse($scope.doacao.contribuinte);
        $scope.doacao.formaPagamento = JSON.parse($scope.doacao.formaPagamento);
        $scope.doacao.campanha.dataInicio = dateUtils.timestampToDate($scope.doacao.campanha.dataInicio);
        $scope.doacao.campanha.dataFim = dateUtils.timestampToDate($scope.doacao.campanha.dataFim);
        /*$scope.doacao.dataOperacao = dateUtils.timestampToDate($scope.doacao.dataOperacao);*/
    };

    var mostrar = function()	{
        doacaoService.getDoacoes().success(function (data) {
            $scope.doacoes = data;
        }).error(function (data, status) {
            alert("ops!! erro na chamada get doacao");
        });
    };

    $scope.salvar = function()	{
        parse();
        $scope.doacao.funcionarioAtendente = $scope.doacao.funcionarioMotoboy;
        doacaoService.saveDoacao($scope.doacao).success(function (data) {
            $scope.limpar();
            mostrar();
            $scope.changeToList();
        });
    };

    $scope.editar = function(){
        parse();
        doacaoService.updateDoacao($scope.doacao).success(function (data) {
            $scope.limpar();
            mostrar();
            $scope.changeToList();
        });
    };

    $scope.seleciona = function(doacao) {
        $scope.doacao = doacao;
        $scope.changeToEdit();
    };

    $scope.limpar = function () {
        delete $scope.doacao;
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

    carregarListas();
    $scope.changeToList();

});
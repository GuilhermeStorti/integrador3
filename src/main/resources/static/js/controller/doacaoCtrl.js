angular.module("app").controller("doacaoCtrl", function ($scope, doacaoService, campanhaService, contribuinteService,
                                                         funcionarioService, dateUtils, formaPagamentoService) {
    var funcionarioMotoboy = {};

    var carregarListas = function () {
        funcionarioService.findAtualMotoboy().success(function (data) {
            funcionarioMotoboy = data;
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
        $scope.doacao.formaPagamento = JSON.parse($scope.doacao.formaPagamento);
        $scope.doacao.campanha.dataInicio = dateUtils.timestampToDate($scope.doacao.campanha.dataInicio);
        $scope.doacao.campanha.dataFim = dateUtils.timestampToDate($scope.doacao.campanha.dataFim);
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

    $scope.selecionaCampanha = function(campanha) {
        $scope.doacao.campanha = campanha;
        $scope.doacao.campanha.dataInicio = dateUtils.timestampToDate(campanha.dataInicio);
        $scope.doacao.campanha.dataFim = dateUtils.timestampToDate(campanha.dataFim);
    };

    $scope.selecionaContribuinte = function(contribuinte) {
        $scope.doacao.contribuinte = contribuinte;
        $scope.doacao.contribuinte.dataNascimento = dateUtils.timestampToDate(contribuinte.dataNascimento);
    };

    $scope.limpar = function () {
        $scope.doacao = {};
        $scope.campanhas = {};
        $scope.contribuintes = {};
        $scope.contribuinteBusca = "";
        $scope.campanhaBusca = "";
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
        $scope.motoboyNome = funcionarioMotoboy.nome + " " + funcionarioMotoboy.sobrenome;
        $scope.doacao.funcionarioMotoboy = funcionarioMotoboy;
        $scope.doacao.parcela = 1;
        $scope.doacao.formaPagamento = $scope.formaPagamentos[0];
        $scope.cadastro = true;
        $scope.listagem = false;
        $scope.edicao = false;

        $scope.titulo = "CADASTRAR";
    };

    $scope.sort = function(keyname){
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    };

    $scope.buscarCampanha = function () {
        campanhaService.findByDescricao($scope.campanhaBusca).success(function (data) {
            $scope.campanhas = data;
        }).error(function (data, status) {
            alert("ops!! erro na chamada Campanha.findByDescricao");
        });
    };

    $scope.buscarContribuinte = function () {
        contribuinteService.findByName($scope.contribuinteBusca).success(function (data) {
            $scope.contribuintes = data;
        }).error(function (data, status) {
            alert("ops!! erro na chamada Campanha.findByDescricao");
        });
    };

    $scope.whatClassIsIt= function(valor){
        if(valor === "B")
            return "label bg-green";
        else if(valor === "G")
            return "label bg-blue";
        else if(valor === "R")
            return "label bg-orange";
        else
            return "label bg-red";
    };

    $scope.converteStatus = function (status) {
        if(status === "B")
            return "BAIXADO";
        else if(status === "G")
            return "GERADO";
        else if(status === "R")
            return "REAGENDADO";
        else
            return "CANCELADO";
    };

    $scope.changeToList();
    carregarListas();

});
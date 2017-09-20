angular.module("app").controller("campanhaCtrl", function ($scope, campanhaService, dateUtils) {

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
        $scope.campanha.dataInicio = dateUtils.timestampToDate(campanha.dataInicio);
        $scope.campanha.dataFim = dateUtils.timestampToDate(campanha.dataFim);
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

    $scope.sort = function(keyname){
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    };

    $scope.changeToList();

});
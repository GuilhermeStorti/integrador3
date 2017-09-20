angular.module("app").controller("usuarioCtrl", function ($scope, usuarioService) {

    var mostrar = function()	{
        usuarioService.getUsuarios().success(function (data) {
            $scope.usuarios = data;
        }).error(function (data, status) {
            alert("ops!! erro na chamada get usuario");
        });
    };

    $scope.salvar = function()	{
        if($scope.confirmacaoSenha === $scope.usuario.senha){
            usuarioService.saveUsuario($scope.usuario).success(function (data) {
                $scope.limpar();
                mostrar();
                $scope.changeToList();
            });
        }else{
            alert("As senhas não conferem");
        }
    };

    $scope.editar = function(){
        if($scope.confirmacaoSenha === $scope.usuario.senha){
            usuarioService.updateUsuario($scope.usuario).success(function (data) {
                $scope.limpar();
                mostrar();
                $scope.changeToList();
            });
        }else{
            alert("As senhas não conferem");
        }
    };

    $scope.seleciona = function(usuario) {
        $scope.usuario = angular.copy(usuario);
        $scope.changeToEdit();
    };

    $scope.limpar = function () {
        delete $scope.usuario;
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
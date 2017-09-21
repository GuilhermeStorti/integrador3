angular.module("app").config(function ($routeProvider) {

    $routeProvider.when("/campanha", {
        templateUrl: "view/campanha.html",
        controller: "campanhaCtrl"
    });
    $routeProvider.when("/cargo", {
        templateUrl: "view/cargo.html",
        controller: "cargoCtrl"
    });
    $routeProvider.when("/formaPagamento", {
        templateUrl: "view/formaPagamento.html",
        controller: "formaPagamentoCtrl"
    });
    $routeProvider.when("/usuario", {
        templateUrl: "view/usuario.html",
        controller: "usuarioCtrl"
    });
    $routeProvider.when("/dashboard", {
        templateUrl: "view/dashboard.html",
        controller: "dashboardCtrl"
    });
    $routeProvider.when("/funcionario", {
        templateUrl: "view/funcionarios.html",
        controller: "funcionarioCtrl"
    });
    $routeProvider.when("/empresa", {
        templateUrl: "view/empresa.html",
        controller: "empresaCtrl"
    });

    $routeProvider.otherwise({redirectTo: "#"});
});
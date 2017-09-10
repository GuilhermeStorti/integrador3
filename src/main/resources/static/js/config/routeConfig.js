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

    $routeProvider.otherwise({redirectTo: "#"});
});
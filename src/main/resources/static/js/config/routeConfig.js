angular.module("app").config(function ($routeProvider) {
$routeProvider.when("/campanha", {
    templateUrl: "view/campanha.html",
    controller: "campanhaCtrl"
});
$routeProvider.otherwise({redirectTo: "#"});
});
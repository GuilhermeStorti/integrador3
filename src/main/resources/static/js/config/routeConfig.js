/**
 * Created by guilhermeplasma on 26/08/17.
 */
angular.module("App").config(function ($routeProvider) {
    $routeProvider.when("/campanha", {
        templateUrl: "view/campanha.html",
        controller: "campanhaCtrl"
    });
    $routeProvider.otherwise({redirectTo: "#"});
});
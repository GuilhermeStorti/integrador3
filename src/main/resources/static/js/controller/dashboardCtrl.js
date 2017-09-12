angular.module("app").controller("dashboardCtrl", function ($scope, dashboardService) {

    var mostrarTaxpayersSavesOfMounth = function()	{
        dashboardService.getTaxpayersSavesOfMounth().success(function (data) {
            $scope.taxpayersSavesOfMounth = data;
        }).error(function (data, status) {
            alert("ops!! erro na chamada getTaxpayersSavesOfMounth");
        });
    };

    var mostrarDonationsOfMounth = function()	{
        dashboardService.getDonationsOfMounth().success(function (data) {
            $scope.donationsOfMounth = data;
        }).error(function (data, status) {
            alert("ops!! erro na chamada getDonationsOfMounth");
        });
    };

    mostrarTaxpayersSavesOfMounth();
    mostrarDonationsOfMounth();

});
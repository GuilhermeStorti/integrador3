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

    var findValueOfDonationsOfMounth = function () {
        dashboardService.findValueOfDonationsOfMounth().success(function (data) {
            $scope.valueOfDonationsOfMounth = data;
        }) .error(function (data, status) {
            alert("ops!! erro na chamada findValueOfDonationsOfMounth");
        });
    };

    var findNumbersOfDonationsGroupByStatus= function () {
        dashboardService.findNumbersOfDonationsGroupByStatus().success(function (data) {
            $scope.numbersOfDonationsGroupByStatus = data;
        }) .error(function (data, status) {
            alert("ops!! erro na chamada findNumbersOfDonationsGroupByStatus");
        });
    };


    mostrarTaxpayersSavesOfMounth();
    mostrarDonationsOfMounth();
    findValueOfDonationsOfMounth();
    findNumbersOfDonationsGroupByStatus();

    console.log($scope.numbersOfDonationsGroupByStatus);

    $scope.colors = [
        '#8BC34A',
        '#FF9800',
        '#9E9E9E'
    ];

    $scope.labels = ['Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sabado', 'Domingo'];
    $scope.data = [
        [65, -59, 80, 81, -56, 55, -40],
        [28, 48, -40, 19, 86, 27, 90],
        [30, 70, -20, 10, 56, 17, 50]
    ];

    $scope.dadosPizza = [1, 1, 4, 1];
    $scope.labelsPizza = ["Baixados", "Cancelados", "Gerados", "Reagendados"];
    $scope.colorsPizza = ["#4CAF50", "#F44336", "#2196F3", "#FF9800"];

    $scope.datasetOverride = [
        {
            label: "Bar chart",
            borderWidth: 1,
            type: 'bar'
        },
        {
            label: "Line chart",
            borderWidth: 3,
            hoverBackgroundColor: "rgba(255,99,132,0.4)",
            hoverBorderColor: "rgba(255,99,132,1)",
            type: 'line'
        }
    ];

});
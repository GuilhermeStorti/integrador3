angular.module("app").factory("dashboardService", function ($http, defaultUrl) {
    var _getDonationsOfMounth = function () {
        return $http.get(defaultUrl + "/dashboard/donationsOfMounth");
    };

    var _getTaxpayersSavesOfMounth = function () {
        return $http.get(defaultUrl + "/dashboard/taxpayersSavesOfMounth");
    };

    return {
        getDonationsOfMounth: _getDonationsOfMounth,
        getTaxpayersSavesOfMounth: _getTaxpayersSavesOfMounth
    };
});
angular.module("app").factory("dashboardService", function ($http, defaultUrl) {
    var _getDonationsOfMounth = function () {
        return $http.get(defaultUrl.getServerUrl() + "/dashboard/donationsOfMounth");
    };

    var _getTaxpayersSavesOfMounth = function () {
        return $http.get(defaultUrl.getServerUrl() + "/dashboard/taxpayersSavesOfMounth");
    };

    var _findValueOfDonationsOfMounth = function () {
        return $http.get(defaultUrl.getServerUrl() + "/dashboard/findValueOfDonationsOfMounth");
    };

    var _findNumbersOfDonationsGroupByStatus = function () {
        return $http.get(defaultUrl.getServerUrl() + "/dashboard/findNumbersOfDonationsGroupByStatus");
    };

    return {
        getDonationsOfMounth: _getDonationsOfMounth,
        getTaxpayersSavesOfMounth: _getTaxpayersSavesOfMounth,
        findValueOfDonationsOfMounth: _findValueOfDonationsOfMounth,
        findNumbersOfDonationsGroupByStatus: _findNumbersOfDonationsGroupByStatus
    };

});
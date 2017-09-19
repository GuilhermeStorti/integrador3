/**
 * Created by guilhermeplasma on 16/09/17.
 */
angular.module("app").factory('dateUtils', function() {
    var _StringToDate = function (data) {
        return new Date(...data.split("-").map((item, indice) => item - indice % 2));
    };

    var _DateToString = function (data) {
        return  data.getDate() + "/" + (data.getMonth()+1) + "/" + data.getFullYear();
    };

    var _TimestampToDate = function (data) {
        return  new Date(data);
    };

    return {
        stringToDate: _StringToDate,
        dateToString: _DateToString,
        timestampToDate: _TimestampToDate
    };
});
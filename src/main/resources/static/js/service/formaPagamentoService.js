angular.module("app").factory("formaPagamentoService", function ($http, defaultUrl) {
    var _getFormaPagamentos = function () {
        return $http.get(defaultUrl + "/formaPagamento");
    };

    var _saveFormaPagamento = function (formaPagamento) {
        return $http.post(defaultUrl + "/formaPagamento", formaPagamento);
    };

    var _updateFormaPagamento = function (formaPagamento) {
        return $http.put(defaultUrl + "/formaPagamento" + "/" + formaPagamento.id, formaPagamento);
    };

    return {
        getFormaPagamentos: _getFormaPagamentos,
        saveFormaPagamento: _saveFormaPagamento,
        updateFormaPagamento: _updateFormaPagamento
    };
});
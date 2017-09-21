angular.module("app").factory("formaPagamentoService", function ($http, defaultUrl) {
    var _getFormaPagamentos = function () {
        return $http.get(defaultUrl.getServerUrl() + "/formaPagamento");
    };

    var _saveFormaPagamento = function (formaPagamento) {
        return $http.post(defaultUrl.getServerUrl() + "/formaPagamento", formaPagamento);
    };

    var _updateFormaPagamento = function (formaPagamento) {
        return $http.put(defaultUrl.getServerUrl() + "/formaPagamento" + "/" + formaPagamento.id, formaPagamento);
    };

    return {
        getFormaPagamentos: _getFormaPagamentos,
        saveFormaPagamento: _saveFormaPagamento,
        updateFormaPagamento: _updateFormaPagamento
    };
});
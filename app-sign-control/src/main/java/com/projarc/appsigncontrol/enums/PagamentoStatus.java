package com.projarc.appsigncontrol.enums;

public enum PagamentoStatus {
    PAGAMENTO_OK,
    VALOR_INCORRETO;

    public static PagamentoStatus getType(String type) {
        if (type.equals("PAGAMENTO_OK")) {
            return PAGAMENTO_OK;
        }

        if (type.equals("VALOR_INCORRETO")) {
            return VALOR_INCORRETO;
        }

        return null;
    }
}

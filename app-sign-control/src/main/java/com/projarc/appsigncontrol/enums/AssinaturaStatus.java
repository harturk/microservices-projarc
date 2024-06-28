package com.projarc.appsigncontrol.enums;

public enum AssinaturaStatus {
    ATIVA,
    CANCELADA;

    public static AssinaturaStatus getType(String type) {
        if (type.equals("ATIVA")) {
            return ATIVA;
        }

        if (type.equals("CANCELADA")) {
            return CANCELADA;
        }

        return null;
    }
}

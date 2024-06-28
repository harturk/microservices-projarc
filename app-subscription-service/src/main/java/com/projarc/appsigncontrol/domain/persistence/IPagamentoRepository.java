package com.projarc.appsigncontrol.domain.persistence;

import com.projarc.appsigncontrol.persistence.entity.PagamentoEntity;

public interface IPagamentoRepository {
    PagamentoEntity save(PagamentoEntity pagamento);
}

package com.gheno;

import java.time.LocalDate;

public record ItemInventarioContainer<T>(
        Caixa<T> caixa,
        String portoOrigem,
        String portoDestino,
        LocalDate dataEmbarque
) {
}

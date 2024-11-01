package julio.br.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import julio.br.model.Venda;

public record VendaResponseDTO(
        List<Long> celulares,
        Long idCliente,
        Float valorFinal,
        LocalDateTime data,
        String formaPagamento) {

    public static VendaResponseDTO valuesOf(Venda venda) {
        List<Long> idCelulares = new ArrayList<Long>();

        for (int i = 0; i < venda.getCelularVenda().size(); i++) {
            idCelulares.add(venda.getCelularVenda().get(i).getId());
        }

        return new VendaResponseDTO(
                idCelulares,
                venda.getCliente().getId(),
                venda.getValorFinal(),
                venda.getData(),
                venda.getFormaPagamento().nome);
    }

}

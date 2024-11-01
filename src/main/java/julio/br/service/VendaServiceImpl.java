package julio.br.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.SecurityContext;
import julio.br.dto.VendaDTO;
import julio.br.dto.VendaResponseDTO;
import julio.br.model.Celular;
import julio.br.model.CelularVenda;
import julio.br.model.Venda;
import julio.br.repository.CelularRepository;
import julio.br.repository.CelularVendaRepository;
import julio.br.repository.ClienteRepository;
import julio.br.repository.VendaRepository;

@ApplicationScoped
public class VendaServiceImpl implements VendaService {

    @Inject
    public VendaRepository vendaRepository;

    @Inject
    public ClienteRepository clienteRepository;

    @Inject
    public CelularRepository celularRepository;

    @Inject
    public CelularVendaRepository celularVendaRepository;

    @Inject
    public CelularService celularService;

    @Inject
    public SecurityContext securityContext;

    @Override
    public VendaResponseDTO create(@Valid VendaDTO dto) {
        Venda venda = new Venda();
        venda.setCelularVenda(new ArrayList<CelularVenda>());

        for (int i = 0; i < dto.celulares().size(); i++) {
            CelularVenda item = new CelularVenda();
            Celular celular = celularRepository.findById(
                    dto.celulares().get(i).idCelular());
            item.setCelular(celular);
            item.setQuantidade(dto.celulares().get(i).quantidade());
            celularVendaRepository.persist(item);
            venda.getCelularVenda().add(item);
        }

        Long id = clienteRepository.findByNome(securityContext.getUserPrincipal().getName()).getId();

        venda.setCliente(clienteRepository.findById(id));
        venda.setData(dto.data());
        venda.setValorFinal(calcularValorFinal(dto));
        venda.setFormaPagamento(dto.formaPagamento());

        vendaRepository.persist(venda);

        for (int i = 0; i < dto.celulares().size(); i++) {
            celularService.adicionarEstoque(
                    dto.celulares().get(i).idCelular(),
                    dto.celulares().get(i).quantidade());
        }

        return VendaResponseDTO.valuesOf(venda);

    }

    @Override
    public List<VendaResponseDTO> findAll() {
        return vendaRepository
                .listAll()
                .stream()
                .map(e -> VendaResponseDTO.valuesOf(e))
                .toList();
    }

    @Override
    public List<VendaResponseDTO> findByCliente(Long idCliente) {
        return vendaRepository
                .findByCliente(idCliente)
                .stream()
                .map(e -> VendaResponseDTO.valuesOf(e))
                .toList();
    }

    public Float calcularValorFinal(VendaDTO dto) {
        Float valor = 0f;
        for (int i = 0; i < dto.celulares().size(); i++) {
            Float valorCelular = celularRepository.findById(dto.celulares().get(i).idCelular()).getPreco();
            int quantidade = dto.celulares().get(i).quantidade();
            valor += (valorCelular * quantidade);
        }

        return valor;
    }

}

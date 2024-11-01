package julio.br.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import julio.br.dto.LinhaResponseDTO;
import julio.br.repository.LinhaRepository;

@ApplicationScoped
public class LinhaServiceImpl implements LinhaService {

    @Inject
    public LinhaRepository linhaRepository;

    @Override
    public List<LinhaResponseDTO> findAll() {
        return linhaRepository
                .findAll()
                .stream()
                .map(e -> LinhaResponseDTO.valuesOf(e))
                .toList();
    }

}

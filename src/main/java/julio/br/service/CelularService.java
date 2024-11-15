package julio.br.service;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.Valid;
import julio.br.dto.CelularDTO;
import julio.br.dto.CelularResponseDTO;

public interface CelularService {

    public List<CelularResponseDTO> findAll(int page, int pageSize);

    public List<CelularResponseDTO> findByNome(String nome, int page, int pageSize);

    public List<CelularResponseDTO> findByMarca(String marca, int page, int pageSize);

    public CelularResponseDTO create(@Valid CelularDTO dto);

    public void update(Long id, @Valid CelularDTO dto);

    public void delete(Long id);

    public List<CelularResponseDTO> findByMarca(String marca);

    public List<CelularResponseDTO> findByNome(String nome);

    public List<CelularResponseDTO> findByAnoLancamento(LocalDate anoLancamento);

    public List<CelularResponseDTO> findByArmazenamento(Float armazenamento);

    public List<CelularResponseDTO> findByRam(Float ram);

    public List<CelularResponseDTO> findByPreco(Float preco);

    public void definirEstoque(Long id, int quantidade);

    public void adicionarEstoque(Long id, int quantidade);

    public void diminuirEstoque(Long id, int quantidade);
}
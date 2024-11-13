package julio.br.dto;

import java.time.LocalDate;
import java.util.List;

import julio.br.model.Celular;

public record CelularResponseDTO(
                Long id,
                TelaResponseDTO tela,
                List<CameraResponseDTO> camera,
                List<PortaSlotResponseDTO> portaSlot,
                List<SensorResponseDTO> sensor,
                ProcessadorResponseDTO processador,
                SerieResponseDTO serie,
                String marca,
                String nome,
                LocalDate anoLancamento,
                Float armazenamento,
                Float ram,
                Float preco,
                int estoque,
                String nomeImagem) {
        public static CelularResponseDTO valuesOff(Celular celular) {
                List<CameraResponseDTO> listaCameras = celular.getCamera().stream().map(CameraResponseDTO::valuesOff)
                                .toList();
                List<PortaSlotResponseDTO> listaPortaSlot = celular.getPortaSlot().stream()
                                .map(PortaSlotResponseDTO::valuesOf)
                                .toList();
                List<SensorResponseDTO> listaSensor = celular.getSensor().stream().map(SensorResponseDTO::valuesOf)
                                .toList();
                return new CelularResponseDTO(
                                celular.getId(),
                                TelaResponseDTO.valuesOf(celular.getTela()),
                                listaCameras,
                                listaPortaSlot,
                                listaSensor,
                                ProcessadorResponseDTO.valuesOf(celular.getProcessador()),
                                SerieResponseDTO.valuesOf(celular.getSerie()),
                                celular.getMarca(),
                                celular.getNome(),
                                celular.getAnoLancamento(),
                                celular.getArmazenamento(),
                                celular.getRam(),
                                celular.getPreco(),
                                celular.getEstoque(),
                                celular.getNomeImagem());
        }
}

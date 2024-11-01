package julio.br.dto;

import julio.br.model.Camera;

public record CameraResponseDTO(
        Long id,
        Float resolucao,
        Boolean frontal) {
    public static CameraResponseDTO valuesOff(Camera camera) {
        return new CameraResponseDTO(
                camera.getId(),
                camera.getResolucao(),
                camera.getFrontal());
    }
}

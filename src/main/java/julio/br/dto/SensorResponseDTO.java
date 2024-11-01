package julio.br.dto;

import julio.br.model.Sensor;

public record SensorResponseDTO(
        Long id,
        String tipo) {

    public static SensorResponseDTO valuesOf(Sensor sensor) {
        return new SensorResponseDTO(
                sensor.getId(),
                sensor.getTipo());
    }

}

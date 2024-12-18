package julio.br.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import julio.br.dto.SensorDTO;
import julio.br.dto.SensorResponseDTO;
import julio.br.model.Celular;
import julio.br.model.Sensor;
import julio.br.repository.CelularRepository;
import julio.br.repository.SensorRepository;

@ApplicationScoped
public class SensorServiceImpl implements SensorService {

    @Inject
    public SensorRepository sensorRepository;

    @Inject
    public CelularRepository celularRepository;

    @Override
    public List<SensorResponseDTO> findAll() {
        return sensorRepository
                .listAll()
                .stream()
                .map(e -> SensorResponseDTO.valuesOf(e))
                .toList();
    }

    @Override
    public Long count() {
        return sensorRepository.count();
    }

    @Override
    @Transactional
    public SensorResponseDTO create(SensorDTO dto) {
        Sensor sensor = new Sensor();

        sensor.setTipo(dto.tipo());

        sensorRepository.persist(sensor);
        return SensorResponseDTO.valuesOf(sensor);
    }

    @Override
    public void update(Long id, SensorDTO dto) {
        Sensor sensor = sensorRepository.findById(id);

        sensor.setTipo(dto.tipo());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Sensor sensor = sensorRepository.findById(id);

        List<Celular> celulares = celularRepository.findBySensor(sensor);
        for (Celular celular : celulares) {
            celular.getSensor().remove(sensor);
            celularRepository.persist(celular);
        }
        sensorRepository.deleteById(id);
    }

}

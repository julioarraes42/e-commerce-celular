package julio.br.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import julio.br.dto.CameraDTO;
import julio.br.dto.CameraResponseDTO;
import julio.br.model.Camera;
import julio.br.model.Celular;
import julio.br.repository.CameraRepository;
import julio.br.repository.CelularRepository;

@ApplicationScoped
public class CameraServiceImpl implements CameraService {

    @Inject
    public CameraRepository cameraRepository;

    @Inject
    public CelularRepository celularRepository;

    @Override
    public List<CameraResponseDTO> findAll(int page, int pageSize) {
        List<Camera> cameras = cameraRepository
                .findAll()
                .page(page, pageSize)
                .list();

        return cameras
                .stream()
                .map(e -> CameraResponseDTO.valuesOff(e))
                .toList();

    }

    @Override
    public Long count() {
        return cameraRepository.count();
    }

    @Override
    public CameraResponseDTO create(@Valid CameraDTO dto) {
        Camera camera = new Camera();

        camera.setFrontal(dto.frontal());
        camera.setResolucao(dto.resolucao());

        cameraRepository.persist(camera);

        return CameraResponseDTO.valuesOff(camera);

    }

    @Override
    public void update(Long id, CameraDTO dto) {
        Camera camera = cameraRepository.findById(id);

        camera.setFrontal(dto.frontal());
        camera.setResolucao(dto.resolucao());

    }

    @Override
    @Transactional
    public void delete(Long id) {
        Camera camera = cameraRepository.findById(id);

        List<Celular> celulares = celularRepository.findByCamera(camera);
        for (Celular celular : celulares) {
            celular.getCamera().remove(camera);
            celularRepository.persist(celular);
        }
        cameraRepository.deleteById(id);
    }

    @Override
    public CameraResponseDTO findById(Long id) {
        Camera camera = cameraRepository.findById(id);

        return CameraResponseDTO.valuesOff(camera);
    }

}

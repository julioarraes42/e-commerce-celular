package julio.br.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import julio.br.model.Camera;

@ApplicationScoped
public class CameraRepository implements PanacheRepository<Camera> {

}

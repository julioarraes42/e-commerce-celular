package julio.br.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import julio.br.model.Sensor;

@ApplicationScoped
public class SensorRepository implements PanacheRepository<Sensor> {

}

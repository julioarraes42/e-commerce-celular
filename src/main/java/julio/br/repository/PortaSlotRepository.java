package julio.br.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import julio.br.model.PortaSlot;

@ApplicationScoped
public class PortaSlotRepository implements PanacheRepository<PortaSlot> {

}

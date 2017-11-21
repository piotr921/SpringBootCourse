package ps.learning.spring5webapp.repository;

import org.springframework.data.repository.CrudRepository;
import ps.learning.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository <Publisher, Long> {
}

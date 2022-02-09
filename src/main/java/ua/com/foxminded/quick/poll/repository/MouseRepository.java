package ua.com.foxminded.quick.poll.repository;

import org.springframework.data.repository.CrudRepository;
import ua.com.foxminded.quick.poll.domain.Mouse;

public interface MouseRepository extends CrudRepository<Mouse, Long> {
}

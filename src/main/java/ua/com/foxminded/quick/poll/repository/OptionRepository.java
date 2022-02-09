package ua.com.foxminded.quick.poll.repository;

import org.springframework.data.repository.CrudRepository;
import ua.com.foxminded.quick.poll.domain.Option;

public interface OptionRepository extends CrudRepository<Option, Long> {
}

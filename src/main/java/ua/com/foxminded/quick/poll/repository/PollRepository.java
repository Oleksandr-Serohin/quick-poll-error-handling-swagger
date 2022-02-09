package ua.com.foxminded.quick.poll.repository;

import org.springframework.data.repository.CrudRepository;
import ua.com.foxminded.quick.poll.domain.Poll;

public interface PollRepository extends CrudRepository<Poll, Long> {
}

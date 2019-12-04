package io.pivotal.user.repository;

import org.springframework.data.repository.CrudRepository;

import io.pivotal.user.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends CrudRepository<User,Integer> {
	public User findByUseridAndPasswd(String userId, String passwd);
	public User findByUserid(String userId);
	public User findByAuthtoken(String authtoken);
}

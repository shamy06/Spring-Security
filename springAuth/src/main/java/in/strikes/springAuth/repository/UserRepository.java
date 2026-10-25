package in.strikes.springAuth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.strikes.springAuth.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

Optional<User> findByUserName(String userName);

}

package in.strikes.springAuth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.strikes.springAuth.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

    Optional<Role> findByName(String name);

}

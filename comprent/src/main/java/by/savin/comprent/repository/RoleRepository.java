package by.savin.comprent.repository;

import by.savin.comprent.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByName(String name);
}

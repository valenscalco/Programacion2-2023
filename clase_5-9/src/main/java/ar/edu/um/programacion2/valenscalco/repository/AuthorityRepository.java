package ar.edu.um.programacion2.valenscalco.repository;

import ar.edu.um.programacion2.valenscalco.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}

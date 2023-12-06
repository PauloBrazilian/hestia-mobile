package hestia.msPersons.repository;


import hestia.msPersons.entity.PersonBUSS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonBussRepository extends JpaRepository<PersonBUSS, Integer> {
}

package repository;


import model.Gender;
import model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findByFullName(String fullName);

    Person findByBirthDate(String birthDate);

    Person findByGender(Gender gender);
}

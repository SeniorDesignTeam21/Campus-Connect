package Design.CampusConnect.repo;

import Design.CampusConnect.entity.Student;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface StudentRepo extends CrudRepository<Student, Integer> {

    Student findByUsername(String username);

}
package vidal.dicyane.atividademultitenant.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vidal.dicyane.atividademultitenant.model.Employee;

import java.util.List;

@Repository
@Transactional
public interface EmployeeDAO extends CrudRepository<Employee, Integer> {
    List<Employee> findAll();
}

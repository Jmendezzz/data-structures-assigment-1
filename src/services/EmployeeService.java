package services;

import models.Employee;

import java.util.Optional;

public interface EmployeeService {
  Employee createEmployee(Employee employee);
  Optional<Employee> getEmployeeByKey(int searchCriteria, String key);
}

package persistence;

import models.Employee;

public interface EmployeePersistence {
  Employee saveEmployee(Employee employee);
  Employee getEmployee(int searchCriteria, String key) throws RuntimeException;
}

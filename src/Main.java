import models.Employee;
import services.EmployeeService;
import services.imp.EmployeeServiceImp;

import java.util.Optional;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    EmployeeService employeeService = new EmployeeServiceImp();

    while (true){
      System.out.println("Seleccione una opción");
      System.out.println( "1. Registrar nuevo empleado. \n"+
                          "2. Buscar empleado.");
      int option = sc.nextInt();
      switch (option){
        case  1:
          Employee employee = inputsCreateEmployee();
          Employee employeeSaved = employeeService.createEmployee(employee);

          System.out.println("Se ha creado el empleado " + employeeSaved.getName());
          break;
        case 2:
          System.out.println("Seleccione un criterio de busqueda \n" +
                              "1. Nombre \n" +
                              "2. Numero \n"+
                              "3. Número seguridad social");
          int searchCriteria = sc.nextInt();

          System.out.println("Ingrese el valor a buscar, según el criterio de busqueda seleccionado");
          String value = sc.next();
          Optional<Employee> employeeOptional = employeeService.getEmployeeByKey(searchCriteria,value);

          employeeOptional.ifPresentOrElse(
                  e-> System.out.println("Empleado encontrado: \n" + e.toString()),
                  ()-> System.out.println("No se encontró el empleado"));
          break;
        default:
          System.out.println("Ingrese una opción válida");
      }
    }
  }
  public static Employee inputsCreateEmployee(){
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese el nombre del empleado:");
    String name = sc.next();

    System.out.println("Ingrese el numero del empleado");
    String id = sc.next();

    System.out.println("Ingrese el número de seguridad social del empleado");
    String socialSecurityNumber = sc.next();

    return new Employee(id,name,socialSecurityNumber);
  }
}
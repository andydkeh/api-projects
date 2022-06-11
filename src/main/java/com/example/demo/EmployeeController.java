package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EmployeeController {

  private final EmployeeRepository repository;

  EmployeeController(EmployeeRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/projetos")
  List<Projeto> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/projetos/add")
  Projeto newEmployee(@RequestBody Projeto newEmployee) {
    return repository.save(newEmployee);
  }

  // Single item
  
  @GetMapping("/projetos/{id}")
  Projeto one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new EmployeeNotFoundException(id));
  }

  @PutMapping("/projetos/{id}")
  Projeto replaceEmployee(@RequestBody Projeto newEmployee, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(employee -> {
    	employee.setProjeto(newEmployee.getProjeto());
    	employee.setCliente(newEmployee.getCliente());
        employee.setGestor(newEmployee.getGestor());
        employee.setFuncionarios(newEmployee.getFuncionarios());
        return repository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return repository.save(newEmployee);
      });
  }

  @DeleteMapping("/projetos/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}

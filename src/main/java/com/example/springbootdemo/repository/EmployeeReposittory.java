package com.example.springbootdemo.repository;

import com.example.springbootdemo.domain.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeReposittory {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public  void  save(Employee employee) {
        entityManager.persist(employee);
    }

  public List<Employee> list(){
     Query query= entityManager.createQuery("from Employee");
     return query.getResultList();
  }

  public  Employee get(Integer id){
        return  entityManager.find(Employee.class,id);
  }

  @Transactional
  public void delete(Employee employee){
      entityManager.remove(employee);
  }
}

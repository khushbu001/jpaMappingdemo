package com.example.jpa.jparelationshipdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa.jparelationshipdemo.entity.EmpAddress;
@Repository
public interface EmpaddressRepo extends JpaRepository<EmpAddress, Long> {

}

package com.ssg.ssgproduct.domain.product;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
//    @Query(value = "select p from Product p where :today between p.ProductDisplayStartTime and p.ProductDisplayEndTime")
//    List<Product> findAllProductOnCondition(Specification<Product> productSpecification, @Param("today") LocalDate today);
}
package com.reportgeneration.repo;

import com.reportgeneration.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findBySalesDateBetween(LocalDate startDate, LocalDate endDate);
}
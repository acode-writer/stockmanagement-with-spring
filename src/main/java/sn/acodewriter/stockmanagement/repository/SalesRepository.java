package sn.acodewriter.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.acodewriter.stockmanagement.model.Sales;

import java.util.Optional;

public interface SalesRepository extends JpaRepository<Sales,Integer> {

    Optional<Sales> findByCode(String code);
}

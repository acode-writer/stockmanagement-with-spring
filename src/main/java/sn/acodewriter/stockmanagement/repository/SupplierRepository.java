package sn.acodewriter.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.acodewriter.stockmanagement.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
}

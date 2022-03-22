package sn.acodewriter.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.acodewriter.stockmanagement.model.SupplierOrderLine;

public interface SupplierOrderLineRepository extends JpaRepository<SupplierOrderLine,Integer> {
}

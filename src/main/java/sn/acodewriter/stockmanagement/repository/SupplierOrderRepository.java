package sn.acodewriter.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.acodewriter.stockmanagement.model.SupplierOrder;

import java.util.Optional;

public interface SupplierOrderRepository extends JpaRepository<SupplierOrder,Integer> {

    Optional<SupplierOrder> findByCode(String code);
}

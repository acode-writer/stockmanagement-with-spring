package sn.acodewriter.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.acodewriter.stockmanagement.model.CustomerOrderLine;

public interface CustomerOrderLineRepository extends JpaRepository<CustomerOrderLine, Integer> {
}

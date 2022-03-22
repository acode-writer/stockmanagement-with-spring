package sn.acodewriter.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.acodewriter.stockmanagement.model.CustomerOrder;

import java.util.Optional;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Integer> {

    Optional<CustomerOrder> findByCode(String code);
}

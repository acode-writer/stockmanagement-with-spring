package sn.acodewriter.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.acodewriter.stockmanagement.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

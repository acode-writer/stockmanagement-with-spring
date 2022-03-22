package sn.acodewriter.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.acodewriter.stockmanagement.model.Company;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
}

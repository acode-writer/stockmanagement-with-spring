package sn.acodewriter.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.acodewriter.stockmanagement.model.SalesLine;

public interface SalesLineRepository extends JpaRepository<SalesLine,Integer> {
}

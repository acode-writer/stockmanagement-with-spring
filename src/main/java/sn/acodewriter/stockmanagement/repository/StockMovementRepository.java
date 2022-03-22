package sn.acodewriter.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.acodewriter.stockmanagement.model.StockMovement;

public interface StockMovementRepository extends JpaRepository<StockMovement, Integer> {
}

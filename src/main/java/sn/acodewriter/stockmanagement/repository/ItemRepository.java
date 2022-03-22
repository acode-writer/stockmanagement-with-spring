package sn.acodewriter.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.acodewriter.stockmanagement.model.Item;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    Optional<Item> findItemsByItemCode(String itemCode);
}

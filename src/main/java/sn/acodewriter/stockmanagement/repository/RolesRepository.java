package sn.acodewriter.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.acodewriter.stockmanagement.model.Roles;

public interface RolesRepository extends JpaRepository<Roles,Integer> {
}

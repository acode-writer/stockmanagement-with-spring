package sn.acodewriter.stockmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.acodewriter.stockmanagement.model.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {
}

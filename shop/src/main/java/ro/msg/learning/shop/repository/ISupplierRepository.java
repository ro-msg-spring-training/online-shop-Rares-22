package ro.msg.learning.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.model.Supplier;

import java.util.Optional;

@Repository
public interface ISupplierRepository extends JpaRepository<Supplier,Integer> {
    Optional<Supplier> findSupplierByName(String name);
}

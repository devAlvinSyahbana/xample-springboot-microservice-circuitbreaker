package tsgitdev.com.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tsgitdev.com.orderservice.model.Order;
public interface OrderRepository extends JpaRepository<Order, Long> {
}

package me.weekbelt.shop.order.infra.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import me.weekbelt.shop.order.command.domain.Order;
import me.weekbelt.shop.order.command.domain.OrderNo;
import me.weekbelt.shop.order.command.domain.OrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Order findById(OrderNo id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }

    @Override
    public List<Order> findByOrdererId(String ordererId, int startRow, int fetchSize) {
        final TypedQuery<Order> query = entityManager.createQuery(
            "select o from Order o where o.orderer.memberId.id = :ordererId order by o.number.number desc",
            Order.class
        );
        query.setParameter("ordererId", ordererId);
        query.setFirstResult(startRow);
        query.setMaxResults(fetchSize);

        return query.getResultList();
    }

    @Override
    public void delete(Order order) {
        entityManager.remove(order);
    }
}

package md.tekwill.finalSpringboot.order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    public Long countById(Integer id);
}

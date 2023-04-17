package md.tekwill.finalSpringboot.cart;

import org.springframework.data.repository.CrudRepository;
public interface CartRepository extends CrudRepository<Cart, Integer>{

    public Long countById(Integer id);


}

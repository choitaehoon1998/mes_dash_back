package mes.broanex.dash.repository;

import mes.broanex.dash.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}

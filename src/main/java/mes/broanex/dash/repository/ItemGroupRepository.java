package mes.broanex.dash.repository;

import mes.broanex.dash.entity.ItemGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemGroupRepository extends JpaRepository<ItemGroup, Long>, ItemGroupQueryRepository {
}

package mes.broanex.dash.repository;

import mes.broanex.dash.entity.WidgetGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WidgetGroupRepository extends JpaRepository<WidgetGroup, Long>, WidgetGroupQueryRepository {
}

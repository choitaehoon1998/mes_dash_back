package mes.broanex.dash.repository;

import mes.broanex.dash.entity.Widget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WidgetRepository extends JpaRepository<Widget, Long>, WidgetQueryRepository {
}

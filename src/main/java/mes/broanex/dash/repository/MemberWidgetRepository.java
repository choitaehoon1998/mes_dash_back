package mes.broanex.dash.repository;

import mes.broanex.dash.entity.MemberWidget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberWidgetRepository extends JpaRepository<MemberWidget, Long>, MemberWidgetQueryRepository {
}

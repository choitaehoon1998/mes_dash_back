package mes.broanex.dash.repository;

import mes.broanex.dash.entity.WidgetGroup;

import java.util.HashMap;
import java.util.List;

public interface WidgetGroupQueryRepository {
	List<WidgetGroup> findByParam(HashMap<String, Object> hashMap);
}

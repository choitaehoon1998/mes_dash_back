package mes.broanex.dash.repository;

import mes.broanex.dash.entity.Widget;

import java.util.HashMap;
import java.util.List;

public interface WidgetQueryRepository {
	List<Widget> findAllByParam(HashMap<String, Object> hashMap);
}

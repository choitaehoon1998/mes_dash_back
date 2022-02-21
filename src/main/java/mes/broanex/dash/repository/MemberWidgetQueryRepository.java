package mes.broanex.dash.repository;

import mes.broanex.dash.entity.MemberWidget;

import java.util.HashMap;
import java.util.List;

public interface MemberWidgetQueryRepository {
	List<MemberWidget> findAllByParam(HashMap<String, Object> hashMap);
}

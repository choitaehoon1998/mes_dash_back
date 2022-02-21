package mes.broanex.dash.repository;

import mes.broanex.dash.entity.ItemGroup;

import java.util.HashMap;
import java.util.List;

public interface ItemGroupQueryRepository {
	List<ItemGroup> findByParam(HashMap<String, Object> hashMap);
}

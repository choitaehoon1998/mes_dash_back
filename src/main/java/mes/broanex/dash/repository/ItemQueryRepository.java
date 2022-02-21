package mes.broanex.dash.repository;

import mes.broanex.dash.entity.Item;

import java.util.HashMap;
import java.util.List;

public interface ItemQueryRepository {
	List<Item> findAllByParam(HashMap<String, Object> hashMap);
}

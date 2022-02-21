package mes.broanex.dash.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import mes.broanex.dash.entity.Item;
import mes.broanex.dash.repository.ItemQueryRepository;

import java.util.HashMap;
import java.util.List;

import static mes.broanex.dash.entity.QItem.item;

@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemQueryRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<Item> findAllByParam(HashMap<String, Object> hashMap) {
		return queryFactory.selectFrom(item).fetch();
	}
}

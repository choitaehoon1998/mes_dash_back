package mes.broanex.dash.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import mes.broanex.dash.entity.ItemGroup;
import mes.broanex.dash.repository.ItemGroupQueryRepository;

import java.util.HashMap;
import java.util.List;

import static mes.broanex.dash.entity.QItemGroup.itemGroup;

@RequiredArgsConstructor
public class ItemGroupRepositoryImpl implements ItemGroupQueryRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<ItemGroup> findByParam(HashMap<String, Object> hashMap) {
		return queryFactory.selectFrom(itemGroup).fetch();
	}
}

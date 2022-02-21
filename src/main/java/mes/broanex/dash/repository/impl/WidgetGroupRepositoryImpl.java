package mes.broanex.dash.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import mes.broanex.dash.entity.WidgetGroup;
import mes.broanex.dash.repository.WidgetGroupQueryRepository;

import java.util.HashMap;
import java.util.List;

import static mes.broanex.dash.entity.QWidgetGroup.widgetGroup;

@RequiredArgsConstructor
public class WidgetGroupRepositoryImpl implements WidgetGroupQueryRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<WidgetGroup> findByParam(HashMap<String, Object> hashMap) {
		return queryFactory.selectFrom(widgetGroup).fetch();
	}
}

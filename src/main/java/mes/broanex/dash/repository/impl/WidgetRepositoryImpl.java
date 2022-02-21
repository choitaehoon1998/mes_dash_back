package mes.broanex.dash.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import mes.broanex.dash.entity.Widget;
import mes.broanex.dash.repository.WidgetQueryRepository;

import java.util.HashMap;
import java.util.List;

import static mes.broanex.dash.entity.QWidget.widget;

@RequiredArgsConstructor
public class WidgetRepositoryImpl implements WidgetQueryRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<Widget> findAllByParam(HashMap<String, Object> hashMap) {
		return queryFactory.selectFrom(widget).fetch();
	}
}

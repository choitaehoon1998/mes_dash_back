package mes.broanex.dash.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import mes.broanex.dash.entity.MemberWidget;
import mes.broanex.dash.repository.MemberWidgetQueryRepository;

import java.util.HashMap;
import java.util.List;

import static mes.broanex.dash.entity.QMemberWidget.memberWidget;

@RequiredArgsConstructor
public class MemberWidgetRepositoryImpl implements MemberWidgetQueryRepository {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<MemberWidget> findAllByParam(HashMap<String, Object> hashMap) {
		return queryFactory.selectFrom(memberWidget).fetch();
	}
}

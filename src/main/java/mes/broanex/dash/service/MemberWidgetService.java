package mes.broanex.dash.service;

import mes.broanex.dash.entity.MemberWidget;
import mes.broanex.dash.repository.MemberWidgetRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MemberWidgetService {

	private final MemberWidgetRepository memberWidgetRepository;

	public MemberWidgetService(MemberWidgetRepository memberWidgetRepository) {
		this.memberWidgetRepository = memberWidgetRepository;
	}

	public List<MemberWidget> findAllByParam(HashMap<String, Object> hashMap) {
		return memberWidgetRepository.findAllByParam(hashMap);
	}

	public void saveNewMemberWidget(MemberWidget memberWidget) {
		memberWidgetRepository.save(memberWidget);
	}

	public void updateMemberWidget(MemberWidget memberWidget) {
		if (memberWidget != null && memberWidget.getIndexNo() != null
				&& memberWidgetRepository.existsById(memberWidget.getIndexNo())) {
			memberWidgetRepository.save(memberWidget);
		}
	}
}

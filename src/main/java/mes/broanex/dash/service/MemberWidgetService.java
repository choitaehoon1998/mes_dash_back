package mes.broanex.dash.service;

import mes.broanex.dash.dto.MemberWidgetRequestDto;
import mes.broanex.dash.entity.MemberWidget;
import mes.broanex.dash.entity.Widget;
import mes.broanex.dash.repository.MemberWidgetRepository;
import mes.broanex.dash.repository.WidgetRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class MemberWidgetService {

	private final MemberWidgetRepository memberWidgetRepository;
	private final WidgetRepository widgetRepository;

	public MemberWidgetService(MemberWidgetRepository memberWidgetRepository, WidgetRepository widgetRepository) {
		this.memberWidgetRepository = memberWidgetRepository;
		this.widgetRepository = widgetRepository;
	}

	public List<MemberWidget> findAllByParam(HashMap<String, Object> hashMap) {
		return memberWidgetRepository.findAllByParam(hashMap);
	}

	public void saveNewMemberWidget(MemberWidgetRequestDto memberWIdgetRequestDto) {
		MemberWidget memberWidget = memberWidgetRepository.findMemberWidgetByMemberIndexNoAndWidget_IndexNo(memberWIdgetRequestDto.getMemberIndexNo(), memberWIdgetRequestDto.getWidgetIndexNo());
		if (memberWidget == null) {
			memberWidget = new MemberWidget();
			memberWidget.setPositionXStart(memberWIdgetRequestDto.getPositionXStart());
			memberWidget.setPositionXEnd(memberWidget.getPositionXEnd());
			memberWidget.setPositionYStart(memberWidget.getPositionYStart());
			memberWidget.setPositionYEnd(memberWidget.getPositionYEnd());
			memberWidget.setMemberIndexNo(1L);
			Optional<Widget> widgetOptional = widgetRepository.findById(memberWIdgetRequestDto.getWidgetIndexNo());
			if (widgetOptional.isPresent()) {
				memberWidget.setWidget(widgetOptional.get());
				memberWidgetRepository.save(memberWidget);
			}
		}
	}

	public void updateMemberWidget(MemberWidget memberWidget) {
		if (memberWidget != null && memberWidget.getIndexNo() != null
				&& memberWidgetRepository.existsById(memberWidget.getIndexNo())) {
			memberWidgetRepository.save(memberWidget);
		}
	}

	public void deleteMemberWidget(Long id) {
		MemberWidget memberWidget =
				memberWidgetRepository.findMemberWidgetByMemberIndexNoAndWidget_IndexNo(1L, id);
		if (memberWidget != null) {
			memberWidgetRepository.delete(memberWidget);
		}
	}
}

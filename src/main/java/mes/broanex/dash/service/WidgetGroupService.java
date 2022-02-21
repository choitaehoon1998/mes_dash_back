package mes.broanex.dash.service;

import mes.broanex.dash.entity.WidgetGroup;
import mes.broanex.dash.repository.WidgetGroupRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class WidgetGroupService {
	private final WidgetGroupRepository widgetGroupRepository;

	public WidgetGroupService(WidgetGroupRepository widgetGroupRepository) {
		this.widgetGroupRepository = widgetGroupRepository;
	}

	public List<WidgetGroup> getByParam(HashMap<String, Object> hashMap) {
		List<WidgetGroup> widgetGroupList = widgetGroupRepository.findByParam(hashMap);
		return widgetGroupList;
	}

	public void saveNewWidgetGroup(WidgetGroup widgetGroup) {
		widgetGroupRepository.save(widgetGroup);
	}

	public void updateWidgetGroup(WidgetGroup widgetGroup) {

	}
}

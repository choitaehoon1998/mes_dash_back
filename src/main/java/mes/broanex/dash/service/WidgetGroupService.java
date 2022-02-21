package mes.broanex.dash.service;

import mes.broanex.dash.entity.WidgetGroup;
import mes.broanex.dash.repository.WidgetGroupRepository;
import org.springframework.stereotype.Service;

@Service
public class WidgetGroupService {
	private final WidgetGroupRepository widgetGroupRepository;

	public WidgetGroupService(WidgetGroupRepository widgetGroupRepository) {
		this.widgetGroupRepository = widgetGroupRepository;
	}

	public void saveNewWidgetGroup(WidgetGroup widgetGroup) {
		widgetGroupRepository.save(widgetGroup);
	}
}

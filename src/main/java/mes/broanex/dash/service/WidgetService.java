package mes.broanex.dash.service;

import mes.broanex.dash.entity.Widget;
import mes.broanex.dash.repository.WidgetRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class WidgetService {
	private final WidgetRepository widgetRepository;

	public WidgetService(WidgetRepository widgetRepository) {
		this.widgetRepository = widgetRepository;
	}

	public List<Widget> getAllByParam(HashMap<String, Object> hashMap) {
		return widgetRepository.findAllByParam(hashMap);
	}

	public void saveNewWidget(Widget widget) {
		widgetRepository.save(widget);
	}
}

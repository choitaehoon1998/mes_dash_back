package mes.broanex.dash.controller;

import mes.broanex.dash.entity.WidgetGroup;
import mes.broanex.dash.service.WidgetGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class WidgetGroupController {
	private final WidgetGroupService widgetGroupService;

	public WidgetGroupController(WidgetGroupService widgetGroupService) {
		this.widgetGroupService = widgetGroupService;
	}

	@PostMapping(value = "/widgetGroup")
	public ResponseEntity<Void> saveNewWidgetGroup(@RequestBody WidgetGroup widgetGroup) {
		widgetGroupService.saveNewWidgetGroup(widgetGroup);
		return ok().build();
	}

}

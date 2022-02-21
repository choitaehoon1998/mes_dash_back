package mes.broanex.dash.controller;

import mes.broanex.dash.entity.WidgetGroup;
import mes.broanex.dash.service.WidgetGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class WidgetGroupController {
	private final WidgetGroupService widgetGroupService;

	public WidgetGroupController(WidgetGroupService widgetGroupService) {
		this.widgetGroupService = widgetGroupService;
	}

	@GetMapping(value = "/widgetGroup")
	public ResponseEntity<List<WidgetGroup>> getWidgetGroupByParam() {
		List<WidgetGroup> widgetGroupList = widgetGroupService.getByParam(new HashMap<String, Object>() {{
			put("aa", "aa");
		}});
		return ok(widgetGroupList);
	}

	@PostMapping(value = "/widgetGroup", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> saveNewWidgetGroup(@RequestPart(value = "widgetGroup") WidgetGroup widgetGroup) {
		widgetGroupService.saveNewWidgetGroup(widgetGroup);
		return ok().build();
	}

	@PutMapping(value = "/widgetGroup")
	public ResponseEntity<Void> updateWidgetGroup(@RequestBody WidgetGroup widgetGroup) {
		widgetGroupService.updateWidgetGroup(widgetGroup);
		return ok().build();
	}

}

package mes.broanex.dash.controller;

import mes.broanex.dash.entity.Widget;
import mes.broanex.dash.service.WidgetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class WidgetController {
	private final WidgetService widgetService;

	public WidgetController(WidgetService widgetService) {
		this.widgetService = widgetService;
	}

	@GetMapping(value = "/widget")
	public ResponseEntity<List<Widget>> getAllWidgetByParam() {
		List<Widget> widgetList = widgetService.getAllByParam(new HashMap<String, Object>() {{
			put("aa", "aa");
		}});
		return ok(widgetList);
	}

	@PostMapping(value = "/widget", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> saveNewWidget(@RequestPart(value = "widget") Widget widget) {
		widgetService.saveNewWidget(widget);
		return ok().build();
	}
}

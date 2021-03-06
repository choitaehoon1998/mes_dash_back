package mes.broanex.dash.controller;

import mes.broanex.dash.dto.MemberWidgetRequestDto;
import mes.broanex.dash.entity.MemberWidget;
import mes.broanex.dash.service.MemberWidgetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class MemberWidgetController {
	private final MemberWidgetService memberWidgetService;

	public MemberWidgetController(MemberWidgetService memberWidgetService) {
		this.memberWidgetService = memberWidgetService;
	}

	@GetMapping(value = "/memberWidget")
	public ResponseEntity<List<MemberWidget>> getMemberWidgetByParam() {
		List<MemberWidget> memberWidgetList = memberWidgetService.findAllByParam(new HashMap<String, Object>() {{
			put("aa", "aa");
		}});
		return ok(memberWidgetList);
	}

	@PostMapping(value = "/memberWidget", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> saveNewMemberWidget(
			@RequestPart(value = "memberWidget") MemberWidgetRequestDto memberWIdgetRequestDto) {
		memberWidgetService.saveNewMemberWidget(memberWIdgetRequestDto);
		return ok().build();
	}

	@PutMapping(value = "/memberWidget")
	public ResponseEntity<Void> updateMemberWidget(@RequestBody MemberWidget memberWidget) {
		memberWidgetService.updateMemberWidget(memberWidget);
		return ok().build();
	}

	@DeleteMapping(value = "/memberWidget/{widgetId}")
	public ResponseEntity<Void> deleteMemberWidget(@PathVariable(name = "widgetId") Long widgetId) {
		memberWidgetService.deleteMemberWidget(widgetId);
		return ok().build();
	}
}

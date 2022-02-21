package mes.broanex.dash.controller;

import mes.broanex.dash.entity.ItemGroup;
import mes.broanex.dash.service.ItemGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.ResponseEntity.ok;


@RestController
public class ItemGroupController {
	private final ItemGroupService itemGroupService;

	public ItemGroupController(ItemGroupService itemGroupService) {
		this.itemGroupService = itemGroupService;
	}

	@GetMapping(value = "/itemGroup")
	public ResponseEntity<List<ItemGroup>> GetItemGroupByParam() {
		List<ItemGroup> itemGroupList = itemGroupService.GetItemGroupByParam(new HashMap<String, Object>() {{
			put("aa", "aa");
		}});
		return ok(itemGroupList);
	}

	@PostMapping(value = "/itemGroup", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> saveNewItemGroup(@RequestPart(value = "itemGroup") ItemGroup itemGroup) {
		itemGroupService.saveNewItemGroup(itemGroup);
		return ok().build();
	}
}

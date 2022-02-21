package mes.broanex.dash.controller;

import mes.broanex.dash.entity.ItemGroup;
import mes.broanex.dash.service.ItemGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;


@RestController
public class ItemGroupController {
	private final ItemGroupService itemGroupService;

	public ItemGroupController(ItemGroupService itemGroupService) {
		this.itemGroupService = itemGroupService;
	}

	@PostMapping(value = "/itemGroup")
	public ResponseEntity<Void> saveNewItemGroup(@RequestBody ItemGroup itemGroup) {
		itemGroupService.saveNewItemGroup(itemGroup);
		return ok().build();
	}
}

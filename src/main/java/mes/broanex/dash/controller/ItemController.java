package mes.broanex.dash.controller;

import mes.broanex.dash.entity.Item;
import mes.broanex.dash.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class ItemController {
	private final ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@PostMapping("/item")
	public ResponseEntity<Void> saveNewItem(@RequestBody Item item) {
		itemService.saveNewItem(item);
		return ok().build();
	}
}

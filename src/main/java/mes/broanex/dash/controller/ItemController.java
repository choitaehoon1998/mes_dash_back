package mes.broanex.dash.controller;

import mes.broanex.dash.entity.Item;
import mes.broanex.dash.service.ItemService;
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
public class ItemController {
	private final ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@GetMapping(value = "/item")
	public ResponseEntity<List<Item>> getAllItemByParam() {
		List<Item> itemList = itemService.getAllByParam(new HashMap<String, Object>() {{
			put("aa", "aa");
		}});
		return ok(itemList);
	}

	@PostMapping(value = "/item", consumes = MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> saveNewItem(@RequestPart(value = "item") Item item) {
		itemService.saveNewItem(item);
		return ok().build();
	}
}

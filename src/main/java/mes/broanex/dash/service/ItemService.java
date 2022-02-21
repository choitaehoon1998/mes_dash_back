package mes.broanex.dash.service;

import mes.broanex.dash.entity.Item;
import mes.broanex.dash.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	private final ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public void saveNewItem(Item item) {
		itemRepository.save(item);
	}
}

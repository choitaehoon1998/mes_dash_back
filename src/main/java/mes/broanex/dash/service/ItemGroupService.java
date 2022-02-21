package mes.broanex.dash.service;

import mes.broanex.dash.entity.ItemGroup;
import mes.broanex.dash.repository.ItemGroupRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemGroupService {

	private final ItemGroupRepository itemGroupRepository;

	public ItemGroupService(ItemGroupRepository itemGroupRepository) {
		this.itemGroupRepository = itemGroupRepository;
	}

	public void saveNewItemGroup(ItemGroup itemGroup) {
		itemGroupRepository.save(itemGroup);
	}
}

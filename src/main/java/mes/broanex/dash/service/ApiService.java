package mes.broanex.dash.service;

import mes.broanex.dash.dto.WidgetResponseDto;
import mes.broanex.dash.entity.Item;
import mes.broanex.dash.entity.ItemGroup;
import mes.broanex.dash.entity.MemberWidget;
import mes.broanex.dash.entity.Widget;
import mes.broanex.dash.repository.MemberWidgetRepository;
import mes.broanex.dash.repository.WidgetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ApiService {
	private final MemberWidgetRepository memberWidgetRepository;
	private final WidgetRepository widgetRepository;

	public ApiService(MemberWidgetRepository memberWidgetRepository, WidgetRepository widgetRepository) {
		this.memberWidgetRepository = memberWidgetRepository;
		this.widgetRepository = widgetRepository;
	}

	public List<HashMap<String,Object>> getByParam(HashMap<String, Object> hashMap) {
		List<MemberWidget> memberWidgetList = memberWidgetRepository.findAllByParam(new HashMap<String, Object>() {{
		}});

		List<HashMap<String,Object>> returnList = new ArrayList<>();
		String typeYn = (String) hashMap.get("typeYn");
		String positionYn = (String) hashMap.get("positionYn");
		String dataColumnYn = (String) hashMap.get("dataColumnYn");
		for (MemberWidget memberWidget : memberWidgetList) {
			HashMap<String, Object> returnMap = new HashMap<>();

			Widget widget = memberWidget.getWidget();
			returnMap.put("name", widget.getName());
			returnMap.put("id", widget.getIndexNo());

			List<String> columnList = new ArrayList<>();
			if (typeYn.equals("Y")) {
				returnMap.put("type", widget.getType().getCode());
			}
			if (positionYn.equals("Y")) {
				HashMap<String, Long> positionMap = new HashMap<String, Long>() {{
					put("positionXStart", memberWidget.getPositionXStart());
					put("positionYStart", memberWidget.getPositionYStart());
					put("positionXEnd", memberWidget.getPositionXEnd());
					put("positionYEnd", memberWidget.getPositionYEnd());
				}};
				returnMap.put("position", positionMap);
			}


			if (dataColumnYn.equals("Y")) {
				List<Object> objectList = new ArrayList<>();

				List<ItemGroup> itemGroupList = widget.getItemGroupList();
				for (ItemGroup itemGroup : itemGroupList) {
					HashMap<String, Object> columnMap = new HashMap<>();
					Item item = itemGroup.getItem();
					columnMap.put("columnName", item.getName());
					columnList.add(item.getName());
					columnMap.put("order", itemGroup.getOrder());
					objectList.add(columnMap);
				}
				if (objectList.size() != 0) {
					returnMap.put("column", objectList);
				}
				List<Object> dataList = new ArrayList<>();

				HashMap<String, Object> dataMap = new HashMap<>();
				if (columnList.size() != 0) {
					for (String string : columnList) {
						dataMap.put(string, "1");
					}
					dataList.add(dataMap);
					dataList.add(dataMap);
					dataList.add(dataMap);
					dataList.add(dataMap);
					dataList.add(dataMap);
					returnMap.put("data", dataList);
				}
			}
			returnList.add(returnMap);
		}
		return returnList;
	}

	public List<WidgetResponseDto> getAllWidget() {
		List<WidgetResponseDto> widgetList = widgetRepository.findReturnAsResponseDto();
		return widgetList;
	}
}

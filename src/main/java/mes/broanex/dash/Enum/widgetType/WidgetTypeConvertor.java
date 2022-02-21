package mes.broanex.dash.Enum.widgetType;

import mes.broanex.dash.entity.WidgetGroup;

import javax.persistence.AttributeConverter;
import java.util.EnumSet;
import java.util.NoSuchElementException;

public class WidgetTypeConvertor implements AttributeConverter<WidgetType, String> {
	@Override
	public String convertToDatabaseColumn(WidgetType attribute) {
		return attribute.getCode();
	}

	@Override
	public WidgetType convertToEntityAttribute(String dbData) {
		return EnumSet.allOf(WidgetType.class).stream()
				.filter(e -> e.getCode().equals(dbData))
				.findAny()
				.orElseThrow(NoSuchElementException::new);
	}
}

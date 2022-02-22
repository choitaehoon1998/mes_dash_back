package mes.broanex.dash.dto;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;
import mes.broanex.dash.Enum.widgetType.WidgetType;

@Getter
@Setter
public class WidgetResponseDto {

	private Long id;
	private String type;
	private String name;

	@QueryProjection
	public WidgetResponseDto(long id, WidgetType type, String name) {
		this.id = id;
		this.type = type.getCode();
		this.name = name;
	}
}

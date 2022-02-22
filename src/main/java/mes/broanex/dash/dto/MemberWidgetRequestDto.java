package mes.broanex.dash.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberWidgetRequestDto {

	private Long positionXStart;
	private Long positionXEnd;
	private Long positionYStart;
	private Long positionYEnd;
	private Long memberIndexNo;
	private Long widgetIndexNo;
}

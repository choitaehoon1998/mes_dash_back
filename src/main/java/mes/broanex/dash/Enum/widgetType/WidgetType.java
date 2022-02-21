package mes.broanex.dash.Enum.widgetType;

import mes.broanex.dash.Enum.CodeValue;

public enum WidgetType implements CodeValue {
	C("CHART", "차트"),
	D("DATA", "데이터"),
	G("GRID", "그리드");

	private String code;
	private String value;

	WidgetType(String code, String value) {
		this.code = code;
		this.value = value;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getValue() {
		return value;
	}
}

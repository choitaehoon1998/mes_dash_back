package mes.broanex.dash.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "WIDGET_GROUP")
@Getter
@Setter
public class WidgetGroup {
	@Id
	@Column(name = "INDEX_NO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long indexNo;

	@Column(name = "NAME")
	private String name;

	@OneToMany(mappedBy = "widgetGroup")
	private List<Widget> widgetList = new ArrayList<>();
}

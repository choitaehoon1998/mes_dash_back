package mes.broanex.dash.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "WIDGET")
public class Widget {

	@Id
	@Column(name = "INDEX_NO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long indexNo;

	@Column(name = "NAME")
	@NotNull
	private String name;

	@ManyToOne
	@JoinColumn(name = "WIDGET_GROUP_INDEX_NO")
	@NotNull
	private WidgetGroup widgetGroup;

	@OneToMany(mappedBy = "widget")
	private List<ItemGroup> itemGroupList = new ArrayList<>();
}

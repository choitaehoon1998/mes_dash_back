package mes.broanex.dash.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import lombok.Getter;
import mes.broanex.dash.Enum.widgetType.WidgetType;
import mes.broanex.dash.Enum.widgetType.WidgetTypeConvertor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "WIDGET")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "indexNo")
@Getter
public class Widget {

	@Id
	@Column(name = "INDEX_NO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long indexNo;

	@Column(name = "TYPE")
	@NotNull
	@Convert(converter = WidgetTypeConvertor.class)
	private WidgetType type;

	@Column(name = "NAME")
	@NotNull
	private String name;

	@ManyToOne
	@JoinColumn(name = "WIDGET_GROUP_INDEX_NO")
	@JsonBackReference
	@NotNull
	private WidgetGroup widgetGroup;

	@JsonManagedReference
	@OneToMany(mappedBy = "widget")
	private List<ItemGroup> itemGroupList = new ArrayList<>();

}

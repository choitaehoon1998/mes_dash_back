package mes.broanex.dash.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "WIDGET_GROUP")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "indexNo")
@Getter
@Setter
public class WidgetGroup {
	@Id
	@Column(name = "INDEX_NO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long indexNo;

	@Column(name = "NAME")
	private String name;

	@JsonManagedReference
	@OneToMany(mappedBy = "widgetGroup")
	private List<Widget> widgetList = new ArrayList<>();
}

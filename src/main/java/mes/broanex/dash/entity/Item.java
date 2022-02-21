package mes.broanex.dash.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ITEM")
public class Item {
	@Id
	@Column(name = "INDEX_NO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long indexNo;

	@Column(name = "NAME")
	@NotNull
	private String name;

	@OneToMany(mappedBy = "item")
	private List<ItemGroup> itemGroupList = new ArrayList<>();
}

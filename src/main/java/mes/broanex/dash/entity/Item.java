package mes.broanex.dash.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ITEM")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "indexNo")
@Getter
public class Item {
	@Id
	@Column(name = "INDEX_NO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long indexNo;

	@Column(name = "NAME")
	@NotNull
	private String name;

	@OneToMany(mappedBy = "item")
	@JsonManagedReference
	private List<ItemGroup> itemGroupList = new ArrayList<>();
}

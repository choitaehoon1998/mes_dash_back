package mes.broanex.dash.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_GROUP", uniqueConstraints = @UniqueConstraint(columnNames = {"ITEM_INDEX_NO", "WIDGET_INDEX_NO"}))
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "indexNo")
@Getter
public class ItemGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "INDEX_NO")
	private Long indexNo;

	@ManyToOne
	@JoinColumn(name = "ITEM_INDEX_NO")
	@NotNull
	@JsonBackReference
	private Item item;

	@ManyToOne
	@JoinColumn(name = "WIDGET_INDEX_NO")
	@NotNull
	@JsonBackReference
	private Widget widget;

	@Column(name="ORDER")
	private Long order;
}

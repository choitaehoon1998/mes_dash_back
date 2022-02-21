package mes.broanex.dash.entity;


import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_GROUP", uniqueConstraints = @UniqueConstraint(columnNames = {"ITEM_INDEX_NO", "WIDGET_INDEX_NO"}))
public class ItemGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "INDEX_NO")
	private Long indexNo;

	@ManyToOne
	@JoinColumn(name = "ITEM_INDEX_NO")
	@NotNull
	private Item item;

	@ManyToOne
	@JoinColumn(name = "WIDGET_INDEX_NO")
	@NotNull
	private Widget widget;
}

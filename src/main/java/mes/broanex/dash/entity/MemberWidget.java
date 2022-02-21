package mes.broanex.dash.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "MEMBER_WIDGET", uniqueConstraints = @UniqueConstraint(columnNames = {"MEMBER_INDEX_NO", "WIDGET_INDEX_NO"}))
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "indexNo")
@Getter
public class MemberWidget {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "INDEX_NO")
	private Long indexNo;

	@Column(name = "POSITION_X_START")
	private Long positionXStart;

	@Column(name = "POSITION_X_END")
	private Long positionXEnd;

	@Column(name = "POSITION_Y_START")
	private Long positionYStart;

	@Column(name = "POSITION_Y_END")
	private Long positionYEnd;

//	@ManyToOne
//	@JoinColumn(name = "MEMBER_INDEX_NO")
//	private User user;

	@Column(name = "MEMBER_INDEX_NO")
	private Long memberIndexNo;

	@ManyToOne
	@JoinColumn(name = "WIDGET_INDEX_NO")
	@JsonBackReference
	private Widget widget;
}

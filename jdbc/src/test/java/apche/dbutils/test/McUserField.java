package apche.dbutils.test;

import com.zl.core.base.utils.utilRandom;
import com.zl.core.base.utils.utilTime;
/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;*/

/**
 * McUserField entity. @author MyEclipse Persistence Tools
 */
/*@Entity
@Table(name = "MC_USER_FIELD", schema = "JPA")*/
public class McUserField implements java.io.Serializable {

	// Fields
	utilTime tt=new utilTime();

	private Integer id;
	private String name=new utilRandom().GeneratePassworrd3(5);
	private String sortOrder=new utilRandom().GeneratePassworrd3(5);
	private String required=new utilRandom().GeneratePassworrd3(5);
	private String visible=new utilRandom().GeneratePassworrd3(5);

	// Constructors

	/** default constructor */
	public McUserField() {
	}

	/** full constructor */
	public McUserField(String name, String sortOrder, String required,
			String visible) {
		this.name = name;
		this.sortOrder = sortOrder;
		this.required = required;
		this.visible = visible;
	}

	// Property accessors
/*	@SequenceGenerator(name = "generator")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)*/
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

/*	@Column(name = "NAME", length = 80)*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	@Column(name = "SORT_ORDER", length = 80)
	public String getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

//	@Column(name = "REQUIRED", length = 80)
	public String getRequired() {
		return this.required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

//	@Column(name = "VISIBLE", length = 80)
	public String getVisible() {
		return this.visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

}
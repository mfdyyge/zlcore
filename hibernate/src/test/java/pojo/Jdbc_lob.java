package pojo;


/**
 *
 */

import javax.persistence.Entity;

import java.sql.Blob;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @ClassName: BlobTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhoushun
 * @date 2013-4-3 上午11:15:38
 *
 */
@Entity
@Table(name = "T_FUNC_XT_YWDXSM")
public class Jdbc_lob implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private byte[] img;
    private String remarke;
    private String id;



    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "REMARKE", nullable = true, length = 5000)
    public String getRemarke() {
        return remarke;
    }

    public void setRemarke(String remarke) {
        this.remarke = remarke;
    }

    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name="IMG", columnDefinition="BLOB", nullable=true)
    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] imgs) {
        this.img = imgs;
    }



}

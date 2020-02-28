package cn.stylefeng.guns.modular.demos.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author www
 * @since 2020-02-25
 */
@TableName("test_con")
public class TestCon implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "Id", type = IdType.ID_WORKER)
    private Integer Id;

    @TableField("Name")
    private String Name;

    @TableField("ConId")
    private Integer ConId;

    @TableField("Sman")
    private String Sman;

    @TableField("ConDate")
    private Date ConDate;

    @TableField("Eman")
    private String Eman;

    @TableField("ConSignDate")
    private Date ConSignDate;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Integer getConId() {
        return ConId;
    }

    public void setConId(Integer ConId) {
        this.ConId = ConId;
    }

    public String getSman() {
        return Sman;
    }

    public void setSman(String Sman) {
        this.Sman = Sman;
    }

    public Date getConDate() {
        return ConDate;
    }

    public void setConDate(Date ConDate) {
        this.ConDate = ConDate;
    }

    public String getEman() {
        return Eman;
    }

    public void setEman(String Eman) {
        this.Eman = Eman;
    }

    public Date getConSignDate() {
        return ConSignDate;
    }

    public void setConSignDate(Date ConSignDate) {
        this.ConSignDate = ConSignDate;
    }

    @Override
    public String toString() {
        return "TestCon{" +
        "Id=" + Id +
        ", Name=" + Name +
        ", ConId=" + ConId +
        ", Sman=" + Sman +
        ", ConDate=" + ConDate +
        ", Eman=" + Eman +
        ", ConSignDate=" + ConSignDate +
        "}";
    }
}

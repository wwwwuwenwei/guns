package cn.stylefeng.guns.modular.demos.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author www
 * @since 2020-02-25
 */
@Data
public class TestConParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    private Integer Id;

    private String Name;

    private Integer ConId;

    private String Sman;

    private Date ConDate;

    private String Eman;

    private Date ConSignDate;

    @Override
    public String checkParam() {
        return null;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public Integer getConId() {
        return ConId;
    }

    public String getSman() {
        return Sman;
    }

    public Date getConDate() {
        return ConDate;
    }

    public String getEman() {
        return Eman;
    }

    public Date getConSignDate() {
        return ConSignDate;
    }
}

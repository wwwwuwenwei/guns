package cn.stylefeng.guns.modular.demos.model.result;

import lombok.Data;
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
public class TestConResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer Id;

    private String Name;

    private Integer ConId;

    private String Sman;

    private Date ConDate;

    private String Eman;

    private Date ConSignDate;

}

package cn.stylefeng.guns.modular.signature.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 签名表
 * </p>
 *
 * @author 
 * @since 2020-02-28
 */
@Data
public class SignatureResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 签名路径 签名存放路径
     */
    private String url;

    /**
     * 是否默认 0.否 1.是
     */
    private String isDefault;

    /**
     * 用户编号
     */
    private String memberId;

}

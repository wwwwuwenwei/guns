package cn.stylefeng.guns.modular.signature.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
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
public class SignatureParam implements Serializable, BaseValidatingParam {

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

    @Override
    public String checkParam() {
        return null;
    }

    public Integer getId() {
        return id;
    }

    public String getMemberId() {
        return memberId;
    }
}

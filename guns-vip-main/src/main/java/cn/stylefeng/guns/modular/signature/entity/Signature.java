package cn.stylefeng.guns.modular.signature.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 签名表
 * </p>
 *
 * @author 
 * @since 2020-02-28
 */
@TableName("signature")
public class Signature implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 签名路径 签名存放路径
     */
    @TableField("url")
    private String url;

    /**
     * 是否默认 0.否 1.是
     */
    @TableField("is_default")
    private String isDefault;

    /**
     * 用户编号
     */
    @TableField("member_id")
    private String memberId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "Signature{" +
        "id=" + id +
        ", url=" + url +
        ", isDefault=" + isDefault +
        ", memberId=" + memberId +
        "}";
    }
}

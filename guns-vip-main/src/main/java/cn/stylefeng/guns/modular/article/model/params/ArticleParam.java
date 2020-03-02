package cn.stylefeng.guns.modular.article.model.params;

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
 * @author 
 * @since 2020-02-28
 */
@Data
public class ArticleParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    private String content;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 创建时间
     */
    private Date createDate;

    private String articleKey;

    private String name;

    private Integer id;

    @Override
    public String checkParam() {
        return null;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }
}

package cn.stylefeng.guns.modular.article.model.result;

import lombok.Data;
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
public class ArticleResult implements Serializable {

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

}

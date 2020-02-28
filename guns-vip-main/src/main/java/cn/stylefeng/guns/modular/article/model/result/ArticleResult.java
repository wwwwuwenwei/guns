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
 * @author www
 * @since 2020-02-27
 */
@Data
public class ArticleResult implements Serializable {

    private static final long serialVersionUID = 1L;


    private String content;

    private Date lastdate;

    private Date cratedate;

    private String articleKey;

    private String name;

    private Integer id;

}

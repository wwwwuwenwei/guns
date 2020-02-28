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
 * @author www
 * @since 2020-02-27
 */
@Data
public class ArticleParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    private transient String content;

    private Date lastdate;

    private Date cratedate;

    private String articleKey;

    private String name;

    private Integer id;

    @Override
    public String checkParam() {
        return null;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }

    public void setCratedate(Date cratedate) {
        this.cratedate = cratedate;
    }

    public void setArticleKey(String articleKey) {
        this.articleKey = articleKey;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLastdate() {
        return lastdate;
    }

    public Date getCratedate() {
        return cratedate;
    }

    public String getArticleKey() {
        return articleKey;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}

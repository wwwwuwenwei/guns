package cn.stylefeng.guns.modular.article.entity;

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
 * @since 2020-02-27
 */
@TableName("article")
public class Article implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("content")
    private String content;

    @TableField("lastdate")
    private Date lastdate;

    @TableField("cratedate")
    private Date cratedate;

    @TableField("article_key")
    private String articleKey;

    @TableField("name")
    private String name;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }

    public Date getCratedate() {
        return cratedate;
    }

    public void setCratedate(Date cratedate) {
        this.cratedate = cratedate;
    }

    public String getArticleKey() {
        return articleKey;
    }

    public void setArticleKey(String articleKey) {
        this.articleKey = articleKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Article{" +
        "content=" + content +
        ", lastdate=" + lastdate +
        ", cratedate=" + cratedate +
        ", articleKey=" + articleKey +
        ", name=" + name +
        ", id=" + id +
        "}";
    }
}

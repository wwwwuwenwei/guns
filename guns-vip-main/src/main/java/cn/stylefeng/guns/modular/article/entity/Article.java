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
 * @author 
 * @since 2020-02-28
 */
@TableName("article")
public class Article implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("content")
    private String content;

    /**
     * 更新时间
     */
    @TableField("update_date")
    private Date updateDate;

    /**
     * 创建时间
     */
    @TableField("create_date")
    private Date createDate;

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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
        ", updateDate=" + updateDate +
        ", createDate=" + createDate +
        ", articleKey=" + articleKey +
        ", name=" + name +
        ", id=" + id +
        "}";
    }
}

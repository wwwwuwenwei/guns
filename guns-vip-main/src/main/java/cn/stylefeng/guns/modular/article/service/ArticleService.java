package cn.stylefeng.guns.modular.article.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.article.entity.Article;
import cn.stylefeng.guns.modular.article.model.params.ArticleParam;
import cn.stylefeng.guns.modular.article.model.result.ArticleResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author www
 * @since 2020-02-27
 */
public interface ArticleService extends IService<Article> {

    /**
     * 新增
     *
     * @author www
     * @Date 2020-02-27
     */
    void add(ArticleParam param);

    /**
     * 删除
     *
     * @author www
     * @Date 2020-02-27
     */
    void delete(ArticleParam param);

    /**
     * 更新
     *
     * @author www
     * @Date 2020-02-27
     */
    void update(ArticleParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author www
     * @Date 2020-02-27
     */
    ArticleResult findBySpec(ArticleParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author www
     * @Date 2020-02-27
     */
    List<ArticleResult> findListBySpec(ArticleParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author www
     * @Date 2020-02-27
     */
     LayuiPageInfo findPageBySpec(ArticleParam param);

    /**
     * 获取文章列表
     * @param condition
     * @return
     */
    Page<Map<String, Object>> articleList(String condition);

    Map<String, Object> articleByKey(String key);

}

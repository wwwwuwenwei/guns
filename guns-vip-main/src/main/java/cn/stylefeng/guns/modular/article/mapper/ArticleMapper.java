package cn.stylefeng.guns.modular.article.mapper;

import cn.stylefeng.guns.modular.article.entity.Article;
import cn.stylefeng.guns.modular.article.model.params.ArticleParam;
import cn.stylefeng.guns.modular.article.model.result.ArticleResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author www
 * @since 2020-02-27
 */
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 获取列表
     *
     * @author www
     * @Date 2020-02-27
     */
    List<ArticleResult> customList(@Param("paramCondition") ArticleParam paramCondition);

    /**
     * 获取map列表
     *
     * @author www
     * @Date 2020-02-27
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") ArticleParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author www
     * @Date 2020-02-27
     */
    Page<ArticleResult> customPageList(@Param("page") Page page, @Param("paramCondition") ArticleParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author www
     * @Date 2020-02-27
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") ArticleParam paramCondition);

    /**
     * 获取文章列表
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    Page<Map<String, Object>> articleList(@Param("page") Page page, @Param("condition") String condition);

    Map<String, Object> articleByKey(@Param("key") String key);

}

package cn.stylefeng.guns.modular.article.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.article.entity.Article;
import cn.stylefeng.guns.modular.article.mapper.ArticleMapper;
import cn.stylefeng.guns.modular.article.model.params.ArticleParam;
import cn.stylefeng.guns.modular.article.model.result.ArticleResult;
import  cn.stylefeng.guns.modular.article.service.ArticleService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author www
 * @since 2020-02-27
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public void add(ArticleParam param){
        Article entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(ArticleParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(ArticleParam param){
        Article oldEntity = getOldEntity(param);
        Article newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public ArticleResult findBySpec(ArticleParam param){
        return null;
    }

    @Override
    public List<ArticleResult> findListBySpec(ArticleParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(ArticleParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(ArticleParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Article getOldEntity(ArticleParam param) {
        return this.getById(getKey(param));
    }

    private Article getEntity(ArticleParam param) {
        Article entity = new Article();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

    /**
     * 获取文章列表
     * @param condition
     * @return
     */
    @Override
    public Page<Map<String, Object>> articleList(String condition) {
        Page page = LayuiPageFactory.defaultPage();
        return this.baseMapper.articleList(page,condition);
    }

    @Override
    public Map<String, Object> articleByKey(String key) {
        return this.baseMapper.articleByKey(key);
    }

}

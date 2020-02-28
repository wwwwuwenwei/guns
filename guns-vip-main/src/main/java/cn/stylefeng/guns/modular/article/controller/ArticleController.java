package cn.stylefeng.guns.modular.article.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.article.entity.Article;
import cn.stylefeng.guns.modular.article.model.params.ArticleParam;
import cn.stylefeng.guns.modular.article.service.ArticleService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import com.baomidou.mybatisplus.core.toolkit.sql.StringEscape;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 控制器
 *
 * @author www
 * @Date 2020-02-27 10:12:20
 */
@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {

    private String PREFIX = "/article";

    @Autowired
    private ArticleService articleService;

    /**
     * 跳转到主页面
     *
     * @author www
     * @Date 2020-02-27
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/article.html";
    }

    /**
     * 新增页面
     *
     * @author www
     * @Date 2020-02-27
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/article_add.html";
    }

    /**
     * 编辑页面
     *
     * @author www
     * @Date 2020-02-27
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/article_edit.html";
    }

    /**
     * 新增接口
     *
     * @author www
     * @Date 2020-02-27
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(ArticleParam articleParam) {
        String content = articleParam.getContent().replace("& ","&");
        articleParam.setContent(StringEscapeUtils.unescapeHtml4(content));
        this.articleService.add(articleParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author www
     * @Date 2020-02-27
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(ArticleParam articleParam) {
        String content = articleParam.getContent().replace("& ","&");
        articleParam.setContent(StringEscapeUtils.unescapeHtml4(content));
        this.articleService.update(articleParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author www
     * @Date 2020-02-27
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(ArticleParam articleParam) {
        this.articleService.delete(articleParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author www
     * @Date 2020-02-27
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(ArticleParam articleParam) {
        Article detail = this.articleService.getById(articleParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author www
     * @Date 2020-02-27
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(ArticleParam articleParam) {
        return this.articleService.findPageBySpec(articleParam);
    }

}



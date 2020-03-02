package cn.stylefeng.guns.modular.article.controller;

import cn.stylefeng.guns.modular.article.entity.Article;
import cn.stylefeng.guns.modular.article.service.ArticleService;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author WWW
 */
@RestController
public class ArticleAppController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/getArticleByKey")
    public ResponseData getArticleInfo(@RequestParam(value = "key") String key) {
        try {
            Article article = null;
            article = this.articleService.getArticleByKey(key);
            if (article != null ) {
                return ResponseData.success(article);
            } else {
                return ResponseData.error("未找到key");
            }
        } catch (Exception e) {
            return ResponseData.error(e.getMessage());
        }
    }
}

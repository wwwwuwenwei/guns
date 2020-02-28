package cn.stylefeng.guns.modular.apps;

import cn.stylefeng.guns.modular.article.entity.Article;
import cn.stylefeng.guns.modular.article.service.ArticleService;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ArticleAppController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article/getArticleByKey")
    public ResponseData getArticleInfo(@RequestParam(value="key") String key){
        Map<String, Object> result = null;
        result = this.articleService.articleByKey(key);
        if(result!=null){
            return ResponseData.success(0,"请求成功",result.get("content"));
        }else {
            return ResponseData.error("请求失败");
        }
    }
}

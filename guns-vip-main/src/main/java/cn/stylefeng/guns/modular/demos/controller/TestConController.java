package cn.stylefeng.guns.modular.demos.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.modular.demos.entity.TestCon;
import cn.stylefeng.guns.modular.demos.model.params.TestConParam;
import cn.stylefeng.guns.modular.demos.model.result.TestConResult;
import cn.stylefeng.guns.modular.demos.service.TestConService;
import cn.stylefeng.guns.modular.demos.warpper.ConWrapper;
import cn.stylefeng.guns.sys.core.exception.enums.BizExceptionEnum;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import org.omg.PortableServer.POAPackage.ObjectAlreadyActive;
import org.springframework.ui.Model;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Map;


/**
 * 控制器
 *
 * @author www
 * @Date 2020-02-25 11:54:35
 */
@Controller
@RequestMapping("/testCon")
public class TestConController extends BaseController {

    private String PREFIX = "/testCon";

    @Autowired
    private TestConService testConService;

    /**
     * 跳转到主页面
     *
     * @author www
     * @Date 2020-02-25
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/testCon.html";
    }

    /**
     * 新增页面
     *
     * @author www
     * @Date 2020-02-25
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/testCon_add.html";
    }

    /**
     * 编辑页面
     *
     * @author www
     * @Date 2020-02-25
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/testCon_edit.html";
    }

    /**
     * 查看详情接口
     *
     * @author www
     * @Date 2020-02-25
     */
    @RequestMapping("/detail/{Id}")
    public String detail(@PathVariable(value = "Id") String id, Model model) {
        if (ToolUtil.isEmpty(id)) {
            throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
        }
        model.addAttribute("Id",id);
        return PREFIX + "/testCon_detail.html";
    }

    /**
     * 查询单条数据
     * @param id
     * @return
     */
    @RequestMapping("/showDetail")
    @ResponseBody
    public TestConResult showConDetail(@RequestParam(value = "id") String id){
//        TestConResult x = testConService.findBySpec(id);
//        return ResponseData.success(0,"成功", x);
        return testConService.findBySpec(id);
    }

    /**
     * 新增接口
     *
     * @author www
     * @Date 2020-02-25
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(TestConParam testConParam) {
        this.testConService.add(testConParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author www
     * @Date 2020-02-25
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(TestConParam testConParam) {
        this.testConService.update(testConParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author www
     * @Date 2020-02-25
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(TestConParam testConParam) {
        this.testConService.delete(testConParam);
        return ResponseData.success();
    }



    /**
     * 查询列表
     *
     * @author www
     * @Date 2020-02-25
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(@RequestParam(value = "condition", required = false) String condition) {
        Page<Map<String, Object>> cons = this.testConService.selectCons(condition);
        Page<Map<String, Object>> wrap = new ConWrapper(cons).wrap();
        return LayuiPageFactory.createPageInfo(wrap);
    }

}



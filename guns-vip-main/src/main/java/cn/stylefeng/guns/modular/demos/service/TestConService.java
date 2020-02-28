package cn.stylefeng.guns.modular.demos.service;

import cn.stylefeng.guns.base.pojo.node.ZTreeNode;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.TestCon;
import cn.stylefeng.guns.modular.demos.model.params.TestConParam;
import cn.stylefeng.guns.modular.demos.model.result.TestConResult;
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
 * @since 2020-02-25
 */
public interface TestConService extends IService<TestCon> {

    /**
     * 新增
     *
     * @author www
     * @Date 2020-02-25
     */
    void add(TestConParam param);

    /**
     * 删除
     *
     * @author www
     * @Date 2020-02-25
     */
    void delete(TestConParam param);

    /**
     * 更新
     *
     * @author www
     * @Date 2020-02-25
     */
    void update(TestConParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author www
     * @Date 2020-02-25
     */
    TestConResult findBySpec(String conId);

    /**
     * 查询列表，Specification模式
     *
     * @author www
     * @Date 2020-02-25
     */
    List<TestConResult> findListBySpec(TestConParam param);


    /**
     * 查询分页数据，Specification模式
     *
     * @author www
     * @Date 2020-02-25
     */
     LayuiPageInfo findPageBySpec(TestConParam param);

    /**
     * 获取列表
     * @param condition
     * @return
     */
    Page<Map<String, Object>> selectCons(String condition);


}

package cn.stylefeng.guns.modular.demos.service.impl;

import cn.stylefeng.guns.base.pojo.node.ZTreeNode;
import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.demos.entity.TestCon;
import cn.stylefeng.guns.modular.demos.mapper.TestConMapper;
import cn.stylefeng.guns.modular.demos.model.params.TestConParam;
import cn.stylefeng.guns.modular.demos.model.result.TestConResult;
import  cn.stylefeng.guns.modular.demos.service.TestConService;
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
 * @since 2020-02-25
 */
@Service
public class TestConServiceImpl extends ServiceImpl<TestConMapper, TestCon> implements TestConService {

    @Override
    public void add(TestConParam param){
        TestCon entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(TestConParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(TestConParam param){
        TestCon oldEntity = getOldEntity(param);
        TestCon newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public TestConResult findBySpec(String conId){
        return this.baseMapper.customByDetail(conId);
    }

    @Override
    public List<TestConResult> findListBySpec(TestConParam param) {
        return null;
    }


   

    @Override
    public LayuiPageInfo findPageBySpec(TestConParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    @Override
    public Page<Map<String, Object>> selectCons(String condition) {
        Page page = LayuiPageFactory.defaultPage();
        return this.baseMapper.selectCons(page, condition);
    }

    private Serializable getKey(TestConParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private TestCon getOldEntity(TestConParam param) {
        return this.getById(getKey(param));
    }

    private TestCon getEntity(TestConParam param) {
        TestCon entity = new TestCon();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}

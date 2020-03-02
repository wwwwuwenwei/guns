package cn.stylefeng.guns.modular.signature.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.signature.entity.Signature;
import cn.stylefeng.guns.modular.signature.mapper.SignatureMapper;
import cn.stylefeng.guns.modular.signature.model.params.SignatureParam;
import cn.stylefeng.guns.modular.signature.model.result.SignatureResult;
import  cn.stylefeng.guns.modular.signature.service.SignatureService;
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
 * 签名表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-02-28
 */
@Service
public class SignatureServiceImpl extends ServiceImpl<SignatureMapper, Signature> implements SignatureService {

    @Override
    public void add(SignatureParam param){
        Signature entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(SignatureParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(SignatureParam param){
        Signature oldEntity = getOldEntity(param);
        Signature newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public SignatureResult findBySpec(SignatureParam param){
        return null;
    }

    @Override
    public List<SignatureResult> findListBySpec(SignatureParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(SignatureParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }


    private Serializable getKey(SignatureParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Signature getOldEntity(SignatureParam param) {
        return this.getById(getKey(param));
    }

    private Signature getEntity(SignatureParam param) {
        Signature entity = new Signature();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

    /**
     * 根据memberId获取数据
     * @param memberId
     * @return
     */
    @Override
    public Map<String, Object> getByMemberId(String memberId) {
        return this.baseMapper.getByMemberId(memberId);
    }

    /**
     * 判断是否存在签名
     * @param memberId
     * @return
     */
    @Override
    public boolean isExistSign(String memberId) {
        return this.baseMapper.isExistSign(memberId);
    }


}

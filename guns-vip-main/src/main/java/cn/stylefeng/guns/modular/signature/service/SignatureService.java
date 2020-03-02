package cn.stylefeng.guns.modular.signature.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.signature.entity.Signature;
import cn.stylefeng.guns.modular.signature.model.params.SignatureParam;
import cn.stylefeng.guns.modular.signature.model.result.SignatureResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 签名表 服务类
 * </p>
 *
 * @author 
 * @since 2020-02-28
 */
public interface SignatureService extends IService<Signature> {

    /**
     * 新增
     *
     * @author 
     * @Date 2020-02-28
     */
    void add(SignatureParam param);

    /**
     * 删除
     *
     * @author 
     * @Date 2020-02-28
     */
    void delete(SignatureParam param);

    /**
     * 更新
     *
     * @author 
     * @Date 2020-02-28
     */
    void update(SignatureParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 
     * @Date 2020-02-28
     */
    SignatureResult findBySpec(SignatureParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 
     * @Date 2020-02-28
     */
    List<SignatureResult> findListBySpec(SignatureParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 
     * @Date 2020-02-28
     */
     LayuiPageInfo findPageBySpec(SignatureParam param);

    /**
     * 根据memberId获取数据
     * @param memberId
     * @return
     */
     Map<String, Object> getByMemberId(String memberId);

    /**
     * 判断是否存在签名
     * @param memberId
     * @return
     */
    boolean isExistSign(String memberId);

}

package cn.stylefeng.guns.modular.signature.mapper;

import cn.stylefeng.guns.modular.signature.entity.Signature;
import cn.stylefeng.guns.modular.signature.model.params.SignatureParam;
import cn.stylefeng.guns.modular.signature.model.result.SignatureResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 签名表 Mapper 接口
 * </p>
 *
 * @author 
 * @since 2020-02-28
 */
public interface SignatureMapper extends BaseMapper<Signature> {

    /**
     * 获取列表
     *
     * @author 
     * @Date 2020-02-28
     */
    List<SignatureResult> customList(@Param("paramCondition") SignatureParam paramCondition);

    /**
     * 获取map列表
     *
     * @author 
     * @Date 2020-02-28
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") SignatureParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author 
     * @Date 2020-02-28
     */
    Page<SignatureResult> customPageList(@Param("page") Page page, @Param("paramCondition") SignatureParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author 
     * @Date 2020-02-28
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") SignatureParam paramCondition);

    /**
     * 根据memberId获取签名
     * @param memberId
     * @return
     */
    Map<String, Object> getByMemberId(@Param("memberId") String memberId);

    /**
     * 判断是否存在签名
     * @return
     */
    boolean isExistSign(@Param("memberId") String memberId);

}

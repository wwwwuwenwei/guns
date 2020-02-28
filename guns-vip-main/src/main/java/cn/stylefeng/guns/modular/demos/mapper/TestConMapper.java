package cn.stylefeng.guns.modular.demos.mapper;

import cn.stylefeng.guns.modular.demos.entity.TestCon;
import cn.stylefeng.guns.modular.demos.model.params.TestConParam;
import cn.stylefeng.guns.modular.demos.model.result.TestConResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author www
 * @since 2020-02-25
 */
public interface TestConMapper extends BaseMapper<TestCon> {

    /**
     * 根据条件查询角色列表
     *
     * @return
     * @date 2017年2月12日 下午9:14:34
     */
    Page<Map<String, Object>> selectCons(@Param("page") Page page, @Param("condition") String condition);

    /**
     * 获取列表
     *
     * @author www
     * @Date 2020-02-25
     */
    List<TestConResult> customList(@Param("paramCondition") TestConParam paramCondition);

    /**
     * 获取合同详情
     * @param conId
     * @return
     */
    TestConResult customByDetail(@Param("conId") String conId);

    /**
     * 获取map列表
     *
     * @author www
     * @Date 2020-02-25
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") TestConParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author www
     * @Date 2020-02-25
     */
    Page<TestConResult> customPageList(@Param("page") Page page, @Param("paramCondition") TestConParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author www
     * @Date 2020-02-25
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") TestConParam paramCondition);

}

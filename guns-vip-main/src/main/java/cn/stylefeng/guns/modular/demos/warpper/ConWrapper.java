/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.stylefeng.guns.modular.demos.warpper;

import cn.stylefeng.guns.sys.core.constant.factory.ConstantFactory;
import cn.stylefeng.guns.sys.core.util.DecimalUtil;
import cn.stylefeng.roses.core.base.warpper.BaseControllerWrapper;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * 角色列表的包装类
 *
 * @author fengshuonan
 * @date 2017年2月19日10:59:02
 */
public class ConWrapper extends BaseControllerWrapper {

    public ConWrapper(Map<String, Object> single) {
        super(single);
    }

    public ConWrapper(List<Map<String, Object>> multi) {
        super(multi);
    }

    public ConWrapper(Page<Map<String, Object>> page) {
        super(page);
    }

    public ConWrapper(PageResult<Map<String, Object>> pageResult) {
        super(pageResult);
    }

    //可以在这对查询出的结果做一些操作
    @Override
    protected void wrapTheMap(Map<String, Object> map) {

    }


}

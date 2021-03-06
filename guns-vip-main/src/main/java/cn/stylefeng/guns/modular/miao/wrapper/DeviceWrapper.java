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
package cn.stylefeng.guns.modular.miao.wrapper;

import cn.stylefeng.guns.factory.MonstantFactory;
import cn.stylefeng.guns.modular.rest.service.DeviceService;
import cn.stylefeng.roses.core.base.warpper.BaseControllerWrapper;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的包装类
 *
 * @author fengshuonan
 * @date 2017年2月13日 下午10:47:03
 */
public class DeviceWrapper extends BaseControllerWrapper {
    @Autowired
    DeviceService deviceService;
    public DeviceWrapper(Map<String, Object> single) {
        super(single);
    }

    public DeviceWrapper(List<Map<String, Object>> multi) {
        super(multi);
    }

    public DeviceWrapper(Page<Map<String, Object>> page) {
        super(page);
    }

    public DeviceWrapper(PageResult<Map<String, Object>> pageResult) {
        super(pageResult);
    }


    @Override
    protected void wrapTheMap(Map<String, Object> map) {
        map.put("deviceType", MonstantFactory.me().getDeviceType((Long)map.get("deviceType")));
        map.put("userId", MonstantFactory.me().getUserName((Long)map.get("userId")));

    }

}

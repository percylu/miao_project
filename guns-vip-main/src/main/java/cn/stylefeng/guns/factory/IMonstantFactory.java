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
package cn.stylefeng.guns.factory;




/**
 * 常量生产工厂的接口
 *
 * @author zky
 * @date 2020-05-29 21:12
 */
public interface IMonstantFactory {

    /**
     * 获取设备类型的名称
     *
     * @author zky
     * @Date 2020/5/29 23:41
     */


    String getDeviceType(Long typeId);
    String getUserName(Long userId);
    String getPetType(Long TypeId);
}

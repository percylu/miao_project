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
package cn.stylefeng.guns.modular.rest.factory;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.base.auth.model.LoginUser;
import cn.stylefeng.guns.base.consts.ConstantsContext;
import cn.stylefeng.guns.modular.rest.entity.RestMiaoUser;
import cn.stylefeng.guns.modular.rest.model.result.MiaoUserResult;
import cn.stylefeng.guns.modular.rest.model.result.UserResult;
import cn.stylefeng.guns.sys.core.constant.factory.ConstantFactory;
import cn.stylefeng.guns.sys.core.constant.state.ManagerStatus;
import cn.stylefeng.guns.sys.modular.system.entity.User;
import cn.stylefeng.guns.sys.modular.system.model.UserDto;
import cn.stylefeng.roses.core.util.ToolUtil;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户创建工厂
 *
 * @author fengshuonan
 * @date 2017-05-05 22:43
 */
public class MiaoUserFactory {

    /**
     * 根据请求创建实体
     */
    public static RestMiaoUser createUser(RestMiaoUser userDto, String md5Password, String salt) {
        if (userDto == null) {
            return null;
        } else {
            RestMiaoUser user = new RestMiaoUser();
            BeanUtils.copyProperties(userDto, user);
            user.setCreateTime(new Date());
            user.setStatus(ManagerStatus.OK.getCode());
            user.setPassword(md5Password);
            user.setSalt(salt);
            return user;
        }
    }

    /**
     * 更新user
     */
    public static RestMiaoUser editUser(RestMiaoUser newUser, RestMiaoUser oldUser) {
        if (newUser == null || oldUser == null) {
            return oldUser;
        } else {
            if (ToolUtil.isNotEmpty(newUser.getAvatar())) {
                oldUser.setAvatar(newUser.getAvatar());
            }
            if (ToolUtil.isNotEmpty(newUser.getName())) {
                oldUser.setName(newUser.getName());
            }

            if (ToolUtil.isNotEmpty(newUser.getSex())) {
                oldUser.setSex(newUser.getSex());
            }

            return oldUser;
        }
    }

    /**
     * 过滤不安全字段并转化为map
     */
    public static Map<String, Object> removeUnSafeFields(User user) {
        if (user == null) {
            return new HashMap<>();
        } else {
            Map<String, Object> map = BeanUtil.beanToMap(user);
            map.remove("password");
            map.remove("salt");
            map.put("birthday", DateUtil.formatDate(user.getBirthday()));
            return map;
        }
    }
    /**
     * 获取用户信息（不含密码）
     */
    public static MiaoUserResult getMiaoUser(RestMiaoUser user){
        MiaoUserResult miaoUserResult = new MiaoUserResult();
        miaoUserResult.setAccount(user.getAccount());
        miaoUserResult.setAvatar(user.getAvatar());
        miaoUserResult.setName(user.getName());
        miaoUserResult.setQq(user.getQq());
        miaoUserResult.setSex(user.getSex());
        miaoUserResult.setStatus(user.getStatus());
        miaoUserResult.setUserId(user.getUserId());
        miaoUserResult.setWeibo(user.getWeibo());
        miaoUserResult.setWeixin(user.getWeixin());
        return miaoUserResult;
    }
    /**
     * 通过用户表的信息创建一个登录用户
     */
    public static LoginUser createLoginUser(RestMiaoUser user) {
        LoginUser loginUser = new LoginUser();

        if (user == null) {
            return loginUser;
        }

        loginUser.setId(user.getUserId());
        loginUser.setAccount(user.getAccount());
        loginUser.setName(user.getName());

        loginUser.setAvatar(user.getAvatar());

        return loginUser;
    }
    /**
     * 判断用户是否是从oauth2登录过来的
     */
    public static boolean oauth2Flag() {
        String account = LoginContextHolder.getContext().getUser().getAccount();
        if (account.startsWith(ConstantsContext.getOAuth2UserPrefix())) {
            return true;
        } else {
            return false;
        }
    }
}

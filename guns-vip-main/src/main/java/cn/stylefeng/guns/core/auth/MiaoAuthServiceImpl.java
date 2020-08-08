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
package cn.stylefeng.guns.core.auth;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.base.auth.exception.AuthException;
import cn.stylefeng.guns.base.auth.exception.enums.AuthExceptionEnum;
import cn.stylefeng.guns.base.auth.jwt.JwtTokenUtil;
import cn.stylefeng.guns.base.auth.jwt.payload.JwtPayLoad;
import cn.stylefeng.guns.base.auth.model.LoginUser;
import cn.stylefeng.guns.base.auth.service.AuthService;

import cn.stylefeng.guns.base.consts.ConstantsContext;
import cn.stylefeng.guns.base.tenant.context.DataBaseNameHolder;
import cn.stylefeng.guns.base.tenant.context.TenantCodeHolder;
import cn.stylefeng.guns.core.auth.model.MiaoLoginUser;
import cn.stylefeng.guns.core.auth.service.MiaoAuthService;
import cn.stylefeng.guns.modular.miao.entity.MiaoUser;
import cn.stylefeng.guns.modular.rest.entity.RestMiaoUser;
import cn.stylefeng.guns.modular.rest.mapper.RestMiaoUserMapper;
import cn.stylefeng.guns.sys.core.auth.cache.SessionManager;
import cn.stylefeng.guns.sys.core.constant.factory.ConstantFactory;
import cn.stylefeng.guns.sys.core.constant.state.ManagerStatus;
import cn.stylefeng.guns.sys.core.listener.ConfigListener;
import cn.stylefeng.guns.sys.core.log.LogManager;
import cn.stylefeng.guns.sys.core.log.factory.LogTaskFactory;
import cn.stylefeng.guns.sys.core.util.SaltUtil;
import cn.stylefeng.guns.sys.modular.system.entity.User;
import cn.stylefeng.guns.sys.modular.system.factory.UserFactory;
import cn.stylefeng.guns.sys.modular.system.service.DictService;
import cn.stylefeng.roses.core.util.HttpContext;
import cn.stylefeng.roses.core.util.SpringContextHolder;
import cn.stylefeng.roses.core.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static cn.stylefeng.guns.base.consts.ConstantsContext.getJwtSecretExpireSec;
import static cn.stylefeng.guns.base.consts.ConstantsContext.getTokenHeaderName;
import static cn.stylefeng.roses.core.util.HttpContext.getIp;

@Service
@DependsOn("springContextHolder")
@Transactional(readOnly = true)
public class MiaoAuthServiceImpl implements MiaoAuthService {

    @Autowired
    private RestMiaoUserMapper userMapper;

    @Autowired
    private SessionManager sessionManager;

    @Autowired
    private DictService dictService;



    public static AuthService me() {
        return SpringContextHolder.getBean(AuthService.class);
    }

    @Override
    public String login(String username, String password) {

        RestMiaoUser user = userMapper.getByAccount(username);

        // 账号不存在
        if (null == user) {
            throw new AuthException(AuthExceptionEnum.USERNAME_PWD_ERROR);
        }

        //验证账号密码是否正确
        String requestMd5 = SaltUtil.md5Encrypt(password, user.getSalt());
        String dbMd5 = user.getPassword();
        if (dbMd5 == null || !dbMd5.equalsIgnoreCase(requestMd5)) {
            throw new AuthException(AuthExceptionEnum.USERNAME_PWD_ERROR);
        }

        return login(username);
    }

    @Override
    public String login(String username) {

        RestMiaoUser user = userMapper.getByAccount(username);

        // 账号不存在
        if (null == user) {
            throw new AuthException(AuthExceptionEnum.USERNAME_PWD_ERROR);
        }

        // 账号被冻结
        if (!user.getStatus().equals(ManagerStatus.OK.getCode())) {
            throw new AuthException(AuthExceptionEnum.ACCOUNT_FREEZE_ERROR);
        }

        //记录登录日志
        LogManager.me().executeLog(LogTaskFactory.loginLog(user.getUserId(), getIp()));

        //TODO key的作用
        JwtPayLoad payLoad = new JwtPayLoad(user.getUserId(), user.getAccount(), "xxxx");

        //创建token
        String token = JwtTokenUtil.generateToken(payLoad);

        //创建登录会话
        sessionManager.createSession(token, user(username));
        //创建cookie
       // addLoginCookie(token);

        return token;
    }

    @Override
    public void addLoginCookie(String token) {
        //创建cookie
        Cookie authorization = new Cookie(getTokenHeaderName(), token);
        authorization.setMaxAge(getJwtSecretExpireSec().intValue());
        authorization.setHttpOnly(true);
        authorization.setPath("/");
        HttpServletResponse response = HttpContext.getResponse();
        response.addCookie(authorization);
    }

    @Override
    public void logout() {
        String token = LoginContextHolder.getContext().getToken();
        logout(token);
    }

    @Override
    public void logout(String token) {

        //记录退出日志
        LogManager.me().executeLog(LogTaskFactory.exitLog(LoginContextHolder.getContext().getUser().getId(), getIp()));

        //删除Auth相关cookies
        Cookie[] cookies = HttpContext.getRequest().getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String tokenHeader = getTokenHeaderName();
                if (tokenHeader.equalsIgnoreCase(cookie.getName())) {
                    Cookie temp = new Cookie(cookie.getName(), "");
                    temp.setMaxAge(0);
                    temp.setPath("/");
                    HttpContext.getResponse().addCookie(temp);
                }
            }
        }

        //删除会话
    }


    @Override
    public LoginUser user(String account) {

        RestMiaoUser user = userMapper.getByAccount(account);

        LoginUser loginUser = new LoginUser();
        loginUser.setAccount(user.getAccount());
        loginUser.setName(user.getName());
        loginUser.setAvatar(user.getAvatar());
        loginUser.setId(user.getUserId());
        return loginUser;
    }


    @Override
    public List<String> findPermissionsByRoleId(Long roleId) {
        return null;
    }

    @Override
    public boolean check(String[] roleNames) {
        LoginUser user = LoginContextHolder.getContext().getUser();
        if (null == user) {
            return false;
        }
        ArrayList<String> objects = CollectionUtil.newArrayList(roleNames);
        String join = CollectionUtil.join(objects, ",");
        if (LoginContextHolder.getContext().hasAnyRoles(join)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAll() {
        HttpServletRequest request = HttpContext.getRequest();
        LoginUser user = LoginContextHolder.getContext().getUser();
        if (null == user) {
            return false;
        }
        String requestURI = request.getRequestURI().replaceFirst(ConfigListener.getConf().get("contextPath"), "");
        String[] str = requestURI.split("/");
        if (str.length > 3) {
            requestURI = "/" + str[1] + "/" + str[2];
        }
        if (LoginContextHolder.getContext().hasPermission(requestURI)) {
            return true;
        }
        return false;
    }

}

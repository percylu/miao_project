package cn.stylefeng.guns.modular.miao.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoUser;
import cn.stylefeng.guns.modular.miao.mapper.MiaoUserMapper;
import cn.stylefeng.guns.modular.miao.model.params.MiaoUserParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoUserResult;
import  cn.stylefeng.guns.modular.miao.service.MiaoUserService;
import cn.stylefeng.guns.sys.modular.system.entity.FileInfo;
import cn.stylefeng.guns.sys.modular.system.service.FileInfoService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * App用户管理 服务实现类
 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
@Service
public class MiaoUserServiceImpl extends ServiceImpl<MiaoUserMapper, MiaoUser> implements MiaoUserService {
    @Autowired
    private FileInfoService fileInfoService;

    @Override
    public void add(MiaoUserParam param){
        MiaoUser entity = getEntity(param);

        this.save(entity);
    }

    @Override
    public void delete(MiaoUserParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoUserParam param){
        MiaoUser oldEntity = getOldEntity(param);
        MiaoUser newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoUserResult findBySpec(MiaoUserParam param){
        return null;
    }

    @Override
    public List<MiaoUserResult> findListBySpec(MiaoUserParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MiaoUserParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    @Override
    public String updateAvatar(String fileId) {
        FileInfo file = fileInfoService.getById(fileId);
        String fileName=file.getFinalName();
        String filePath = "/image/"+fileName;
        return filePath;
    }

    private Serializable getKey(MiaoUserParam param){
        return param.getUserId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MiaoUser getOldEntity(MiaoUserParam param) {
        return this.getById(getKey(param));
    }

    private MiaoUser getEntity(MiaoUserParam param) {
        MiaoUser entity = new MiaoUser();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}

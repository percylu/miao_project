package cn.stylefeng.guns.modular.miao.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.miao.entity.MiaoPet;
import cn.stylefeng.guns.modular.miao.mapper.MiaoPetMapper;
import cn.stylefeng.guns.modular.miao.model.params.MiaoPetParam;
import cn.stylefeng.guns.modular.miao.model.result.MiaoPetResult;
import  cn.stylefeng.guns.modular.miao.service.MiaoPetService;
import cn.stylefeng.guns.modular.miao.wrapper.DeviceWrapper;
import cn.stylefeng.guns.modular.miao.wrapper.PetWrapper;
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
import java.util.Map;

/**
 * <p>
 * 宠物管理 服务实现类
 * </p>
 *
 * @author 卢水柏
 * @since 2020-07-31
 */
@Service
public class MiaoPetServiceImpl extends ServiceImpl<MiaoPetMapper, MiaoPet> implements MiaoPetService {
    @Autowired
    FileInfoService fileInfoService;
    @Override
    public void add(MiaoPetParam param){
        MiaoPet entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(MiaoPetParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(MiaoPetParam param){
        MiaoPet oldEntity = getOldEntity(param);
        MiaoPet newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public MiaoPetResult findBySpec(MiaoPetParam param){
        return null;
    }

    @Override
    public List<MiaoPetResult> findListBySpec(MiaoPetParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(MiaoPetParam param){
        Page pageContext = getPageContext();
        Page<Map<String, Object>> page = this.baseMapper.customPageMapList(pageContext, param);
        Page wrap = new PetWrapper(page).wrap();
        return LayuiPageFactory.createPageInfo(wrap);
    }

    private Serializable getKey(MiaoPetParam param){
        return param.getPetId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private MiaoPet getOldEntity(MiaoPetParam param) {
        return this.getById(getKey(param));
    }

    private MiaoPet getEntity(MiaoPetParam param) {
        MiaoPet entity = new MiaoPet();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

    @Override
    public String updatePic(String fileId) {
        FileInfo file = fileInfoService.getById(fileId);
        String fileName=file.getFinalName();
        String filePath = "/image/"+fileName;
        return filePath;
    }

}

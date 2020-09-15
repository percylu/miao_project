package cn.stylefeng.guns.modular.jpush.service;

import cn.stylefeng.guns.modular.jpush.model.PushBean;

public interface JiGuangPushService {
    boolean pushAll(PushBean pushBean);

    boolean pushIos(PushBean pushBean);

    boolean pushIos(PushBean pushBean, String... registids);

    boolean pushAndroid(PushBean pushBean);

    boolean pushAndroid(PushBean pushBean, String... registids);

    String[] checkRegistids(String[] registids);

}

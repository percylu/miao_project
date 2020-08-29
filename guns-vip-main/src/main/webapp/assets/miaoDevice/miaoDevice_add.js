/**
 * 添加或者修改页面
 */
var MiaoDeviceInfoDlg = {
    data: {
        deviceId: "",
        userId: "",
        deviceSn: "",
        deviceType: "",
        status: "",
        rubbish: "",
        litter: "",
        tims: "",
        createTime: "",
        updateTime: ""
    }
};

layui.use(['form', 'admin', 'ax','laydate','upload','formSelects'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;

















    //下拉多选框
    var formSelects = layui.formSelects;
    formSelects.config('seldeviceType', {
        searchUrl: Feng.ctxPath + "/miaoDeviceType/list",//请更换成您自己的url,可参考项目中的其他接口
        keyName: 'type',//更换成自己的keyName,可参考项目中的其他接口
        keyVal: 'typeId'//更换成自己的keyVal,可参考项目中的其他接口
    });





    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/miaoDevice/addItem", function (data) {
            Feng.success("添加成功！");
            //传给上个页面，刷新table用
            admin.putTempData('formOk', true);
            //关掉对话框
            admin.closeThisDialog();
        }, function (data) {
            Feng.error("添加失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });


});
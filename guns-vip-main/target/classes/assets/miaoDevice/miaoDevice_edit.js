/**
 * 详情对话框
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























    //获取详情信息，填充表单
    var ajax = new $ax(Feng.ctxPath + "/miaoDevice/detail?deviceId=" + Feng.getUrlParam("deviceId"));
    var result = ajax.start();
    form.val('miaoDeviceForm', result.data);
    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/miaoDevice/editItem", function (data) {
            Feng.success("更新成功！");
            //传给上个页面，刷新table用
            admin.putTempData('formOk', true);
            //关掉对话框
            admin.closeThisDialog();
        }, function (data) {
            Feng.error("更新失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });


    $.ajax({
        url:Feng.ctxPath + "/miaoDeviceType/list",
        type:'get',
        dateType:'json',
        success:function(datas){
            var type = $('#deviceType');
            var typelist=datas.data;
            for(var i = 0; i < typelist.length; i++) {

                if(typelist[i]['typeId']==result.data.deviceType){
                    type.append(("<option selected value="+typelist[i]['typeId']+">"+typelist[i]['type']+"</option>"));
                }else{
                    type.append(("<option value="+typelist[i]['typeId']+">"+typelist[i]['type']+"</option>"));
                }
            }
            //layui重新渲染
            layui.use('form', function(){
                var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
                form.render('select');
                //form.render();
            });
        }
    });

});
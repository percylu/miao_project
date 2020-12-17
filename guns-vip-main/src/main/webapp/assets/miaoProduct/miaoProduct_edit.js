/**
 * 详情对话框
 */
var MiaoProductInfoDlg = {
    data: {
        productId: "",
        name: "",
        originalPrice: "",
        salePrice: "",
        promotion: "",
        img: "",
        platform: "",
        link: "",
        createTime: ""
    }
};

layui.use(['form', 'admin', 'ax','laydate','upload','formSelects'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
















    //普通图片上传
    var upload = layui.upload;
    upload.render({
        elem: '#img'
        ,url: Feng.ctxPath + '/system/uploads' //改成您自己的上传接口
        ,before: function(obj){
            //预读本地文件示例，不支持ie8
            obj.preview(function(index, file, result){
                $('#filePreview').attr('src', result); //图片链接（base64）

            });
        }
        ,done: function(res){
            // var ajax = new $ax(Feng.ctxPath + "/system/updateAvatar", function (data) {
            //     Feng.success(res.message);
            // }, function (data) {
            //     Feng.error("修改失败!" + data.responseJSON.message + "!");
            // });
            // ajax.set("fileId", res.data.fileId);
            // ajax.start();
            $('#img').val("/image/"+res.data.finalName);
        }
        ,error: function(){
            Feng.error("上传文件失败！");
        }
    });







    //获取详情信息，填充表单
    var ajax = new $ax(Feng.ctxPath + "/miaoProduct/detail?productId=" + Feng.getUrlParam("productId"));
    var result = ajax.start();
    form.val('miaoProductForm', result.data);
    $('#filePreview').attr('src', result.data.img); //图片链接（base64）
    $('#img').val(result.data.img); //图片链接（base64）

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        console.log($('#img').val());
        data.field.img=$('#img').val();
        console.log(data.field);
        var ajax = new $ax(Feng.ctxPath + "/miaoProduct/editItem", function (data) {
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

});
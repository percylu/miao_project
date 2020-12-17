/**
 * 添加或者修改页面
 */
var MiaoTopicInfoDlg = {
    data: {
        topicId: "",
        title: "",
        subTitle: "",
        img: "",
        hotCount: "",
        joinCount: "",
        likeCount: "",
        commentCount: "",
        seq: "",
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
















    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/miaoTopic/addItem", function (data) {
            Feng.success("添加成功！");
            //传给上个页面，刷新table用
            admin.putTempData('formOk', true);
            //关掉对话框
            admin.closeThisDialog();
        }, function (data) {
            Feng.error("添加失败！" + data.responseJSON.message)
        });
        data.field.img=$('#img').val();
        ajax.set(data.field);
        ajax.start();

        return false;
    });


});
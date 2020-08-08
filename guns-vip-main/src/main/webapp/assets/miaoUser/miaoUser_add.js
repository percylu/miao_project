/**
 * 添加或者修改页面
 */
var MiaoUserInfoDlg = {
    data: {
        userId: "",
        avatar: "",
        account: "",
        password: "",
        salt: "",
        name: "",
        sex: "",
        status: "",
        qq: "",
        weixin: "",
        weibo: "",
        createTime: "",
        updateTime: ""
    }
};

layui.use(['form', 'admin', 'ax','laydate','upload','formSelects'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var upload = layui.upload;






























    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/miaoUser/addItem", function (data) {
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

    upload.render({
        elem: '#ImgPreview'
        , url: Feng.ctxPath + '/system/upload'
        , before: function (obj) {
            obj.preview(function (index, file, result) {
                $('#avatarPreview').attr('src', result);
            });
        }
        , done: function (res) {
            var ajax = new $ax(Feng.ctxPath + "/miaoBanner/updateAvatar", function (data) {
                Feng.success(res.message);
            }, function (data) {
                Feng.error("修改失败!" + data.responseJSON.message + "!");
            });
            ajax.set("fileId", res.data.fileId);

            var filePath=ajax.start();
            $('#avatar').val(filePath.data.filePath);
        }
        , error: function () {
            Feng.error("上传头像失败！");
        }
    });



});
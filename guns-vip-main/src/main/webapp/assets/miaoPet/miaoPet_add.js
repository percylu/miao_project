/**
 * 添加或者修改页面
 */
var MiaoPetInfoDlg = {
    data: {
        petId: "",
        userId: "",
        name: "",
        type: "",
        sexy: "",
        weight: "",
        birthday: "",
        rdid: "",
        imgurls: "",
        createTime: "",
        updateTime: ""
    }
};

layui.use(['form', 'admin', 'ax', 'laydate', 'upload', 'formSelects'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var laydate = layui.laydate;
    var upload = layui.upload;

    // 渲染时间选择框
    laydate.render({
        elem: '#birthday'
    });
    upload.render({
        elem: '#img1,#img2,#img3'
        , url: Feng.ctxPath + '/system/upload'
        , before: function (obj) {
            let item=$(this.item);
            obj.preview(function (index, file, result) {
                item.attr('src', result);
            });
        }
        , done: function (res) {
            var ajax = new $ax(Feng.ctxPath + "/miaoPet/updatePic", function (data) {
                Feng.success(res.message);
            }, function (data) {
                Feng.error("修改失败!" + data.responseJSON.message + "!");
            });
            ajax.set("fileId", res.data.fileId);

            var filePath=ajax.start();
            var url=$('#imgurls').val();
            if(url==""){
                $('#imgurls').val(filePath.data.filePath);
            }else{
                var arr=url.split(",");
                var index=$(this.item).attr('seq');
                arr[index]=filePath.data.filePath;

                var path=arr.join(",");
                $('#imgurls').val(path);
            }
            console.log($('#imgurls').val());
        }
        , error: function () {
            Feng.error("上传图片失败！");
        }
    });
    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/miaoPet/addItem", function (data) {
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

    $.ajax({
        url: Feng.ctxPath + "/miaoType/list",
        type: 'get',
        dateType: 'json',
        success: function (datas) {
            var type = $('#type');
            var typelist = datas.data;
            for (var i = 0; i < typelist.length; i++) {
                type.append(("<option value=" + typelist[i]['typeId'] + ">" + typelist[i]['typeName'] + "</option>"));
            }
            //layui重新渲染
            layui.use('form', function () {
                var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
                form.render('select');
                //form.render();
            });
        }
    });

});
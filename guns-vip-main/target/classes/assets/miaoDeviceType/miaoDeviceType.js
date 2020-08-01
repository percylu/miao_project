layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 设备类型管理
     */
    var MiaoDeviceType = {
        tableId: "miaoDeviceTypeTable"
    };

    /**
     * 初始化表格的列
     */
    MiaoDeviceType.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'typeId', hide: true, title: '主键id'},
            {field: 'color', sort: true, title: '设备颜色'},
            {field: 'type', sort: true, title: '设备型号'},
            {field: 'imgurl', sort: true, title: '设备图片'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {field: 'updateTime', sort: true, title: '更新时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MiaoDeviceType.search = function () {
        var queryData = {};


        table.reload(MiaoDeviceType.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    MiaoDeviceType.openAddDlg = function () {
        func.open({
            title: '添加设备类型',
            content: Feng.ctxPath + '/miaoDeviceType/add',
            tableId: MiaoDeviceType.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      MiaoDeviceType.openEditDlg = function (data) {
          func.open({
              title: '修改设备类型',
              content: Feng.ctxPath + '/miaoDeviceType/edit?typeId=' + data.typeId,
              tableId: MiaoDeviceType.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    MiaoDeviceType.exportExcel = function () {
        var checkRows = table.checkStatus(MiaoDeviceType.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    MiaoDeviceType.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/miaoDeviceType/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MiaoDeviceType.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("typeId", data.typeId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + MiaoDeviceType.tableId,
        url: Feng.ctxPath + '/miaoDeviceType/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MiaoDeviceType.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MiaoDeviceType.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    MiaoDeviceType.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        MiaoDeviceType.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MiaoDeviceType.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MiaoDeviceType.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MiaoDeviceType.onDeleteItem(data);
        }
    });
});

layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 设备数据管理
     */
    var MiaoDeviceData = {
        tableId: "miaoDeviceDataTable"
    };

    /**
     * 初始化表格的列
     */
    MiaoDeviceData.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'deviceDataId', hide: true, title: '主键id'},
            {field: 'deviceId', sort: true, title: '设备ID'},
            {field: 'weight', sort: true, title: '排泄物重量'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MiaoDeviceData.search = function () {
        var queryData = {};


        table.reload(MiaoDeviceData.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    MiaoDeviceData.openAddDlg = function () {
        func.open({
            title: '添加设备数据',
            content: Feng.ctxPath + '/miaoDeviceData/add',
            tableId: MiaoDeviceData.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      MiaoDeviceData.openEditDlg = function (data) {
          func.open({
              title: '修改设备数据',
              content: Feng.ctxPath + '/miaoDeviceData/edit?deviceDataId=' + data.deviceDataId,
              tableId: MiaoDeviceData.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    MiaoDeviceData.exportExcel = function () {
        var checkRows = table.checkStatus(MiaoDeviceData.tableId);
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
    MiaoDeviceData.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/miaoDeviceData/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MiaoDeviceData.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("deviceDataId", data.deviceDataId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + MiaoDeviceData.tableId,
        url: Feng.ctxPath + '/miaoDeviceData/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MiaoDeviceData.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MiaoDeviceData.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    MiaoDeviceData.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        MiaoDeviceData.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MiaoDeviceData.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MiaoDeviceData.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MiaoDeviceData.onDeleteItem(data);
        }
    });
});

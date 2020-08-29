layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 设备管理管理
     */
    var MiaoDevice = {
        tableId: "miaoDeviceTable"
    };

    /**
     * 初始化表格的列
     */
    MiaoDevice.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'deviceId', hide: true, title: '主键id'},
            {field: 'userId', sort: true, title: '所属用户'},
            {field: 'deviceSn', sort: true, title: '设备编号'},
            {field: 'deviceType', sort: true, title: '设备型号'},
            {field: 'status', sort: true, title: '状态',templet:"#statusTpl"},
            {field: 'rubbish', sort: true, title: '垃圾百分比'},
            {field: 'litter', sort: true, title: '猫砂百分比'},
            {field: 'tims', sort: true, title: '如厕次数'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {field: 'updateTime', sort: true, title: '更新时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MiaoDevice.search = function () {
        var queryData = {};


        table.reload(MiaoDevice.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    MiaoDevice.openAddDlg = function () {
        func.open({
            title: '添加设备管理',
            content: Feng.ctxPath + '/miaoDevice/add',
            tableId: MiaoDevice.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      MiaoDevice.openEditDlg = function (data) {
          func.open({
              title: '修改设备管理',
              content: Feng.ctxPath + '/miaoDevice/edit?deviceId=' + data.deviceId,
              tableId: MiaoDevice.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    MiaoDevice.exportExcel = function () {
        var checkRows = table.checkStatus(MiaoDevice.tableId);
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
    MiaoDevice.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/miaoDevice/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MiaoDevice.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("deviceId", data.deviceId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + MiaoDevice.tableId,
        url: Feng.ctxPath + '/miaoDevice/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MiaoDevice.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MiaoDevice.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    MiaoDevice.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        MiaoDevice.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MiaoDevice.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MiaoDevice.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MiaoDevice.onDeleteItem(data);
        }
    });
});

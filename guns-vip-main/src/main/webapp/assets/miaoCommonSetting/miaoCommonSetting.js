layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * App通用设置管理
     */
    var MiaoCommonSetting = {
        tableId: "miaoCommonSettingTable"
    };

    /**
     * 初始化表格的列
     */
    MiaoCommonSetting.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'settingId', hide: true, title: '主键ID'},
            {field: 'settingTitle', sort: true, title: '设置类型'},
            {field: 'updateTime', sort: true, title: '更新时间'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MiaoCommonSetting.search = function () {
        var queryData = {};

        queryData['createTime'] = $('#createTime').val();

        table.reload(MiaoCommonSetting.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    MiaoCommonSetting.openAddDlg = function () {
        func.open({
            title: '添加App通用设置',
            content: Feng.ctxPath + '/miaoCommonSetting/add',
            tableId: MiaoCommonSetting.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      MiaoCommonSetting.openEditDlg = function (data) {
          func.open({
              title: '修改App通用设置',
              content: Feng.ctxPath + '/miaoCommonSetting/edit?settingId=' + data.settingId,
              tableId: MiaoCommonSetting.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    MiaoCommonSetting.exportExcel = function () {
        var checkRows = table.checkStatus(MiaoCommonSetting.tableId);
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
    MiaoCommonSetting.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/miaoCommonSetting/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MiaoCommonSetting.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("settingId", data.settingId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + MiaoCommonSetting.tableId,
        url: Feng.ctxPath + '/miaoCommonSetting/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MiaoCommonSetting.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MiaoCommonSetting.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    MiaoCommonSetting.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        MiaoCommonSetting.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MiaoCommonSetting.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MiaoCommonSetting.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MiaoCommonSetting.onDeleteItem(data);
        }
    });
});

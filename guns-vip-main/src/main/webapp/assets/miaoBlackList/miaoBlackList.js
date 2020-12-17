layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 黑名单列表管理
     */
    var MiaoBlackList = {
        tableId: "miaoBlackListTable"
    };

    /**
     * 初始化表格的列
     */
    MiaoBlackList.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'userId', hide: true, title: '主键id'},
            {field: 'blackUserId', sort: true, title: '用户'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MiaoBlackList.search = function () {
        var queryData = {};


        table.reload(MiaoBlackList.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    MiaoBlackList.openAddDlg = function () {
        func.open({
            title: '添加黑名单列表',
            content: Feng.ctxPath + '/miaoBlackList/add',
            tableId: MiaoBlackList.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      MiaoBlackList.openEditDlg = function (data) {
          func.open({
              title: '修改黑名单列表',
              content: Feng.ctxPath + '/miaoBlackList/edit?userId=' + data.userId,
              tableId: MiaoBlackList.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    MiaoBlackList.exportExcel = function () {
        var checkRows = table.checkStatus(MiaoBlackList.tableId);
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
    MiaoBlackList.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/miaoBlackList/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MiaoBlackList.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("userId", data.userId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + MiaoBlackList.tableId,
        url: Feng.ctxPath + '/miaoBlackList/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MiaoBlackList.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MiaoBlackList.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    MiaoBlackList.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        MiaoBlackList.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MiaoBlackList.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MiaoBlackList.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MiaoBlackList.onDeleteItem(data);
        }
    });
});

layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 关注列表管理
     */
    var MiaoFollowList = {
        tableId: "miaoFollowListTable"
    };

    /**
     * 初始化表格的列
     */
    MiaoFollowList.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'followId', hide: true, title: '主键id'},
            {field: 'userId', sort: true, title: '用户'},
            {field: 'followUserId', sort: true, title: '关注人'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MiaoFollowList.search = function () {
        var queryData = {};


        table.reload(MiaoFollowList.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    MiaoFollowList.openAddDlg = function () {
        func.open({
            title: '添加关注列表',
            content: Feng.ctxPath + '/miaoFollowList/add',
            tableId: MiaoFollowList.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      MiaoFollowList.openEditDlg = function (data) {
          func.open({
              title: '修改关注列表',
              content: Feng.ctxPath + '/miaoFollowList/edit?followId=' + data.followId,
              tableId: MiaoFollowList.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    MiaoFollowList.exportExcel = function () {
        var checkRows = table.checkStatus(MiaoFollowList.tableId);
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
    MiaoFollowList.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/miaoFollowList/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MiaoFollowList.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("followId", data.followId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + MiaoFollowList.tableId,
        url: Feng.ctxPath + '/miaoFollowList/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MiaoFollowList.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MiaoFollowList.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    MiaoFollowList.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        MiaoFollowList.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MiaoFollowList.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MiaoFollowList.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MiaoFollowList.onDeleteItem(data);
        }
    });
});

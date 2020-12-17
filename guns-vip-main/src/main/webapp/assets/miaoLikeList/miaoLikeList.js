layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 点赞列表管理
     */
    var MiaoLikeList = {
        tableId: "miaoLikeListTable"
    };

    /**
     * 初始化表格的列
     */
    MiaoLikeList.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'postId', hide: true, title: '主键id'},
            {field: 'userId', sort: true, title: '用户'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MiaoLikeList.search = function () {
        var queryData = {};


        table.reload(MiaoLikeList.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    MiaoLikeList.openAddDlg = function () {
        func.open({
            title: '添加点赞列表',
            content: Feng.ctxPath + '/miaoLikeList/add',
            tableId: MiaoLikeList.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      MiaoLikeList.openEditDlg = function (data) {
          func.open({
              title: '修改点赞列表',
              content: Feng.ctxPath + '/miaoLikeList/edit?postId=' + data.postId,
              tableId: MiaoLikeList.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    MiaoLikeList.exportExcel = function () {
        var checkRows = table.checkStatus(MiaoLikeList.tableId);
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
    MiaoLikeList.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/miaoLikeList/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MiaoLikeList.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("postId", data.postId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + MiaoLikeList.tableId,
        url: Feng.ctxPath + '/miaoLikeList/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MiaoLikeList.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MiaoLikeList.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    MiaoLikeList.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        MiaoLikeList.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MiaoLikeList.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MiaoLikeList.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MiaoLikeList.onDeleteItem(data);
        }
    });
});

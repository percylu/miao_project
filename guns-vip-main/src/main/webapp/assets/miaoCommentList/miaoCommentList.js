layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 评论列表管理
     */
    var MiaoCommentList = {
        tableId: "miaoCommentListTable"
    };

    /**
     * 初始化表格的列
     */
    MiaoCommentList.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'postId', hide: true, title: '主键id'},
            {field: 'userId', sort: true, title: '用户'},
            {field: 'comment', sort: true, title: '评论'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MiaoCommentList.search = function () {
        var queryData = {};


        table.reload(MiaoCommentList.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    MiaoCommentList.openAddDlg = function () {
        func.open({
            title: '添加评论列表',
            content: Feng.ctxPath + '/miaoCommentList/add',
            tableId: MiaoCommentList.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      MiaoCommentList.openEditDlg = function (data) {
          func.open({
              title: '修改评论列表',
              content: Feng.ctxPath + '/miaoCommentList/edit?postId=' + data.postId,
              tableId: MiaoCommentList.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    MiaoCommentList.exportExcel = function () {
        var checkRows = table.checkStatus(MiaoCommentList.tableId);
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
    MiaoCommentList.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/miaoCommentList/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MiaoCommentList.tableId);
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
        elem: '#' + MiaoCommentList.tableId,
        url: Feng.ctxPath + '/miaoCommentList/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MiaoCommentList.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MiaoCommentList.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    MiaoCommentList.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        MiaoCommentList.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MiaoCommentList.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MiaoCommentList.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MiaoCommentList.onDeleteItem(data);
        }
    });
});

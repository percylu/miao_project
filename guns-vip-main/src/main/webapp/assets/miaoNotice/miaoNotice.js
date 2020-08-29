layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 通知表管理
     */
    var MiaoNotice = {
        tableId: "miaoNoticeTable"
    };

    /**
     * 初始化表格的列
     */
    MiaoNotice.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'noticeId', hide: true, title: '主键'},
            {field: 'title', sort: true, title: '标题'},
            {field: 'type', sort: true, title: '消息类型',templet:"#typeTpl"},
            {field: 'content', sort: true, title: '内容'},
            {field: 'toList', sort: true, title: '接收人'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {field: 'createUser', sort: true, title: '创建人'},
            {field: 'updateTime', sort: true, title: '修改时间'},
            {field: 'updateUser', sort: true, title: '修改人'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MiaoNotice.search = function () {
        var queryData = {};

        queryData['title'] = $('#title').val();

        table.reload(MiaoNotice.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    MiaoNotice.openAddDlg = function () {
        func.open({
            title: '添加通知表',
            content: Feng.ctxPath + '/miaoNotice/add',
            tableId: MiaoNotice.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      MiaoNotice.openEditDlg = function (data) {
          func.open({
              title: '修改通知表',
              content: Feng.ctxPath + '/miaoNotice/edit?noticeId=' + data.noticeId,
              tableId: MiaoNotice.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    MiaoNotice.exportExcel = function () {
        var checkRows = table.checkStatus(MiaoNotice.tableId);
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
    MiaoNotice.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/miaoNotice/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MiaoNotice.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("noticeId", data.noticeId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + MiaoNotice.tableId,
        url: Feng.ctxPath + '/miaoNotice/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MiaoNotice.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MiaoNotice.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    MiaoNotice.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        MiaoNotice.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MiaoNotice.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MiaoNotice.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MiaoNotice.onDeleteItem(data);
        }
    });
});

layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 个人动态管理
     */
    var MiaoPost = {
        tableId: "miaoPostTable"
    };

    /**
     * 初始化表格的列
     */
    MiaoPost.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'postId', hide: true, title: '主键id'},
            {field: 'title', sort: true, title: '动态标题'},
            {field: 'topicId', sort: true, title: '关联话题'},
            {field: 'userId', sort: true, title: '用户'},
            {field: 'file', sort: true, title: '动态图片'},
            {field: 'city', sort: true, title: '城市'},
            {field: 'location', sort: true, title: '详细位置'},
            {field: 'likeCount', sort: true, title: '点赞数量'},
            {field: 'hotCount', sort: true, title: '综合热度'},
            {field: 'commentCount', sort: true, title: '评论次数'},
            {field: 'seq', sort: true, title: '排序（0最小）'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MiaoPost.search = function () {
        var queryData = {};


        table.reload(MiaoPost.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    MiaoPost.openAddDlg = function () {
        func.open({
            title: '添加个人动态',
            content: Feng.ctxPath + '/miaoPost/add',
            tableId: MiaoPost.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      MiaoPost.openEditDlg = function (data) {
          func.open({
              title: '修改个人动态',
              content: Feng.ctxPath + '/miaoPost/edit?postId=' + data.postId,
              tableId: MiaoPost.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    MiaoPost.exportExcel = function () {
        var checkRows = table.checkStatus(MiaoPost.tableId);
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
    MiaoPost.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/miaoPost/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MiaoPost.tableId);
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
        elem: '#' + MiaoPost.tableId,
        url: Feng.ctxPath + '/miaoPost/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MiaoPost.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MiaoPost.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    MiaoPost.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        MiaoPost.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MiaoPost.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MiaoPost.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MiaoPost.onDeleteItem(data);
        }
    });
});

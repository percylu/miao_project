layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 话题维护管理
     */
    var MiaoTopic = {
        tableId: "miaoTopicTable"
    };

    /**
     * 初始化表格的列
     */
    MiaoTopic.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'topicId', hide: true, title: '主键id'},
            {field: 'title', sort: true, title: '主题名称'},
            {field: 'subTitle', sort: true, title: '子主题名称'},
            {field: 'img', sort: true, title: '主题图片',templet:'#imgTpl'},
            {field: 'hotCount', sort: true, title: '热度'},
            {field: 'joinCount', sort: true, title: '参与次数'},
            {field: 'likeCount', sort: true, title: '点赞次数'},
            {field: 'commentCount', sort: true, title: '评论次数'},
            {field: 'seq', sort: true, title: '排序（0最小）'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MiaoTopic.search = function () {
        var queryData = {};


        table.reload(MiaoTopic.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    MiaoTopic.openAddDlg = function () {
        func.open({
            title: '添加话题维护',
            content: Feng.ctxPath + '/miaoTopic/add',
            tableId: MiaoTopic.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      MiaoTopic.openEditDlg = function (data) {
          func.open({
              title: '修改话题维护',
              content: Feng.ctxPath + '/miaoTopic/edit?topicId=' + data.topicId,
              tableId: MiaoTopic.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    MiaoTopic.exportExcel = function () {
        var checkRows = table.checkStatus(MiaoTopic.tableId);
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
    MiaoTopic.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/miaoTopic/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MiaoTopic.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("topicId", data.topicId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + MiaoTopic.tableId,
        url: Feng.ctxPath + '/miaoTopic/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MiaoTopic.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MiaoTopic.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    MiaoTopic.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        MiaoTopic.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MiaoTopic.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MiaoTopic.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MiaoTopic.onDeleteItem(data);
        }
    });
});

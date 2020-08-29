layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 喵小小文章管理
     */
    var MiaoArticle = {
        tableId: "miaoArticleTable"
    };

    /**
     * 初始化表格的列
     */
    MiaoArticle.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'articleId', hide: true, title: '主键ID'},
            {field: 'articleTitle', sort: true, title: '文章标题'},
            {field: 'articleEditor', sort: true, title: '作者'},
            {field: 'articleFrom', sort: true, title: '文章来源'},
            {field: 'articleCompany', sort: true, title: '发布机构'},
            {field: 'updateTime', sort: true, title: '更新时间'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MiaoArticle.search = function () {
        var queryData = {};

        queryData['articleTitle'] = $('#articleTitle').val();
        queryData['createTime'] = $('#createTime').val();

        table.reload(MiaoArticle.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    MiaoArticle.openAddDlg = function () {
        func.open({
            title: '添加喵小小文章',
            content: Feng.ctxPath + '/miaoArticle/add',
            tableId: MiaoArticle.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      MiaoArticle.openEditDlg = function (data) {
          func.open({
              title: '修改喵小小文章',
              content: Feng.ctxPath + '/miaoArticle/edit?articleId=' + data.articleId,
              tableId: MiaoArticle.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    MiaoArticle.exportExcel = function () {
        var checkRows = table.checkStatus(MiaoArticle.tableId);
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
    MiaoArticle.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/miaoArticle/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MiaoArticle.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("articleId", data.articleId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + MiaoArticle.tableId,
        url: Feng.ctxPath + '/miaoArticle/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MiaoArticle.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MiaoArticle.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    MiaoArticle.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        MiaoArticle.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MiaoArticle.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MiaoArticle.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MiaoArticle.onDeleteItem(data);
        }
    });
});

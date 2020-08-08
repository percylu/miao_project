layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 广告图管理管理
     */
    var MiaoBanner = {
        tableId: "miaoBannerTable"
    };

    /**
     * 初始化表格的列
     */
    MiaoBanner.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'bannerId', hide: true, title: '主键ID'},
            {field: 'bannerImg', sort: true, title: '广告图',templet:"#bannerImgTpl",},
            {field: 'bannerUrl', sort: true, title: '广告URL'},
            {field: 'updatetime', sort: true, title: '更新时间'},
            {field: 'createtime', sort: true, title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MiaoBanner.search = function () {
        var queryData = {};


        table.reload(MiaoBanner.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    MiaoBanner.openAddDlg = function () {
        func.open({
            title: '添加广告图管理',
            content: Feng.ctxPath + '/miaoBanner/add',
            tableId: MiaoBanner.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      MiaoBanner.openEditDlg = function (data) {
          func.open({
              title: '修改广告图管理',
              content: Feng.ctxPath + '/miaoBanner/edit?bannerId=' + data.bannerId,
              tableId: MiaoBanner.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    MiaoBanner.exportExcel = function () {
        var checkRows = table.checkStatus(MiaoBanner.tableId);
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
    MiaoBanner.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/miaoBanner/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MiaoBanner.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("bannerId", data.bannerId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + MiaoBanner.tableId,
        url: Feng.ctxPath + '/miaoBanner/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MiaoBanner.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MiaoBanner.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    MiaoBanner.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        MiaoBanner.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MiaoBanner.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MiaoBanner.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MiaoBanner.onDeleteItem(data);
        }
    });
});

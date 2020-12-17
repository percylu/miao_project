layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 商品维护管理
     */
    var MiaoProduct = {
        tableId: "miaoProductTable"
    };

    /**
     * 初始化表格的列
     */
    MiaoProduct.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'productId', hide: true, title: '主键id'},
            {field: 'name', sort: true, title: '商品名称'},
            {field: 'originalPrice', sort: true, title: '商品原价'},
            {field: 'salePrice', sort: true, title: '销售价格'},
            {field: 'promotion', sort: true, title: '首页促销',templet:"#promotionTpl"},
            {field: 'img', sort: true, title: '商品图片',templet: "#imgTpl"},
            {field: 'platform', sort: true, title: '平台来源'},
            {field: 'link', sort: true, title: '跳转链接'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MiaoProduct.search = function () {
        var queryData = {};


        table.reload(MiaoProduct.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    MiaoProduct.openAddDlg = function () {
        func.open({
            title: '添加商品维护',
            content: Feng.ctxPath + '/miaoProduct/add',
            tableId: MiaoProduct.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      MiaoProduct.openEditDlg = function (data) {
          func.open({
              title: '修改商品维护',
              content: Feng.ctxPath + '/miaoProduct/edit?productId=' + data.productId,
              tableId: MiaoProduct.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    MiaoProduct.exportExcel = function () {
        var checkRows = table.checkStatus(MiaoProduct.tableId);
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
    MiaoProduct.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/miaoProduct/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MiaoProduct.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("productId", data.productId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + MiaoProduct.tableId,
        url: Feng.ctxPath + '/miaoProduct/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MiaoProduct.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MiaoProduct.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    MiaoProduct.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        MiaoProduct.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MiaoProduct.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MiaoProduct.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MiaoProduct.onDeleteItem(data);
        }
    });
});

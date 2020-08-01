layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 宠物数据管理
     */
    var MiaoPetData = {
        tableId: "miaoPetDataTable"
    };

    /**
     * 初始化表格的列
     */
    MiaoPetData.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'petDataId', hide: true, title: '主键id'},
            {field: 'petId', sort: true, title: '宠物ID'},
            {field: 'weight', sort: true, title: '排泄物重量'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MiaoPetData.search = function () {
        var queryData = {};


        table.reload(MiaoPetData.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    MiaoPetData.openAddDlg = function () {
        func.open({
            title: '添加宠物数据',
            content: Feng.ctxPath + '/miaoPetData/add',
            tableId: MiaoPetData.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      MiaoPetData.openEditDlg = function (data) {
          func.open({
              title: '修改宠物数据',
              content: Feng.ctxPath + '/miaoPetData/edit?petDataId=' + data.petDataId,
              tableId: MiaoPetData.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    MiaoPetData.exportExcel = function () {
        var checkRows = table.checkStatus(MiaoPetData.tableId);
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
    MiaoPetData.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/miaoPetData/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MiaoPetData.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("petDataId", data.petDataId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + MiaoPetData.tableId,
        url: Feng.ctxPath + '/miaoPetData/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MiaoPetData.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MiaoPetData.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    MiaoPetData.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        MiaoPetData.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MiaoPetData.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MiaoPetData.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MiaoPetData.onDeleteItem(data);
        }
    });
});

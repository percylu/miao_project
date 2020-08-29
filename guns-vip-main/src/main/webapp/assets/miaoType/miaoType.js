layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 宠物品种管理
     */
    var MiaoType = {
        tableId: "miaoTypeTable"
    };

    /**
     * 初始化表格的列
     */
    MiaoType.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'typeId', hide: true, title: '主键ID'},
            {field: 'typeName', sort: true, title: '品种名称'},
            {field: 'updateTime', sort: true, title: '更新时间'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MiaoType.search = function () {
        var queryData = {};


        table.reload(MiaoType.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    MiaoType.openAddDlg = function () {
        func.open({
            title: '添加宠物品种',
            content: Feng.ctxPath + '/miaoType/add',
            tableId: MiaoType.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      MiaoType.openEditDlg = function (data) {
          func.open({
              title: '修改宠物品种',
              content: Feng.ctxPath + '/miaoType/edit?typeId=' + data.typeId,
              tableId: MiaoType.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    MiaoType.exportExcel = function () {
        var checkRows = table.checkStatus(MiaoType.tableId);
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
    MiaoType.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/miaoType/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MiaoType.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("typeId", data.typeId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + MiaoType.tableId,
        url: Feng.ctxPath + '/miaoType/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MiaoType.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MiaoType.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    MiaoType.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        MiaoType.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MiaoType.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MiaoType.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MiaoType.onDeleteItem(data);
        }
    });
});

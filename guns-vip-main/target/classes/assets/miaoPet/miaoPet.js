layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 宠物管理管理
     */
    var MiaoPet = {
        tableId: "miaoPetTable"
    };

    /**
     * 初始化表格的列
     */
    MiaoPet.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'petId', hide: true, title: '主键id'},
            {field: 'userId', sort: true, title: '所属用户'},
            {field: 'name', sort: true, title: '名字'},
            {field: 'type', sort: true, title: '品种'},
            {field: 'sexy', sort: true, title: '性别'},
            {field: 'weight', sort: true, title: '重量'},
            {field: 'birthday', sort: true, title: '生日'},
            {field: 'rdid', sort: true, title: 'RFID'},
            {field: 'imgurls', sort: true, title: '图片'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {field: 'updateTime', sort: true, title: '更新时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MiaoPet.search = function () {
        var queryData = {};


        table.reload(MiaoPet.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    MiaoPet.openAddDlg = function () {
        func.open({
            title: '添加宠物管理',
            content: Feng.ctxPath + '/miaoPet/add',
            tableId: MiaoPet.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      MiaoPet.openEditDlg = function (data) {
          func.open({
              title: '修改宠物管理',
              content: Feng.ctxPath + '/miaoPet/edit?petId=' + data.petId,
              tableId: MiaoPet.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    MiaoPet.exportExcel = function () {
        var checkRows = table.checkStatus(MiaoPet.tableId);
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
    MiaoPet.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/miaoPet/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MiaoPet.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("petId", data.petId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + MiaoPet.tableId,
        url: Feng.ctxPath + '/miaoPet/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MiaoPet.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MiaoPet.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    MiaoPet.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        MiaoPet.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MiaoPet.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MiaoPet.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MiaoPet.onDeleteItem(data);
        }
    });
});

layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * App用户管理管理
     */
    var MiaoUser = {
        tableId: "miaoUserTable"
    };

    /**
     * 初始化表格的列
     */
    MiaoUser.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'userId', hide: true, title: '主键id'},
            {field: 'avatar', sort: true, title: '头像',templet:"#avatarImgTpl", },
            {field: 'account', sort: true, title: '账号'},
            {field: 'name', sort: true, title: '名字'},
            {field: 'sex', sort: true, title: '性别',templet:"#sexTpl",},
            {field: 'status', sort: true, title: '状态',templet:"#statusTpl",},
            {field: 'createTime', sort: true, title: '创建时间'},
            {field: 'updateTime', sort: true, title: '更新时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    MiaoUser.search = function () {
        var queryData = {};


        table.reload(MiaoUser.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    MiaoUser.openAddDlg = function () {
        func.open({
            title: '添加App用户管理',
            content: Feng.ctxPath + '/miaoUser/add',
            tableId: MiaoUser.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      MiaoUser.openEditDlg = function (data) {
          func.open({
              title: '修改App用户管理',
              content: Feng.ctxPath + '/miaoUser/edit?userId=' + data.userId,
              tableId: MiaoUser.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    MiaoUser.exportExcel = function () {
        var checkRows = table.checkStatus(MiaoUser.tableId);
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
    MiaoUser.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/miaoUser/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(MiaoUser.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("userId", data.userId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + MiaoUser.tableId,
        url: Feng.ctxPath + '/miaoUser/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: MiaoUser.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        MiaoUser.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    MiaoUser.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        MiaoUser.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + MiaoUser.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            MiaoUser.openEditDlg(data);
        } else if (layEvent === 'delete') {
            MiaoUser.onDeleteItem(data);
        }
    });
});

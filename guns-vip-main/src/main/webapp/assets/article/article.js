layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Article = {
        tableId: "articleTable"
    };

    /**
     * 初始化表格的列
     */
    Article.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: 'ID'},
            {field: 'name', sort: true, title: '名称'},
            {field: 'articleKey', sort: true, title: 'key'},
            // {field: 'content', sort: true, title: ''},
            {field: 'createDate', sort: true, title: '创建时间'},
            {field: 'updateDate', sort: true, title: '更新时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Article.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Article.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Article.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/article/add',
            tableId: Article.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Article.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/article/edit?id=' + data.id,
            tableId: Article.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Article.exportExcel = function () {
        var checkRows = table.checkStatus(Article.tableId);
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
    Article.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/article/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Article.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", data.id);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Article.tableId,
        url: Feng.ctxPath + '/article/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Article.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Article.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Article.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Article.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Article.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Article.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Article.onDeleteItem(data);
        }
    });
});

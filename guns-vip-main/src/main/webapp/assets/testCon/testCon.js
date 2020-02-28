layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var TestCon = {
        tableId: "testConTable"
    };

    /**
     * 初始化表格的列
     */
    TestCon.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'Id', hide: true, title: 'ID'},
            {field: 'Name', sort: true, title: '合同名称'},
            {field: 'ConId', sort: true, title: '合同编号'},
            {field: 'Sman', sort: true, title: '发起方'},
            {field: 'ConDate', sort: true, title: '合同截止日期'},
            {field: 'Eman', sort: true, title: '接收方'},
            {field: 'ConSignDate', sort: true, title: '发起签约时间'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    TestCon.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(TestCon.tableId, {
            where: queryData, page: {curr: 1}
        });//queryData传递的参数，通过调用/list重新访问，然后刷新列表
    };

    /**
     * 弹出添加对话框
     */
    TestCon.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/testCon/add',
            tableId: TestCon.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    TestCon.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/testCon/edit?Id=' + data.Id,
            tableId: TestCon.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    TestCon.exportExcel = function () {
        var checkRows = table.checkStatus(TestCon.tableId);
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
    TestCon.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/testCon/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(TestCon.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("Id", data.Id);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + TestCon.tableId,
        url: Feng.ctxPath + '/testCon/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: TestCon.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        TestCon.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        TestCon.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        TestCon.exportExcel();
    });

    //显示详情事件
    TestCon.onDetail = function (data) {
        func.open({
            title: '详情',
            content: Feng.ctxPath + '/testCon/detail/' + data.Id,
            tableId: TestCon.tableId
        });
        //alert(data)
    };

    // 工具条点击事件
    table.on('tool(' + TestCon.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            TestCon.openEditDlg(data);
        } else if (layEvent === 'delete') {
            TestCon.onDeleteItem(data);
        } else if(layEvent === 'detail'){
            TestCon.onDetail(data);
        }
    });
});

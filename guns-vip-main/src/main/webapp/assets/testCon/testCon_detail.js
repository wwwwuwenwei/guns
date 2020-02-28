/**
 * 添加或者修改页面
 */
var TestConInfoDlg = {
    data: {
        Name: "",
        ConId: "",
        Sman: "",
        ConDate: "",
        Eman: "",
        ConSignDate: ""
    }
};

layui.use(['form', 'admin', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;

    // var ajax = new $ax(Feng.ctxPath + "/testCon/showDetail?id=3", function (data) {
    //     Feng.success("成功！");
    // }, function (data) {
    //     Feng.error("失败！");
    // });
    // ajax.start();

    $.ajax({
        type: "GET",
        url: Feng.ctxPath + "/testCon/showDetail",
        data: {id:"3"},
        dataType: "json",
        success: function(data){
           console.log(data)
        }
    });



});
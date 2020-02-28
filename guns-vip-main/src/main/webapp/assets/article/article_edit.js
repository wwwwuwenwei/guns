/**
 * 详情对话框
 */
var ArticleInfoDlg = {
    data: {
        content: "",
        lastdate: "",
        cratedate: "",
        articleKey: "",
        name: "",
        id: ""
    }
};

layui.use(['form', 'admin', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;

    //获取详情信息，填充表单
    var ajax = new $ax(Feng.ctxPath + "/article/detail?id=" + Feng.getUrlParam("id"));
    var result = ajax.start();
    if(result!=null&&result.data!=null){
        form.val('articleForm', result.data);
        if(result.data.content!=null){
            var content = result.data.content;
            // content = content.replace(/& amp;/g,"&" );
            // content = content.replace(/& lt;/g, "<");
            // content = content.replace(/& gt;/g, ">");
            // content = content.replace(/& quot;/g, "\"");//引号
            // window.editor.html(content);
            // window.editor.sync();
            editor.txt.html(result.data.content);
        }
    }

    // 对Date的扩展，将 Date 转化为指定格式的String
    Date.prototype.Format = function (fmt) { // author: meizz
        var o = {
            "M+": this.getMonth() + 1, // 月份
            "d+": this.getDate(), // 日
            "h+": this.getHours(), // 小时
            "m+": this.getMinutes(), // 分
            "s+": this.getSeconds(), // 秒
            "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
            "S": this.getMilliseconds() // 毫秒
        };
        if (/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    };

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {

        var ajax = new $ax(Feng.ctxPath + "/article/editItem", function (data) {
            Feng.success("更新成功！");
            //传给上个页面，刷新table用
            admin.putTempData('formOk', true);
            //关掉对话框
            admin.closeThisDialog();
        }, function (data) {
            Feng.error("更新失败！" + data.responseJSON.message)
        });
        data.field.content = editor.txt.html();
        data.field.lastdate = new Date().Format("yyyy-MM-dd hh:mm:ss");
        ajax.set(data.field);
        ajax.start();

        // window.editor.sync();
        // data.field.content = document.getElementById("content").value;

        return false;
    });

});
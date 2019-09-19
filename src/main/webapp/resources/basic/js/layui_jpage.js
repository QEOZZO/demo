var layuiJpage = function (options) {
    layui.use(['table', 'form'], function () {
        var table = layui.table;
        var opts = $.extend(new Object(), layuiJpage.defaults, options);
        table.render(opts);
        //监听提交
        layui.form.on('submit(' + opts.search_lay_filter + ')', function (data) {
            var formData = data.field;
            //执行重载
            table.reload(opts.reload_elem, {
                where: formData
            });
            return false;//false：阻止表单跳转  true：表单跳转
        });
    });
};

layuiJpage.defaults = {
    search_lay_filter: 'search', // 查询按钮lay-filter属性值
    reload_elem: 'table-data', //table的id
    elem: '#table-data', //table的id
    url: "", //数据接口地址
    where: $('#searchForm').serializeJSON(), //表单数据
    method: 'post', //提交方式
    request: {
        pageName: 'pageNo', //页码的参数名称，默认：page
        limitName: 'pageSize' //每页数据量的参数名，默认：limit
    },
    response: {
        statusCode: 's200' //规定成功的状态码，默认：0
    },
    cols: '', //列表需要展示的数据，需要重写
    parseData: function (res) { //res 即为原始返回的数据
        return {
            "code": res.status, //解析接口状态
            "msg": parseMsg(res), //解析提示文本
            "count": res.data == null ? 0 : res.data.totalCount, //解析数据长度
            "data": res.data == null ? '' : res.data.result //解析数据列表
        };
    },
    //,skin: 'line' //表格风格
    even: true,
    page: true, //是否显示分页,
    limits: [5, 7, 10],
    limit: 10, //每页默认显示的数量
    groups: 5 //连续出现的页码个数
};

//解析提示文本
function parseMsg(result) {
    if (result.status == "s500") {
        return "服务器遇到问题，请重试！";
    } else if (result.status == "s400") {
        return "您提交的数据有误！";
    } else if (result.status == "s401") {
        return result.msg;
    } else if (result.status == "s403") {
        return "没有访问权限！";
    }
    return result.msg;
}

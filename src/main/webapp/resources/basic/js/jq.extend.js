$.extend({
    myAjax: function (options) {
        var defaults = {
            showLoading: true,
            beforeSend: function (request) {

            },
            dataHandler: function (result) {
                return result;
            },
            complete: function (xhr, ts) {

            }
        };
        var opts = $.extend(defaults, options);

        var temp_beforeSend = opts.beforeSend;
        opts.beforeSend = function (request) {
            if (opts.showLoading) {
                opts.loding = layer.load(1, {shade: [0.4, '#000']});
            }
            var header = $("meta[name='_csrf_header']").attr("content");
            var token = $("meta[name='_csrf']").attr("content");
            if (typeof header != "undefined" && null != header && "" != header && typeof token != "undefined" && null != token && "" != token) {
                request.setRequestHeader(header, token);
            }
            return temp_beforeSend(request);
        };
        var temp_complete = opts.complete;
        opts.complete = function (xhr, ts) {
            if (typeof opts.loding != "undefined") {
                layer.close(opts.loding);
            }
            temp_complete(xhr, ts);
        };

        var temp_success = opts.success;
        opts.success = function (result) {
            if (result.status == "s500") {
                layer.alert("服务器遇到问题，请重试！", {
                    icon: 5,
                    shadeClose: true,
                    title: "系统提示"
                });
            } else if (result.status == "s400") {
                layer.alert("您提交的数据有误！", {
                    icon: 5,
                    shadeClose: true,
                    title: "系统提示"
                });
            } else if (result.status == "s401") {
                layer.alert(result.msg, {
                    icon: 5,
                    shadeClose: true,
                    title: "系统提示"
                });
            } else if (result.status == "s403") {
                layer.alert("没有访问权限！", {
                    icon: 5,
                    shadeClose: true,
                    title: "系统提示"
                });
            } else if (result.status == "s404") {
                layer.alert("信息未找到！", {
                    icon: 5,
                    shadeClose: true,
                    title: "系统提示"
                });
            }else if(result.status=="s999"){
                layer.alert("请求已被处理！", {
                    icon: 5,
                    shadeClose: true,
                    title: "系统提示"
                });
            }
            temp_success(opts.dataHandler(result));
        };
        $.ajax(opts);
    }
});
$.extend({
    myDataGridAjax: function (options) {
        options.showLoading = false;
        options.dataHandler = function (result) {
            var obj = new Object();
            obj.rows = result.data.result ? result.data.result : [];
            obj.total = result.data.totalCount ? result.data.totalCount : 0;
            return obj;
        };
        $.myAjax(options);
    }
});
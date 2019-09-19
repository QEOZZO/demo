/**
 * layer弹出层关闭自己
 */
function closeSelfLayer(){
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}
$(function(){
    //layer关闭按钮绑定关闭事件
	$(".m-close-layer").click(function(){
		closeSelfLayer();
	});
});

function closeFrameLayer(winame){
	layer.close(layer.getFrameIndex(winame));
}

/**
 * list页弹出的layer层执行成功后回调方法（关闭layer层并刷新列表）
 * @param winame
 */
function onLayerSuccess(winame,tableId){
	var index =layer.index;
	if(!isNullOrEmpty(winame)){
		index =layer.getFrameIndex(winame);
	}
	var default_table_id="table-data";
	if(!isNullOrEmpty(tableId)){
        default_table_id=tableId;
    }
	layui.table.reload(default_table_id);
	layer.close(index);
	layer.msg("保存成功",{time:3000});

}
/**
 * 弹出的layer层执行成功后回调方法（关闭layer层并刷新页面）
 * @param winame
 */
function onLayerSuccess2(winame){
    var index =layer.index;
    if(!isNullOrEmpty(winame)){
        index = parent.layer.getFrameIndex(winame);
    }
    layer.close(index);
    layer.msg("保存成功",{time:3000});
    window.location.reload();
}

function lockLayer(msg,fn){
    layer.alert(msg, {icon: 4,shadeClose: true,title: "系统提示"},fn);
}
function errorLayer(msg,fn){
    layer.alert(msg, {icon: 5,shadeClose: true,title: "系统提示"},fn);
}
function successLayer(msg,fn){
    layer.alert(msg, {icon: 6,shadeClose: true,title: "系统提示"},fn);
}
function warnLayer(msg,fn){
    layer.alert(msg, {icon: 7,shadeClose: true,title: "系统提示"},fn);
}

/**
 * 确认提示框
 * @param msg 消息内容
 * @param btn1 按钮1
 * @param btn2 按钮2
 * @param fn1 按钮1执行的方法
 * @param fn2 按钮2执行的方法
 */
function confirmLayer(msg,btn1,btn2,fn1,fn2){
    if(typeof btn1 == "function"){
        fn1 = btn1;

        if(typeof btn2 == "function"){
            fn2 = btn2;
        }
    }else{
        if(typeof btn2 == "function"){
            fn1 = btn2;
        }
    }
    if(typeof btn1 != "string"){
        btn1 = "确定";
    }
    if(typeof btn2 != "string"){
        btn2 = "取消";
    }
    if(typeof fn1!= "function"){
        fn1 = null;
    }
    if(typeof fn2!= "function"){
        fn2 = null;
    }
    layer.confirm(msg, {icon: 3,shadeClose: true,title: "系统提示",btn: [btn1,btn2]}, fn1,fn2);
}

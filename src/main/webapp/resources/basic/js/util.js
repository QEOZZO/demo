// String.prototype.trim = function (){
// 	return this.replace(/(^\s*)|(\s*$)/g, "");
// };
// String.prototype.ltrim = function (){
// 	return this.replace(/(^\s*)/g, "");
// };
// String.prototype.rtrim = function () {
// 	return this.replace(/(\s*$)/g, "");
// };
String.prototype.endWith=function(str){
	if(str==null||str==""||this.length==0||str.length>this.length){
		return false;
	}
	if(this.substring(this.length-str.length)==str){
		return true;
	}
	else{
		return false;
	}
};
String.prototype.startWith=function(str){
	if(str==null||str==""||this.length==0||str.length>this.length){
		return false;
	}
	if(this.substr(0,str.length)==str){
		return true;
	}
	else{
		return false;
	}
};
/**根据form和input名称设置checkbox
 * @param frmName
 * @param iptName
 * @param values
 */
function checkedByFormNameAndIptName(frmName,iptName,values){
	var array=values.split(",");
	$("form[name="+frmName+"] input[name="+iptName+"]:checkbox").each(function(){
		for ( var i = 0; i < array.length; i++) {
			if(array[i] == this.value){
				this.checked="true";
				return;
			}
		}
	});
}

/**
 *根据父元素ID和input名称设置checkbox
 * @param pId 父元素ID
 * @param iptName
 * @param values
 */
function checkedByPIdAndIptName(pId,iptName,values){
	var array=values.split(",");
	$("#"+pId+" input[name="+iptName+"]:checkbox").each(function(){
		for ( var i = 0; i < array.length; i++) {
			if(array[i] == this.value){
				this.checked="true";
				return;
			}
		}
	});
}

/**根据form和input名称设置radio
 * @param frm
 * @param ipt
 * @param values
 */
function radioCheckedByFormAndName(frm,ipt,value){
	$("form[name="+frm+"] input[name="+ipt+"]:radio").each(function(){
		if(value == this.value){
			this.checked="true";
			return;
		}
	});	
}
/**根据select的id和value设置select
 * @param id
 * @param value
 */
function selectedByValue(id,value){
	$("#"+id).val(value);
}
/**根据name值设置复选框为单选效果
 * @param name
 */
function setToRadio(name){
	$("input[name="+name+"]").click(function(){
		var this_1 = this;
		$("input[name="+name+"]").each(function(){
			if(this_1 != this){
				this.checked = false;
			}
		});
	});
}

/**
 * 转义html字符（防止页面注入）
 * @param s
 * @returns {*}
 */
function escapeHtml(s){
	if(null == s) {s = "";}
	if(typeof s == "string"){
		s = s.replace("<","&lt;");
		s = s.replace(">","&gt;");
		s = s.replace("\"","&#34;");
	}
	return s;
}

/**
 * 超长截取
 * @param s 要处理的字符串
 * @param len 最大长度
 * @param f 超长截取后是否追加三个点的省略号
 * @returns {*}
 */
function substring(s,len,f){
	if(typeof s == "undefined" || s == null) return "";
	if(s.length <= len) return s;
	if(f) return s.substr(0,len-1)+"...";
	return s.substr(0,len);
}

/**
 * 判断字符串是否为null或空字符串
 * @param s 要判断的字符串
 * @returns {boolean}
 */
function isNullOrEmpty(s){
	if(typeof s == "undefined" || s === null || s === "null" || s === "NULL" || s === ""){
		return true;
	}else{
		return false;
	}
}
function nullToEmpty(s){
	if(isNullOrEmpty(s)){
		return "";
	}else{
		return s;
	}
}

function countWord(ipt,tip,max){
	var v_content = $(ipt).val();
	if(v_content.length > max){
		v_content = v_content.substring(0,max);
		$(ipt).val(v_content);
	}
	$(tip).html(max - v_content.length);
}

/**
 * 剩余字符数计算显示
 * @param ipt 输入框选择器
 * @param tip 剩余字符显示标签选择器
 * @param max 最大字符数
 */
function bindCountWord(ipt,tip,max){
	$(ipt).keydown(function(){
		countWord(ipt,tip,max);
	});
	$(ipt).keyup(function(){
		countWord(ipt,tip,max);
	});
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
	layer.confirm(msg, {icon: 3,shadeClose: true,title: "系统提示",btn: [btn1,btn2]}, fn1,fn2);
}


/**
 * 校验radio单选框是否选中
 * @param value
 * @param item
 * @param form_id 表单ID
 * @param msg 返回的提示消息
 */
function radioCheck(value, item, form_id, msg) {
	var verifyName = $(item).attr('name'),
		verifyType = $(item).attr('type'),
		formElem = $(item).parents('#' + form_id + ''),//获取当前所在的form元素，如果存在的话
		verifyElem = formElem.find('input[name=' + verifyName + ']'),//获取需要校验的元素
		isTrue = verifyElem.is(':checked'),//是否命中校验
		focusElem = verifyElem.next().find('i.layui-icon');//焦点元素
	if (!isTrue || !value) {
		//定位焦点
		focusElem.css(verifyType == 'radio' ? {"color": "#FF5722"} : {"border-color": "#FF5722"});
		//对非输入框设置焦点
		focusElem.first().attr("tabIndex", "1").css("outline", "0").blur(function () {
			focusElem.css(verifyType == 'radio' ? {"color": ""} : {"border-color": ""});
		}).focus();
		return msg;
	}
}


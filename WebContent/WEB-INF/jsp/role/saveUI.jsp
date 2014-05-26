<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>角色列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
    <script type="text/javascript">
	function updateType(option) {
		// 传替页面参数，且返回回来
		var parm = "?k=1";
		for (name in option) {
			parm += "&" + name + "=" + option[name];
		}

		window.location.href = "role_addUI.action" + parm;
	}
    </script>
</head>
<body> 

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 角色设置
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">

    <s:form action="role_%{ id == null ? 'add' : 'edit' }">
    	<s:hidden name="id"></s:hidden>
    
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 岗位信息 </DIV>  -->
			<s:if test="id == null">
	    		请选择角色类型：
				<s:select name="type"
					list="#{'1':'系统','2':'科目内容管理'}"
					headerKey="" headerValue="请选择"
					onchange="updateType({type:this.value});"></s:select>		
			
			</s:if>
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table class="mainForm">
                    <tr>
                        <td width="100">角色名称</td>
                        <td><s:textfield name="name" cssClass="InputStyle" /> *</td>
                    </tr>
                    <tr>
                        <td>角色说明</td>
                        <td><s:textarea name="description" cssClass="TextareaStyle"></s:textarea></td>
                    </tr>                
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
        </div>
    </s:form>
</div>

</body>
</html>


<%@page import="com.tms.entity.chapter.Chapter"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>科目管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.js"></script>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/file.css" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/script/jquery_treeview/jquery.treeview.css" />
	<script type="text/javascript">
	function menuClick( menu ){
		$(menu).next().toggle();
	}
	</script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 科目管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="subject_list">
    	<s:hidden name="id"></s:hidden>
    
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 正在为【】配置权限 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table class="mainForm">
					<!--表头-->
					<thead>
						<tr align="LEFT" valign="MIDDLE" id="TableTitle">
							<td width="300px" style="padding-left: 7px;">
								<span>科目管理</span>
							</td>
						</tr>
					</thead>
                   
			   		<!--显示数据列表-->
					<tbody id="TableData">
						<tr class="TableDetail1">
							<!-- 显示权限树 -->
							<td>

<!-- 显示树状结构内容 -->
<ul id="tree">
<s:iterator value="subjectList" var="subject">
	<li>
		<div onClick="menuClick(this);" class="level1Style">
			<input type="hidden"  value="${id}"/>
			<label for="cb_${id}" ><span class="folder" >${name}</span></label>
		</div>
		
		<ul>
		<s:iterator value="chapterList" var="chapter">
			
			<s:if test="#subject.id == #chapter.subject.id" >
			<li>
				<div onClick="menuClick(this);" class="level1Style">
					<input type="hidden"  value="${id}" id="cb_${id}"/>					
					<label for="cb_${id}"><span class="folder">${name}</span></label>
				</div>
				<ul>
				<s:iterator value="sectionList" var="section">
					<s:if test="#chapter.id == #section.chapter.id" >				
						<li>
							<input type="hidden"  value="${id}" id="cb_${id}"  />
							<label for="cb_${id}"><span class="folder">${name}</span></label>
						</li>
					</s:if>
				</s:iterator>										
				</ul>
			</li>		
			</s:if>
		</s:iterator>
		</ul>
	</li>
</s:iterator>
</ul>

							</td>
						</tr>
					</tbody>
                </table>
            </div>
        </div>
        
        <script type="text/javascript">
        	$("#tree").treeview();
        </script>

    </s:form>
</div>     

<div class="Description">
	说明：<br />
	1，选中一个权限时：<br />
	&nbsp;&nbsp;&nbsp;&nbsp; a，应该选中他的所有直系上级。<br />
	&nbsp;&nbsp;&nbsp;&nbsp; b，应该选中他的所有直系下级。<br />
	2，取消选择一个权限时：<br />
	&nbsp;&nbsp;&nbsp;&nbsp; a，应该取消选择他的所有直系下级。<br />
	&nbsp;&nbsp;&nbsp;&nbsp; b，如果同级的权限都是未选择状态，就应该取消选中他的直接上级，并向上做这个操作。<br />

	3，全选/取消全选。<br />
	4，默认选中当前岗位已有的权限。<br />
</div>

</body>
</html>
    
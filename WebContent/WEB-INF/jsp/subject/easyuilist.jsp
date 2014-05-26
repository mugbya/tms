<%@page import="com.tms.entity.chapter.Chapter"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<title>科目管理</title>
<meta name="keywords" content="jquery,ui,easy,easyui,web">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/script/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/script/pageCommon.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/script/PageUtils.js"
	charset="utf-8"></script>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/script/jquery-easyui-1.3.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/script/jquery-easyui-1.3.6/themes/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/script/jquery-easyui-1.3.6/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/script/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#menu").tree({
			onContextMenu : function(e, node) {
				e.preventDefault();
				$(this).tree('select', node.target);
				$('#mm').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			}
		});

	});

	/* 对添加事件的处理 */
	function append() {
		var t = $('#menu');
		var node = t.tree('getSelected');

		/*增加科目*/
		if (node.attributes.nodeType == 0) {
			window.location.href = "subject_addUI.action";
		}

		/*增加课程*/
		if (node.attributes.nodeType == 1) {
			var subjectId = node.attributes.nodeid;
			window.location.href = "chapter_addUI.action?subjectId="
					+ subjectId;
		}

		/*增加小节*/
		if (node.attributes.nodeType == 2) {
			var chapterId = node.attributes.nodeid;
			window.location.href = "section_addUI.action?chapterId="
					+ chapterId;
		}
	}

	/* 对修改事件的处理 */
	function edit() {
		var t = $('#menu');
		var node = t.tree('getSelected');

		/*修改课程名称*/
		if (node.attributes.nodeType == 1) {
			var subjectId = node.attributes.nodeid;
			window.location.href = "subject_editUI.action?id=" + subjectId;
		}

		/*修改章节*/
		if (node.attributes.nodeType == 2) {
			var chapterId = node.attributes.nodeid;
			window.location.href = "chapter_editUI.action?id=" + chapterId;
		}

		/*修改小节*/
		if (node.attributes.nodeType == 3) {
			var sectionId = node.attributes.nodeid;
			window.location.href = "section_editUI.action?id=" + sectionId;
		}
	}

	/*对移除事件的处理*/
	function removeit(){
		var t = $('#menu');
		var node = t.tree('getSelected');

		/*删除课程*/
		if (node.attributes.nodeType == 1) {
			var subjectId = node.attributes.nodeid;

			if (window.confirm("确认删除该课程及其子项吗？")) {
				window.location.href = "subject_delete.action?id=" + subjectId;
			}
			;
		}

		/*修改章节*/
		if (node.attributes.nodeType == 2) {
			var chapterId = node.attributes.nodeid;
			window.location.href = "chapter_editUI.action?id=" + chapterId;
		}

		/*修改小节*/
		if (node.attributes.nodeType == 3) {
			var sectionId = node.attributes.nodeid;
			window.location.href = "section_editUI.action?id=" + sectionId;
		}
	}
	
	function moveUp() {
		var node = $('#tt').tree('getSelected');
		$('#tt').tree('collapse', node.target);
	}
	function moveDown() {
		var node = $('#tt').tree('getSelected');
		$('#tt').tree('expand', node.target);
	}
</script>

</head>
<body>
	<!-- 标题显示 -->
	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				科目管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!-- 表单内容显示 -->
	<div class="ItemBlockBorder">
		<div class="ItemBlock">
			<table class="mainForm">
				<!--表头-->
				<thead>
					<tr align="LEFT" valign="MIDDLE" id="TableTitle">
						<td width="300px" style="padding-left: 7px;"><span>科目管理</span>
						</td>
					</tr>
				</thead>

				<!--显示数据列表-->
				<tbody id="TableData">
					<tr class="TableDetail1">
						<!-- 显示权限树 -->
						<td>
							<!-- 显示树状结构内容 -->
							<ul id="menu" class="easyui-tree" data-options="lines:true">
								<li data-options="'attributes':{'nodeType':'0'}"><span>科目列表</span>
									<ul>
										<s:iterator value="subjectList" var="subject">
											<li
												data-options="'attributes':{'nodeid':'${id}','nodeType':'1'}"><span>${name}</span>
												<ul>
													<s:iterator value="chapterList" var="chapter">
														<s:if test="#subject.id == #chapter.subject.id">
															<li
																data-options="'attributes':{'nodeid':'${id}','nodeType':'2'}"><span>${name}</span>
																<ul>
																	<s:iterator value="sectionList" var="section">
																		<s:if test="#chapter.id == #section.chapter.id">
																			<li
																				data-options="'attributes':{'nodeid':'${id}','nodeType':'3'}"><span>${name}</span></li>
																		</s:if>
																	</s:iterator>
																</ul></li>
														</s:if>
													</s:iterator>
												</ul></li>
										</s:iterator>
									</ul></li>
							</ul>

							<div id="mm" class="easyui-menu" style="width: 120px;">
								<div onclick="append()" data-options="iconCls:'icon-add'">添加</div>
								<div onclick="removeit()" data-options="iconCls:'icon-remove'">删除</div>
								<div onclick="edit()" data-options="iconCls:'icon-edit'">修改</div>
								<div class="menu-sep"></div>
								<div onclick="moveUp()">上移</div>
								<div onclick="moveDown()">下移</div>
							</div>

						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
<%@page import="com.tms.entity.chapter.Chapter"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<title>知识点管理</title>
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
			onClick : function(node) {
				if (node.attributes.nodeType == 4) {
					var desc = node.attributes.nodeDesc;
					$("#know-desc").html(desc);
				}
			},
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

		/*增加知识点*/
		if (node.attributes.nodeType == 3) {
				var sectionId = node.attributes.nodeid;
			window.location.href = "know_addUI.action?sectionId="+ sectionId;
		}
	}

	/* 对修改事件的处理 */
	function edit() {
		var t = $('#menu');
		var node = t.tree('getSelected');

		/*修改知识点*/
		if (node.attributes.nodeType == 4) {
			var node2=$('#menu').tree('getParent',node.target);
			var sectionId = node2.attributes.nodeid;
			
			var knowId = node.attributes.nodeid;
			window.location.href = "know_editUI.action?id=" + knowId + "&sectionId="+sectionId;
		}
	}

	/*对移除事件的处理*/
	function removeit() {
		var t = $('#menu');
		var node = t.tree('getSelected');

		/*删除知识点*/
		if (node.attributes.nodeType == 4) {
			var node2=$('#menu').tree('getParent',node.target);
			var sectionId = node2.attributes.nodeid;

			var knowId = node.attributes.nodeid;

			if (window.confirm("确认删除该知识点吗？")) {
				window.location.href = "know_delete.action?id=" + knowId + "&sectionId="+sectionId;
			}
			;
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
				知识点管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!-- 表单内容显示 -->


	<table class="TableStyle">
		<!--表头-->
		<thead>
			<tr align="LEFT" valign="MIDDLE" id="TableTitle">
				<td width="500px">知识点结构</td>
				<td>知识点描述</td>
			</tr>
		</thead>

		<!--显示数据列表-->
		<tbody id="TableData" class="dataContainer">
			<tr class="TableDetail1 template">
				<!-- 显示权限树 -->
				<td rowspan="3">
					<!-- 显示树状结构内容 -->
					<ul id="menu" class="easyui-tree" data-options="lines:true">
						<li data-options="'attributes':{'nodeType':'0'}"><span>科目列表</span>
							<ul>
								<s:iterator value="subjectList" var="subject">
									<li
										data-options="'attributes':{'nodeid':'${id}','nodeType':'1'}" state="closed"><span>${name}</span>
										<ul>
											<s:iterator value="chapterList" var="chapter">
												<s:if test="#subject.id == #chapter.subject.id">
													<li
														data-options="'attributes':{'nodeid':'${id}','nodeType':'2'}" state="closed"><span>${name}</span>
														<ul>
															<s:iterator value="sectionList" var="section">
																<s:if test="#chapter.id == #section.chapter.id">
																	<li
																		data-options="'attributes':{'nodeid':'${id}','nodeType':'3'}" state="closed" ><span>${name}</span>
																		<ul>
																			<s:iterator value="knows">
																				<li
																					data-options="'attributes':{'nodeid':'${id}','nodeDesc':'${description}','nodeType':'4'}"><span>${name}</span></li>
																			</s:iterator>
																		</ul></li>
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

				<td>
					<div id="know-desc"></div>
				</td>
			</tr>
			<tr>
				<td height="25px">题型及试题数统计信息</td>
			</tr>
			<tr>
				<td height="200px">
					<ul>
						<li>单选题：XX</li>
						<li>多选题：XX</li>
						<li>判断题：XX</li>
						<li>填空题：XX</li>
						<li>文字录入：XX</li>
						<li>操作题：XXX</li>
					</ul>
				</td>
			</tr>
	<!-- 
			<tr>
				<td align="center" colspan="2"><input type="button" value="新增"
					class="btn_add" /> <input type="button" value="删除" /> <input
					type="button" value="修改" /> <input type="button" value="上移" /> <input
					type="button" value="下移" /> <input type="button" value="试题" /> <input
					type="button" value="退出" /></td>
			</tr>	
	 -->
		</tbody>
	</table>



</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>试题列表</title>
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
<script type="text/javascript">
	//显示角色详细信息
	function showDetail(flag, a) {
		var detailDiv = a.parentNode.getElementsByTagName("div")[0];
		if (flag) {
			detailDiv.style.display = "block";
		} else {
			detailDiv.style.display = "none";
		}
	}
</script>

</head>
<body>

	<div id="Title_bar">
		<div id="Title_bar_Head">
			<div id="Title_Head"></div>
			<div id="Title">
				<!--页面标题-->
				<img border="0" width="13" height="13"
					src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
				试题管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<div id="MainArea">
		<table class="TableStyle">

			<!-- 表头-->
			<thead>
				<tr align="CENTER" valign="MIDDLE" id="TableTitle">
					<td width="400px">试题名称</td>
					<td width="200px">试题答案</td>
					<td width="50px">难度</td>
					<td width="50px">分值</td>
					<td width="50px">试题类型</td>
					<td width="50px">所属题库</td>
					<td width="300px">从属知识点</td>
					<td width="100px">相关操作</td>
				</tr>
			</thead>

			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer">
				<s:iterator value="testList">
					<tr align="CENTER" class="TableDetail1 template">
						<td>
							<a class="summary" onmouseover="showDetail(true,this);"onmouseout="showDetail(false,this)"> 
								<s:set name="qs" value="question"></s:set>
								 <s:if test="#qs.length()>45">
									<s:property value="question.substring(0,45)+'......'" />
								 </s:if> 
								 <s:else>${question}&nbsp;</s:else>
							</a>
							<div class="detail_info">${question}&nbsp;</div>
						</td>
						<td>
							<a class="summary" onmouseover="showDetail(true,this);"onmouseout="showDetail(false,this)">
								<s:set name="an" value="answer"></s:set>
								<s:if test="#an.length()>15">
									<s:property value="answer.substring(0,15)+'.....'"/>
								</s:if>
								<s:else>${answer}&nbsp;</s:else>
							</a>
							<div class="detail_info">${answer}&nbsp;</div>							
						</td>
						<td>${difficulty}&nbsp;</td>
						<td>${score}&nbsp;</td>
						<td><s:if test="type== 1">单选</s:if> <s:elseif
								test="type == 2"> 多选</s:elseif> <s:elseif test="type == 3">判断</s:elseif>
							<s:elseif test="type == 4">填空</s:elseif> <s:elseif
								test="type == 5"> 文字录入</s:elseif> <s:elseif test="type == 6 ">操作题</s:elseif>
							<s:else>错误的题型</s:else></td>
						<td>${testName}&nbsp;</td>
						<td><s:iterator value="knows">
						${name }
					</s:iterator></td>
						<td><s:a action="test_delete?id=%{id}"
								onclick="return delConfirm()">删除</s:a> <s:a
								action="test_editUI?id=%{id}">修改</s:a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail">
			<div id="TableTail_inside">
				<s:a action="test_addUI">
					<img
						src="${pageContext.request.contextPath}/style/images/createNew.png" />
				</s:a>
			</div>
		</div>
	</div>
</body>
</html>

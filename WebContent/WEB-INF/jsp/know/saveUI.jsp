<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>知识点添加</title>
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
	function updateType(option) {
		// 传替页面参数，且返回回来
		var parm = '?sectionId=<s:property value="sectionId"/>';
		for (name in option) {
			parm += "&" + name + "=" + option[name];
		}

		window.location.href = "know_addUI.action" + parm;
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
				知识点添加
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div id="MainArea">
		<s:form action="know_%{ id == null ? 'add' : 'edit' }">
			<s:hidden name="id"></s:hidden>


			<div class="ItemBlock_Title1">
				<!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 岗位信息 </DIV>  -->


				<s:if test="id == null">
					选择增添知识点的方式：
					<s:select name="type" list="#{'1':'从已有的知识点进行选择','2':'新增知识点'}"
						headerKey="" headerValue="请选择"
						onchange="updateType({type:this.value});"></s:select>

				</s:if>
			</div>

			
			<s:if test="type == 1">
			
				<!-- 表单内容显示 -->
				<div class="ItemBlockBorder">
					<div class="ItemBlock">
						<table class="mainForm">
							<tr>
								<td>为当前小节选择知识点<input type="hidden" value="${section.id }" name="sectionId"></td>
								<td>${section.name }</td>
							</tr>
							<tr>
								<td width="150">知识点</td>
								<td><s:select name="knowIds" cssClass="SelectStyle"
										multiple="true" size="10" list="#knowList" listKey="id"
										listValue="name" />
									按住Ctrl键可以多选或取消选择</td>
							</tr>
						</table>

					</div>
				</div>			
			
			
			</s:if>


			<s:if test="type == 2 ">
				<!-- 表单内容显示 -->
				<div class="ItemBlockBorder">
					<div class="ItemBlock">


						<table class="mainForm">
							<tr>
								<td width="100">知识点名称</td>
								<td><s:textfield name="name" cssClass="InputStyle" /> *</td>
							</tr>
							<tr>
								<td>知识点说明</td>
								<td><s:textarea name="description" cssClass="TextareaStyle"></s:textarea></td>
							</tr>
						</table>
					</div>
				</div>

				<div class="ItemBlock_Title1">
					<!-- 信息说明 -->
					<div class="ItemBlock_Title1">
						<img border="0" width="4" height="7"
							src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" />
						小节选择
					</div>
				</div>

				<!-- 表单内容显示 -->
				<div class="ItemBlockBorder">
					<div class="ItemBlock">
						<table class="mainForm">
							<tr>
								<td width="100">小节</td>
								<td><s:select name="sectionIds" cssClass="SelectStyle"
										multiple="true" size="10" list="#sectionList" listKey="id"
										listValue="name" />
									按住Ctrl键可以多选或取消选择</td>
							</tr>
						</table>

					</div>
				</div>
			</s:if>
			
			<s:if test="id != null">
			
				<!-- 表单内容显示 -->
				<div class="ItemBlockBorder">
					<div class="ItemBlock">


						<table class="mainForm">
							<tr>
								<td width="100">知识点名称</td>
								<td><s:textfield name="name" cssClass="InputStyle" /> *</td>
							</tr>
							<tr>
								<td>知识点说明</td>
								<td><s:textarea name="description" cssClass="TextareaStyle"></s:textarea></td>
							</tr>
						</table>
					</div>
				</div>

				<div class="ItemBlock_Title1">
					<!-- 信息说明 -->
					<div class="ItemBlock_Title1">
						<img border="0" width="4" height="7"
							src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" />
						小节选择
					</div>
				</div>

				<!-- 表单内容显示 -->
				<div class="ItemBlockBorder">
					<div class="ItemBlock">
						<table class="mainForm">
							<tr>
								<td width="100">小节</td>
								<td><s:select name="sectionIds" cssClass="SelectStyle"
										multiple="true" size="10" list="#sectionList" listKey="id"
										listValue="name" />
									按住Ctrl键可以多选或取消选择</td>
							</tr>
						</table>

					</div>
				</div>			
			
			</s:if>
			
			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="image"
					src="${pageContext.request.contextPath}/style/images/save.png" /> <a
					href="javascript:history.go(-1);"><img
					src="${pageContext.request.contextPath}/style/images/goBack.png" /></a>
			</div>
		</s:form>
	</div>

</body>
</html>


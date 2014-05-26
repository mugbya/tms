<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>试题管理</title>
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

	function saveValue(){
			
			var node = $('#menu').tree('getSelected');	

			/*选择小节*/
			if (node.attributes.nodeType == 4) {
				var knowId = node.attributes.nodeid;
				$("#knowId").val(knowId);				
			}		
	}

	function updateType(option) {
		// 传替页面参数，且返回回来
		var parm = "?k=1";
		for (name in option) {
			parm += "&" + name + "=" + option[name];
		}

		window.location.href = "test_addUI.action" + parm;
		//		window.location.reload();
		//$("#formID").submit();
	}
	var i = 4; //第几个复选框按钮
	var j = 3; //从第三个复选框开始增加（以开始的）
	var n = 1; //第一个填空框
	var m = 0; //从第0个填空框后面开始增加
	//动态增加选项
	function addOption_check() {
		$("#tr_" + j)
				.after(
						'<tr id="tr_'
								+ (j + 1)
								+ '"><td><input type="checkbox" name="number" value='+i+'></td><td><s:textfield name="value" cssClass="InputStyle" ></s:textfield></td></tr>');
		i++;
		j++;
	}
	function addOption_radio() {
		$("#tr_" + j)
				.after(
						'<tr id="tr_'
								+ (j + 1)
								+ '"><td><input type="radio" name="number" value='+i+'></td><td><s:textfield name="value" cssClass="InputStyle" ></s:textfield></td></tr>');
		i++;
		j++;
	}
	function addOption_text() {
		$("#tr_" + m)
				.after(
						'<tr id="tr_'
								+ (m + 1)
								+ '"><td>答案内容'
								+ (n + 1)
								+ ':</td><td><s:textfield name="value" cssClass="InputStyle" ></s:textfield></td></tr>');
		n++;
		m++;
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
				试题管理
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!-- 显示科目章节信息 -->

	<!-- 表单内容显示 -->
	<div class="ItemBlockBorder">
		<div class="ItemBlock">
			<table class="mainForm">
				<!--表头-->
				<thead>
					<tr align="LEFT" valign="MIDDLE" id="TableTitle">
						<td width="300px" style="padding-left: 7px;"><span>科目章节详情</span>
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

							
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<!-- 显示增加试题相关的信息 -->

	<!--显示表单内容-->
	<div id="MainArea">
		<s:form id="formID" action="test_%{ id == null ? 'add' : 'edit' }">
			<s:hidden name="id"></s:hidden>


			<s:hidden  name="knowId" id="knowId"></s:hidden>

			<div class="ItemBlock_Title1">
				<!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 岗位信息 </DIV>  -->

				<s:if test="id == null">
					请选择题型：
					<s:select name="type"
						list="#{'1':'单选','2':'多选','3':'判断','4':'填空','5':'文字录入','6':'操作'}"
						headerKey="" headerValue="请选择"
						onchange="updateType({type:this.value});"></s:select>

				</s:if>
				<s:if test="id  != null">
					<input  type="hidden" name="type" value="<s:property value="type"/>">
				</s:if>

				<s:if test="type == 2  && id == null">
					&nbsp;&nbsp;&nbsp;&nbsp;是否增加选项：
					<input type="button" onclick="addOption_check();" value="点击增加一个选项">
				</s:if>
				<s:elseif test=" type == 1 && id == null">
					&nbsp;&nbsp;&nbsp;&nbsp;是否增加选项：
					<input type="button" onclick="addOption_radio();" value="点击增加一个选项">
				</s:elseif>
				<s:elseif test="type == 4 && id == null">
					&nbsp;&nbsp;&nbsp;&nbsp;是否增加填空答案：
					<input type="button" onclick="addOption_text();" value="点击增加一个填空项">
				</s:elseif>
			</div>



			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table class="mainForm">
						<tr>
							<td width="100">题目内容</td>
							<td><s:textarea name="question" cssClass="TextareaStyle"></s:textarea></td>
						</tr>

						<!-- 单选按钮时出现的界面 -->
						<s:if test="type==1">
							<tr>
								<td>选项及答案</td>
							</tr>
							<tr>
								<td>答案</td>
								<td>内容</td>
							</tr>

							<!-- 单选新增 -->
							<s:if test="id == null">
								<s:iterator begin="0" end="3" var="p">
									<tr id="tr_<s:property value="#p"/>">
										<td><input type="radio" name="number"
											value="<s:property value="#p"/>"></td>
										<td><s:textfield name="value" cssClass="InputStyle"></s:textfield></td>
									</tr>
								</s:iterator>
							</s:if>

							<!-- 单选修改 -->
							<s:else>
								<s:iterator value="choicesList" status="st">

									<s:if test="value == answer">
										<tr>
											<td><input type="radio" name="number" checked
												value="<s:property value="#st.index"/>"></td>
											<td><s:textfield name="value" cssClass="InputStyle"></s:textfield></td>
										</tr>
									</s:if>
									<s:else>
										<tr>
											<td><input type="radio" name="number"
												value="<s:property value="#st.index"/>"></td>
											<td><s:textfield name="value" cssClass="InputStyle"></s:textfield></td>
										</tr>
									</s:else>
								</s:iterator>
							</s:else>
						</s:if>

						<!-- 多选时出现下面界面 -->
						<s:elseif test="type == 2">
							<tr>
								<td>选项及答案</td>
							</tr>
							<tr>
								<td>答案</td>
								<td>内容</td>
							</tr>

							<!-- 多选新增 -->
							<s:if test="id == null">
								<s:iterator begin="0" end="3" var="p">
									<tr id="tr_<s:property value="#p"/>">
										<td><input type="checkbox" name="number"
											value="<s:property value="#p"/>"></td>
										<td><s:textfield name="value" cssClass="InputStyle"></s:textfield></td>
									</tr>
								</s:iterator>
							</s:if>

							<!-- 多选修改 没做正确答案回显-->
							<s:else>
								<s:iterator value="choicesList" status="sta">
									<tr>
										<td><input type="checkbox" name="number"
											value="<s:property value="#sta.index"/>"></td>
										<td><s:textfield name="value" cssClass="InputStyle"></s:textfield></td>
									</tr>
								</s:iterator>
							</s:else>
						</s:elseif>

						<!-- 判断题时出现下面界面 -->
						<s:elseif test="type == 3">
							<tr>
								<td>指定答案</td>
								<td>答案内容</td>
							</tr>

							<!-- 判断题新增  -->
							<s:if test="id == null">
								<tr>
									<td><s:radio name="answer" list="#{'1':'正确','0':'错误' }"></s:radio></td>
									<td><s:textfield name="value" cssClass="InputStyle"></s:textfield></td>
								</tr>
							</s:if>

							<!-- 判断题修改 -->
							<s:else>
								<s:iterator value="choicesList">
									<tr>
										<td><s:radio name="answer" list="#{'1':'正确','0':'错误' }"></s:radio></td>
										<td><s:textfield name="value" cssClass="InputStyle"></s:textfield></td>
									</tr>
								</s:iterator>
							</s:else>
						</s:elseif>

						<!-- 填空题出现下面界面 -->
						<s:elseif test="type == 4">
							<tr>
								<td>答案是否有序</td>
								<td><s:radio name="orderly"
										list="#{'false':'无序','true':'有序' }"></s:radio></td>
							</tr>

							<!-- 填空新增时 -->
							<s:if test="id == null">
								<s:iterator begin="0" end="0" var="p">
									<tr id="tr_<s:property value="#p"/>">
										<td>答案内容<s:property value="#p+1" />：
										</td>
										<td><s:textfield name="value" cssClass="InputStyle"></s:textfield></td>
									</tr>
								</s:iterator>
							</s:if>
							<!-- 填空修改时 -->
							<s:else>
								<s:iterator value="choicesList" status="st">
									<tr>
										<td>答案内容<s:property value="#st.index" />：
										</td>
										<td><s:textfield name="value" cssClass="InputStyle"></s:textfield></td>
									</tr>
								</s:iterator>
							</s:else>

						</s:elseif>


						<!-- 公共部分 -->
						<tr>
							<td>试题分值</td>
							<td><s:textfield name="score" cssClass="InputStyle"></s:textfield></td>
						</tr>
						<tr>
							<td>试题难度</td>
							<td><s:textfield name="difficulty" cssClass="InputStyle"></s:textfield></td>
						</tr>
						<tr>
							<td>题库名称</td>
							<td><s:textfield name="testName" cssClass="InputStyle"></s:textfield></td>
						</tr>
					</table>
				</div>
			</div>

			<%-- 
			<div class="ItemBlock_Title1">
				<!-- 信息说明 -->
				<div class="ItemBlock_Title1">
					<img border="0" width="4" height="7"
						src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" />
					知识点选择
				</div>
			</div>

			<!-- 表单内容显示 -->

				<div class="ItemBlockBorder">
					<div class="ItemBlock">
						<table class="mainForm">
							<tr>
								<td width="100">知识点</td>
								<td><s:select name="knowIds" cssClass="SelectStyle"
										multiple="true" size="10" list="#knowList" listKey="id"
										listValue="name" /> 按住Ctrl键可以多选或取消选择</td>
							</tr>
						</table>
					</div>
				</div>
			 --%>

			<!-- 表单操作 -->
			<div id="InputDetailBar">
				<input type="image"
					src="${pageContext.request.contextPath}/style/images/save.png"  onclick="saveValue();"/>
				<a href="javascript:history.go(-1);"><img
					src="${pageContext.request.contextPath}/style/images/goBack.png" /></a>
			</div>
		</s:form>
	</div>

</body>
</html>


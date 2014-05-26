<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>试卷参数设置</title>
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
		var parm = "?k=1";
		for (name in option) {
			parm += "&" + name + "=" + option[name];
		}
		window.location.href = "paper_setParams.action" + parm;
	}
	var sum = 0;
	var score = 0;

	/* 得到的试题总分数 */
	function get_score(value) {
		/* 进行数字效验 */
		var regExp = /^\d+$/g;
		var isNumber = regExp.test(value);
		if (!isNumber) {
			alert('请输入数字！');
			vlaue = '';
		}
		score = parseInt(value);
	}

	/* 对章节分数的验证 */
	function chapter_score(value){
		/* 进行数字效验 */
		var regExp = /^\d+$/g;
		var isNumber = regExp.test(value);
		if (!isNumber) {
			alert('请输入数字！');
			vlaue = '';
		}
				
	}
	
	/* 对各种题型的验证 */
	function sum_Type_score(value) {
		/* 进行数字效验 */
		var regExp = /^\d+$/g;
		var isNumber = regExp.test(value);
		if (!isNumber) {
			alert('请输入数字！');
			vlaue = '';
		}
		single_score = parseInt($("#single_score").val());
		if (isNaN(single_score)) {
			single_score = 0;
		}
		check_score = parseInt($("#check_score").val());

		if (isNaN(check_score)) {
			check_score = 0;
		}
		judge_score = parseInt($("#judge_score").val());
		if (isNaN(judge_score)) {
			judge_score = 0;
		}
		blank_score = parseInt($("#blank_score").val());
		if (isNaN(blank_score)) {
			blank_score = 0;
		}
		sum = single_score + check_score + judge_score + blank_score;


		if (score > sum) {
			xx = score - sum;
			$("#oo").html("其他题型还可以出：" + xx + "分");
		} else if (score == sum) {
			$("#oo").html("已无剩余分数可供分配！");
		} else {
			$("#oo").html("！！！ 警告---分配的分数超出总分数");
			alert("警告---分配的分数超出总分数");
		}
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
				试卷参数设置
			</div>
			<div id="Title_End"></div>
		</div>
	</div>

	<!--显示表单内容-->
	<div id="MainArea">
		<s:form action="paper_generatePaper">
			<s:hidden name="id"></s:hidden>


			<div class="ItemBlock_Title1">
				<!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 岗位信息 </DIV>  -->
			</div>

			<!-- 表单内容显示 -->
			<div class="ItemBlockBorder">
				<div class="ItemBlock">
					<table class="mainForm">
						<%--
                    <tr>
                        <td width="270">请选择题库</td>
                        <td><s:select name="testName" list="testList"  listKey="id" listValue="testName" headerKey="" headerValue="请选择"></s:select> *</td>
                    </tr>   					
					 --%>
						<tr>
							<td width="270">请选择科目</td>
							<td><s:select name="subject" list="subjectList" listKey="id"
									listValue="name" headerKey="" headerValue="请选择"
									onchange="updateType({subject:this.value});"></s:select> * <span
								id="oo"> </span></td>
						</tr>

						<tr>
							<td width="270">试卷名称</td>
							<td><s:textfield name="name" cssClass="InputStyle" /> *</td>
						</tr>
						<tr>
							<td width="270">试卷总分数</td>
							<td><s:textfield name="score" id="score"
									onchange="get_score(this.value);" cssClass="InputStyle" /> *</td>
						</tr>
						<tr>
							<td width="270">考试时长（分钟）</td>
							<td><s:textfield name="time" cssClass="InputStyle" /> *</td>
						</tr>



						<s:iterator value="chapterList" status="st">
							<tr>
								<td width="270">为${name }分配分数（）</td>
								<td><input type="text" name="chapter_${id }"
									id="chapter_score_<s:property value="#st.index"/>"
									onchange="chapter_score(this.value);" class="InputStyle">
									*</td>
							</tr>
						</s:iterator>


						<tr>
							<td width="270">为单选题分配分数（）</td>
							<td><s:textfield name="single_score" id="single_score"
									onchange="sum_Type_score(this.value);" cssClass="InputStyle" />
								*</td>
						</tr>
						<tr>
							<td width="270">为多选题分配分数（）</td>
							<td><s:textfield name="check_srore" id="check_score"
									onchange="sum_Type_score(this.value);" cssClass="InputStyle" />
								*</td>
						</tr>
						<tr>
							<td width="270">为判断题分配分数（）</td>
							<td><s:textfield name="judge_score" id="judge_score"
									onchange="sum_Type_score(this.value);" cssClass="InputStyle" />
								*</td>
						</tr>
						<tr>
							<td width="270">为填空题分配分数（）</td>
							<td><s:textfield name="blank_score" id="blank_score"
									onchange="sum_Type_score(this.value);" cssClass="InputStyle" />
								*</td>
						</tr>
						<tr>
							<td width="270">是否设置难度等级（1-5）【不设置则默认为空】</td>
							<td><s:textfield name="difficulty" cssClass="InputStyle" />
								*</td>
						</tr>

						<tr>
							<td width="270">设置生成分数</td>
							<td><s:textfield name="number" cssClass="InputStyle" /> *</td>
						</tr>

					</table>
				</div>
			</div>

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


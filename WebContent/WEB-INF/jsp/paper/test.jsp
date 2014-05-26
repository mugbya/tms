<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0066)http://tcsd6.it211.com.cn/exam/start/getPaperQuestionByType?type=1 -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<title>tms考试</title>
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/style/paper.css" media="all">
		<style type="text/css">
body {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
}
/*Example for a Menu Style*/
.menu {
	background-color: #e5e5e5;
	border-bottom: #ccc;
	height: 24px;
	width: 400px;
	margin-left: 180px;
	margin-top: 50px
}

.menu ul {
	margin: 0px;
	padding: 0px;
	list-style: none;
	text-align: center;
}

.menu li {
	display: inline;
	line-height: 24px;
}

.menu li a {
	color: #000;
	text-decoration: none;
	padding: 5px 10px 10px 10px;
}

.menu li a.tabactive {
	border: 0px solid #d7d7d7;
	border-right: 0px solid #d7d7d7;
	color: #000000;
	background-color: #ffffff;
	font-weight: bold;
	position: relative;
}

.currentPage {
	background-color: #ccc;
}

pre {
	margin-top: 0px;
	padding-top: 3px;
}
</style>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/script/jquery.js"></script>
</head>
<body>

	<div id="box2">


		<div class="title2">
			<h1>
				TMS标准考试 ${paper.subject }试题<br><span>（ ${paper.score }
						分制，考试时间 ${ paper.time} 分钟）</span>
			</h1>
		</div>

		<!-- 单选开始 -->
		<s:iterator value="singleTest" status="st">
			<div class="exam2">
				<s:if test="#st.index == 0">
					<h1>
						一、单选<span>(共${paper.single_score }分,每小题2分)</span>
					</h1>
				</s:if>

				<div>
					<div style="float: left; display: block;">
						<s:property value="#st.index+1" />
						.
					</div>
					<div
						style="margin-left: 25px; width: 770px; word-wrap: break-word;">
						<p>
							<span style="font-size: 10.5pt; font-family: 宋体;"> ${ question}</span>
						</p>
						<p>
							<br> <span style="font-size: 10.5pt; font-family: 宋体;"></span>
						</p>
					</div>
				</div>
				<div style="clear: both;"></div>

				<form name="form" action="" method="post">

					<s:iterator value="choices" status="stx">

						<div style="margin: 5px 0px 0px 20px;">
							<table border="0" cellspacing="0" cellpadding="0"
								style="font-family: &amp; amp;">
								<tbody>
									<tr>
										<td width="45px;" valign="top"><input type="radio"
											name="singleQuestion" value="A" id="RadioGroup_2359"
											onclick="submitSingleAnswer(2359,&#39;A&#39;);"> <span>
													<s:if test="#stx.index == 0">A.</s:if> <s:elseif
														test="#stx.index == 1">B.</s:elseif> <s:elseif
														test="#stx.index == 2">C.</s:elseif> <s:elseif
														test="#stx.index == 3">D.</s:elseif>
											</span></td>
										<td valign="bottom">
											<div style="width: 820px;">
												<p class="MsoNormal">
													<span>${value }</span>
												</p>
												<p>
													<br>
												</p>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</s:iterator>
				</form>
			</div>
		</s:iterator>

		<!-- 多选题开始 -->
		
		<s:iterator value="checkTest" status="st">
			<div class="exam2">
				<s:if test="#st.index == 0">
					<h1>
						二、多选<span>(共${paper.check_srore }分,每小题2分)</span>
					</h1>
				</s:if>

				<div>
					<div style="float: left; display: block;">
						<s:property value="#st.index+1" />
						.
					</div>
					<div
						style="margin-left: 25px; width: 770px; word-wrap: break-word;">
						<p>
							<span style="font-size: 10.5pt; font-family: 宋体;"> ${ question}</span>
						</p>
						<p>
							<br> <span style="font-size: 10.5pt; font-family: 宋体;"></span>
						</p>
					</div>
				</div>
				<div style="clear: both;"></div>

				<form name="form" action="" method="post">

					<s:iterator value="choices" status="stx">

						<div style="margin: 5px 0px 0px 20px;">
							<table border="0" cellspacing="0" cellpadding="0"
								style="font-family: &amp; amp;">
								<tbody>
									<tr>
										<td width="45px;" valign="top"><input type="checkbox"
											name="singleQuestion" value="A" id="RadioGroup_2359"
											onclick="submitSingleAnswer(2359,&#39;A&#39;);"> <span>
													<%--
													<s:if test="#stx.index == 0">A.</s:if> <s:elseif
														test="#stx.index == 1">B.</s:elseif> <s:elseif
														test="#stx.index == 2">C.</s:elseif> <s:elseif
														test="#stx.index == 3">D.</s:elseif>
													
													 --%>
											</span></td>
										<td valign="bottom">
											<div style="width: 820px;">
												<p class="MsoNormal">
													<span>${value }</span>
												</p>
												<p>
													<br>
												</p>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</s:iterator>
				</form>
			</div>			
		</s:iterator>
		
		<!-- 判断题区域 -->
		<s:iterator value="judgeTest" status="st">
		
			<div class="exam2">
				<s:if test="#st.index == 0">
					<h1>
						三、判断<span>(共${paper.judge_score }分,每小题1分)</span>
					</h1>
				</s:if>

				<div>
					<div style="float: left; display: block;">
						<s:property value="#st.index+1" />
						.
					</div>
					<div
						style="margin-left: 25px; width: 770px; word-wrap: break-word;">
						<p>
							<span style="font-size: 10.5pt; font-family: 宋体;"> ${ question}</span>
						</p>
						<p>
							<br> <span style="font-size: 10.5pt; font-family: 宋体;"></span>
						</p>
					</div>
				</div>
				<div style="clear: both;"></div>

				<form name="form" action="" method="post">


						<div style="margin: 5px 0px 0px 20px;">
							<table border="0" cellspacing="0" cellpadding="0"
								style="font-family: &amp; amp;">
								<tbody>
									<tr>
										<td width="45px;" valign="top"><input type="radio"
											name="singleQuestion" value="A" id="RadioGroup_2359"
											onclick="submitSingleAnswer(2359,&#39;A&#39;);"> <span>
											</span></td>
										<td valign="bottom">
											<div style="width: 820px;">
												<p class="MsoNormal">
													<span>是</span>
												</p>
												<p>
													<br>
												</p>
											</div>
										</td>										
									</tr>
									<tr>
										<td width="45px;" valign="top"><input type="radio"
											name="singleQuestion" value="A" id="RadioGroup_2359"
											onclick="submitSingleAnswer(2359,&#39;A&#39;);"> <span>
											</span></td>
										<td valign="bottom">
											<div style="width: 820px;">
												<p class="MsoNormal">
													<span>否</span>
												</p>
												<p>
													<br>
												</p>
											</div>
										</td>										
									</tr>									
								</tbody>
							</table>
						</div>
				</form>
			</div>					
		
		</s:iterator>
	
	
		<!-- 填空题区域 -->
		<s:iterator value="blankTest" status="st">
		
			<div class="exam2">
				<s:if test="#st.index == 0">
					<h1>
						四、填空<span>(共${paper.blank_score }分,每小题2分)</span>
					</h1>
				</s:if>

				<div>
					<div style="float: left; display: block;">
						<s:property value="#st.index+1" />
						.
					</div>
					<div
						style="margin-left: 25px; width: 770px; word-wrap: break-word;">
						<p>
							<span style="font-size: 10.5pt; font-family: 宋体;"> ${ question}</span>
						</p>
						<p>
							<br> <span style="font-size: 10.5pt; font-family: 宋体;"></span>
						</p>
					</div>
				</div>
				<div style="clear: both;"></div>
			
				<form name="form" action="" method="post">

					<s:iterator value="choices" status="stx">

						<div style="margin: 5px 0px 0px 20px;">
							<table border="0" cellspacing="0" cellpadding="0"
								style="font-family: &amp; amp;">
								<tbody>
									<tr>
										<td width="45px;" valign="top">
										<input name="singleQuestion"  id="RadioGroup_2359"></td>
									</tr>
								</tbody>
							</table>
						</div>
					</s:iterator>
				</form>				
			</div>
		</s:iterator>
		
	
	</div>
</body>
</html>












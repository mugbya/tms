<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>您已退出TMS系统</title>
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
<script type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/style/blue/logout.css"
	rel="stylesheet" type="text/css">
</head>

<body>

			<table width=100% height=100%>
				<tr>
					<td align=center>
						<div id=Logout>
							<div id=AwokeMsg>
								<img id=LogoutImg
									src="${pageContext.request.contextPath}/style/blue/images/logout/logout.gif"
									border=0> <img id=LogoutTitle
									src="${pageContext.request.contextPath}/style/blue/images/logout/logout1.gif"
									border=0>
							</div>
							<div id=LogoutOperate>
								<img
									src="${pageContext.request.contextPath}/style/blue/images/logout/logout2.gif"
									border=0> <a
									href="${pageContext.request.contextPath}/user_loginUI.action">重新进入系统</a>
								<img
									src="${pageContext.request.contextPath}/style/blue/images/logout/logout3.gif"
									border=0> <a
									href="javascript: window.open('','_self');window.close();">关闭当前窗口</a>
							</div>
						</div>
					</td>
				</tr>
			</table>

</body>
</html>

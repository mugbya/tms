<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>TMS试题库管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
    <script type="text/javascript"></script>	
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery_treeview/jquery.cookie.js"></script>
</head>

	<frameset rows="100,*,25" framespacing=0 border=0 frameborder="0">
		<frame noresize name="TopMenu" scrolling="no" src="${pageContext.request.contextPath}/home_top.action">
		<frameset cols="180,*" id="resize">
			<frame noresize name="menu" scrolling="yes" src="${pageContext.request.contextPath}/home_left.action">
			<frame noresize name="right" scrolling="yes" src="${pageContext.request.contextPath}/home_right.action">
		</frameset>
		<frame noresize name="status_bar" scrolling="no" src="${pageContext.request.contextPath}/home_bottom.action">
	</frameset>

	<noframes><body>
</body>
</noframes></html>




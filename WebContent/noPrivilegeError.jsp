<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<HTML>
<HEAD>
    <TITLE>没有权限</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
    <script type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/style/blue/login.css" type=text/css rel=stylesheet>
</HEAD>   
<BODY>

<DIV ID="Title_bar">
    <DIV ID="Title_bar_Head">
        <DIV ID="Title_Head"></DIV>
        <DIV ID="Title"><!--页面标题-->
            <IMG BORDER="0" WIDTH="13" HEIGHT="13" SRC="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 提示
        </DIV>
        <DIV ID="Title_End"></DIV>
    </DIV>
</DIV>


<!--显示表单内容-->
<DIV ID="MainArea">
		<DIV CLASS="ItemBlock_Title1">
        </DIV> 
        
        <DIV CLASS="ItemBlockBorder" STYLE="margin-left: 15px;">
            <DIV CLASS="ItemBlock" STYLE="text-align: center; font-size: 16px;">
				出错了，您没有权限访问此功能！
            </DIV>
        </DIV>
        
        <!-- 操作 -->
        <DIV ID="InputDetailBar">
            <A HREF="javascript:history.go(-1);"><IMG SRC="${pageContext.request.contextPath}/style/images/goBack.png"/></A>
        </DIV>
</DIV>

</BODY>
</HTML>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>TopMenu</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
	<script type="text/javascript"></script>
	<LINK href="${pageContext.request.contextPath}/style/blue/top.css" type=text/css rel=stylesheet>
	
	<script type="text/javascript">
	</script>
	<style type="text/css">
		#messageArea{
			color: white;
			font-size: 14px;
			font-weight: bold;
		}
	</style>
</head>

<body CLASS=PageBody leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
	
	<div id="Head1">
		<div id="Logo">
        	<iframe name="autoRefashion" src="" width="0" height="0"></iframe>
			<a id="msgLink" href="javascript:void(0)"></a>
            <font color="#0000CC" style="color:#F1F9FE; font-size:28px; font-family:Arial Black, Arial">TMS试题库管理系统</font> 
			<!--<img border="0" src="css/blue/images/logo.png" />-->
        </div>
		<div id="Head1Right">
			<div id="Head1Right_UserName">
                <img border="0" width="13" height="14" src="${pageContext.request.contextPath}/style/images/top/user.gif" /> 您好，<b>${user.name }</b>
			</div>
			<div id="Head1Right_UserDept"></div>

			<div id="Head1Right_Time">
				</div>
		</div>
        <div id="Head1Right_SystemButton">
            <a href="${pageContext.request.contextPath}/user_logout.action" target="_parent">
                <img width="78" height="20" alt="退出系统" src="${pageContext.request.contextPath}/style/blue/images/top/logout.gif" />
            </a>
        </div>
	</div>
    
    <div id="Head2">
        <div id="Head2_Awoke">

        </div>
        
        <div id="Head2_FunctionList" style="text-align: left">
        	<a href="javascript: window.parent.right.location.reload(true);">刷新</a>
        </div>
    </div>

</body>

</html>

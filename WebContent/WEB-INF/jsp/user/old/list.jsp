<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
</head>
<body>

	<s:iterator value="#roleList">
		<s:property value="id"/>
		<s:property value="name"/>
		<s:property value="desc" />
		<s:a action="role_delete?id=%{id}" onclick="return confirm('确认要删除么？')">删除</s:a>
		<s:a action="role_editUI?id=%{id}">修改</s:a>
		
		<br/>
	</s:iterator>

	<s:a action="role_addUI">添加 </s:a>

</body>
</html>

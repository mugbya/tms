<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>试卷列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
    <script type="text/javascript"></script>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 试卷管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
   <table  class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td width="300">试卷名称</td>
                <td width="100">考试科目</td>
                <td width="200">考试时长(分钟)</td>
                <td>试卷总分数</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" >
        	<s:iterator value="paperList">
       		     <tr class="TableDetail1 template">   
       		     	<td>${name}</td>
       		     	<td>${subject}</td>
       		     	<td>${time }</td>
       		     	<td>${score }</td>
       		     	 <td>
            		   	<s:a action="paper_delete?id=%{id}" onclick="return delConfirm()">删除</s:a>
              	  	    <s:a action="paper_test?id=%{id}">查看试卷详细情况</s:a>						
              		  </td>
       		     </tr>
        	</s:iterator>
   
            
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
		<div id="TableTail_inside">
			<s:a action="paper_setParams"><img src="${pageContext.request.contextPath}/style/images/createNew.png" /></s:a>
        </div>
    </div>
</div>
</body>
</html>

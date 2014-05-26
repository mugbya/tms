<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>试题添加</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
    <script type="text/javascript">
    </script>
</head>
<body> 

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
	   <div id="Title_Head"></div>
	   <div id="Title"><!--页面标题-->
	       <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 试题添加
	   </div>
	   <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
    <s:form action="know_%{ id == null ? 'add' : 'edit' }">
    	<s:hidden name="id"></s:hidden>

    	
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 岗位信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table class="mainForm">
                
					<tr>
						<td colspan="3">题目内容</td>
						<td>知识点:XXX</td>
					</tr>              
					<!-- 具体内容区 -->
					<tr>
						<td colspan="3"><s:textarea name="question" cssClass="InputStyle"></s:textarea></td>
						<td>知识描述：XXXXXXXXXXXX</td>
					</tr> 
					
					
					<tr>
						<td colspan="3">选项及答案</td>
						<td rowspan="2"><p>分数：</p></td>
					</tr>
					<tr>
						<td>选项</td>
						<td>答案</td>
						<td>内容</td>
					</tr>
					<tr>
						<td>A</td>
						<td><input type="radio"></td>
						<td><input type="text"/>内容</td>
						<td rowspan="2"><p>难度：</p></td>						
					</tr>
					<tr>
						<td>B</td>
						<td><input type="radio"></td>
						<td><input type="text"/>内容</td>
					</tr>
					<tr>
						<td>C</td>
						<td><input type="radio"></td>
						<td><input type="text"/>内容</td>
						<td>基本信息</td>
					</tr>
					<tr>
						<td>D</td>
						<td><input type="radio"></td>
						<td><input type="text"/>内容</td>
						<td rowspan="4"><p>题库名称：XXX</p>  <p>科目名称：XXX</p>  <p>总题数：XXX</p> </td>						
					</tr>										

					<tr>
						<td>E</td>
						<td><input type="radio"></td>
						<td><input type="text"/>内容</td>				
					</tr>
					<tr>
						<td>F</td>
						<td><input type="radio"></td>
						<td><input type="text"/>内容</td>
					</tr>
					<tr>
						<td>G</td>
						<td><input type="radio"></td>
						<td><input type="text"/>内容</td>
					</tr>	
								
                </table>
            </div>
        </div>

		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 知识点选择 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table  class="mainForm">
                    <tr>
						<td width="100">知识点</td>
                        <td>
                        	<s:select name="knowIds" cssClass="SelectStyle"
                        		multiple="true" size="10" 
                        		list="#knowList" listKey="id" listValue="name"
                        	/>
							按住Ctrl键可以多选或取消选择
                        </td>
                    </tr>
                </table>
            </div>
        </div>		
               
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
        </div>
    </s:form>
</div>

</body>
</html>


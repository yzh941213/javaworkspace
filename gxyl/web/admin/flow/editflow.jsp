<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@ include file="/include/easyui.jsp" %>
<%@ include file="/include/kindeditor.jsp" %>
<script type="text/javascript" src="../../adminjs/flow/editflow.js"></script>
<style>
.dvs{width:660px;height:24px;line-height:24px;padding-left:4px;background:#c0de98;}
</style>
</head>
<body>
<form action="${action}" method="post" onsubmit="return check();">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="${pageContext.request.contextPath}/themes/tab_03.gif" width="15" height="30" /></td>
        <td width="1021" background="${pageContext.request.contextPath}/themes/tab_05.gif"><span class="tablab">编辑</span></td>
        <td width="322" background="${pageContext.request.contextPath}/themes/tab_05.gif">
        	<div style="float:right;margin-right:20px;"><a href="javascript:history.back();">返回</a></div>
        </td>
        <td width="14"><img src="${pageContext.request.contextPath}/themes/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="${pageContext.request.contextPath}/themes/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3">
          <table width="99%" class="gridedit" border="0" align="center" cellpadding="0" cellspacing="1">
          <tr>
            <th height="26" colspan="3"></th>
          </tr>
          <tr>
            <td height="26" width="80" align="right">所属分类：</td>
            <td width="600"><select name="fcAutoid">
            	<c:forEach var="flowcls" items="${flowclsList}">
            		<option value="${flowcls.fcAutoid}"<c:if test="${flowcls.fcAutoid eq flow.fcAutoid}">selected</c:if>>${flowcls.fcName}</option>
            	</c:forEach>
            </select>
            	<input type="button" value="添加配置文件" onclick="openUp('pz')"/>
            </td>
            <td>&nbsp;培训项目：</td>
          </tr>
          
          <tr>
            <td height="26" align="right">软件名称：</td>
            <td><div id="dvName" class="dvs">${flow.flowName}</div><input type="hidden" name="flowName" value="${flow.flowName}"/></td>
          	<td rowspan="7" valign="top" style="padding:2px;">
          		<table id="tabItem" border="0" width="100%" class="gridedit" cellpadding="0" cellspacing="1">
          			<tr>
          				<th width="20" height="26"><input type="checkbox" name="itemChkall"/></th>
          				<th width="30">序号</th>
          				<th>培训项目名称</th>
          			</tr>
          			<c:forEach items="${itemList}" var="item" varStatus="status">
          			<tr>
          				<td height="26" align='center'><input type="checkbox" name="itemChk" value="${item.itemAutoid}" <c:if test="${item.del eq 'false' }">checked</c:if> /></td>
          				<td align='center'>${item.subID}</td>
          				<td align='center'>${item.itemName}</td>
          			</tr>
          			</c:forEach>
          		</table>
          		<input type="hidden" name="items" value="${flow.items}">
          	</td>
          </tr>
          <tr>
            <td height="26" align="right">软件ID：</td>
            <td><div id="dvID" class="dvs">${flow.itemID}</div><input type="hidden" name="itemID" value="${flow.itemID}"/></td>
          </tr>
          <tr>
            <td height="26" align="right">厂家名称：</td>
            <td><div id="dvCompany" class="dvs">${flow.companyID}</div><input type="hidden" name="companyID" value="${flow.companyID}"/></td>
          </tr>
          <tr>
            <td height="26" align="right">描述信息：</td>
            <td><textarea name="content" id="content">${flow.content}</textarea></td>
          </tr>
          <tr>
            <td height="26" align="right">软件：</td>
            <td>
            	<input type="button" value="添加软件" onclick="openUp('az')"/>
            	<span id="spFile"><c:if test="${action eq 'modify.do'}">文件：【</c:if>${flow.fileName}<c:if test="${action eq 'modify.do'}">】；路径：【</c:if>${flow.filePath}<c:if test="${action eq 'modify.do'}">】</c:if></span>
            	<a id="dnexe" href="${pageContext.request.contextPath}${flow.filePath}" <c:if test="${action eq 'create.do'}">style="display:none"</c:if>>下载</a>
            	<input type="hidden" name="fileName" value="${flow.fileName}" />
            	<input type="hidden" name="filePath" value="${flow.filePath}" />
            	<input type="hidden" name="fileSize" value="${flow.fileSize}" />
            </td>
          </tr>
          <tr>
            <td height="26" align="right">操作文档：</td>
            <td>
            	<input type="button" value="添加操作文档" onclick="openUp('doc')"/>
            	<input type="text" name="docName" style="width:270px;<c:if test="${flow.docPath eq '' or flow.docPath eq null }">display:none;</c:if>" value="${flow.docName}"  />&nbsp;
            	<span id="spDoc"><c:if test="${flow.docPath ne '' && flow.docPath ne null}">路径：【${flow.docPath}】</c:if></span>
            	<a id="dnDoc" href="${pageContext.request.contextPath}${flow.docPath}" <c:if test="${action eq 'create.do'}">style="display:none"</c:if>>下载</a>
            	
            	<input type="hidden" name="docPath" value="${flow.docPath}" />
            </td>
          </tr>
          <tr>
          	<td height="26" align="right">图片：</td>
          	<td><img id="img" width="240" height="180" src="${pageContext.request.contextPath}${flow.imageUrl}"/>
          		<a href="javascript:openUp('img');">上传图片</a>
          		<input type="hidden" id="imageUrl" name="imageUrl" value="${flow.imageUrl}"/>&nbsp;&nbsp;
          		<a href="javascript:;" id="imgmanage">选择图片</a>
          	</td>
          </tr>
        </table>
        <input type="hidden" name="flowType" value="${flow.flowType}" />
        <input type="hidden" name="flowAutoid" value="${flow.flowAutoid}"/>
        	<br/>
        	<div align="center"><input type="submit" value="保存"/></div>
        </td>
        <td width="9" background="${pageContext.request.contextPath}/themes/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
   <tr>
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="${pageContext.request.contextPath}/themes/tab_20.gif" width="15" height="29" /></td>
        <td background="${pageContext.request.contextPath}/themes/tab_21.gif" align="center">
          &nbsp;</td>
        <td width="14"><img src="${pageContext.request.contextPath}/themes/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
<div id="diaUp" class="easyui-dialog" data-options="title:'上传文件',closed:true,width:380,height:140">
	<iframe id="ifmUp" frameborder="0" scrolling="no" style="width:100%;height:100%"></iframe>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@ include file="/include/easyui.jsp" %>
</head>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="${pageContext.request.contextPath}/themes/tab_03.gif" width="15" height="30" /></td>
        <td background="${pageContext.request.contextPath}/themes/tab_05.gif"><span class="tablab">申报资料</span></td>
        <td background="${pageContext.request.contextPath}/themes/tab_05.gif">
        <table border="0" align="right" cellpadding="0" cellspacing="0">
            <tr>
              <td align="center"><a class="addbtn" href="#">新增</a></td>              
              <td align="center"><a class="delbtn" href="#">删除</a></td>
              <td width="230" align="left"><input><a class="editbtn" href="#">查询</a></td>
            </tr>
        </table></td>
        <td width="14"><img src="${pageContext.request.contextPath}/themes/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="${pageContext.request.contextPath}/themes/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3">
          <table width="99%" class="grid" border="0" align="center" cellpadding="0" cellspacing="1">
          <tr>
            <th width="6%" height="26"><input type="checkbox" name="chkall" value="checkbox" /></th>
            <th width="8%">序号</th>
            <th width="20%">名称</th>
            <th width="24%">文件路径</th>
            <th width="14%">类型</th>
            <th width="7%">编辑</th>
          </tr>
         <c:forEach items="${list}" var="ware" varStatus="status">
          <tr>
            <td height="26"><input name="chk" type="checkbox" value="${ware.wareAutoid}" /></td>
            <td>${(pager.pageindex-1)*pager.pagesize+status.count}</td>
            <td>${ware.wareName}</td>
            <td>${ware.filePath}</td>
            <td>${ware.type}</td>
            <td><a class="edittd" href="addedit.do?wareAutoid=${ware.wareAutoid}">编辑</a></td>
          </tr>
         </c:forEach>
          
        </table>
        </td>
        <td width="9" background="${pageContext.request.contextPath}/themes/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="${pageContext.request.contextPath}/themes/tab_20.gif" width="15" height="29" /></td>
        <td background="${pageContext.request.contextPath}/themes/tab_21.gif">
          
        </td>
        <td width="14"><img src="${pageContext.request.contextPath}/themes/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
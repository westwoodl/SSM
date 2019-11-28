<%--
  Created by IntelliJ IDEA.
  User: RongChao Xu
  Date: 2019/11/26
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/metro/easyui.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>

<shiro:hasPermission name="user:create"><span>添加</span></shiro:hasPermission>
<shiro:hasPermission name="user:update"><span>修改</span></shiro:hasPermission>
<shiro:hasPermission name="user:delete"><span>删除</span></shiro:hasPermission>

<table id="table" class="datagrid" />

<script type="text/javascript">
    $(function () {
        $("#table").datagrid({
            singleSeclect: true,
            width: '100%',
            height: '300px',
            title: "数据表格",
            iconCls: 'icon-save',
            collapsible: true,
            url: '${pageContext.request.contextPath}/user/user',
            rownumbers: true,
            toolbar: '#tb',
            fitColumns: true,
            columns: [[
                {field: 'id', title: 'ID', width: 100, align: 'center', sortable: true},
                {field: 'address', title: '地址', width: 100, align: 'center'},
                {field: 'username', title: '账号', width: 100, align: 'center'},
                {field: 'password', title: '密码', width: 100, align: 'center'},
                {
                    field: 'sex', title: '性别', width: 100, align: 'center', formatter: function (value) {
                        return value = 1 ? "男" : "女";
                    }
                }
            ]]
        });
    });
</script>
</body>
</html>

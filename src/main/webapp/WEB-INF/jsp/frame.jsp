<%--
  Created by IntelliJ IDEA.
  User: 光玉
  Date: 2018/3/25
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%-- 每个jsp文件中都加入下面两句 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   <%--注意：需要放一个jstl.jar包到Tomcat的WEB-INF/lib下--%>

<!DOCTYPE html>
<head>
    <title>客户管理系统主界面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv ="Pragma" content = "no-cache"/>
    <meta http-equiv="Cache-Control" content="no cache" />
    <meta http-equiv="Expires" content="0" />
    <script type="text/javascript" src="/resources/layui/layui.all.js"></script>
    <link rel="stylesheet" href="/resources/layui/css/layui.css">

</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">Admin</div>
        <%-- 头部区域（可配合layui已有的水平导航） --%>
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    管理员
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">注销</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <%-- 左侧导航区域（可配合layui已有的垂直导航） --%>
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">基本操作</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/customer/allCustomerList/1" target="option">客户信息</a></dd>
                        <dd><a href="/customer/add" target="option">添加客户</a></dd>
                        <dd><a href="/customer/query" target="option">高级搜索</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="/customer/DevelopDoc" target="option">开发日志</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <%-- 内容主体区域 --%>
        <iframe id="option" name="option" width="100%" height="100%"></iframe>
    </div>
    <div class="layui-footer">
        <%-- 底部固定区域 --%>
        © 光玉- 2018/3/28 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp友情链接：<a href="https://www.layui.com/doc/">layui使用文档</a>
    </div>
</div>
</body>
</html>

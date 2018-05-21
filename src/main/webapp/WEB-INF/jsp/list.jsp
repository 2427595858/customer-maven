<%--
  Created by IntelliJ IDEA.
  User: 光玉
  Date: 2018/3/25
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>客户列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv ="Pragma" content = "no-cache"/>
    <meta http-equiv="Cache-Control" content="no cache" />
    <meta http-equiv="Expires" content="0" />
    <script type="text/javascript" src="/resources/layui/layui.all.js"></script>
    <link rel="stylesheet" href="/resources/layui/css/layui.css">
</head>
<body>
    <!-- 建表 -->
    <!--<h3 align="center">客户列表</h3>-->
    <table class="layui-table" lay-size="sm">
        <colgroup>
            <col width="150">
            <col width="150">
            <col width="150">
            <col width="150">
            <col width="150">
            <col width="150">
        </colgroup>
        <thead>
            <tr>
                <th>姓名</th>
                <th>性别</th>
                <th>电话</th>
                <th>邮箱</th>
                <th>个人描述</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <!-- JSP中使用JSTL的c标签 -->
            <c:forEach items="${pb.beanList}" var="cstm">
                <tr>
                    <td>${cstm.name}</td>
                    <td>${cstm.gender}</td>
                    <td>${cstm.phone}</td>
                    <td>${cstm.email}</td>
                    <td>${cstm.description}</td>
                    <td>
                        <a class="layui-btn layui-btn-sm" href="/customer/edit/${cstm.id}">
                            编辑
                        </a>
                        <a class="layui-btn layui-btn-danger layui-btn-sm" href="/customer/delete/${cstm.id}">
                            删除
                        </a>
                        <%--<button class="layui-btn layui-btn-danger layui-btn-sm" id="delete" value="${cstm.id}">--%>
                            <%--删除--%>
                        <%--</button>--%>
                    </td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
    <br/>

    <%-- 分页 --%>
    <div style="text-align: center">
        第${pb.pageNum}页/共${pb.totalPage}页
        <a href="/customer/list/1">
            <button class="layui-btn">
                首页
            </button>
        </a>
        <c:if test="${pb.pageNum>1}">
            <a href="/customer/list/${pb.pageNum-1}">
                <button class="layui-btn layui-btn-sm">
                    <i class="layui-icon"> &#xe603;</i>
                </button>
            </a>
        </c:if>

        <%-- 计算页数，赋给变量begin和end --%>
        <c:choose>
            <%-- 如果总页数不超过10页，则将所有页数都显示出来 --%>
            <c:when test="${pb.totalPage<=10}">
                <c:set var="begin" value="1"/>
                <c:set var="end" value="${pb.totalPage}"/>
            </c:when>

            <%-- 当总页数超过10时，通过公式计算begin和end的值 --%>
            <c:otherwise>
                <c:set var="begin" value="${pb.pageNum-5}"/>
                <c:set var="end" value="${pb.pageNum+4}"/>
                <%-- 头溢出 --%>
                <c:if test="${begin<1}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="10"/>
                </c:if>
                <%-- 尾溢出 --%>
                <c:if test="${end>pb.totalPage}">
                    <c:set var="begin" value="${pb.totalPage-9}"/>
                    <c:set var="end" value="${pb.totalPage}"/>
                </c:if>
            </c:otherwise>
        </c:choose>

        <%-- 循环遍历页码列表 --%>
        <c:forEach var="i" begin="${begin}" end="${end}">
            <c:choose>
                <c:when test="${i eq pb.pageNum}">  <%-- 在方框中显示当前页码 --%>
                    <button class="layui-btn layui-btn-sm layui-btn-disabled">
                        ${i}
                    </button>
                </c:when>
                <c:otherwise>
                    <a href="/customer/list/${i}">
                        <button class="layui-btn layui-btn-sm">
                            ${i}
                        </button>
                    </a>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <%-- 给出下一页以及尾页链接 --%>
        <c:if test="${pb.pageNum<pb.totalPage}">
            <a href="/customer/list/${pb.pageNum+1}">
                <button class="layui-btn layui-btn-sm">
                    <i class="layui-icon"> &#xe602;</i>
                </button>
            </a>
        </c:if>
        <a href="/customer/list/${pb.totalPage}">
            <button class="layui-btn">
                尾页
            </button>
        </a>
    </div>

    <script>


        //注意啊，使用layui.js时，要引入layer弹出层时要写下面三句话啊
        layui.use('layer',function () {
            var $=layui.jquery;
            var layer=layui.layer;

            <%--//删除客户信息--%>
            <%--$(document).on("click","#delete",function(){--%>
                <%--var id = $(this).attr("value");--%>
                <%--var v = '${pageContext.request.contextPath}/customer/delete/' + id;--%>
                <%--console.log(v);--%>
                <%--layer.alert('确定要删除吗',{--%>
                    <%--icon:3,--%>
                    <%--btn:['确定','取消'],--%>
                    <%--yes:function(){--%>
                        <%--window.location.href = '${pageContext.request.contextPath}/customer/delete/' + id;--%>
                        <%--console.log(id);--%>
                        <%--layer.msg('操作成功',{--%>
                            <%--icon:1,--%>
                            <%--time:3000--%>
                        <%--});--%>
                        <%--// 提交表单后关闭弹出层窗口--%>
                        <%--layer.close();--%>
                        <%--// 刷新页面--%>
                        <%--location.reload();--%>
                    <%--}--%>
                <%--});--%>
            <%--})--%>
        })

    </script>
</body>
</html>

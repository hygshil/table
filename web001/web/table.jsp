<%--
  Created by IntelliJ IDEA.
  User: ASD
  Date: 2021/7/31
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

      <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
  </head>
  <style>

  </style>
  <body>
  <table border="1">
      <tbody>
      <tr>
          <td><input type="checkbox" id="checks"></td>
          <th>姓名</th>
          <th>年龄</th>
          <th>班级</th>
      </tr>
      </tbody>
      <tbody id="user">
      <tr>
      <%--<td><input type="checkbox" id="users"></td>--%>
      <%--<td></td>--%>
      <%--<td></td>--%>
      <%--<td></td>--%>
      </tr>
      </tbody>
  </table>

  <script>
      $(function(){
          //1.ajax 访问 后台
          $.ajax({
              url:'/table.json',
              type:'GET',
              data:'',
              dataType:'JSON',
              success:function (res) {
                  $.each(res.rows,function (index,item) {
                      $('#user').append(
                          "<tr><td><input type=\"checkbox\" id=\"users\"></td>"
                          +"<td>"+item.name+"</td>"
                          +"<td>"+item.age+"</td>"
                          +"<td>"+item.class+"</td></tr>"
                      )
                  })
              }

          })
      });
  </script>

  </body>
</html>

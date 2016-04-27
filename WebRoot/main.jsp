<%@page import="com.mysky.company.entity.staffBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主查詢頁面</title>
    
	<meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="這是查詢主頁面">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	    <link href="jqueryUI/jquery-ui.css" type="text/css" rel="stylesheet">
  </head>
  
  <body>
    <%  
    if (request.getAttribute("pageBean") == null ){
    %><jsp:forward page="command" ></jsp:forward><% } %>
  	<div>
  		<form class="f1" action="/company/command" method="post">
  			<fieldset><legend>條件查詢</legend>
  				<table width="100%">
					<label for="datein1">生日範圍：</label>
					<label for="datein1">起始日期</label>
  					<input type="text" id="datein1" size="9" name="date"/>
					<label for="datein2">截止日期</label>
					<input type="text" id="datein2"  size="9" name="dateend"/>
					
					<label for="section1">所屬部門：</label>
					<select name="seID" id="section1">
						<option value="1">編程一部</option>
						<option value="2">編程二部</option>
						<option value="3">編程三部</option>
					</select>
					<label for="name1">姓名：</label>
					<input type="text" name="name" size="12" id="naem1"/>
					<label for="sex1">性別：</label>
					<input type="radio" name="sex" value="男">男
					<input type="radio" name="sex" value="女">女			
					
					<label for="love">愛好：</label>
					<input type="radio" name="love" value="吃貨君">吃貨君
					<input type="radio" name="love" value="運動達人">運動達人
					<input type="radio" name="love" value="學霸君">學霸君
  					</br><input type="submit" id="subSelectInfo" name="CURD" value="點擊查詢"/>
  				</table>
  			</fieldset>
  		</form>
  	</div>
    <div>
			<fieldset><legend>聯繫人列表</legend>
				<table width="70%" bordercolor=" #0000FF" border="2" >
				<tr>
					<th width="5%">員工編號</th>
					<th width="10%">員工姓名</th>
					<th width="10%">出生日期</th>
					<th width="3%">性別</th>
					<th width="15%">興趣愛好</th>
					<th width="10%">部門名稱</th>
					<th width="6%" colspan="2">操作</th>
				</tr>
					<tbody id="1">
						<c:forEach begin="0" items="${pageBean.pageData}" var="bean" varStatus="varSta" >
							<form class="f1" action="/company/commandPage" method="post" >	
								<tr id="${varSta.count}">
									<td width="5%"  id="id${varSta.count}" align="center">${bean.id}</td>
									<td width="10%" id="name${varSta.count}"  align="center">${bean.name}</td>
									<td width="10%" id="birthday${varSta.count}" align="center">${bean.birthday}</td>
									<td width="3%"  id="sex${varSta.count}"  align="center">${bean.sex}</td>
									<td width="10%" id="love${varSta.count}" align="center">${bean.love}</td>
									<td width="8%"  id="seID${varSta.count}" align="center">${bean.seID}</td>
									<input type="hidden" name="id" value="${bean.id}"/>
									<td width="3%"  align="center"><input type="button" id="${bean.id}" name="CURD" value="修改" onClick="Wopen(${varSta.count})"/></td>
									<td width="3%"  align="center"><input type="submit" id="${bean.id}" name="CURD" value="刪除"/></td>
								</tr>
							</form>
						</c:forEach>
					</tbody>
				</table>
				
				<form class="f1" action="/company/command" method="post" >
					<div style=width:70% align="center">
						<tr width="100%">
							
							<td width="10%"><input type="submit"  name="first" value="首頁"/></td>
							<tdwidth="10%"><input type="submit"  name="back" value="上一頁"/>
								<input  type="text" id="dangqianye" size="2" name="currentPage" value="${pageBean.currentPage}"/>
								<input type="submit"  name="next" value="下一頁"/>
							</td>
							<td width="10%">
								<label for="totalpage">共</label>
								<input type="text" name="total" id="totalpage" size="2"  value="${pageBean.totalPage}"/>
								<label for="totalpage">頁</label>
							</td>
						</tr>
					</div>
			</fieldset>
		</form>
		<form action="/company/commandPage" method="post">
			<input type="button" id="subAddInfo" name="CURD" value="增加" onClick="Wopen1()"/>
		</form>
	</div>
	
	<script src="jqueryUI/external/jquery/jquery.js"></script>
	<script src="jqueryUI/jquery-ui.js"></script>
	<script type="text/javascript" >
	
		  function Wopen(i){
		    var id=document.getElementById("id"+i).innerHTML;
		    var name=document.getElementById("name"+i).innerHTML;
		    var birthday=document.getElementById("birthday"+i).innerHTML;
		    var sex=document.getElementById("sex"+i).innerHTML;
		    var love=document.getElementById("love"+i).innerHTML;
		    var seID=document.getElementById("seID"+i).innerHTML;
		   
		    var url='AddInfo.jsp?id='+id+'&name='+name+'&birthday='+birthday+'&sex='+sex+'&love='+love+'&seID='+seID;
		    
		    url= encodeURI(url);
		    url=encodeURI(url);
      		window.open(url,'muhaha','width=350,height=250');
  			} 
  		function Wopen1(){
		   
      		window.open('AddInfo.jsp','muhaha','width=350,height=250');
  			} 
		

		$(function (){  
//---------------------利用datepicker创建时间段----------------  
        $("#datein1").datepicker({    //绑定开始日期  
            changeMonth:true,   //显示下拉列表月份  
            changeYear:true,    //显示下拉列表年份  
            showWeek:true,      //显示星期    
            firstDay:"1",           //设置开始为1号  
            onSelect:function(dateText,inst){  
                //设置结束日期的最小日期  
                $("dateEnd").datepicker('option','minDate',new Date(dateText.replace('-',',')));  
                  
                }  
            });  
              
        $("#datein2").datepicker({  //设置结束绑定日期  
            changeMonth:true,   //显示下拉列表月份  
            changeYear:true,    //显示下拉列表年份  
            showWeek:true,      //显示星期    
            firstDay:"1",           //设置开始为1号  
            onSelect:function(dateText,inst){  
                //设置开始日期的最大日期  
                $('#dateStart').datepicker('option','maxDate',new Date(dateText.replace('-',',')));  
                }  
            });  
    });  
	</script>
  </body>
</html>
<!--width=40% align="right"-->
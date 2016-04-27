
<%@ page language="java"  
import="java.util.*" 
 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta charset="utf-8">
    <meta name="author" content="angtian">
    <link href="jqueryUI/jquery-ui.css" rel="stylesheet">
	<title>联系人添加页面</title>
</head>
<body>
	<div>
		<form class="f1" action="/company/command" method="post" >
			<fieldset >
			<legend>联系人添加</legend>
				<table width=100% >
					<tbody>
					
						<tr ><td class=“left” width=40% align="right"><label for="t1">姓 名：</label></td>
							<td class="right"><input type="text" id="t1" name="name" value /></td>
						</tr>
						
						<tr><td class=“left” width=40% align="right"><label for="DepDate">生 日：</label></td>
							<td class="right"><input type="date" id="DepDate" name="birthday" vealue="${bean.birthday}"></td>
						</tr>
						
						<tr><td class=“left” width=40% align="right"><label for="1">性 别：</label></td>
							<td class="right"><input type="radio" id="sex1" name="sex" value="男" <c:if test="${bean.sex=='男'}"> checked='checked'</c:if>/>男<!-- name设置成一样的就行了-->
							<input type="radio" id="sex2" name="sex" value="女" <c:if test="${bean.sex=='女'}"> checked='checked'</c:if>/>女
							</td>
						</tr>
						
						<tr><td class=“left” width=40% align="right">兴 趣：</td>
							<td class="right">
							<input type="radio" id="love1" name="love" value="吃貨君" <c:if test="${bean.love=='吃貨君'}"> checked='checked'</c:if>/>吃貨君
							<input type="radio" id="love2" name="love" value="運動達人" <c:if test="${bean.love=='運動達人'}"> checked='checked'</c:if>/>運動達人
							<input type="radio" id="love3" name="love" value="學霸君" <c:if test="${bean.love=='學霸君'}"> checked='checked'</c:if>/>學霸君
							</td>
						</tr>
						
											
						<tr><td class=“left” width=40% align="right">部 门：</td>
							<td><select id="selc" name="seID">
							<option value="1" <c:if test="${bean.seID=='1'}"> selected='selected'</c:if>/>编程1部</option>
							<option value="2" <c:if test="${bean.seID=='2'}"> selected='selected'</c:if>/>编程2部</option>
							<option value="3"  <c:if test="${bean.seID=='3'}"> selected='selected'</c:if>/>编程3部</option>
							</select>
							</td>
						</tr>
						
						<tr>
							<input type="hidden" id="id" name="id" value />
							<td class=“left” width=40% align="right" rowspan=2>
							<input id="Submit1" type="button" name="CURD" value="确认test增添"  onclick="test()"/>
							</td>
							<td> <input id="Reset1" type="reset" value="重 置" />
							</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
		</form>
	</div>
	
	<script src="jqueryUI/external/jquery/jquery.js"></script>
	<script src="jqueryUI/jquery-ui.js"></script>
	<script  type="text/javascript" charset="UTF-8">

		
		 var str=document.location.search;
		 str=decodeURI(str);
		 str=decodeURI(str);
		 var params=str.split("?");
		 params=params[1].split("&");
		
		
		for(var i=0;i<params.length;i++){
		  	var param= params[i].split("=");
		  
		  	switch(param[0]){
		  		case 'id': target= document.getElementById("id");target.value=param[1];
		  		break;
		  		case 'name': target= document.getElementById("t1");target.value=param[1];
		  		break;
		  		case 'birthday': target= document.getElementById("DepDate");target.value=param[1];
		  		break;
		  		case 'sex': if(param[1]=='男'){document.getElementById('sex1').checked='checked';}else{document.getElementById('sex2').checked='checked';};
		  		break;
		  		case 'love':if(param[1]=='吃貨君'){document.getElementById('love1').checked='checked';}
		  																	else if(param[1]=='運動達人'){document.getElementById('love2').checked='checked';}
		  																		else{document.getElementById('love3').checked='checked'};
		  			break;
		  		case 'seID':$("#selc").val(param[1]); 
		  			break;
		  			
		  		default :
		  			break;
		  	}
		 }
		 
	
	
	$(function (){  
		       $("#DepDate").datepicker({  
            dateFormat:'yy-mm-dd',  //更改时间显示模式  
            showAnim:"slide",       //显示日历的效果slide、fadeIn、show等  
            changeMonth:true,       //是否显示月份的下拉菜单，默认为false  
            changeYear:true,        //是否显示年份的下拉菜单，默认为false  
            showWeek:true,          //是否显示星期,默认为false  
            showButtonPanel:true,   //是否显示取消按钮，并含有today按钮，默认为false  
            closeText:'close',      //设置关闭按钮的值  
            yearRange:'2010:2012',  //显示可供选择的年份  
            defaultDate:+7          //表示默认日期是在当前日期加上7天  
            });  
       })
	</script>
</body>
</html>

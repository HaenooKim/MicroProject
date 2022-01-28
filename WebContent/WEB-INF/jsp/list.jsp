<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR" import="banana.Bang07VO, java.util.List"%>
<%
	List<Bang07VO> ls = (List<Bang07VO>)request.getAttribute("rlist");

%>
<!DOCTYPE html>
<html>
<head>
<style>


@import url(https://fonts.googleapis.com/earlyaccess/notosanskr.css);
@import url("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css");

*{
	margin: 0;
	padding: 0;
}

html {
	height:100%;
}

body {
  background: linear-gradient(45deg, rgba(161,149,228,1) 27%, rgba(184,163,226,1) 61%, rgba(170,166,225,1) 70%, rgba(235,150,229,1) 100%, rgba(88,157,217,1) 100%, rgba(65,192,218,1) 100%);
  font-family: "Noto Sans KR";
  color: #fff;
}
i {
  padding-right: 8px;
}
li {
  list-style: none;
}
a {
  text-decoration: none;
  color: #fff;
}
a:hover {
  color: #e91e63;
}

h1 {
  font-size: 40px;
  text-align: center;
  margin-bottom: 15px;
  text-shadow: 2px 2px 6px gray;
}

h2 {
	width:50%;
	text-align:left;
}

table {
  width: 100%;
  table-layout: fixed;
}

.menu {
  font-size: 18px;
  padding-bottom: 10px;
  text-align: right;
}

.tableHeader {
  background-color: rgba(255, 255, 255, 0.2);
}

.tableContent {
  height: 300px;
  overflow-x: auto;
  margin-top: 0px;
  border: 1px solid rgba(255, 255, 255, 0.2);
}
th {
  padding: 20px 15px;
  text-align: left;
  font-weight: 500;
  font-size: 20px;
  text-shadow: 2px 2px 6px gray;
}
td {
  padding: 15px;
  text-align: left;
  vertical-align: middle;
  font-weight: 300;
  font-size: 15px;
  border-bottom: solid 1px rgba(255, 255, 255, 0.1);
  text-shadow: 2px 2px 6px gray;
}

section {
  margin: 50px;
}

.bangmyung_form_content {
	margin-top:10px;
	width : 50%;
	height: 100px;
	outline : none;
	border : 0;
	background-color: rgba(255, 255, 255, 0.2);
	border-radius : 10px;
	color:white;
	font-weight:bold;
	font-size:20px;
	text-align : center;
}

.bangmyung_form_submit{
	margin-top:20px;
	width : 350px;
	padding:15px 30px;
	outline:none;
	border:0;
	border-radius : 30px;
	cursor:pointer;
	background-color:#bc71f5;
	color:white;
	font-size:20px;
	font-weight:bold;
	transition:background-color 500ms linear;
}

.bangmyung_form_submit:hover {
	
	background-color:#b55ef7;
}

.bangmyung_form {
	margin-top : 30px;
	display : flex;
	flex-direction : column;
	justify-content : center;
	align-items : center;
}

::-webkit-scrollbar {
  width: 6px;
}
::-webkit-scrollbar-track {
  -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}
::-webkit-scrollbar-thumb {
  -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}

</style>
</head>
<body>
<section>
	<h1>방명록</h1>
	<div class="tableHeader">
		<table  cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td>글 번호</td>
			<td>내용</td>
		</tr>
		</table>
	</div>	
	
	<div class="tableContent">
		<table cellpadding="0" cellspacing="0" border="0">
		<%
		for( Bang07VO t : ls ) {
			%><tr>
				<td><%=t.getNo()%></td>
				<td><span><%=t.getContent()%></span>
				<span><a href="del.do?no=<%=t.getNo()%>">[X]</a></span>
				</td>
			</tr>
		<% }
		%>
		</table>
	</div>

	
		<form method="GET" action="add.do" class="bangmyung_form">
			<h2>방명록을 남겨주세요!</h2>
			<input type="text" name="content" class="bangmyung_form_content"/>
			<input type="submit"  class="bangmyung_form_submit"/>
		</form>
</section>
	
</body>
</html>
	


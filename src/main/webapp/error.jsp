<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP '404.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <style type="text/css">
      body { margin: 0; padding: 0; font-family: "helvetica neue", helvetica, arial, sans-serif; font-size: 13px; background: #8dd3d5 url("/images/dailymile_error_bg_2.png") repeat-x 0 0; }
      #background { width: 100%; height: 100%; z-index: 1; }
      #content {
        position:absolute;
        text-align:center;
        top:55px;
        width:100%;
        z-index:3;
        text-shadow: 0 1px 1px #FFF;
        min-height: 653px;
        background: url("/hotel/img/shoes_hanging.png") no-repeat 50% 120px;
      }
      #error_page{
      	height:653px;
		width:100%;
      }
      #logo { position: absolute; z-index: 4; left: 22%; top: 12px;}
      h1 { color: #363C44; font-size: 32pt; font-weight: bold; line-height: 25px; margin-bottom: 0;}
      h2, p { color: #64818E; font-size: 15pt; font-weight: normal;}
      p { font-size: 13pt; }
      p a, p a:visited, a img { color: #454545; text-decoration: none; border: none; outline: 0;}
    </style>
  </head>
  
   <body>
    <div id="error_page">
      <img id="background" src="/hotel/img/404background.jpg" />
      <div id="content">
        <h1>页面君迷路了</h2>
        <h2>对不起，页面不存在或被移动了</h2>
        <h2>${msg }</h2>
      </div>
    </div>
  </body>
</html>

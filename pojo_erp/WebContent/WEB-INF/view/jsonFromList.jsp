<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String,Object>> rList =
	(List<Map<String,Object>>)request.getAttribute("formList");
	Gson gson = new Gson();
	String imsi = null;
	imsi = gson.toJson(rList);
	out.print(imsi);
%>
<%@page import="kr.co.sist.user.restaurant.RestaurantVO"%>
<%@page import="kr.co.sist.user.restaurant.RestaurantDAO"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	RestaurantDAO rDAO = RestaurantDAO.getInstance();
	JSONObject jsonObj = new JSONObject();
	
	try{
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEEE");
	    List<RestaurantVO> list = rDAO.selectAllRestaurant();
	    jsonObj.put("resultFlag", true);
	    jsonObj.put("dataSize", list.size());
	    jsonObj.put("pubDate", sdf.format(new Date()));
	    
	    JSONArray jsonArr = new JSONArray();
	    JSONObject jsonTemp = null;
	    
	    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	    for(RestaurantVO rVO : list){
	        jsonTemp = new JSONObject();
	        jsonTemp.put("name", rVO.getName());
	        jsonTemp.put("menu", rVO.getMenu());
	        jsonTemp.put("lat", rVO.getLat());
	        jsonTemp.put("lng", rVO.getLng());
	        jsonTemp.put("date", sdf2.format(rVO.getInput_date()));
			
	        // 값을 가진 JSONObject를 JSONArray 추가
	        jsonArr.add(jsonTemp);
	    }
	    
	    // 모든 값을 가진 jsonArr를 JSONObject 추가
	    jsonObj.put("data", jsonArr);
	} catch(SQLException e){
	    jsonObj.put("resultFlag", false);
	    e.printStackTrace();
	}
%>
<%= jsonObj.toJSONString() %>
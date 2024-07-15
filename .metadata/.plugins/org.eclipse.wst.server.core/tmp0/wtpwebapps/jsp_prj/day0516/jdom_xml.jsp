<%@page import="java.io.FileOutputStream"%>
<%@page import="org.jdom2.output.Format"%>
<%@page import="org.jdom2.output.XMLOutputter"%>
<%@page import="org.jdom2.Element"%>
<%@page import="org.jdom2.Document"%>
<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"
    info="JSP에서 XML을 생성하여 출력"%>
<%
//1. XML문서 객체 생성
Document doc=new Document();//<?xml version="1.0" encoding="UTF-8"?>
//2. 최상위 부모노드 생성
Element rootNode=new Element("msgs");//<msgs>
//3. 자식 노드 생성
Element subNode=new Element("msg");//<msg>
//자식노드가 문자열을 가져야한다면 설정
subNode.setText("안녕 XML : JDOM2 Parser를 사용한 XML생성");//<msg>안녕...</msg>

Element subNode2=new Element("msg");
subNode2.setText("오늘은 목요일 입니다.");//<msg>오늘은...</msg>

//4.자식노드를 부모노드에 배치
rootNode.addContent(subNode);//<msgs><msg>안녕..</msg></msgs>
rootNode.addContent(subNode2);//<msgs><msg>안녕..</msg></msgs><msgs><msg>오늘은..</msg></msgs>

//5.부모노드를 XML문서 객체 배치
//System.out.println(doc);// [Document:  No DOCTYPE declaration,  No root element]
//System.out.println(rootNode);// [Element: <msgs/>]
//System.out.println(subNode);// [Element: <msg/>]
doc.addContent(rootNode);
//6. XML 문서객체를 출력
XMLOutputter xOut=new XMLOutputter();
xOut.setFormat(Format.getPrettyFormat());
xOut.output(doc,System.out);//생성된 XML을 console로 출력
//<?xml version="1.0" encoding="UTF-8"?>
//<msgs><msg>안녕 XML : JDOM2 Parser를 사용한 XML생성</msg></msgs>

FileOutputStream fos=new FileOutputStream("C:/dev/workspace/jsp_prj/src/main/webapp/day0516/hello.xml");
xOut.output(doc,fos);//생성된 XML을 File로 출력
xOut.output(doc,out);//생성된 XML을 웹브라우저 (out)으로 출력



%>
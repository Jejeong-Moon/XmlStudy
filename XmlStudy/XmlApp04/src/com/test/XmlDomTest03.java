/*=============================
 * 	XmlDomTest03.java
 * 	- 콘솔 기반 자바 프로그램
 * 	- XML DOM 활용 → 로컬(local) XML 읽어내기
 * 	  (breakfast_menu.xml)
 ============================*/

// breakfast_menu.xml 파일을 대상으로
/*
■[Strawberry Belgian Waffles] $7.95 900칼로리
 Light Belgian waffles covered with strawberries and whipped cream 
-----------------------------------------------
■[Berry-Berry Belgian Waffles] $8.95 900칼로리
 Light Belgian waffles covered with an assortment of fresh berries and whipped cream 
-----------------------------------------------
 					:
 이와 같이 결과 출력이 이루어질 수 있도록 프로그램을 작성한다.
 
 */

package com.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlDomTest03
{
	public static void main(String[] args)
	{
		try
		{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document xmlObj = null;
			xmlObj = builder.parse("breakfast_menu.xml");
			
			Element root = xmlObj.getDocumentElement();
			
			NodeList menuNodeList = root.getElementsByTagName("food");
			//System.out.println(menuNodeList.getLength());
			
			for (int i = 0; i < menuNodeList.getLength(); i++)
			{
				Node menuNode = menuNodeList.item(i);
				Element menuElement = (Element)menuNode;
				
				/*
				NodeList nameNodeList = menuElement.getElementsByTagName("name");
				Node nameNode = nameNodeList.item(0);
				Element nameElement = (Element)nameNode;
				
				System.out.println(nameElement.getTextContent());
				*/
				
				System.out.printf("■[%s] %s %s칼로리%n - %s %n-----------------------------------------------%n"
											,getText(menuElement, "name"),getText(menuElement, "price")
											,getText(menuElement, "calories"), getText(menuElement, "description"));
			}
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
	}
	
	private static String getText(Element parent, String tagname)
	{
		String result = "";
		Node node = parent.getElementsByTagName(tagname).item(0);
		Element element = (Element)node;
		
		result = element.getChildNodes().item(0).getNodeValue();
		
		return result;
	}
	
	
}

/*==================================
 * 	XmlDomTest08.java
 * 	- 콘솔 기반 자바 프로그램
 * 	- XMLDOM 활용 → 원격(remote) XML 읽어내기
 *	→ https://news-ex.jtbc.co.kr/v1/get/rss/issue 
 =================================*/

/*
 <title>JTBC News</title>
<link>http://news-ex.jtbc.co.kr/v1/get/rss/issue</link>
<description>
<![CDATA[ 이슈 TOP 10 RSS ]]>
</description>
<language>ko</language>
<copyright>Copyright(C) JTBC All rights reserved.</copyright>
 
 <item>
<title>
<![CDATA[ 트럼프 "바이든 선제 사면 무효"…이유는 자동서명기계? [소셜픽] ]]>
</title>
<link>https://news.jtbc.co.kr/article/NB12239148</link>
<description>
<![CDATA[ 트럼프 대통령이 전임자가 한 사면이 무효라고 주장했습니다. &#39;자동 서명 기계&#39;가 서명했기 때문이라는 겁니다. [도널드 트럼프/미국 대통령 : 사면하기 위해 자동 서명 기계를 썼습니다. 선출되지 않은 ]]>
</description>
<pubDate>2025.03.18</pubDate>
</item>
 
 
 */

package com.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlDomTest08
{
	public static void main(String[] args)
	{
		try
		{
			// ※ DOM(Document Object Model)
			//		- XML 이나 HTML Document(문서)를 응용프로그램에서 사용하기 위한 API 규격
			//		- DOM 은 Documnet(문서)의 각 부분들을 객체(Object)로 표현함 API
			
			// ※ DOM(Document Object Model) 파서(parser)
			//		- XML 문서를 읽고 해석한 후
			//		  해석한 결과를 메모리에 DOM 객체를 트리구조로 생성시키는 파서(Parser)
			//		- 원하는 데이터에 접근할 수 있도록 해주어
			//		  검색, 수정, 삭제할 수 있도록 지원
			
			// ※ 주로 사용되는 DOM(Document Object model) 인터페이스
			//		- Node
			//		: 모든 객체의 부모 인터페이스로서 공토적으로 기능하는 함수를 가진다.
			//		- NodeList(NODESET)
			//		: 노드들을 리스트로 받아 처리하기 쉽도록 한 것 (일괄 처리)
			//		- Document
			//		: DOM(Document Object Model) 트리 구조의 최상위 노드로
			//		  XML 문서 자체를 의미한다.
			//		- Element
			//		: XML 의 엘리먼트에 해당하는 객체 유형
			//		- Attr
			//		: XML의 attribute에 해당하는 객체 유형
			//		- CharacterData 
			//		: XML의 데이터에 해당하는 객체 유형
			//		- Text
			//		: 문자 데이터(내용)에 해당하는 객체 유형
			
			
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document xmlObj = null;
			
			xmlObj = builder.parse("https://news-ex.jtbc.co.kr/v1/get/rss/issue");
			
			
			Element root = xmlObj.getDocumentElement();
			
			
			XMLDOM.getText2(root);
			
			/*
			NodeList channelNodeList = root.getElementsByTagName("channel");
			for (int i = 0; i < channelNodeList.getLength(); i++)
			{
				Node channelNode = channelNodeList.item(i);
				Element channelElement = (Element)channelNode;
				
				
				System.out.println(channelElement.getNodeName());
				
			}
			
			
			NodeList channelNodeList = root.getElementsByTagName("channel");
			Node channelNode = channelNodeList.item(0);
			Element channelElement = (Element)channelNode;
			 */
			
			
			//System.out.println(channelElement.getTextContent());
			//System.out.println(XMLDOM.getText(channelElement, "title"));
			
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		
	}
	
	
}

package com.example.demo.common.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XmlUtil {

    static String generate_xml_path= PropertyUtil.getProperty("generate_xml_path");

    /**
     * 获取文件根节点对象
     * @param file
     * @return org.dom4j.Element
     * @Author: chaiqianlong
     * @Date: 2019-10-29 16:23
     */
    public static Element getRootNode(File file){
        //1.创建Reader对象
        SAXReader reader = new SAXReader();
        //2.加载xml
        Document document = null;
        try {
            document = reader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        //3.获取根节点
        return document.getRootElement();
    }

    /**
     * 根据父节点对象和子节点名称获取子节点列表
     * @param parent_node 父节点对象
     * @param child_node_name 子节点名称
     * @return java.util.List<org.dom4j.Element>
     * @Author: chaiqianlong
     * @Date: 2019-10-29 16:23
     */
     public static List<Element> getNodeList(Element parent_node, String child_node_name){
         return parent_node.elements(child_node_name);
     }

    /**
     * 获取第一个节点值
     * @param nodeList
     * @return java.lang.String
     * @Author: chaiqianlong
     * @Date: 2019-10-29 16:24
     */
    public static String getNodeValueFirst(List<Element> nodeList) {
        String result = "";
        if (nodeList.size() > 0) {
            result = nodeList.get(0).getText().trim();
        }
        return result;
    }

    /**
     * 获取所有节点值
     * @param nodeList
     * @return java.lang.String
     * @Author: chaiqianlong
     * @Date: 2019-10-29 16:24
     */
    public static String getNodeValueAll(List<Element> nodeList) {
        String result = "";
        for (int i = 0; i < nodeList.size(); i++) {
            result += nodeList.get(i).getText().trim();
        }
        return result;
    }

    /**
     * 字符串转xml
     * @param xmlStr
     * @param fileName
     * @return void
     * @Author: chaiqianlong
     * @Date: 2019-10-29 16:24
     */
    public static void StringToXml(String xmlStr,String fileName) {
        fileName = generate_xml_path + File.separator + fileName;
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        OutputXml(document,fileName);
    }

    /**
     * 输出xml文件
     * @param doc
     * @param filename
     * @return void
     * @Author: chaiqianlong
     * @Date: 2019-10-29 16:24
     */
    public static void OutputXml(Document doc, String filename){
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        try {
            XMLWriter writer = new XMLWriter(new FileWriter(new File(filename)), format);
            writer.write(doc);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

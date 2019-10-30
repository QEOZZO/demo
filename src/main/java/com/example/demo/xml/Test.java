package com.example.demo.xml;

import com.example.demo.xml.bean.MainDataBean;
import com.example.demo.xml.bean.OrderDataBean;
import com.example.demo.xml.bean.UserDataBean;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Test {

    private  static String filePath = "/Users/chaiqianlong/workspace/practive/demo/src/main/java/com/example/demo/xml/file/generate/data.xml";

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(MainDataBean.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object unmarshal = unmarshaller.unmarshal(new File(filePath));
            MainDataBean mainData = (MainDataBean) unmarshal;
            UserDataBean userData = mainData.getUserDataBean();
            OrderDataBean orderData = mainData.getOrderDataBean();
            System.out.println(userData);
            System.out.println(orderData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

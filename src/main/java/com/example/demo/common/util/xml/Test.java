package com.example.demo.common.util.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Test {

    private  static String resoursePath = "/Users/chaiqianlong/workspace/practive/demo/src/main/java/com/example/demo/common/util/xml/test.xml";

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(MainDataModel.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object unmarshal = unmarshaller.unmarshal(new File(resoursePath));
            MainDataModel mainDataModel = (MainDataModel) unmarshal;
            First first = mainDataModel.getFirst();
            Secend secend = mainDataModel.getSecend();
            System.out.println(first);
            System.out.println(secend);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

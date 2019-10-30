package com.example.demo.common.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Test {

    private  static String resoursePath = "/Users/chaiqianlong/workspace/practive/demo/src/main/java/com/example/demo/common/util/xml/test.xml";

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Data.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object unmarshal = unmarshaller.unmarshal(new File(resoursePath));
            Data data = (Data) unmarshal;
            First first = data.getFirst();
            Secend secend = data.getSecend();
            System.out.println(first);
            System.out.println(secend);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

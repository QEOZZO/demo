package com.example.demo.xml.controller;

import com.example.demo.common.entity.MsgModel;
import com.example.demo.xml.bean.MainDataBean;
import com.example.demo.xml.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Controller
@RequestMapping(value = "/demo")
public class DemoController {

    @Autowired
    DemoService demoService;

    /**
     * 解密后生成的文件
     */
    private static String generateFilePath = "/Users/chaiqianlong/workspace/practive/demo/src/main/java/com/example/demo/xml/file/generate/data.xml";

    @ResponseBody
    @PostMapping("/test")
    public Object demoTestPost() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(MainDataBean.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object unmarshal = unmarshaller.unmarshal(new File(generateFilePath));
        MainDataBean mainDataBean = (MainDataBean) unmarshal;
        MsgModel msgModel = demoService.testSave(mainDataBean);
        return msgModel;
    }

}

package com.keith.demo;

import com.keith.utils.ReplaceStr;
import org.junit.Test;

public class TestReplaceStr {

    @Test
    public void testReplaceStr1(){
        ReplaceStr replaceStr = new ReplaceStr();
//        String filePath = TestReplaceStr.class.getResource("../../../wsdlFile.wsdl").getPath();
        String filePath = ClassLoader.getSystemResource("wsdlFile.wsdl").getPath();
        String oldStr = "$MAVEN_REPOSITORY$";
        String newStr = "D://maven//repo";
        boolean result = replaceStr.replaceStr(filePath, oldStr, newStr);
        System.out.println("the result is : " + result);
    }
}

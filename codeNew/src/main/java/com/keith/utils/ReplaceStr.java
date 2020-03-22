package com.keith.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class ReplaceStr {

    private static final Logger logger = LoggerFactory.getLogger(ReplaceStr.class);

    public boolean replaceStr(String filePath, String oldStr, String newStr) {
        boolean result = false;
        if (filePath == null) {
            logger.info("file is null");
            return result;
        }
        File file = new File(filePath);
        StringBuilder sb = new StringBuilder();
        String encoding = "UTF-8";
        String line = "";
        try(FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(fileInputStream, encoding);
            BufferedReader bufferedReader = new BufferedReader(reader)) {
            while ((line = bufferedReader.readLine()) != null) {
                if (line.indexOf(oldStr) > -1) {
                    line = line.substring(0, line.indexOf(oldStr)) + newStr + line.substring(line.indexOf(oldStr) + oldStr.length());
                }
                sb.append(line + "\r\n");
            }

        } catch (IOException e) {
            logger.error("read file error" + e);
            return result;
        }

        try (FileOutputStream outputStream = new FileOutputStream(file);
             OutputStreamWriter writer = new OutputStreamWriter(outputStream, encoding);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write(sb.toString());
        } catch (IOException e) {
            logger.error("write file error" + e);
            return result;
        }
        result = true;
        return result;
    }
}

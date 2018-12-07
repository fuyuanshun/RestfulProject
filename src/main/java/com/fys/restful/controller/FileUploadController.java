package com.fys.restful.controller;

import com.alibaba.fastjson.JSON;
import com.fys.restful.util.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
@RequestMapping(value = "/upload")
public class FileUploadController {

    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public @ResponseBody
    String upLoad(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws Exception {
        String fileName = multipartFile.getOriginalFilename();
        ResultUtil resultUtil = null;
        if (fileName == null || "".equals(fileName)) {
            resultUtil = new ResultUtil("400", "仅支持上传MP3文件", null);
            return JSON.toJSONString(resultUtil);
        }

        //将上传的文件名按照.切割成一个数组，获得数组的个数
        String[] strings = fileName.split("\\.");

        if (!fileName.split("\\.")[strings.length-1].equals("mp3")) {
            resultUtil = new ResultUtil("400", "仅支持上传MP3文件", null);
            return JSON.toJSONString(resultUtil);
        }

        String path = request.getServletContext().getRealPath("/WEB-INF/music");
        File uploadDir = new File(path+"\\"+fileName);
        if (!new File(path).exists()) {
            new File(path).mkdirs();
        }
        uploadDir.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(
                uploadDir);
        byte[] bytes = multipartFile.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(
                fileOutputStream);
        stream.write(bytes);
        stream.flush();
        stream.close();
        return "上传成功！";
    }
}

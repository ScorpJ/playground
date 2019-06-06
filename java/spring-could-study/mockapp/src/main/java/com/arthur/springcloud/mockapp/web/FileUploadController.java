package com.arthur.springcloud.mockapp.web;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@RestController
@RequestMapping("/files")
public class FileUploadController {

    private static Logger log = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping( method = RequestMethod.GET)
    public String hello(){
        return "Hello";
    }

    @RequestMapping(method= RequestMethod.POST)
    public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException {

        if(!file.isEmpty()){
            log.debug("Process file: {}", file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("D:\\tmp\\", System.currentTimeMillis()+ file.getOriginalFilename()));
        }

        return "success";
    }

    @RequestMapping(value="/files", method=RequestMethod.POST)
    public String doUploadFile2(MultipartHttpServletRequest multiRequest) throws IOException{

        Iterator<String> filesNames = multiRequest.getFileNames();
        while(filesNames.hasNext()){
            String fileName =filesNames.next();
            MultipartFile file =  multiRequest.getFile(fileName);
            if(!file.isEmpty()){
                log.debug("Process file: {}", file.getOriginalFilename());
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File("D:\\tmp\\", System.currentTimeMillis()+ file.getOriginalFilename()));
            }

        }

        return "success";
    }
}

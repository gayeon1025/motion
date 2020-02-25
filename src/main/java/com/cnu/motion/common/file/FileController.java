package com.cnu.motion.common.file;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/files")
public class FileController {

    @Value("${file.upload-dir}")
    private String destination;

    @PostMapping
    public String upload(@RequestParam("file") MultipartFile[] files) throws IOException {
        for (MultipartFile file : files) {
            File newFile = new File(destination + file.getOriginalFilename());

            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);
            } catch (IOException exception) {
                log.debug("File to upload file : {}", exception);
                throw exception;
            }
        }

        log.debug("Success to upload {} files at {}.", files.length, destination);
        return destination;
    }
}

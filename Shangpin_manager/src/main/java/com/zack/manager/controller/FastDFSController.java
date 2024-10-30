package com.zack.manager.controller;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("admin/system")
@Api(tags = {"文件操作接口"})
public class FastDFSController {

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @PostMapping("/fileUpload")
    @ApiOperation(value = "上传文件接口", httpMethod = "POST")
    public String uploadFile(@RequestPart MultipartFile file) throws IOException {
        StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        return storePath.getFullPath();
    }

    @GetMapping("/fileDownload")
    @ApiOperation(value = "下载文件接口", httpMethod = "GET", produces = "application/octet-stream")
    public ResponseEntity<byte[]> downloadFile(String filePath) throws IOException {
        StorePath storePath = StorePath.parseFromUrl(filePath);
        byte[] content = fastFileStorageClient.downloadFile(storePath.getGroup(), storePath.getPath(), new DownloadByteArray());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment",filePath.substring(filePath.lastIndexOf("/")+1));
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        System.out.println(filePath.substring(filePath.lastIndexOf("/")+1));
        return new ResponseEntity<byte[]>(content,headers, HttpStatus.OK);
    }

    @DeleteMapping("/fileDelete")
    @ApiOperation(value = "删除文件接口", httpMethod = "DELETE")
    public String deleteFile(String filePath) throws IOException {
        StorePath storePath = StorePath.parseFromUrl(filePath);
        fastFileStorageClient.deleteFile(storePath.getGroup(),storePath.getPath());
        return "delete OK";
    }

}


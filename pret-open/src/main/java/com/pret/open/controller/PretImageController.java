package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.util.DateUtil;
import com.pret.common.util.file.FileUpload;
import com.pret.common.util.file.UuidUtil;
import com.pret.open.entity.PretImage;
import com.pret.open.entity.vo.PretImageVo;
import com.pret.open.service.PretImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("pretImage")
public class PretImageController extends BaseManageController<PretImageService, PretImage, PretImageVo> {
    @Value("${upload.baseurl}")
    private String baseurl;
    @Value("${upload.path}")
    private String path;

    @Log("新增图片")
    @PostMapping("/{type}")
    public PretImage uploadImg(@PathVariable String type, HttpServletRequest request) {
        String prefix = DateUtil.getDays();
        // 文件上传路径
        String subPath = type + "/" + prefix;
        String filePath = path + subPath;
        String fileName = this.upload(request, filePath);

        PretImage image = new PretImage();
        image.setPath(subPath + "/" + fileName);
        image.setUrl(baseurl + "/" + type + "/" + prefix + "/" + fileName);
        this.service.save(image);

        return image;
    }

    /* *
     * 功能描述: 上次图片
     * 〈〉
     * @Param: [request, filePath]
     * @Return: java.lang.String
     * @Author: wujingsong
     * @Date: 2019/10/9  11:03 上午
     */
    private String upload(HttpServletRequest request, String filePath) {
        String fileName = "";

        MultipartHttpServletRequest mul = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = mul.getFileMap();
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            MultipartFile mf = entity.getValue();
            try {
                fileName = FileUpload.fileUp(mf, filePath,
                        UuidUtil.get32UUID());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fileName;
    }
}
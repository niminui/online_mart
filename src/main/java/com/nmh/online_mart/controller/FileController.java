package com.nmh.online_mart.controller;

import com.alibaba.fastjson.JSON;
import com.nmh.online_mart.dto.MsgDTO;
import com.nmh.online_mart.provider.ALiYunProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * @author niminui
 * @date 2020/4/23 10:43
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private ALiYunProvider aLiYunProvider;

    @RequestMapping(value = "/uploadProduction", method = RequestMethod.POST)
    @ResponseBody
    public MsgDTO uploadProduction(MultipartFile file, HttpServletRequest request) {
        URL fileName = null;
        try {
            assert file != null;
            fileName = aLiYunProvider.upload(file.getInputStream(),
                    file.getContentType(), Objects.requireNonNull(file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
            return MsgDTO.fail().add("re_msg","图片上传失败！请重试");
        }
        request.getSession().setAttribute("fileName", JSON.toJSONString(fileName));
        return MsgDTO.success().add("re_msg",fileName);
    }

}

package com.itheima.document.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.document.entity.File;
import com.itheima.document.entity.User;
import com.itheima.document.service.FileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (File)表控制层
 *
 * @author makejava
 * @since 2020-01-02 13:04:32
 */
@RestController
@RequestMapping("file")
public class FileController  extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private FileService fileService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public File selectOne(Integer id) {
        return this.fileService.queryById(id);
    }

    @RequestMapping("/findAll")
    public @ResponseBody
    Map<String, Object> findAll(@RequestParam(defaultValue = "1", required = true) Integer page,
                                @RequestParam(defaultValue = "100", required = true) Integer size) {
        map.clear();
        PageHelper.startPage(page, size);
        String operator=null;
        List<File> files = fileService.queryAllByLimit(page, size,null);
        PageInfo pageInfo = new PageInfo(files, page);
        map.put("rows", pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }

    @RequestMapping("/findMyAll")
    public @ResponseBody
    Map<String, Object> findMyAll(@RequestParam(defaultValue = "1", required = true) Integer page,
                                @RequestParam(defaultValue = "100", required = true) Integer size) {
        map.clear();
        String operator= ((User)session.getAttribute("user")).getUsername();
        PageHelper.startPage(page, size);
        List<File> files = fileService.queryAllByLimit(page, size,operator);
        PageInfo pageInfo = new PageInfo(files, page);
        map.put("rows", pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }

    @RequestMapping("/upload")
    public @ResponseBody Map<String,Object> upload(MultipartFile file) throws IOException {
        map.clear();
        User user = (User)session.getAttribute("user");
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        java.io.File file2 =new java.io.File(path);
        if (!file2.exists()){
            file2.mkdirs();
        }
        String filename=file.getOriginalFilename();
        file.transferTo(new java.io.File(path,filename));
        File file1=new File()
                .setName(file.getOriginalFilename())
                .setOperator(user.getName())
                .setType(file.getContentType())
                .setSize(String.valueOf(file.getSize()/1048576.0)+"M")
                .setPath(filename)
                .setUploadtime(new Date());
        fileService.insert(file1);
        return map;
    }

    @RequestMapping("/delete")
    public @ResponseBody Map<String,Object> delete(Integer id){
        map.clear();
        try {
            fileService.deleteById(id);
            map.put("msg",1);
        } catch (Exception e) {
            map.put("msg",1);
        }
        return map;
    }

}
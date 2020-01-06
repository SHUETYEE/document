package com.itheima.document.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.document.entity.Student;
import com.itheima.document.service.StudentService;
import com.itheima.document.util.ExcelUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2019-12-20 21:36:38
 */
@Controller
@RequestMapping("/student")
public class StudentController extends BaseController {
    /**
     * 服务对象
     */
    @Autowired
    private StudentService studentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Student selectOne(Integer id) {
        return this.studentService.queryById(id);
    }

    @RequestMapping("/findAll")
    public @ResponseBody Map<String, Object> findAll(@RequestParam(defaultValue = "1", required = true) Integer page,
                                                     @RequestParam(defaultValue = "100", required = true) Integer size) {
        map.clear();
        PageHelper.startPage(page, size);
        List<Student> students = studentService.queryAllByLimit(page, size);
        PageInfo pageInfo = new PageInfo(students, page);
        map.put("rows", pageInfo.getList());
        map.put("total",pageInfo.getTotal());
        return map;
    }

    @RequestMapping("add")
    public @ResponseBody Map<String,Object> add(Student student){
        map.clear();
        try {
            studentService.insert(student);
            map.put("msg",1);
        } catch (Exception e) {
           map.put("msg",0);
        }
        return map;
    }

    @RequestMapping("/delete")
    public @ResponseBody Map<String,Object> delete(Integer id){
        System.out.println(id);
        map.clear();
        try {
            studentService.deleteById(id);
            map.put("msg",1);
        } catch (Exception e) {
            map.put("msg",1);
        }
        return map;
    }

    @RequestMapping("/upload")
    public @ResponseBody Map<String,Object> upload(MultipartFile file) throws IOException {
        map.clear();
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        List<Student> list = ExcelUtils.importExcel(workbook);
        studentService.insertList(list);
        return map;
    }

    @RequestMapping("/export")
    public ResponseEntity<Object> export(Student student) throws UnsupportedEncodingException {
        List<Student> userList = studentService.findStudent(student);
        System.out.println(userList);
        String fileName = "学生数据.xls";
        String sheetName = "学生数据";
        ByteArrayOutputStream bos = ExcelUtils.exportUser(userList, sheetName);
        String encode = URLEncoder.encode(fileName, "UTF-8");
        //创建封装响应头信息的对象
        HttpHeaders headers = new HttpHeaders();
        //封装响应内容类型
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment",encode);
        return new ResponseEntity<Object>(bos.toByteArray(),headers, HttpStatus.CREATED);
    }

    @RequestMapping("findOne")
    public void findOne(Integer id){
        Student student = studentService.queryById(id);
        model.addAttribute("student",student);
    }

}
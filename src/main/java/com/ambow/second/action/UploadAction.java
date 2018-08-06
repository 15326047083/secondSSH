package com.ambow.second.action;

import com.ambow.second.entity.User;
import com.ambow.second.service.IUserService;
import com.ambow.second.util.ExportExcel;
import com.ambow.second.util.ImportExcel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.deploy.net.HttpResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class UploadAction extends ActionSupport {

    @Autowired
    private IUserService userService;
    private File file;
    private String contentType;
    private String filename;

    public void setUpload(File file) {
        this.file = file;
    }

    public void setUploadContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setUploadFileName(String filename) {
        this.filename = filename;
    }

    public String execute() {
        //...
        return SUCCESS;
    }
    @Action(value = "doUpload" ,results = {@Result(name = "success", location = "/user/queryAll.action",type = "redirect")})
    public String doUpload(){
        ImportExcel importExcel=new ImportExcel();
        List<User> importList=importExcel.ImportExcel(file);
        userService.saveOrUpdate(importList);
        return SUCCESS;
    }
    @Action(value = "download" ,results = {@Result(name = "success", location = "/user/queryAll.action",type = "redirect")})
    public String download(){
        HttpServletResponse response= ServletActionContext.getResponse();
        ExportExcel exportExcel=new ExportExcel();
        try {
            List<User> userList=userService.queryAll();
            // path是指欲下载的文件的路径。
            File file = exportExcel.ExportExcel(userList);
            // 取得文件名。
            System.out.println(file);
            String filename = file.getName();
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename="
                    + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(
                    response.getOutputStream());
            response.setContentType("application/vnd.ms-excel;charset=gb2312");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
            file.delete();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return  null;
    }
}

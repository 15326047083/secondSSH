package com.ambow.second.util;

import com.ambow.second.entity.User;
import com.ambow.second.service.IUserService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExportExcel {

    @Autowired
    private IUserService userService;

    public int ExportExcel(List<User> list) {
            Field[] fields = null;
            String result = "";
            if (list.size() == 0 || list == null) {
                return 0;
            } else {
                // list里为对象，我们取出第一个对象的键作为表头
                User u = list.get(0);
                Class clazz = u.getClass();
                String className = clazz.getSimpleName();
                fields = clazz.getDeclaredFields(); // 这里通过反射获取字段数组
                File folder = new File("D:/software/export");
                // 判断是否存在
                if (!folder.exists()) {
                    folder.mkdirs();
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fileName = sdf.format(new Date());
                String name = fileName.concat(".xls");
                WritableWorkbook book = null;
                File file = null;
                try {
                    file = new File("D:/software/export".concat(File.separator).concat(name));
                    // 创建xsl文件
                    book = Workbook.createWorkbook(file);
                    // 创建sheet
                    WritableSheet sheet = book.createSheet(className, 0);
                    int i = 0; // 列
                    int j = 0; // 行
                    for (Field f : fields) {
                        j = 0;
                        Label label = new Label(i, j, f.getName()); // 这里把字段名称写入excel第一行中
                        sheet.addCell(label);
                        j = 1;
                        for (Object obj : list) {
                            Object temp = getFieldValueByName(f.getName(), obj);
                            String strTemp = "";
                            if (temp != null) {
                                strTemp = temp.toString();
                            }
                            sheet.addCell(new Label(i, j, strTemp)); // 把每个对象此字段的属性写入这一列excel中
                            j++;
                        }
                        i++;
                    }
                    book.write();
                    result = file.getPath();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                finally {
                    fileName = null;
                    name = null;
                    folder = null;
                    file = null;
                    if(book!=null){
                        try {
                            book.close();
                        } catch (WriteException e) {
                            // TODO Auto-generated catch block
                            result = "WriteException";
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            result = "IOException";
                            e.printStackTrace();
                        }
                    }
                }
            }
            return fields.length;
        }
        public Object getFieldValueByName(String fieldName, Object o) {
            try {
                String firstLetter = fieldName.substring(0, 1).toUpperCase();
                String getter = "get" + firstLetter + fieldName.substring(1);    //获取方法名
                Method method = o.getClass().getMethod(getter, new Class[]{});  //获取方法对象
                Object value = method.invoke(o, new Object[]{});    //用invoke调用此对象的get字段方法
                return value;  //返回值
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

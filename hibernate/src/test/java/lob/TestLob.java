package lob;

import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;
import pojo.Jdbc_lob;

import java.awt.print.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Clob;

public class TestLob {


    public void blobTest() {
        Jdbc_lob b = new Jdbc_lob();
        try {
            FileInputStream fis = new FileInputStream(
                    "E:\\Users\\zhoushun\\Pictures\\0fb3c75c9037e36bfbf2c0b5.jpg");
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            b.setImg(buffer);
            b.setRemarke("zhoushun");
            //this.h.save(b);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }// 定义文件读入流
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
/*
    public static void main(String[] args) throws IOException {
        //得到session
        Configuration cfg = new Configuration().configure();
        ServiceRegistry  sr = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sf = cfg.buildSessionFactory(sr);
        Session session = sf.openSession();
        //得到LobHelper
        LobHelper lobHelper = session.getLobHelper();
        //得到图片的blob
        InputStream in = new FileInputStream("F:\\4563123.jpg");
        Blob blob = lobHelper.createBlob(in, in.available());
        //得到简介的clob
        Clob clob = lobHelper.createClob("这是一本书。#（*&#@￥%（*&@￥）（@#￥#￥");
        //创建图书对象
        Book book = new Book();
        book.setPhoto(blob);
        book.setDescription(clob);
        //存进数据库
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }*/


/*
    @Test
    public void blobTest() throws FileNotFoundException {
        //得到session
        Configuration cfg = new Configuration().configure();
        ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sf = cfg.buildSessionFactory(sr);
        Session session = sf.openSession();
        //得到LobHelper
        LobHelper lobHelper = session.getLobHelper();
        //得到图片的blob
        InputStream in = new FileInputStream("F:\\4563123.jpg");
        Blob blob = lobHelper.createBlob(in, in.available());
        //得到简介的clob
        Clob clob = lobHelper.createClob("这是一本书。#（*&#@￥%（*&@￥）（@#￥#￥");

        //创建图书对象
        Book book = new Book();
        book.setPhoto(blob);
        book.setDescription(clob);
        //存进数据库
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }*/
}

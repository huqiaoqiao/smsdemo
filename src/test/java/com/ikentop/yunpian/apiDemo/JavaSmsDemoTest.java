package com.ikentop.yunpian.apiDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URLEncoder;

/**
 * @author : Huqiao
 * @since : 2017/9/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JavaSmsDemo.class)
public class JavaSmsDemoTest {
    //编码格式。发送编码格式统一用UTF-8
    private String ENCODING = "UTF-8";
    private String apikey = "xxxxxxxxxxxxxxxxxxxxxxxxxx";
    private String mobile = "xxxxxxxxxx";

    @Test
    public void testGetUserInfo() throws Exception {
        System.out.println(JavaSmsDemo.getUserInfo(apikey));
    }

    @Test
    public void testSendSms() throws Exception {
        String text = "【艾肯拓】您好,您的订单编号为:1234";
        System.out.println(JavaSmsDemo.sendSms(apikey, text, mobile));
    }

    @Test
    public void testTplSendSms() throws Exception {
        //设置模板ID，如使用1号模板:【#company#】您的验证码是#code#
        long tpl_id = 1;
        //设置对应的模板变量值
        String tpl_value = URLEncoder.encode("#code#", ENCODING) + "="
                + URLEncoder.encode("1234", ENCODING) + "&"
                + URLEncoder.encode("#company#", ENCODING) + "="
                + URLEncoder.encode("艾肯拓", ENCODING);
        System.out.println(JavaSmsDemo.tplSendSms(apikey, tpl_id, tpl_value, mobile));
    }

    @Test
    public void testSendVoice() throws Exception {
        String code = "1234";
        System.out.println( JavaSmsDemo.sendVoice(apikey, mobile, code));
    }

    @Test
    public void testBindCall() throws Exception {
        String from = "+86xxxxxxxxx";
        String to= "+86xxxxxxxx";
        Integer duration = 30*60;
        System.out.println(JavaSmsDemo.bindCall(apikey,from,to,duration));
    }

    @Test
    public void testUnbindCall() throws Exception {
        String from = "+86xxxxxxx";
        String to= "+86xxxxxxx";
        System.out.println(JavaSmsDemo.unbindCall(apikey,from,to));
    }

}
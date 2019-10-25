package com.gqz.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringBootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    //测试发送简单邮件
    @Test
    public void testSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();

        //右键设置
        message.setSubject("ForFuture Group 通知");
        message.setText("gqzdev 邮件通知信息，明天休假一天！");

        message.setTo("2027776292@qq.com");
        message.setFrom("ganquanzhong@qq.com");

        mailSender.send(message);

        System.out.println("右键发送成功！");
    }

    //测试发送复杂邮件 （文件 图片等）
    @Test
    public void testSendMail() throws Exception{
        //1.创建一个复杂的消息右键
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //文件支持
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        helper.setSubject("【ForFuture Group】通知");
        helper.setText("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
                "<html>\n" +
                " <head>\n" +
                "  <title> 打赏 design by gqzdev </title>\n" +
                "  <meta name=\"Generator\" content=\"EditPlus\">\n" +
                "  <meta name=\"Author\" content=\"\">\n" +
                "  <meta name=\"Keywords\" content=\"\">\n" +
                "  <meta name=\"Description\" content=\"\">\n" +
                "    <style>\n" +
                "            /*  打赏 start create by gqz*/\n" +
                "            .dashang_content {\n" +
                "                width: 80%;\n" +
                "                margin: 10px auto;\n" +
                "            }\n" +
                "\n" +
                "            .hide_box {\n" +
                "                z-index: 999;\n" +
                "                filter: alpha(opacity=50);\n" +
                "                background: #666;\n" +
                "                opacity: 0.5;\n" +
                "                -moz-opacity: 0.5;\n" +
                "                left: 0;\n" +
                "                top: 0;\n" +
                "                height: 99%;\n" +
                "                width: 100%;\n" +
                "                position: fixed;\n" +
                "                display: none;\n" +
                "            }\n" +
                "\n" +
                "            .shang_box {\n" +
                "                width: 540px;\n" +
                "                height: 540px;\n" +
                "                padding: 10px;\n" +
                "                background-color: #fff;\n" +
                "                border-radius: 10px;\n" +
                "                position: fixed;\n" +
                "                z-index: 1000;\n" +
                "                left: 50%;\n" +
                "                top: 50%;\n" +
                "                margin-left: -280px;\n" +
                "                margin-top: -280px;\n" +
                "                border: 1px dotted #dedede;\n" +
                "                display: none;\n" +
                "            }\n" +
                "\n" +
                "            .shang_box img {\n" +
                "                border: none;\n" +
                "                border-width: 0;\n" +
                "            }\n" +
                "\n" +
                "            .dashang {\n" +
                "                display: block;\n" +
                "                width: 100px;\n" +
                "                margin: 5px auto;\n" +
                "                height: 25px;\n" +
                "                line-height: 25px;\n" +
                "                padding: 10px;\n" +
                "                background-color: #E74851;\n" +
                "                color: #fff;\n" +
                "                text-align: center;\n" +
                "                text-decoration: none;\n" +
                "                border-radius: 10px;\n" +
                "                font-weight: bold;\n" +
                "                font-size: 16px;\n" +
                "            }\n" +
                "\n" +
                "            .shang_close {\n" +
                "                float: right;\n" +
                "                display: inline-block;\n" +
                "            }\n" +
                "\n" +
                "            .shang_logo {\n" +
                "                display: block;\n" +
                "                text-align: center;\n" +
                "                margin: 20px auto;\n" +
                "            }\n" +
                "\n" +
                "            .shang_tit {\n" +
                "                width: 100%;\n" +
                "                height: 75px;\n" +
                "                text-align: center;\n" +
                "                line-height: 66px;\n" +
                "                color: #a3a3a3;\n" +
                "                font-size: 16px;\n" +
                "                /*background: url('/dsimg/cy-reward-title-bg.jpg');*/\n" +
                "                font-family: 'Microsoft YaHei';\n" +
                "                margin-top: 7px;\n" +
                "                margin-right: 2px;\n" +
                "            }\n" +
                "\n" +
                "            .shang_tit p {\n" +
                "                color: #a3a3a3;\n" +
                "                text-align: center;\n" +
                "                font-size: 16px;\n" +
                "            }\n" +
                "\n" +
                "            .shang_payimg {\n" +
                "                width: 140px;\n" +
                "                padding: 10px;\n" +
                "                border: 6px solid #EA5F00;\n" +
                "                margin: 0 auto;\n" +
                "                border-radius: 3px;\n" +
                "                height: 140px;\n" +
                "            }\n" +
                "\n" +
                "            .shang_payimg img {\n" +
                "                display: block;\n" +
                "                text-align: center;\n" +
                "                width: 140px;\n" +
                "                height: 140px;\n" +
                "            }\n" +
                "\n" +
                "            .pay_explain {\n" +
                "                text-align: center;\n" +
                "                margin: 10px auto;\n" +
                "                font-size: 12px;\n" +
                "                color: #545454;\n" +
                "            }\n" +
                "\n" +
                "            .radiobox {\n" +
                "                width: 16px;\n" +
                "                height: 16px;\n" +
                "                background: url('https://static.runoob.com/images/dashang/radio2.jpg');\n" +
                "                /* background: url('https://images.cnblogs.com/cnblogs_com/gqzdev/1564989/t_dashang_radio2.jpg');  */\n" +
                "                display: block;\n" +
                "                float: left;\n" +
                "                margin-top: 5px;\n" +
                "                margin-right: 14px;\n" +
                "            }\n" +
                "\n" +
                "            .checked .radiobox {\n" +
                "                background: url('https://static.runoob.com/images/dashang/radio1.jpg');\n" +
                "                /* background: url('https://images.cnblogs.com/cnblogs_com/gqzdev/1564989/t_dashang_radio1.jpg');  */\n" +
                "            }\n" +
                "\n" +
                "            .shang_payselect {\n" +
                "                text-align: center;\n" +
                "                margin: 0 auto;\n" +
                "                margin-top: 40px;\n" +
                "                cursor: pointer;\n" +
                "                height: 60px;\n" +
                "                width: 280px;\n" +
                "            }\n" +
                "\n" +
                "            .shang_payselect .pay_item {\n" +
                "                display: inline-block;\n" +
                "                margin-right: 10px;\n" +
                "                float: left;\n" +
                "            }\n" +
                "\n" +
                "            .shang_info {\n" +
                "                clear: both;\n" +
                "            }\n" +
                "\n" +
                "            .shang_info p,\n" +
                "            .shang_info a {\n" +
                "                color: #C3C3C3;\n" +
                "                text-align: center;\n" +
                "                font-size: 12px;\n" +
                "                text-decoration: none;\n" +
                "                line-height: 2em;\n" +
                "            }\n" +
                "            /*  打赏 end create by gqzdev/    \n" +
                "    </style>\n" +
                " </head>\n" +
                "    \n" +
                "    \n" +
                "      \n" +
                "    \n" +
                " <body>\n" +
                "    <!--打赏  链接  start-->\n" +
                "    <a onclick=\"dashangToggle()\" class=\"dashang\">打赏</a>\n" +
                "\n" +
                "    <!--打赏 start-->\n" +
                "    <div>\n" +
                "        <div class=\"dashang_content\" >\n" +
                "            <div class=\"shang_box\">\n" +
                "                <a class=\"shang_close\" href=\"javascript:void(0)\" onclick=\"dashangToggle()\" title=\"关闭\">\n" +
                "                    <img src=\"https://images.cnblogs.com/cnblogs_com/gqzdev/1564989/t_close.jpg\"\n" +
                "                         style=\"width:10px;height:10px\" alt=\"取消\" /></a>\n" +
                "                <div class=\"shang_tit\">\n" +
                "                    <p>『感谢您的支持，我会继续努力的』</p>\n" +
                "                </div>\n" +
                "                <div class=\"shang_payimg\">\n" +
                "                    <img src=\"https://images.cnblogs.com/cnblogs_com/gqzdev/1564989/t_alipay.png\" alt=\"扫码支持\" title=\"扫一扫\" />\n" +
                "                </div>\n" +
                "                <div class=\"pay_explain\">扫码打赏，你说多少就多少</div>\n" +
                "                <div class=\"shang_payselect\">\n" +
                "                    <div class=\"pay_item checked\" data-id=\"alipay\">\n" +
                "                        <span class=\"radiobox\"></span>\n" +
                "                        <span class=\"pay_logo\">\n" +
                "                      <img src=\"https://images.cnblogs.com/cnblogs_com/gqzdev/1564989/t_alipay.jpg\"\n" +
                "                           style=\"width:82px;height:28px\"  alt=\"支付宝\" />\n" +
                "                </span>\n" +
                "                    </div>\n" +
                "                    <div class=\"pay_item\" data-id=\"weipay\">\n" +
                "                        <span class=\"radiobox\"></span>\n" +
                "                        <span class=\"pay_logo\">\n" +
                "                      <img src=\"https://images.cnblogs.com/cnblogs_com/gqzdev/1564989/t_wechat.jpg\"\n" +
                "                           style=\"width:115px;height:28px\" alt=\"微信\" />\n" +
                "                </span>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"shang_info\">\n" +
                "                    <p>打开<span id=\"shang_pay_txt\" style=\"font-weight:bold; margin: 6px;\">支付宝</span>扫一扫，即可进行扫码打赏哦!!</p>\n" +
                "                    <p>Powered by\n" +
                "                        <a href=\"http://ganquanzhong.top\" target=\"_blank\" title=\"ForFuture Design\">Design  ForFuture Group</a>\n" +
                "                        &nbsp;&nbsp; <a >gqzdev™</a>\n" +
                "                    </p>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <!--打赏 end-->\n" +
                "\n" +
                "\n" +
                "    <!--  打赏  start-->    \n" +
                "    <script src=\"https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js\"></script>\n" +
                "    <script>\n" +
                "        $(function() {\n" +
                "            $(\".pay_item\").click(function() {\n" +
                "                $(this).addClass('checked').siblings('.pay_item').removeClass('checked');\n" +
                "                var dataid = $(this).attr('data-id');\n" +
                "                $(\".shang_payimg img\").attr(\"src\", \"https://images.cnblogs.com/cnblogs_com/gqzdev/1564989/t_\" + dataid + \".png\");\n" +
                "                $(\"#shang_pay_txt\").text(dataid == \"alipay\" ? \"支付宝\" : \"微信\");\n" +
                "            });\n" +
                "        });\n" +
                "        function dashangToggle() {\n" +
                "            $(\".hide_box\").fadeToggle();\n" +
                "            $(\".shang_box\").fadeToggle();\n" +
                "        }\n" +
                "    </script>\n" +
                "    <!--  打赏  start-->  \n" +
                " </body>\n" +
                "</html>",true);
        helper.setTo("2027776292@qq.com");
        helper.setFrom("ganquanzhong@qq.com");

        //上传文件
        helper.addAttachment("gqz.jpg",new File("E:\\00_GQZ\\my-gqzdev\\登记照.jpg"));


        mailSender.send(mimeMessage);
        System.out.println("右键成功发送给对方！");
    }

}

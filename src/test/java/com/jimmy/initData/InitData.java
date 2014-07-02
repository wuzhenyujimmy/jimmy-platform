package com.jimmy.initData;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jimmy.module.po.DevLog;
import com.jimmy.service.DevLogService;
import com.jimmy.service.TagService;
import com.jimmy.web.taglib.TreeTag;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "../../../spring/applicationContext.xml")
public class InitData {

    @Autowired
    DevLogService devLogService;

    @Autowired
    TagService tagService;

    @Autowired
    TreeTag treeTag;

    @Test
    public void init() {
        for (int i = 0; i < 333; i++) {
            String title = "Hello to make it cool " + i;
            String htmlContent = "<p><b><font face='Arial Black' size='6' color='#ff3333'>1. Where this festival com from?</font></b><br></p><p><ul><li><font face='Arial Black' size='4' color='#333333'>It is come from china</font></li><li><font face='Arial Black' size='4' color='#333333'>This morning I dream you, do you believe it?</font></li><li><font face='Arial Black' size='4' color='#333333'>How this day comes to be a bad day, I think tomorow may be a good day.</font></li></ul><div><font color='#333333' face='Arial Black' size='4'><br></font></div><div><font face='Arial Black' size='6' color='#ff3366'>2. What the structure of html file.<span id='sceditor-end-marker' class='sceditor-selection sceditor-ignore' style='line-height: 0; display: none;'> </span><span id='sceditor-start-marker' class='sceditor-selection sceditor-ignore' style='line-height: 0; display: none;'> </span></font></div><div><font face='Arial Black' size='6' color='#ff3366'>&nbsp; &nbsp;</font><font face='Arial Black' color='#ff3366' size='4'> </font><font size='4' color='#3333ff' face='Courier New'>&lt;html&gt;</font></div><div><font size='4' color='#3333ff' face='Courier New'>&nbsp; &nbsp; &nbsp; &nbsp; &lt;head&gt;</font></div><div><font size='4' color='#3333ff' face='Courier New'>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &lt;title&gt;Jimmy is a good boy!&lt;/title&gt;</font></div><div><font size='4' color='#3333ff' face='Courier New'>&nbsp; &nbsp; &nbsp; &nbsp; &lt;/head&gt;</font></div><div><font size='4' color='#3333ff' face='Courier New'><br></font></div><div><font size='4' color='#3333ff' face='Courier New'>&nbsp; &nbsp; &nbsp; &nbsp; &lt;body&gt;</font></div><div><font size='4' color='#3333ff' face='Courier New'>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;Hello jimmy</font></div><div><font size='4' color='#3333ff' face='Courier New'>&nbsp; &nbsp; &nbsp; &nbsp; &lt;/body&gt;</font></div><div><font size='4' color='#3333ff' face='Courier New'><br></font></div><div><font size='4' color='#3333ff' face='Courier New'>&nbsp; &nbsp; &lt;html&gt;</font></div></p>";
            DevLog devLog = new DevLog(title, htmlContent);
            devLogService.add(devLog);

            System.out.println(i + "  ====================");
        }
    }

    @Test
    public void teetTag() {
        System.out.println(treeTag.getHtmlContent());
    }
}

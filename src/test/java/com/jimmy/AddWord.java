package com.jimmy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import com.jimmy.module.po.Word;
import com.jimmy.service.WordService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "../../spring/applicationContext.xml")
public class AddWord {

    @Autowired
    WordService wordService;

    @Test
    public void add() {

        File file = new File("c:/temp.txt");

        try {
            InputStream in = new FileInputStream(file);
            Reader reader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String context;

            while (!(StringUtils.isEmpty(context = bufferedReader.readLine()))) {

                String[] strs = context.trim().split("#");

                String example = "";
                if (strs.length == 3) {
                    example = strs[2];
                }

                Word entity = new Word(strs[0], strs[1], example);
                wordService.add(entity);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

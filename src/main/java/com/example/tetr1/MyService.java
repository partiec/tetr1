package com.example.tetr1;

import com.example.tetr1.templates.Template;
import com.example.tetr1.templates.Template_T;
import com.example.tetr1.templates.Template_UpDown;

import java.util.Random;

public class MyService {

    public static Template chooseTemplate() {
        Random random = new Random();
        int r = random.nextInt(Const.TEMPLATES_COUNT);
        if (r == 0) {
            return new Template_T();
        } else return new Template_UpDown();
    }
}

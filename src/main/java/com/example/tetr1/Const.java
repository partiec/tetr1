package com.example.tetr1;

import com.example.tetr1.templates.Template;
import com.example.tetr1.templates.Template_T;
import com.example.tetr1.templates.Template_UpDown;

public class Const {
    static int PXL = 30;
    static int WIDTH_RECT = 15;
    static int HEIGHT_RECT = 25;
    static int WIDTH_PXL = PXL * WIDTH_RECT;
    static int HEIGHT_PXL = PXL * HEIGHT_RECT;
    static int BOTTOM = HEIGHT_PXL - PXL;
    static int TEMPLATES_COUNT = 2;

    //templates:----------------
    static Template template_T = new Template_T();
    static Template template_UpDown = new Template_UpDown();
    //-------------------------/

}

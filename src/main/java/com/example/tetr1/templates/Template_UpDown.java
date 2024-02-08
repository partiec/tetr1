package com.example.tetr1.templates;

public class Template_UpDown implements Template {


    public int wide1() {
        return matrix_1()[0].length;
    }

    @Override
    public int wide2() {
        return matrix_2()[0].length;
    }

    @Override
    public int wide3() {
        return matrix_3()[0].length;
    }

    @Override
    public int wide4() {
        return matrix_4()[0].length;
    }

    public int[][] matrix_1() {
        int[][] res = {
                {1, 0},
                {1, 1},
                {0, 1,}
        };
        return res;
    }

    public int[][] matrix_2() {
        int[][] res = {
                {0, 1, 1},
                {1, 1, 0}
        };
        return res;
    }

    public int[][] matrix_3() {
        return matrix_1();
    }

    public int[][] matrix_4() {
        return matrix_2();
    }

}

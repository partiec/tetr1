package com.example.tetr1.templates;

public class Template_T implements Template {


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
        int[][] result = {
                {0, 0, 0},
                {1, 1, 1},
                {0, 1, 0}
        };
        return result;
    }

    public int[][] matrix_2() {
        int[][] result = {
                {0, 1},
                {1, 1},
                {0, 1}
        };
        return result;
    }

    public int[][] matrix_3() {
        int[][] result = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 0, 0}
        };
        return result;
    }

    public int[][] matrix_4() {
        int[][] result = {
                {1, 0},
                {1, 1},
                {1, 0}
        };
        return result;
    }

}

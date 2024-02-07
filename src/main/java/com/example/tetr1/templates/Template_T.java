package com.example.tetr1.templates;

public class Template_T implements Template {

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
                {0, 1, 0},
                {1, 1, 0},
                {0, 1, 0}
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
                {0, 1, 0},
                {0, 1, 1},
                {0, 1, 0}
        };
        return result;
    }

}

package com.example.user.proglajurusan;

import java.util.ArrayList;

public class TanyaModel {
    private Integer code ;
    private String message;
    private ArrayList <DataTanyaModel> data;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<DataTanyaModel> getData() {
        return data;
    }
}

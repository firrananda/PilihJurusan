package com.example.user.proglajurusan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class TanyaAdapter extends ArrayAdapter {
    private ArrayList<DataTanyaModel> list;

    public TanyaAdapter(@NonNull Context context,ArrayList<DataTanyaModel> list) {
        super(context, 0);
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_tanya,parent,false);
        TextView txvTanya = view.findViewById(R.id.txvTanya);
        CheckBox chbTanya = view.findViewById(R.id.chbTanya);
        txvTanya.setText(list.get(position).getNama_gejala_fisik());
        return view;
    }
}

package com.example.user.proglajurusan;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuisFragment extends Fragment {


    public QuisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quis, container, false);

        final Button btnplaytest = (Button) view.findViewById(R.id.btnplaytest);

        btnplaytest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentbk = new Intent(getActivity(), TestActivity.class);
                getActivity().startActivity(intentbk);
            }
        });

        return view;
    }

}

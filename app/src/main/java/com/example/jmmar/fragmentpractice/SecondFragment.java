package com.example.jmmar.fragmentpractice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    private Button mButton;
    private TextView mTextView;
    private Boolean flag = false;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_second, container, false);

        mButton = (Button) v.findViewById(R.id.frag_two_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                if (!flag) {
                    fm.beginTransaction().replace(R.id.frag_container_one, new ThirdFragment()
                            , MainActivity.FRAG_THREE_TAG).commit();
                    flag = true;
                }
                else {
                    fm.beginTransaction().replace(R.id.frag_container_one, new FirstFragment()
                            , MainActivity.FRAG_ONE_TAG).commit();
                    flag = false;
                }
            }
        });

        mTextView = (TextView) v.findViewById(R.id.frag_two_label);




        return v;
    }

}

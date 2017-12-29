package com.example.jmmar.fragmentpractice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jmmar.fragmentpractice.R;

/**
 * A simple {@link Fragment} subclass.
 */

public class FirstFragment extends Fragment {
    private Button mButton;
    private TextView mTextView;
    public static final String TITLE = "frag1";

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance(String title){
        FirstFragment frag = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(TITLE,title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first, container, false);

        mButton = (Button) v.findViewById(R.id.frag_one_button);
        mTextView = (TextView) v.findViewById(R.id.frag_one_label);

        Bundle args = getArguments();

        if (args != null)
            mTextView.setText(args.getString(TITLE));

        return v;
    }

}

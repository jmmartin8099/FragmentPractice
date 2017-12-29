package com.example.jmmar.fragmentpractice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowAllFragment extends Fragment {


    public ShowAllFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_show_all, container, false);

        FragmentManager mFragmentManager = getActivity().getSupportFragmentManager();

        mFragmentManager.beginTransaction().add(R.id.frag_container_one,
                new FirstFragment().newInstance("Coming from show all fragment"),
                MainActivity.FRAG_ONE_TAG).commit();
        mFragmentManager.beginTransaction().add(R.id.frag_container_two,
                new SecondFragment(),MainActivity.FRAG_TWO_TAG).commit();

        return v;
    }

}

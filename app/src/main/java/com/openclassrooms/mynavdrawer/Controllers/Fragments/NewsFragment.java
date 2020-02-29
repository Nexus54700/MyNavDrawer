package com.openclassrooms.mynavdrawer.Controllers.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.mynavdrawer.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    public static NewsFragment newInstance() {
        return (new NewsFragment());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }
}

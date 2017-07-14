package com.efisys.quienmepresta.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.efisys.quienmepresta.R;
import com.efisys.quienmepresta.adapter.HalfRightSwipeAdapter;
import com.efisys.quienmepresta.data.Album;

public class HalfRightSwipeFragment extends Fragment {

    public static final String TAG = "HalfRightSwipeFragment";

    public static Fragment newInstance() {
        return new HalfRightSwipeFragment();
    }

    private HalfRightSwipeAdapter mAdapter;
    protected Activity activity;
    private Spinner motivoPrestamo;
    private Spinner pagos;
    private Spinner tiempoPagos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_swipe, container, false);
        return view;

    }
}
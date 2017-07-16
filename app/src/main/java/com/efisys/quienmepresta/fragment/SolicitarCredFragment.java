package com.efisys.quienmepresta.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.efisys.quienmepresta.R;


public class SolicitarCredFragment extends Fragment {
    public static final String TAG = "SolicitarCredFragment";
    public static Fragment newInstance() {
        return new SolicitarCredFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.solicitar_cred_fragment, container, false);
    }
}

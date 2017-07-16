package com.efisys.quienmepresta.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.efisys.quienmepresta.R;


public class MiPerfilFragment extends Fragment {
    public static final String TAG = "MiPerfilFragment";
    public static Fragment newInstance() {
        return new MiPerfilFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.mi_perfil_fragment, container, false);
    }
}

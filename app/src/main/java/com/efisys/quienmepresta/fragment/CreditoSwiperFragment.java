package com.efisys.quienmepresta.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.efisys.quienmepresta.R;
import com.efisys.quienmepresta.adapter.HalfRightSwipeCreditoAdapter;
import com.efisys.quienmepresta.data.ListCredito;


public class CreditoSwiperFragment extends Fragment implements HalfRightSwipeCreditoAdapter.OnItemDismissListener, HalfRightSwipeCreditoAdapter.OnItemSelectListener {

    public static final String TAG = "CreditoSwiperFragment";

    public static Fragment newInstance() {
        return new CreditoSwiperFragment();
    }

    private HalfRightSwipeCreditoAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.credito_swipe_activity, container, false);
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.swipe_list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new HalfRightSwipeCreditoAdapter(ListCredito.getListCreditos());
        mAdapter.setOnItemDismissListener(this);
        mAdapter.setOnItemItemSelectListener(this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemDismissed(ListCredito listCredito) {
    }

    @Override
    public void onItemSelected(ListCredito listCredito) {

    }
}
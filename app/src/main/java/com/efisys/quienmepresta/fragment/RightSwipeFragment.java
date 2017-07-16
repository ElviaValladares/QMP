package com.efisys.quienmepresta.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.efisys.quienmepresta.R;
import com.efisys.quienmepresta.adapter.RightSwipeAdapter;
import com.efisys.quienmepresta.data.Album;


public class RightSwipeFragment extends Fragment implements RightSwipeAdapter.OnItemDismissListener, RightSwipeAdapter.OnItemSelectListener {

    public static final String TAG = "RightSwipeFragment";
    private String hola;

    public static Fragment newInstance(String hola) {
        return new RightSwipeFragment();
    }

    private RightSwipeAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_swipe, container, false);
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.creditoSwipeActivity);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new RightSwipeAdapter(Album.getAlbum());
        mAdapter.setOnItemDismissListener(this);
        mAdapter.setOnItemItemSelectListener(this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemDismissed(Album album) {
        mAdapter.deleteItem(album);
        Toast.makeText(getContext(), "item deleted at album : " + album.getName(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemSelected(Album album) {
        Toast.makeText(getContext(), "item selected at position with title: " + album.getName(), Toast.LENGTH_LONG).show();
    }
}

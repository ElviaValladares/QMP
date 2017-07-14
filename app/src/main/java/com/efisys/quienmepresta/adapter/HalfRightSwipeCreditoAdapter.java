package com.efisys.quienmepresta.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.efisys.quienmepresta.R;
import com.efisys.quienmepresta.data.ListCredito;
import com.efisys.quienmepresta.swipe.CreditoCoordinatorLayout;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class HalfRightSwipeCreditoAdapter  extends RecyclerView.Adapter<HalfRightSwipeCreditoAdapter.ViewHolder> {
    public interface OnItemDismissListener {
        void onItemDismissed(ListCredito listCredito);
    }

    public interface OnItemSelectListener {
        void onItemSelected(ListCredito listCredito);
    }

    private List<ListCredito> mLisCreditos;
    private OnItemDismissListener mOnItemDismissListener;
    private OnItemSelectListener mOnItemSelectListener;

    public HalfRightSwipeCreditoAdapter(List<ListCredito> creditos) {
        this.mLisCreditos = creditos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.credito_swipe_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //Context context = holder.itemView.getContext();
        ListCredito listCredito = getItem(position);
        holder.banco.setImageResource(listCredito.getImagen());
        holder.nombBanco.setText(listCredito.getNombreBanco());
        holder.cat.setText(listCredito.getCat());
        holder.aval.setText(listCredito.getAvalesGarantias());
        holder.depositos.setText(listCredito.getDeposito());
        holder.oficina.setText(listCredito.getOficinaCiudad());
        holder.foreground.setOnClickListener(new OnItemSelectedClick(listCredito));
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
        holder.coordinatorLayout.sync();
    }

    @Override
    public int getItemCount() {
        return mLisCreditos.size();
    }


    private ListCredito getItem(int position) {
        return mLisCreditos.get(position);
    }

    public void setOnItemDismissListener(OnItemDismissListener listener) {
        mOnItemDismissListener = listener;
    }

    public void setOnItemItemSelectListener(OnItemSelectListener listener) {
        mOnItemSelectListener = listener;
    }

    public class OnItemDismiss implements View.OnClickListener {

        private ListCredito listCredito;

        public OnItemDismiss(ListCredito listCredito) {
            this.listCredito = listCredito;
        }

        @Override
        public void onClick(View v) {
            if (mOnItemDismissListener != null) {
                mOnItemDismissListener.onItemDismissed(listCredito);
            }
        }
    }

    private class OnItemSelectedClick implements View.OnClickListener{

        private ListCredito listCredito;

        public OnItemSelectedClick(ListCredito listCredito) {
            this.listCredito = listCredito;
        }

        @Override
        public void onClick(View v) {
            if (mOnItemSelectListener != null) {
                mOnItemSelectListener.onItemSelected(listCredito);
            }
        }
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // Campos respectivos de un item
        @Bind(R.id.img_banco)
        public ImageView banco;
        @Bind(R.id.nombreBanco)
        public TextView nombBanco;
        @Bind(R.id.cat)
        public TextView cat;
        @Bind(R.id.avales)
        public TextView aval;
        @Bind(R.id.deposito)
        public TextView depositos;
        @Bind(R.id.oficinas)
        public TextView oficina;
        public CreditoCoordinatorLayout coordinatorLayout;
        @Bind(R.id.foregroundView)
        public View foreground;


        public ViewHolder(View view) {
            super(view);
            coordinatorLayout = (CreditoCoordinatorLayout) view;
            ButterKnife.bind(this, view);
        }
    }


}

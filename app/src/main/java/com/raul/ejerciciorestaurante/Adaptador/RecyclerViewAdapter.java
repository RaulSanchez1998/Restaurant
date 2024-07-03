package com.raul.ejerciciorestaurante.Adaptador;

import androidx.annotation.NonNull;


import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.raul.ejerciciorestaurante.Entidad.restauranteModelo;
import com.raul.ejerciciorestaurante.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView titulo, direccion, telefono, comentario;
        ImageView foto;

        public ViewHolder(View itemView) {
            super(itemView);
            foto = (ImageView)itemView.findViewById(R.id.imgRestaurante);
            titulo = (TextView) itemView.findViewById(R.id.tvTitulo);
            direccion = (TextView) itemView.findViewById(R.id.tvDireccion);
            telefono = (TextView) itemView.findViewById(R.id.tvTelefono);
            comentario = (TextView) itemView.findViewById(R.id.tvComentario);
        }
    }

    public List<restauranteModelo> restaurenteLista;

    public RecyclerViewAdapter(List<restauranteModelo> restaurenteLista) {
        this.restaurenteLista = restaurenteLista;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurante, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titulo.setText(restaurenteLista.get(position).getTitulo());
        holder.direccion.setText(restaurenteLista.get(position).getDireccion());
        holder.telefono.setText(restaurenteLista.get(position).getTelefono());
        holder.comentario.setText(restaurenteLista.get(position).getComentario());
        holder.foto.setImageResource(restaurenteLista.get(position).getFoto());
    }


    @Override
    public int getItemCount() {
        return restaurenteLista.size();
    }
}


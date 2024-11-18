package com.example.magic.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.magic.R;
import com.example.magic.beans.Carta;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CartaAdapter extends RecyclerView.Adapter<CartaAdapter.CartaViewHolder> {

    private List<Carta> cartas;
    private Context context;

    public CartaAdapter(Context context, List<Carta> cartas) {
        this.context = context;
        this.cartas = cartas;
    }

    @NonNull
    @Override
    public CartaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carta, parent, false);
        return new CartaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartaViewHolder holder, int position) {
        Carta carta = cartas.get(position);
        holder.bind(carta);
    }

    @Override
    public int getItemCount() {
        return cartas.size();
    }

    public void actualizarCartas(List<Carta> nuevasCartas) {
        this.cartas = nuevasCartas;
        notifyDataSetChanged();
    }

    class CartaViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCarta;
        TextView tvNombreCarta;
        TextView tvPrecioCarta;

        CartaViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCarta = itemView.findViewById(R.id.ivCarta);
            tvNombreCarta = itemView.findViewById(R.id.tvNombreCarta);
            tvPrecioCarta = itemView.findViewById(R.id.tvPrecioCarta);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Carta carta = cartas.get(position);
                    Intent intent = new Intent(context, DetalleProductoActivity.class);
                    intent.putExtra("CARTA_ID", carta.getIdCarta());
                    context.startActivity(intent);
                }
            });
        }

        void bind(Carta carta) {
            tvNombreCarta.setText(carta.getNombre());
            NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));
            tvPrecioCarta.setText(formatoMoneda.format(carta.getPrecio()));

            // Aquí deberías cargar la imagen de la carta usando una librería como Glide o Picasso
            // Por ejemplo, con Glide:
            // Glide.with(itemView).load(carta.getUrlImagen()).into(ivCarta);
        }
    }
}
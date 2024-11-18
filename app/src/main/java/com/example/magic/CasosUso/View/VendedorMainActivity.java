package com.example.magic.CasosUso.View;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.magic.Controllers.CartaController;
import com.example.magic.R;
import com.example.magic.adapters.CartaAdapter;
import com.example.magic.beans.Carta;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

public class VendedorMainActivity extends AppCompatActivity {
    private RecyclerView rvMisProductos;
    private FloatingActionButton fabAgregarProducto;
    private CartaController cartaController;
    private CartaAdapter cartaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendedor_main);

        // Inicializar controladores
        cartaController = new CartaController();

        // Inicializar vistas
        rvMisProductos = findViewById(R.id.rvMisProductos);
        fabAgregarProducto = findViewById(R.id.fabAgregarProducto);

        // Configurar RecyclerView
        rvMisProductos.setLayoutManager(new LinearLayoutManager(this));
        List<Carta> misCartas = cartaController.obtenerTodasCartas(); // Aquí deberías filtrar por el vendedor actual
        cartaAdapter = new CartaAdapter(this, misCartas);
        rvMisProductos.setAdapter(cartaAdapter);

        // Configurar listeners
        fabAgregarProducto.setOnClickListener(v -> mostrarDialogoNuevoProducto());
    }

    private void mostrarDialogoNuevoProducto() {
         cartaAdapter.actualizarCartas(cartaController.obtenerTodasCartas());
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Actualizar la lista de productos cada vez que se vuelve a la actividad
        cartaAdapter.actualizarCartas(cartaController.obtenerTodasCartas());
    }
}
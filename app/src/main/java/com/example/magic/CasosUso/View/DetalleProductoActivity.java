package com.example.magic.CasosUso.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.magic.Controllers.CalificacionController;
import com.example.magic.Controllers.CartaController;
import com.example.magic.R;
import com.example.magic.beans.Calificacion;
import com.example.magic.beans.Carta;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class DetalleProductoActivity extends AppCompatActivity {

    private ImageView ivProducto;
    private TextView tvNombreProducto;
    private TextView tvDescripcion;
    private TextView tvPrecio;
    private RatingBar ratingBar;
    private Button btnCalificar;
    private Button btnAgregarAlCarrito;

    private CartaController cartaController;
    private CalificacionController calificacionController;
    private Carta carta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);

        // Inicializar vistas
        ivProducto = findViewById(R.id.ivProducto);
        tvNombreProducto = findViewById(R.id.tvNombreProducto);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        tvPrecio = findViewById(R.id.tvPrecio);
        ratingBar = findViewById(R.id.ratingBar);
        btnCalificar = findViewById(R.id.btnCalificar);
        btnAgregarAlCarrito = findViewById(R.id.btnAgregarAlCarrito);

        // Inicializar controladores
        cartaController = new CartaController();
        calificacionController = new CalificacionController();

        // Obtener el ID de la carta de los extras
        int cartaId = getIntent().getIntExtra("CARTA_ID", -1);
        if (cartaId == -1) {
            Toast.makeText(this, "Error al cargar el producto", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Cargar los datos de la carta
        carta = cartaController.obtenerCarta(cartaId);
        if (carta == null) {
            Toast.makeText(this, "Producto no encontrado", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Mostrar los datos de la carta
        mostrarDatosCarta();

        // Configurar listeners
        btnCalificar.setOnClickListener(v -> calificarCarta());
        btnAgregarAlCarrito.setOnClickListener(v -> agregarAlCarrito());
    }

    private void mostrarDatosCarta() {
        tvNombreProducto.setText(carta.getNombre());
        tvDescripcion.setText(carta.getDescripcion());
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));
        tvPrecio.setText(formatoMoneda.format(carta.getPrecio()));

        // Aquí deberías cargar la imagen de la carta usando una librería como Glide o Picasso
        // Por ejemplo, con Glide:
        // Glide.with(this).load(carta.getUrlImagen()).into(ivProducto);

        // Calcular y mostrar la calificación promedio
        float calificacionPromedio = calificacionController.obtenerCalificacionPromedio(carta.getIdCarta());
        ratingBar.setRating(calificacionPromedio);
    }

    private void calificarCarta() {
        // Aquí deberías obtener el usuario actual del sistema de autenticación
        int usuarioId = 1; // Por ahora, usamos un ID fijo

        Calificacion nuevaCalificacion = new Calificacion(
                0, // El ID se generará automáticamente
                usuarioId,
                carta.getIdCarta(),
                Math.round(ratingBar.getRating()),
                "", // No estamos manejando comentarios por ahora
                new Date()
        );

        calificacionController.agregarCalificacion(nuevaCalificacion);
        Toast.makeText(this, "Calificación guardada", Toast.LENGTH_SHORT).show();
    }

    private void agregarAlCarrito() {
        // Aquí implementarías la lógica para agregar al carrito
        Toast.makeText(this, "Producto agregado al carrito", Toast.LENGTH_SHORT).show();
    }
}
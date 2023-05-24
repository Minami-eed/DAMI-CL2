package com.example.ciudadseguraapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class DenunciaActivity : AppCompatActivity() {

    private lateinit var denunciaViewModel: DenunciaViewModel
    lateinit var list: List<Denuncia>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_denuncias)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(false)
        title = "Seguridad Ciudadana"

        denunciaViewModel = run {
            ViewModelProvider(this)[DenunciaViewModel::class.java]
        }

        val recyclerDenuncias = findViewById<RecyclerView>(R.id.recyclerDenuncias)

        val adapter = DenunciaAdapter()
        recyclerDenuncias.adapter = adapter
        recyclerDenuncias.layoutManager = LinearLayoutManager(this)

        denunciaViewModel.denuncias?.observe(this){ denuncias ->
            if (denuncias.isNotEmpty()) {
                recyclerDenuncias.visibility = View.VISIBLE

                list = denuncias

                denuncias?.let {
                    adapter.setDenuncias(it)
                }

            } else {
                recyclerDenuncias.visibility = View.GONE
            }
        }

        val floatingMenu = findViewById<FloatingActionButton>(R.id.floatingMenu)

        floatingMenu.setOnClickListener {
            registrarDenuncia()
        }
    }

    fun registrarDenuncia() {
        val mDialogDenuncia = LayoutInflater.from(this).inflate(R.layout.activity_registrar_denuncia, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogDenuncia)
        val mAlertDialog = mBuilder.show()

        val buttonCreate  = mAlertDialog.findViewById<Button>(R.id.btnGuardarDenuncia)
        val txtLugar = mDialogDenuncia.findViewById<EditText>(R.id.denunciaLugar)
        val txtTitulo = mDialogDenuncia.findViewById<EditText>(R.id.denunciaTitulo)
        val txtComentario = mDialogDenuncia.findViewById<EditText>(R.id.denunciaComentario)

        buttonCreate?.setOnClickListener {
            mAlertDialog.dismiss()

            val lugarDenuncia = txtLugar.text.toString()
            val tituloDenuncia = txtTitulo.text.toString()
            val comentarioDenuncia = txtComentario.text.toString()

            val currentDateTime = LocalDateTime.now().formatChangeNote()
            var newDenuncia = Denuncia(lugarDenuncia, tituloDenuncia, currentDateTime, comentarioDenuncia)
            denunciaViewModel.saveDenunciaWithCoroutines(newDenuncia)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun LocalDateTime.formatChangeNote() : String
            = this.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))

}
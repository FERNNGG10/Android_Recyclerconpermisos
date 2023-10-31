package com.example.android_recyclerconpermisos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.android_recyclerconpermisos.adapters.Adaptador;
import com.example.android_recyclerconpermisos.models.Permiso;
import android.Manifest;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Permiso>Lista_permisos= new ArrayList<>();
        Lista_permisos.add(new Permiso(Manifest.permission.CALL_PHONE,"Permiso para llamada"));
        Lista_permisos.add(new Permiso(Manifest.permission.CAMERA,"Permiso para camara"));
        Lista_permisos.add(new Permiso(Manifest.permission.RECORD_AUDIO,"Permiso para microfono"));

        Adaptador adaptador = new Adaptador(Lista_permisos);
        RecyclerView recyclerView= findViewById(R.id.rePermisos);
        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }
}
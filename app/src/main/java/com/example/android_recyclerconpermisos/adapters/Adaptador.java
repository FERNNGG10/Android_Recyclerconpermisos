package com.example.android_recyclerconpermisos.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_recyclerconpermisos.R;
import com.example.android_recyclerconpermisos.models.Permiso;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.viewHolder> {
    List <Permiso> Lista_permisos;
    public Adaptador(List<Permiso>Lista_permiso){Lista_permisos=Lista_permiso;}
    @NonNull
    @Override



    public Adaptador.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater ly =LayoutInflater.from(parent.getContext());
        View v=ly.inflate(R.layout.item_permisos,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.viewHolder holder, int position) {
        Permiso p =Lista_permisos.get(position);
        holder.setdata(p);

    }

    @Override
    public int getItemCount() {
        return Lista_permisos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        Permiso permiso;
        TextView txtpermiso,txtdescripcion;
        Switch aSwitch;
        Context context;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            txtdescripcion=itemView.findViewById(R.id.txtdescripcion);
            aSwitch=itemView.findViewById(R.id.switch1);
            context=itemView.getContext();

        }

        public void setdata(Permiso p)
        {
            permiso=p;
            txtdescripcion.setText(p.getDescripcion());
            aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                    if (b) {
                       //ALVESTIA SI SALIO XDDDDD
                        if (ContextCompat.checkSelfPermission(context, permiso.getPermiso()) != PackageManager.PERMISSION_GRANTED) {

                            ActivityCompat.requestPermissions((Activity) context, new String[]{permiso.getPermiso()}, 6999);
                        }
                    }

                }
            });
        }
    }
}

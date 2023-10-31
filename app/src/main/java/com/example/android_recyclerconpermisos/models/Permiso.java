package com.example.android_recyclerconpermisos.models;

import java.security.Permission;
import java.security.Permissions;

public class Permiso {

    private String permiso;
    private String descripcion;

    public  Permiso(String permiso, String descripcion)
    {
        this.permiso=permiso;
        this.descripcion=descripcion;
    }
    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}

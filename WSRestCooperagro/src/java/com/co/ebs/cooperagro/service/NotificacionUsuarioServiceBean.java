/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ebs.cooperagro.service;

import com.co.ebs.cooperagro.dataaccess.NotificacionUsuarioDataAccessImp;
import com.co.ebs.cooperagro.domain.NotificacionUsuario;
import com.co.ebs.cooperagro.domain.NotificacionUsuarioR;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseNotificacionUsuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan Ruge
 */
public class NotificacionUsuarioServiceBean implements NotificacionUsuarioService{

    //Atributos
    private final NotificacionUsuarioDataAccessImp notifUsuDataAccess = new NotificacionUsuarioDataAccessImp();
    
    //Métodos
    
    @Override
    public Boolean saveNotificacionUsuario(NotificacionUsuario notificacionUsuario) {
        return this.notifUsuDataAccess.saveNotificacionUsuario(notificacionUsuario);
    }

    @Override
    public Boolean editNotificacionUsuario(NotificacionUsuario notificacionUsuario) {
        return notifUsuDataAccess.editNotificacionUsuario(notificacionUsuario);
    }

    @Override
    public void deleteNotificacionUsuario(NotificacionUsuario notificacionUsuario) {
        this.notifUsuDataAccess.deleteNotificacionUsuario(notificacionUsuario);
    }

    @Override
    public List<NotificacionUsuario> findAllNotificaciones() {
        return this.notifUsuDataAccess.findAllNotificaciones();
    }

    @Override
    public ResponseNotificacionUsuario listNotUsuarioFindByUser(Long codUsuario) {
      ResponseNotificacionUsuario respuestaNotificacionUsuario=new ResponseNotificacionUsuario();
      
      NotificacionUsuario notificacionParaBuscar=new NotificacionUsuario();
      Usuario usuarioParaBuscar= new Usuario(codUsuario);
      notificacionParaBuscar.setIUsuario(usuarioParaBuscar);
      List<NotificacionUsuario> listaNotificacionUsuarios = this.notifUsuDataAccess.listNotUsuarioFindByUser(notificacionParaBuscar);
      if (listaNotificacionUsuarios!=null && listaNotificacionUsuarios.size()>0) {
          List<NotificacionUsuarioR> listaNotificacionUsuario = new ArrayList<>();
          for (NotificacionUsuario notificacionUsuario : listaNotificacionUsuarios) {
              NotificacionUsuarioR notf = new NotificacionUsuarioR();
              notf.setiCodigo(notificacionUsuario.getICodigo());
              notf.setcTitulo(notificacionUsuario.getCTitulo());
              notf.setcDescripcion(notificacionUsuario.getCDescripcion());
              notf.setiDuracion(notificacionUsuario.getIDuracion());
              notf.setcEstado(notificacionUsuario.getCEstado());
              notf.setfFecha(notificacionUsuario.getFFecha());
              listaNotificacionUsuario.add(notf);
          }
          
          
          respuestaNotificacionUsuario.setiCodigo(1);
          respuestaNotificacionUsuario.setbRta(Boolean.TRUE);
          respuestaNotificacionUsuario.setsMsj("Consulta correcta");
          respuestaNotificacionUsuario.setListNotificacionUsuario(listaNotificacionUsuario);
      }
      else{
          respuestaNotificacionUsuario.setiCodigo(0);
          respuestaNotificacionUsuario.setbRta(Boolean.FALSE);
          respuestaNotificacionUsuario.setsMsj("No tiene notificaciones actualmente");
      }
      return respuestaNotificacionUsuario;
    }

    @Override
    public NotificacionUsuario findNotificacionUsuarioById(Long id) {
        return this.notifUsuDataAccess.findNotificacionUsuarioById(id);
    }

    @Override
    public int notificacionesSinLeer( Usuario usuario) {
       return this.notifUsuDataAccess.notificacionesSinLeer(usuario).size();
    }
    
    public String[] dosUltimasNotificacionesSinLeer(Usuario usuario){
        String[] nombres = new String[2];
        List<NotificacionUsuario> lista = this.notifUsuDataAccess.notificacionesSinLeer(usuario);
        if(lista!=null && lista.size()>0){
            if(lista.get(0)!=null){
                nombres[0]=lista.get(0).getCDescripcion();
            }
            if(lista.get(1)!=null){
                nombres[1]=lista.get(1).getCDescripcion();
            }
        }
        else{
            nombres=null;
        }
        return nombres;
    }
}

package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.FotoPerfil;
import com.co.ebs.cooperagro.domain.Usuario;
import com.co.ebs.cooperagro.respuestasGenericas.respuestaGenerica;
import java.util.List;

public interface FotoPerfilDataAccess 
{
    /**
     * Método de interface que busca por usuario
     * 
     * @param usuario
     * @return List<FotoPerfil>
     */
    List<FotoPerfil> buscarPorUsuario(Usuario usuario);
}
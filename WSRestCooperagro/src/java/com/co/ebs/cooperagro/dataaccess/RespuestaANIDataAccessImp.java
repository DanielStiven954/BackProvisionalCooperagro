package com.co.ebs.cooperagro.dataaccess;

import com.co.ebs.cooperagro.domain.RespuestaAniOlimpiait;
import com.co.ebs.cooperagro.general.WSRestGenericRepositoryJPA;
import com.co.ebs.cooperagro.general.connectionDBJPA;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Brayan Moreno
 */
public class RespuestaANIDataAccessImp  extends WSRestGenericRepositoryJPA<RespuestaAniOlimpiait> implements RespuestaANIDataAccess{

    private EntityManager em = null;
    
    @Override
    public RespuestaAniOlimpiait saveRespuesta(RespuestaAniOlimpiait respuestaAniOlimpiait) {
        return create(respuestaAniOlimpiait);
    }

    @Override
    public RespuestaAniOlimpiait updateRespuesta(RespuestaAniOlimpiait respuestaAniOlimpiait) {
        return update(respuestaAniOlimpiait);
    }

    @Override
    public RespuestaAniOlimpiait findRespuestaById(Long id) {
        return find(id);
    }

    @Override
    public List<RespuestaAniOlimpiait> findRespuestaAniOlimpiait(Long iTipoIdent, String sNumIdent) {
        List<RespuestaAniOlimpiait> respuestaAniOlimpiaits = new ArrayList<>();
        
        connectionDBJPA connDBJPA = new connectionDBJPA();
        
        try {
            em = connDBJPA.getEntityManager();
            String sql = "SELECT ra.* \n "
                    + " FROM consulta_ani_olimpiait ca, respuesta_ani_olimpiait ra \n"
                    + " WHERE ra.i_cons_ani_olimpiait = ca.i_codigo  \n"
                    + " AND ca.c_identificacion = ? \n"
                    + " AND ca.i_tipo_ident = ? \n"
                    + " ORDER BY ra.i_codigo DESC ";
            Query query = em.createNativeQuery(sql, RespuestaAniOlimpiait.class);
            query.setParameter(1, sNumIdent);
            query.setParameter(2, iTipoIdent);
            
            List<RespuestaAniOlimpiait> result = query.getResultList();
            if(result != null && !result.isEmpty()){
                respuestaAniOlimpiaits = result;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            connDBJPA.closeEntityManager();
            if(em!=null){
                if(em.isOpen()){
                    em.close();
                }
            }
        }
        return respuestaAniOlimpiaits;
    }
    
}

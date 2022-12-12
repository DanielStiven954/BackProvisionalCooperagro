package com.co.ebs.cooperagro.wsrestapi;

import com.co.ebs.cooperagro.request.RequestDetalle;
import com.co.ebs.cooperagro.request.RequestListObligacionesTerm;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseEstadoCuenta;
import com.co.ebs.cooperagro.respuestasGenericas.ResponseObligacionesTerminadas;
import com.co.ebs.cooperagro.service.EstadoCuentaCoreServiceBean;
import com.co.ebs.cooperagro.security.Secured;
import com.co.ebs.cooperagro.service.PazySalvoServiceBean;
import com.ebssystem.DatoDTO;
import com.ebssystem.DetalleCta;
import com.ebssystem.Movimiento;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service Estado Cuenta
 *
 * @author Brian Cardenas
 */
@Path("WSRestAPI")
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8")
public class WSEstadoCuenta {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WSEstadoCuenta
     */
    public WSEstadoCuenta() {
    }

    /**
     * Retrieves representation of an instance of
     * com.co.ebs.cooperagro.wsrestapi.WSEstadoCuenta
     *
     * @param xiCodUser
     * @param xcProducto
     * @return JSON de DatoDTO
     */
    @GET
    @Path("WSEstadoCuenta/consEstadoCuenta")
    @Secured
    public List<DatoDTO> estadoCuenta(@QueryParam("xiCodUser") int xiCodUser, @QueryParam("xcProducto") String xcProducto) {
        EstadoCuentaCoreServiceBean EstadocuentaCoreServiceBean = new EstadoCuentaCoreServiceBean();
        return EstadocuentaCoreServiceBean.wsConsultarEstadoCuenta(xiCodUser, xcProducto);
    }

    @POST
    @Path("WSEstadoCuenta/obtenerEstadoCuenta")
    @Secured
    public ResponseEstadoCuenta obtenerEstadoCuenta(@QueryParam("xiCodUser") int xiCodUser) {
        EstadoCuentaCoreServiceBean estadoCuentaCoreServiceBean = new EstadoCuentaCoreServiceBean();
        return estadoCuentaCoreServiceBean.obtenerEstaCuentaByUser(xiCodUser);
    }

//    @GET
//    @Path("WSEstadoCuenta/detalleCtaCredito")
//    @Secured
//    public DetalleCta getDetalleCtaCredito(@QueryParam("xsNumRadic") String xsNumRadic) {
//        EstadoCuentaCoreServiceBean EstadocuentaCoreServiceBean = new EstadoCuentaCoreServiceBean();
//        return EstadocuentaCoreServiceBean.wsConsultaDetalleCtaCredito(xsNumRadic);
//    }

//    @GET
//    @Path("WSEstadoCuenta/detalleCtaAporte")
//    @Secured
//    public DetalleCta getDetalleCtaAporte(@QueryParam("xsNumRadic") String xsNumRadic) {
//        EstadoCuentaCoreServiceBean EstadocuentaCoreServiceBean = new EstadoCuentaCoreServiceBean();
//        return EstadocuentaCoreServiceBean.wsConsultaDetalleCtaAporte(xsNumRadic);
//    }
    
//    @GET
//    @Path("WSEstadoCuenta/detalleCtaAporteAmp")
//    @Secured
//    public RequestDetalle getDetalleCtaAporteAmp(@QueryParam("xsNumRadic") String xsNumRadic) {
//        EstadoCuentaCoreServiceBean EstadocuentaCoreServiceBean = new EstadoCuentaCoreServiceBean();
//        return EstadocuentaCoreServiceBean.wsConsultaDetalleCtaAporteAmp(xsNumRadic);
//    }

//    @GET
//    @Path("WSEstadoCuenta/detalleCtaServicio")
//    @Secured
//    public DetalleCta getDetalleCtaServicio(@QueryParam("xsNumRadic") String xsNumRadic) {
//        EstadoCuentaCoreServiceBean EstadocuentaCoreServiceBean = new EstadoCuentaCoreServiceBean();
//        return EstadocuentaCoreServiceBean.wsConsultaDetalleCtaServicio(xsNumRadic);
//    }
    
//    @GET
//    @Path("WSEstadoCuenta/detalleCtaServicioBenef")
//    @Secured
//    public RequestDetalle getDetalleCtaServicioBenef(@QueryParam("xsNumRadic") String xsNumRadic) {
//        EstadoCuentaCoreServiceBean EstadocuentaCoreServiceBean = new EstadoCuentaCoreServiceBean();
//        return EstadocuentaCoreServiceBean.wsConsultaDetalleCtaServicioBenef(xsNumRadic);
//    }

    @GET
    @Path("WSEstadoCuenta/movimientoCredito")
    @Secured
    public Movimiento getMovimientoCredito(@QueryParam("xsNumRadic") String xsNumRadic) {
        EstadoCuentaCoreServiceBean EstadocuentaCoreServiceBean = new EstadoCuentaCoreServiceBean();
        return EstadocuentaCoreServiceBean.wsConsultaMovimientosCtaCredito(xsNumRadic);
    }

    @GET
    @Path("WSEstadoCuenta/movimientoAporte")
    @Secured
    public Movimiento getMovimientoAporte(@QueryParam("xsNumRadic") String xsNumRadic) {
        EstadoCuentaCoreServiceBean EstadocuentaCoreServiceBean = new EstadoCuentaCoreServiceBean();
        return EstadocuentaCoreServiceBean.wsConsultaMovimientosCtaAporte(xsNumRadic);
    }

    @GET
    @Path("WSEstadoCuenta/movimientoServicio")
    @Secured
    public Movimiento getMovimientoServicio(@QueryParam("xsNumRadic") String xsNumRadic) {
        EstadoCuentaCoreServiceBean EstadocuentaCoreServiceBean = new EstadoCuentaCoreServiceBean();
        return EstadocuentaCoreServiceBean.wsConsultaMovimientosCtaServicio(xsNumRadic);
    }

    @POST
    @Path("WSEstadoCuenta/detalleMovimientoCredito")
    @Secured
    public Movimiento detalleMovimientoCredito(@QueryParam("xsNumRadic") String xsNumRadic, @QueryParam("xsCodOper") String codOperation) {
        EstadoCuentaCoreServiceBean EstadocuentaCoreServiceBean = new EstadoCuentaCoreServiceBean();
        return EstadocuentaCoreServiceBean.wsConsultaDetalleMovCtaCredito(xsNumRadic, codOperation);
    }

    @POST
    @Path("WSEstadoCuenta/detalleMovimientoServicio")
    @Secured
    public Movimiento detalleMovimientoServicio(@QueryParam("xsNumRadic") String xsNumRadic, @QueryParam("xsCodOper") String codOperation) {
        EstadoCuentaCoreServiceBean EstadocuentaCoreServiceBean = new EstadoCuentaCoreServiceBean();
        return EstadocuentaCoreServiceBean.wsConsultaDetalleMovCtaCredito(xsNumRadic, codOperation);
    }

    @POST
    @Path("WSEstadoCuenta/obligacionesTerminadas")
    public ResponseObligacionesTerminadas obtenerObligacionesTerminadas(RequestListObligacionesTerm obligacionesTerm) {
        PazySalvoServiceBean pazySalvoServiceBean = new PazySalvoServiceBean();
        return pazySalvoServiceBean.obligacionesTerminadas(obligacionesTerm.getSCodigo(), obligacionesTerm.getSProducto());
    }

}

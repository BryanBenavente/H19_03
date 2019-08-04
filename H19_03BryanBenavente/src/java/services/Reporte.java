package services;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class Reporte extends dao.Conexion {

    //Reporte para la vista Equipo
    public void exportarEquip(Map parameters) throws JRException, IOException, Exception {
        try {
            File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reporte/Catalog.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.conectar());
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.addHeader("Content-disposition", "attachment; filename=Reporte_Catalogo.pdf");
            ServletOutputStream stream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
            stream.close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception e) {
            System.out.println("ERROR en exportarEquip: " + e.getMessage());
        }
    }

    //Reporte para la vista Proveedor
    public void exportarBolet(Map parameters) throws JRException, IOException, Exception {
        try {
            System.out.println(parameters);
            File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reporte/Bolta1.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.conectar());
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.addHeader("Content-disposition", "attachment; filename=Boleta_Venta.pdf");
            ServletOutputStream stream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
            stream.close();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception e) {
            System.out.println("ERROR en exportarBolet: " + e.getMessage());
        }
    }

    
}

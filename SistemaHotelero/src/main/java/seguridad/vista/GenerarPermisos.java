package seguridad.vista;

import Finanzas.vista.*;
import Comercial.vista.*;
import Hoteleria.vista.*;
import java.net.UnknownHostException;
import seguridad.dominio.Permisos;

/**
 *
 * @author Diego Vásquez
 */
public class GenerarPermisos {
 
    Permisos ejecutarPermisos = new Permisos();

    public void getPermisos(String modulo, String usuario) {
        try {
            if (modulo == "Seguridad") {

                MDI_Sistema.JMenu_Mantenimientos.setVisible(false);
                MDI_Sistema.JMenuItem_Usuarios.setVisible(false);
                MDI_Sistema.JMenuItem_Aplicaciones.setVisible(false);
                MDI_Sistema.JMenu_Asignaciones.setVisible(false);
                MDI_Sistema.JMenuItem_Perfiles.setVisible(false);
                MDI_Sistema.JMenuItem_Modulos.setVisible(false);
                MDI_Sistema.JMenuItem_AplicacionesUsuario.setVisible(false);
                MDI_Sistema.JMenuItem_Bitacora.setVisible(false);

                ejecutarPermisos.ejecutarBusqueda(usuario);

                for (int i = 0; i < ejecutarPermisos.getAplicaciones().length; i++) {
                    int varApp = Integer.parseInt(ejecutarPermisos.getAplicaciones()[i]);
                    if (varApp >= 10 && varApp <= 99) {
                        MDI_Sistema.JMenu_Mantenimientos.setVisible(true);
                        switch (varApp) {
                            case 10:
                                MDI_Sistema.JMenuItem_Usuarios.setVisible(true);
                                break;
                            case 20:
                                break;
                        }
                    }
                    if (varApp >= 100 && varApp <= 199) {
                        MDI_Sistema.JMenu_Asignaciones.setVisible(true);
                        switch (varApp) {
                            case 100:
                                break;
                            case 200:
                                break;
                        }
                    }

                }
            }
            if (modulo == "Financiero") {

            }
            if (modulo == "Hotelero") {
                
                MDIHoteleria.mnt_amadellaves.setVisible(false);
                MDIHoteleria.mnt_habitaciones.setVisible(false);
                MDIHoteleria.mnt_servicios.setVisible(false);
                MDIHoteleria.mnt_huespedes.setVisible(false);
                MDIHoteleria.mnt_formasdepago.setVisible(false);
                MDIHoteleria.mnt_pisos.setVisible(false);
                
                ejecutarPermisos.ejecutarBusqueda(usuario);
                
                for (int i = 0; i < ejecutarPermisos.getAplicaciones().length; i++) {
                    int varApp = Integer.parseInt(ejecutarPermisos.getAplicaciones()[i]);
                    if (varApp >= 2001 && varApp <= 2201) {
                        MDIHoteleria.submenu_mantenimientos.setVisible(true);
                        MDIHoteleria.submenu_procesos.setVisible(false);
                        switch (varApp) {
                            case 2001:
                                MDIHoteleria.mnt_amadellaves.setVisible(true);
                                MDIHoteleria.mnt_habitaciones.setVisible(true);
                                break;
                            case 2101:
                                MDIHoteleria.mnt_servicios.setVisible(true);
                                MDIHoteleria.mnt_huespedes.setVisible(true);
                                break;
                        }
                    }
                    if (varApp >= 2202 && varApp <= 2400) {
                        MDIHoteleria.submenu_procesos.setVisible(true);
                        MDIHoteleria.submenu_mantenimientos.setVisible(true);
                        switch (varApp) {
                            case 2202:
                                MDIHoteleria.mnt_formasdepago.setVisible(false);
                                break;
                            case 2400:
                                MDIHoteleria.mnt_pisos.setVisible(false);
                                break;
                        }
                    }
                }
            }
            if (modulo == "Comercial") {

            }
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
    }

    public String[] getAccionesAplicacion(int codigoAplicacion, String usuario) {
        ejecutarPermisos.ejecutarBusqueda(usuario);
        String[] matrixPermisos = new String[5];
        for (int i = 0; i < 5; i++) {
            matrixPermisos[i] = ejecutarPermisos.getPermisosApps(codigoAplicacion)[i];
        }
        return matrixPermisos;
    }
}

package co.edu.uco.terraxs.init;
/*
import java.util.List;
import java.util.UUID;

import co.edu.uco.terraxs.businesslogic.facade.ProveedorFacade;
import co.edu.uco.terraxs.businesslogic.facade.impl.ProveedorFacadeImpl;
import co.edu.uco.terraxs.crosscutting.excepciones.TerraxsException;
import co.edu.uco.terraxs.crosscutting.utilitarios.UtilUUID;
import co.edu.uco.terraxs.dto.CiudadDTO;
import co.edu.uco.terraxs.dto.ProveedorDTO;
import co.edu.uco.terraxs.dto.TipoDocumentoDTO;

public class Main {
	
    public static void main(String[] args) {
        try {
            ProveedorFacade proveedorFacade = new ProveedorFacadeImpl();

            // Asumimos que estos UUIDs existen en la base de datos
            UUID tipoDocumentoId = UtilUUID.convertirAUUID("223e3567-e89b-12d3-a456-426614174001"); // Reemplaza por uno real
            UUID ciudadId = UtilUUID.convertirAUUID("223e4567-e89b-17d3-a456-426614174001");         // Reemplaza por uno real

            TipoDocumentoDTO tipoDocumento = new TipoDocumentoDTO();
            tipoDocumento.setId(tipoDocumentoId);
            tipoDocumento.setNombre("Cédula de Ciudadanía");

            CiudadDTO ciudad = new CiudadDTO();
            ciudad.setId(ciudadId);
            ciudad.setNombre("Medellín");

            // Crear nuevo proveedor
            ProveedorDTO nuevoProveedor = new ProveedorDTO();
            nuevoProveedor.setId(UUID.randomUUID());
            nuevoProveedor.setTipoDocumento(tipoDocumento);
            nuevoProveedor.setNumeroIdentificacion("1036789547");
            nuevoProveedor.setNombres("Camila");
            nuevoProveedor.setApellidos("Vásquez");
            nuevoProveedor.setCorreo("camila7@gmail.com");
            nuevoProveedor.setTelefono("3226374766");
            nuevoProveedor.setCorreoConfirmado(false);
            nuevoProveedor.setTelefonoConfirmado(false);
            nuevoProveedor.setDireccionResidencia("Carrera 9 Numero 10-60");
            nuevoProveedor.setCiudad(ciudad);
            nuevoProveedor.setPassword("1040180407Cc*");
            
           proveedorFacade.registrarProveedor(nuevoProveedor);
            System.out.println("✅ Proveedor registrado: " + nuevoProveedor);

           // Consultar por ID (usar el ID real que acabas de registrar si lo guardaste)
            ProveedorDTO proveedorConsultado = proveedorFacade.consultarProveedorPorId(UtilUUID.convertirAUUID("cbe94d76-c937-49d8-a858-20d3bce46819"));
            System.out.println("🔍 Consultado por ID: " + proveedorConsultado);

             // Modificar el proveedor
            ProveedorDTO proveedorModificado = nuevoProveedor;
            proveedorModificado.setNombres("Juan  Modificado");

            proveedorFacade.modificarDatosProveedor(UtilUUID.convertirAUUID("cbe94d76-c937-49d8-a858-20d3bce46819"), proveedorModificado);
            System.out.println("✏️ Proveedor modificado correctamente.");

            // Consultar con filtro
            ProveedorDTO filtro = new ProveedorDTO();
            filtro.setNombres("Juan");

            List<ProveedorDTO> proveedoresFiltrados = proveedorFacade.consultarProveedores(filtro);
            System.out.println("📋 Proveedores encontrados con filtro:");
            for (ProveedorDTO proveedor : proveedoresFiltrados) {
                System.out.println(proveedor);
            }

            // Eliminar proveedor
            proveedorFacade.eliminarProveedor(UtilUUID.convertirAUUID("57c6c23b-f2cc-4233-adb7-14c9f4f6c6cc"));
            System.out.println("🗑️ Proveedor eliminado definitivamente.");

        } catch (TerraxsException e) {
            System.err.println("❌ Error controlado: " + e.getMensajeUsuario());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("💥 Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}*/

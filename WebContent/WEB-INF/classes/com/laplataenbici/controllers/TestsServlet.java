package com.laplataenbici.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.Estacion;
import com.laplataenbici.model.domain.Localidad;
import com.laplataenbici.model.domain.Ubicacion;
import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.tracking.OperacionTracking;
import com.laplataenbici.model.domain.tracking.TrackingBicicleta;
import com.laplataenbici.model.domain.tracking.TrackingEstacion;
import com.laplataenbici.model.domain.tracking.TrackingUsuario;
import com.laplataenbici.model.domain.utils.EstadoBicicleta;
import com.laplataenbici.model.domain.utils.EstadoEstacion;
import com.laplataenbici.model.domain.utils.EstadoUsuario;
import com.laplataenbici.model.domain.utils.Rol;
import com.laplataenbici.model.domain.utils.Sexo;
import com.laplataenbici.model.repository.impl.BicicletaRepositoryImpl;
import com.laplataenbici.model.repository.impl.EstacionRepositoryImpl;
import com.laplataenbici.model.repository.impl.LocalidadRepositoryImpl;
import com.laplataenbici.model.repository.impl.UsuarioRepositoryImpl;
import com.laplataenbici.model.repository.impl.tracking.TrackingBicicletaRepositoryImpl;
import com.laplataenbici.model.repository.impl.tracking.TrackingEstacionRepositoryImpl;
import com.laplataenbici.model.repository.impl.tracking.TrackingUsuarioRepositoryImpl;

/**
 * Servlet implementation class TestsServlet
 */
@WebServlet(urlPatterns = {"/tests"})
public class TestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter pw = response.getWriter();
		
		this.testLocalidades(pw);
		this.testEstaciones(pw);
		this.testUsuarios(pw);
		this.testBicicletas(pw);
		this.testTrackingBicicletas(pw);
		this.testTrackingEstacions(pw);
		this.testTrackingUsuarios(pw);
		
	
	}
	
	
	private void testLocalidades(PrintWriter pw){
		
		pw.println("--------------------------------------------------");
		pw.println("----- Tests de localidades");
		pw.println("--------------------------------------------------");
		
		TestsUtils<Localidad> test = new TestsUtils<Localidad>(pw,new LocalidadRepositoryImpl()) {
			
			@Override
			protected Localidad modificarRegistro(Localidad entity) {
				entity.setCodigoPostal(6789);
				return entity;
			}

			@Override
			protected Localidad nuevoRegistro() {
				Localidad tmp = new Localidad();
				tmp.setCodigoPostal(1234);
				tmp.setNombre("FALSA");
				return tmp;
			}
		};
		
		test.run();
		
		pw.println(">");
		pw.println(">");
	}
	
	private void testEstaciones(PrintWriter pw){
		
		pw.println("--------------------------------------------------");
		pw.println("----- Tests de estaciones");
		pw.println("--------------------------------------------------");
		
		TestsUtils<Estacion> test = new TestsUtils<Estacion>(pw,new EstacionRepositoryImpl()) {
			
			@Override
			protected Estacion modificarRegistro(Estacion entity) {
				entity.setNombre("Nueva nombre de plaza");
				return entity;
			}

			@Override
			protected Estacion nuevoRegistro() {
				Estacion tmp = new Estacion();
				tmp.setEstado(EstadoEstacion.OPERATIVA);
				tmp.setDireccion("7 y 54");
				tmp.setNombre("Pza San Martin");
				tmp.setUbicacion(new Ubicacion(123D,123D));
				return tmp;
			}
		};
		
		test.run();
		
		pw.println(">");
		pw.println(">");
	}
	
	private void testUsuarios(PrintWriter pw){
		
		pw.println("--------------------------------------------------");
		pw.println("----- Tests de usuarios");
		pw.println("--------------------------------------------------");
		
		TestsUtils<Usuario> test = new TestsUtils<Usuario>(pw,new UsuarioRepositoryImpl()) {
			
			@Override
			protected Usuario modificarRegistro(Usuario entity) {
				entity.setApellido("Gomez Gomoso");
				return entity;
			}

			@Override
			protected Usuario nuevoRegistro() {
				Usuario tmp = new Usuario();
				tmp.setEstado(EstadoUsuario.HABILITADO);
				tmp.setApellido("Gomez");
				tmp.setNombre("Cristian");
				tmp.setDNI(1230123);
				tmp.setCalle("Av 32");
				tmp.setNumero("456");
				Localidad loc = new Localidad();
				loc.setId(3L);
				tmp.setLocalidad(loc);
				tmp.setFechaNacimiento(new Date());
				tmp.setRol(Rol.USER);
				tmp.setSexo(Sexo.M);
				tmp.setUsername("cgomez");
				tmp.setPassword("secreta");
				return tmp;
			}
		};
		
		test.run();
		
		pw.println(">");
		pw.println(">");
	}
	
	private void testBicicletas(PrintWriter pw){
		
		pw.println("--------------------------------------------------");
		pw.println("----- Tests de Bicicletas");
		pw.println("--------------------------------------------------");
		
		TestsUtils<Bicicleta> test = new TestsUtils<Bicicleta>(pw,new BicicletaRepositoryImpl()) {
			
			@Override
			protected Bicicleta modificarRegistro(Bicicleta entity) {
				entity.setEstado(EstadoBicicleta.REPARACION);
				return entity;
			}

			@Override
			protected Bicicleta nuevoRegistro() {
				Bicicleta tmp = new Bicicleta();
				tmp.setEstado(EstadoBicicleta.APTA);
				tmp.setFechaIngreso(new Date());
				Estacion est = new Estacion();
				est.setId(1L);
				tmp.setEstacion(est);
				return tmp;
			}
		};
		
		test.run();
		
		pw.println(">");
		pw.println(">");
	}
	
	private void testTrackingBicicletas(PrintWriter pw){
		
		pw.println("--------------------------------------------------");
		pw.println("----- Tests de TrackingBicicletas");
		pw.println("--------------------------------------------------");
		
		TestsUtils<TrackingBicicleta> test = new TestsUtils<TrackingBicicleta>(pw,new TrackingBicicletaRepositoryImpl()) {
			
			@Override
			protected TrackingBicicleta modificarRegistro(TrackingBicicleta entity) {
				entity.setMensaje("El usuario retiró la bici");
				return entity;
			}

			@Override
			protected TrackingBicicleta nuevoRegistro() {
				TrackingBicicleta tmp = new TrackingBicicleta();
				
				Bicicleta bici = new Bicicleta();
				bici.setId(1L);
				tmp.setEntity(bici);
				
				tmp.setOperacion(OperacionTracking.MODIFICACION);
				tmp.setFecha(new Date());
				
				Usuario user = new Usuario();
				user.setId(1L);
				tmp.setModificadorPor(user);
				
				return tmp;
			}
		};
		
		test.run();
		
		pw.println(">");
		pw.println(">");
	}

	
	private void testTrackingUsuarios(PrintWriter pw){
		
		pw.println("--------------------------------------------------");
		pw.println("----- Tests de TrackingUsuarios");
		pw.println("--------------------------------------------------");
		
		TestsUtils<TrackingUsuario> test = new TestsUtils<TrackingUsuario>(pw,new TrackingUsuarioRepositoryImpl()) {
			
			@Override
			protected TrackingUsuario modificarRegistro(TrackingUsuario entity) {
				entity.setMensaje("El usuario se dió de alta");
				return entity;
			}

			@Override
			protected TrackingUsuario nuevoRegistro() {
				TrackingUsuario tmp = new TrackingUsuario();
				
				Usuario user = new Usuario();
				user.setId(1L);
				tmp.setEntity(user);
				tmp.setModificadorPor(user);
				
				tmp.setOperacion(OperacionTracking.ALTA);
				tmp.setFecha(new Date());
				
				return tmp;
			}
		};
		
		test.run();
		
		pw.println(">");
		pw.println(">");
	}

	
	private void testTrackingEstacions(PrintWriter pw){
		
		pw.println("--------------------------------------------------");
		pw.println("----- Tests de TrackingEstacions");
		pw.println("--------------------------------------------------");
		
		TestsUtils<TrackingEstacion> test = new TestsUtils<TrackingEstacion>(pw,new TrackingEstacionRepositoryImpl()) {
			
			@Override
			protected TrackingEstacion modificarRegistro(TrackingEstacion entity) {
				entity.setMensaje("La estacion paso de operativa a cerrada");
				return entity;
			}

			@Override
			protected TrackingEstacion nuevoRegistro() {
				TrackingEstacion tmp = new TrackingEstacion();
				
				Estacion estacion = new Estacion();
				estacion.setId(1L);
				tmp.setEntity(estacion);
				
				tmp.setOperacion(OperacionTracking.MODIFICACION);
				tmp.setFecha(new Date());
				
				Usuario user = new Usuario();
				user.setId(1L);
				tmp.setModificadorPor(user);
				
				return tmp;
			}
		};
		
		test.run();
		
		pw.println(">");
		pw.println(">");
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

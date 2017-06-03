package com.laplataenbici.controllers;

import java.io.PrintWriter;
import java.util.Optional;

import com.laplataenbici.model.domain.AbstractEntity;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.interfaces.IEntityRepository;

public abstract class TestsUtils<T extends AbstractEntity> {

	private final IEntityRepository<T> repo;
	private final PrintWriter pw;
	private Long insId;
	
	public TestsUtils(PrintWriter pw,IEntityRepository<T> repo){
		this.repo = repo;
		this.pw = pw;
	}
	
	public void TestGet() {
		
		try{
			pw.println("> Buscando todos los registros");
			pw.println("> ");
			Page<T> registros = repo.findAll(new Pageable(0,20));
			
			pw.println("> Se recuperaron "+registros.getTotalItems()+" resultados");
			pw.println("> ");
			pw.println("> ");
			pw.println("> Buscar registro con id 1");
			pw.println("> ");
			Optional<T> tmp = repo.findOneById(1L);
			if(tmp.isPresent()){
				pw.println("> Registro encontrado: "+tmp.get().toString());
				pw.println("> ");
			}else{
				throw new Exception("No se encontro el registro con id 1");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			pw.println("**************** Falló TestGet ****************");
		}
		
	}
	
	public void TestAlta(){
		T nuevoRegistro = this.nuevoRegistro();
		pw.println("> Agregar un registro -> "+nuevoRegistro.toString());
		pw.println("> ");
		try{
			T tmp = repo.save(nuevoRegistro);
			
			insId = tmp.getId();
			pw.println("> Registro guardado con id "+insId);
			
		}catch(Exception e){
			e.printStackTrace();
			pw.println("****************  Falló TestAlta ****************");
		}
		
	}
	
	public void TestModificacion(){
		pw.println("> Modificar el registro previamente creado");
		pw.println("> ");
		try{
			Optional<T> buscada = repo.findOneById(insId);
			if(buscada.isPresent()){
				T modificada = this.modificarRegistro(buscada.get());
				
				repo.save(modificada);
				
				pw.println("> Registro modificado: "+modificada.toString());
			
			}else{
				throw new Exception("No se econtró el registro con id "+insId);
			}
						
		}catch(Exception e){
			e.printStackTrace();
			pw.println("**************** Falló TestModificacion ****************");
		}
		
	}
	
	
	public void TestBaja(){
		pw.println("> Borrar el registro previamente creado");
		pw.println("> ");
		try{
			
			pw.println("> Borrado el registro con id: "+repo.delete(insId));
						
		}catch(Exception e){
			e.printStackTrace();
			pw.println("**************** Falló TestBaja ****************");
		}
		
	}
	
	protected abstract T modificarRegistro(T entity);
	protected abstract T nuevoRegistro();
	
	public void run(){
		this.TestGet();
		this.TestAlta();
		this.TestModificacion();
		this.TestBaja();
	}
}

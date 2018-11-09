package cl.aicb.java.agendacontactos;

import java.util.ArrayList;

public class Agenda {
	
	private ArrayList<Contacto> listaContactos;
	
	public Agenda(){
		this.listaContactos=new ArrayList<Contacto>();
	}
	
	public Agenda(ArrayList<Contacto> listaContactos){
		this.listaContactos=listaContactos;
	}
	
	public ArrayList<Contacto> getListaContactos() {
		return listaContactos;
	}

	public void setListaContactos(ArrayList<Contacto> listaContactos) {
		this.listaContactos = listaContactos;
	}
	
	public int cantidadContactos(){
		return this.listaContactos.size();
	}
	
	public Contacto obtenerContacto(int pos){
		try{
			return this.listaContactos.get(pos);
		}catch(Exception e){
			throw e;
		}
	}
	
	public void agregarContacto(Contacto c){
		try{
			this.listaContactos.add(c);
			System.out.println("Contacto agregado exitosamente");
		}catch(Exception e){
			throw e;
		}
	}
	
	public void modificarContacto(int pos, Contacto c){
		try{
			Contacto con=this.listaContactos.get(pos);
			con.setNombre(c.getNombre());
			con.setTelefono(c.getTelefono());
			con.setEmail(c.getEmail());
			System.out.println("Contacto modificado exitosamente");
		}catch(Exception e){
			throw e;
		}
	}
	
	public void eliminarContacto(int pos){
		try{
			this.listaContactos.remove(pos);
			System.out.println("Contacto eliminado exitosamente");
		}catch(Exception e){
			throw e;
		}
	}
	
}

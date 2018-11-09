package cl.aicb.java.agendacontactos;

import java.util.Scanner;

public class Principal {

	public static Scanner entrada=new Scanner(System.in); 

	public static void main(String[] args) {
		System.out.println("=====================================================");
		System.out.println("Inicio del Programa AGENDA DE CONTACTOS");
		System.out.println("=====================================================");
		System.out.println("");
		try {
			Agenda agendaContactos = new Agenda();
			String opcion = menuOpciones();
			while(!opcion.equals("5")){
				System.out.println("-----------------------------------------------------");
				if(opcion.equals("1")){ // Opción 1: Ver lista de contactos
					if(agendaContactos.cantidadContactos()==0){
						System.out.println("Agenda de contactos vacía.");
					}else{					
						int i=1;
						System.out.println("Agenda de contactos:");
						for(Contacto item: agendaContactos.getListaContactos()){
							System.out.println(">> " + i + " : " + item.getNombre() + " / " + item.getTelefono() + " / " + item.getEmail());
							i++;
						}
					}
				}
				else if(opcion.equals("2")){ // Opción 2: Agregar nuevo contacto
					System.out.print("Ingrese nombre del contacto : ");
					String nombre=entrada.nextLine();
					while(nombre.equals("")){
						System.out.println("El nombre no debe estar vacio!");
						System.out.print("Ingrese nombre del contacto : ");
						nombre=entrada.nextLine();
					}
					System.out.print("Ingrese telefono del contacto : ");
					String telefono=entrada.nextLine();
					while(telefono.equals("")){
						System.out.println("El telefono no debe estar vacio!");
						System.out.print("Ingrese telefono del contacto : ");
						telefono=entrada.nextLine();
					}
					System.out.print("Ingrese e-mail del contacto : ");
					String email=entrada.nextLine();
					while(email.equals("")){
						System.out.println("El e-mail no debe estar vacio!");
						System.out.print("Ingrese e-mail del contacto : ");
						email=entrada.nextLine();
					}
					Contacto c = new Contacto(nombre, telefono, email);
					agendaContactos.agregarContacto(c);
				}
				else if(opcion.equals("3")){ // Opción 3: Modificar contacto existente
					if(agendaContactos.cantidadContactos()==0){
						System.out.println("Agenda de contactos vacía.");
						System.out.println("No hay contactos para modificar.");
					}else{					
						int i=1;
						System.out.println("Agenda de contactos:");
						for(Contacto item: agendaContactos.getListaContactos()){
							System.out.println(">> " + i + " : " + item.getNombre() + " / " + item.getTelefono() + " / " + item.getEmail());
							i++;
						}
						System.out.print("Ingrese posicion del contacto a modificar en la agenda: ");
						int posMod=entrada.nextInt();
						entrada.nextLine();
						while(posMod<1 || posMod>agendaContactos.cantidadContactos()){
							System.out.println("Debe ingresar una posición válida!");
							System.out.print("Ingrese posicion del contacto a modificar en la agenda: ");
							posMod=entrada.nextInt();
							entrada.nextLine();
						}
						posMod--;
						Contacto conMod=agendaContactos.obtenerContacto(posMod);
						mostrarDatosContacto(conMod);
						System.out.print("Edite nombre del contacto (<DEJAR EN BLANCO>=No Cambiar) : ");
						String nombreMod=entrada.nextLine();
						if(nombreMod.equals("")){
							nombreMod=conMod.getNombre();
						}
						System.out.print("Edite telefono del contacto (<DEJAR EN BLANCO>=No Cambiar) : ");
						String telefonoMod=entrada.nextLine();
						if(telefonoMod.equals("")){
							telefonoMod=conMod.getTelefono();
						}
						System.out.print("Edite e-mail del contacto (<DEJAR EN BLANCO>=No Cambiar) : ");
						String emailMod=entrada.nextLine();
						if(emailMod.equals("")){
							emailMod=conMod.getEmail();
						}
						conMod.setNombre(nombreMod);
						conMod.setTelefono(telefonoMod);
						conMod.setEmail(emailMod);
						agendaContactos.modificarContacto(posMod, conMod);
					}
				}
				else if(opcion.equals("4")){ // Opción 4: Eliminar contacto
					if(agendaContactos.cantidadContactos()==0){
						System.out.println("Agenda de contactos vacía.");
						System.out.println("No hay contactos para eliminar.");
					}else{					
						int i=1;
						System.out.println("Agenda de contactos:");
						for(Contacto item: agendaContactos.getListaContactos()){
							System.out.println(">> " + i + " : " + item.getNombre() + " / " + item.getTelefono() + " / " + item.getEmail());
							i++;
						}
						System.out.print("Ingrese posicion del contacto a eliminar en la agenda: ");
						int posEli=entrada.nextInt();
						entrada.nextLine();
						while(posEli<1 || posEli>agendaContactos.cantidadContactos()){
							System.out.println("Debe ingresar una posicion valida!");
							System.out.print("Ingrese posicion del contacto a eliminar en la agenda: ");
							posEli=entrada.nextInt();
							entrada.nextLine();
						}
						posEli--;
						Contacto conEli = agendaContactos.obtenerContacto(posEli);
						mostrarDatosContacto(conEli);
						System.out.print("Esta seguro de eliminar este contacto? (S=Si/N=No) : ");
						String opcEli = entrada.nextLine();
						while(!opcEli.equalsIgnoreCase("s") && !opcEli.equalsIgnoreCase("n")){
							System.out.println("Debe ingresar una respuesta valida!");
							System.out.print("Esta seguro de eliminar este contacto? (S=Si/N=No) : ");
							opcEli = entrada.nextLine();
						}
						if(opcEli.equalsIgnoreCase("s")){
							agendaContactos.eliminarContacto(posEli);
						}
						if(opcEli.equalsIgnoreCase("n")){
							System.out.println("Contacto no ha sido eliminado");
						}
					}
				}else{ // Otra opción no válida para el programa
					System.out.println("Debe ingresar una opcion valida para el programa!");
				}
				System.out.println("-----------------------------------------------------");
				opcion=menuOpciones();
			}
		}catch(Exception e){
			System.out.println("Error!!! : " + e.getMessage());
		}
		// Opción 5: Salir
		System.out.println("");
		System.out.println("=====================================================");
		System.out.println("Gracias por usar este programa! ;)");
		System.out.println("=====================================================");
	}

	public static String menuOpciones(){
		// Menu de Opciones del Programa.
		// Retorna la opción seleccionada por el usuario.
		System.out.println("Que desea hacer?");
		System.out.println("1) Ver lista de contactos");
		System.out.println("2) Agregar nuevo contacto");
		System.out.println("3) Modificar contacto existente");
		System.out.println("4) Eliminar contacto");
		System.out.println("5) Salir");
		System.out.print("Ingrese una opcion: ");
		String opcion=entrada.nextLine();
		return opcion;
	}
	
	public static void mostrarDatosContacto(Contacto c){
		// Muestra los datos del contacto dado
		System.out.println(">> Datos del contacto selecionado");
		System.out.println("> Nombre: " + c.getNombre());
		System.out.println("> Telefono: " + c.getTelefono());
		System.out.println("> E-mail: " + c.getEmail());
	}

}

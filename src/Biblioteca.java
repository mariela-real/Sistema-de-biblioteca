
import javax.print.Doc;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Biblioteca {
    private String nombre;
    private String direccion;
    private Scanner in;
    private ArrayList <Persona> listaPersonas;
    private ArrayList <Prestamo> listaDeudores;
    private ArrayList <Material> listaMateriales;

    public Biblioteca(String nombre,String direccion)
    {
        this.nombre=nombre;
        this.direccion=direccion;
        in=new Scanner(System.in);
        listaPersonas=new ArrayList<>();
        listaDeudores = new ArrayList<>();
        listaMateriales = new ArrayList<>();
    }
    public void Menu()
    {
        System.out.println("Bienvenidos a la Biblioteca "+ nombre);
        System.out.println("[1] Gestionar Material");
        System.out.println("[2] Gestionar Persona");
        System.out.println("[3] Gestionar Prestamo");
        System.out.println("[0] Salir");
    }
    public void Iniciar()
    {
        int opcion;

        do{
            Menu();

            opcion=in.nextInt();

            switch (opcion)
            {
                case 1 -> menuMaterial();
                case 2 -> menuPersona();
                case 3 -> menuPrestamo();
                case 0 -> System.out.println("El sistema se esta cerrando");
                default -> {
                }
            }
        } while(opcion!=0);
        
    }

    private void menuMaterial()
    {
        int opcionMenuMaterial;

        do {
            System.out.println("[1] Libro");
            System.out.println("[2] Revista");
            System.out.println("[3] Editar material");
            System.out.println("[4] eliminar material");
            System.out.println("[5] mostrar lista de materiales");
            System.out.println("[0] Salir");

            opcionMenuMaterial = in.nextInt();

            switch (opcionMenuMaterial)
            {
                case 1->registrarLibro();
                case 2->registrarRevista();
                case 3->editarMaterial();
                case 4->eliminarMaterial();
                case 5->mostrarMaterial();
                default -> {}
            }
        }while (opcionMenuMaterial != 0);
    }
    private void menuPersona() {
        int opcionMenuPersona;

      do {
    	  System.out.println("[1] Estudiante");
    	  System.out.println("[2] Docente");
    	  System.out.println("[3] Editar usuario");
    	  System.out.println("[4] Eliminar usuario");
    	  System.out.println("[5] Mostrar lista de usuarios");
    	  System.out.println("[0] Salir");

          opcionMenuPersona=in.nextInt();

          switch (opcionMenuPersona)
          {
              case 1 -> registrarEstudiante();
              case 2 -> registrarDocente();
              case 3 -> editarPersona();
              case 4 -> eliminarPersona();
              case 5 -> mostrarPersona();
              default -> {
              }
          }
    	  }while (opcionMenuPersona != 0);
    }
    private void menuPrestamo()
    {
        int opcionMenuPrestamo = -1;
        String codDocente, matricula,  titulo;

        while(opcionMenuPrestamo != 0 )
        {
            System.out.println("-------Registro de prestamos-------");
            System.out.println("[1] Realizar prestamo a estudiante");
            System.out.println("[2] Realizar prestamo a docente");
            System.out.println("[3] Mostrar lista de deudores");
            System.out.println("[0] Salir");

            opcionMenuPrestamo = in.nextInt();

            switch (opcionMenuPrestamo)
            {
                case 1 ->
                {
                    System.out.print("Ingresar matricula: ");
                    matricula = in.next();

                    System.out.print("Ingresar titulo del material: ");
                    titulo = in.next();

                    Persona estudiante = validarPersona(matricula);
                    Material material = validarMaterial(titulo);

                    if ( estudiante != null && material !=null )
                    {
                        estudiante.setEsDeudor(true);
                        this.listaDeudores.add(new Prestamo(estudiante, material));
                    }
                }
                case 2 ->
                {
                    System.out.print("Ingresar el cod docente: ");
                    codDocente = in.next();

                    System.out.print("Ingresar titulo del material: ");
                    titulo = in.next();

                    Persona docente = validarPersona(codDocente);
                    Material material = validarMaterial(titulo);

                    if ( docente != null && material !=null )
                    {
                        docente.setEsDeudor(true);
                        this.listaDeudores.add(new Prestamo(docente, material));
                    }

                }
                case 3 ->
                {
                    for (int i = 0; i < (long) listaDeudores.size(); i++) {
                        System.out.println(listaDeudores.get(i));
                    }
                }
                default -> {}
            }
        }
    }
    private Persona validarPersona(String ValorUnico)
    {
        for (int i = 0; i < (long) this.listaPersonas.size(); i++)
        {
            if (this.listaPersonas.get(i) instanceof Estudiante est)
            {
                if (Objects.equals(est.getMatricula(), ValorUnico))
                {
                    return this.listaPersonas.get(i);
                }
            }
            else if(this.listaPersonas.get(i) instanceof Docente doc)
            {
                if(Objects.equals(doc.getCodDocente(), ValorUnico))
                {
                    return this.listaPersonas.get(i);
                }
            }
        }

        return null;
    }
    private Material validarMaterial(String titulo)
    {
        for (int i = 0; i < (long) this.listaMateriales.size(); i++)
        {
            if (Objects.equals(this.listaMateriales.get(i).getTitulo(), titulo))
            {
                return this.listaMateriales.get(i);
            }
        }

        return null;
    }
    private void registrarEstudiante()
    {
         System.out.print("nombre: ");
         String nombre=in.next();
         System.out.print("ci: ");
         String ci=in.next();
         System.out.print("edad: ");
         int edad=in.nextInt();
         System.out.print("matricula: ");
         String matricula=in.next();
         Estudiante estudiante = new Estudiante(nombre, ci, edad,matricula);
         listaPersonas.add(estudiante);
    }
         
    private void registrarDocente()
    {
        System.out.print("Nombre: ");
        String nombre=in.next();
        System.out.print("Codigo docente: ");
        String codDocente=in.next();
        System.out.print("Ci:");
        String ci =in.next();
        System.out.print("Edad:");
        int edad = in.nextInt();
        Docente nuevo = new Docente(nombre, ci, edad, codDocente);
        listaPersonas.add(nuevo);
    }
    private void registrarLibro()
    {
        System.out.print("Nombre libro: ");
        String nombre=in.next();
        System.out.print("Autor: ");
        String autor=in.next();
        System.out.print("Editorial: ");
        String editorial =in.next();
        Libro libro = new Libro(nombre, autor, editorial);
        listaMateriales.add(libro);
    }
    private void registrarRevista()
    {
        System.out.print("Nombre revista: ");
        String nombre=in.next();
        System.out.print("Autor: ");
        String autor=in.next();
        System.out.print("Secciones:");
        String secciones =in.next();
        Revista revista = new Revista(nombre, autor, secciones);
        listaMateriales.add(revista);
    }
    
    private void editarPersona()
    {
         String newNombre;
         String newCi;
         int newEdad;
         System.out.println("-----Editar-----\n");
         System.out.print("Ingresar el nombre actual:");
         nombre = in.next();

         for(int  i = 0; i < (long) listaPersonas.size() ; i++)
         {
             if (Objects.equals(listaPersonas.get(i).getNombre(), nombre))
             {
                 System.out.print("Ingresar nuevo nombre: ");
                 newNombre = in.next();
                 System.out.print("Ingresar nuevo ci: ");
                 newCi = in.next();
                 System.out.print("Ingresar nueva edad: ");
                 newEdad = in.nextInt();

                 listaPersonas.get(i).setNombre(newNombre);
                 listaPersonas.get(i).setCi(newCi);
                 listaPersonas.get(i).setEdad(newEdad);

                 break;
             }
         }
    }

    private void editarMaterial()
    {
        String newNombreMaterial;
        String newAutor;

        System.out.print("-----Editar-----\n");
        System.out.print("Ingresar el titulo actual: ");
        nombre = in.next();

        for(int  i = 0; i < (long) listaMateriales.size() ; i++)
        {
            if (Objects.equals(listaMateriales.get(i).getTitulo(), nombre))
            {
                System.out.print("Ingresar nuevo titulo: ");
                newNombreMaterial = in.next();
                System.out.print("Ingresar nuevo autor: ");
                newAutor = in.next();

                listaMateriales.get(i).setTitulo(newNombreMaterial);
                listaMateriales.get(i).setAutor(newAutor);
                break;
            }
        }
    }
   private void eliminarPersona()
   {
         String nombre;
         System.out.print("-----Eliminar-----\n");
         System.out.print("Ingresar el nombre: ");
         nombre = in.next();

         for(int  i = 0; i < (long) listaPersonas.size() ; i++)
         {
             if (Objects.equals(listaPersonas.get(i).getNombre(), nombre))
             {
                 listaPersonas.remove(i);
                 System.out.println("----- Persona Eliminada-----");
                 break;
             }
         }
   }

   private void eliminarMaterial()
   {
        String nombre;
        System.out.print("-----Eliminar-----\n");
        System.out.print("Ingresar el titulo:");
        nombre = in.next();

        for(int  i = 0; i < (long) listaMateriales.size() ; i++)
        {
            if (Objects.equals(listaMateriales.get(i).getTitulo(), nombre))
            {
                listaMateriales.remove(i);
                System.out.println("----- Material Eliminado-----");
                break;
            }
        }
   }
   private void mostrarPersona()
   {
         for (int i = 0; i< (long) listaPersonas.size(); i++)
         {
             System.out.println(listaPersonas.get(i));
         }
   }

   private void mostrarMaterial()
   {
        for (int i = 0; i< (long) listaMateriales.size(); i++)
        {
            System.out.println(listaMateriales.get(i));
        }
   }
    
}

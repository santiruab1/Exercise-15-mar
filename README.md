# Sistema de Gestión de Biblioteca

Este proyecto implementa un sistema de gestión para una biblioteca, permitiendo administrar libros, usuarios y préstamos. A continuación, se describen las decisiones tomadas durante el desarrollo del código, organizadas por clase.

---

## **Clase `Libro`**
La clase `Libro` representa los libros disponibles en la biblioteca. Se tomaron las siguientes decisiones de diseño:

### **Constructores**
- Se implementaron **múltiples constructores** para permitir la creación de objetos `Libro` con diferentes niveles de detalle:
  - Constructor con todos los atributos (`titulo`, `autor`, `ISBN`, `anioPublicacion`, `disponible`).
  - Constructor con solo el título.
  - Constructor con título y autor.
  - Constructor con título, autor e ISBN.
  - Constructor por defecto con valores iniciales.

### **Validaciones**
- En los métodos `set` de los atributos (`titulo`, `autor`, `ISBN`, `anioPublicacion`), se validó que los datos no fueran nulos ni estuvieran vacíos para garantizar la integridad de los datos.

### **Métodos Especiales**
- **`marcarComoPrestado`**: Cambia el estado del libro a no disponible (`disponible = false`) y valida si el libro ya estaba prestado.
- **`marcarComoDisponible`**: Cambia el estado del libro a disponible (`disponible = true`) y valida si el libro ya estaba disponible.
- **`toString`**: Proporciona una representación legible del libro, mostrando todos sus atributos.

---

## **Clase `Usuario`**
La clase `Usuario` representa a los usuarios registrados en la biblioteca. Se tomaron las siguientes decisiones:

### **Constructores**
- Se implementaron **múltiples constructores** para permitir la creación de objetos `Usuario` con diferentes niveles de detalle:
  - Constructor con todos los atributos (`id`, `nombre`, `email`, `prestamosActuales`).
  - Constructor con solo el `id`.
  - Constructor con `id` y `nombre`.
  - Constructor con `id`, `nombre` y `email`.
  - Constructor por defecto con valores iniciales.

### **Validaciones**
- En los métodos `set` de los atributos (`id`, `nombre`, `email`), se validó que los datos no fueran nulos ni estuvieran vacíos.

### **Métodos Especiales**
- **`agregarPrestamo`**: Agrega un libro a la lista de préstamos actuales del usuario, validando que el libro no sea nulo.
- **`eliminarPrestamo`**: Elimina un libro de la lista de préstamos actuales del usuario, validando que el libro no sea nulo.
- **`toString`**: Proporciona una representación legible del usuario, mostrando todos sus atributos y los libros prestados.

---

## **Clase `Prestamo`**
La clase `Prestamo` representa los préstamos realizados en la biblioteca. Se tomaron las siguientes decisiones:

### **Constructores**
- Se implementaron **múltiples constructores** para permitir la creación de objetos `Prestamo` con diferentes niveles de detalle:
  - Constructor con todos los atributos (`libro`, `usuario`, `fechaPrestamo`, `fechaDevolucionPrevista`).
  - Constructor con solo el libro.
  - Constructor con libro y usuario.
  - Constructor con libro, usuario y fecha de préstamo.
  - Constructor por defecto con valores iniciales.

### **Validaciones**
- En los métodos `set` de los atributos (`libro`, `usuario`, `fechaPrestamo`, `fechaDevolucionPrevista`), se validó que los datos no fueran nulos.

### **Métodos Especiales**
- **`diasRetraso`**: Calcula los días de retraso en la devolución del libro utilizando la clase `LocalDate` de la librería `java.time`. Si no hay retraso, devuelve 0.
- **`toString`**: Proporciona una representación legible del préstamo, mostrando todos sus atributos.

---

## **Clase `Biblioteca`**
La clase `Biblioteca` contiene la lógica principal del sistema. Se tomaron las siguientes decisiones:

### **Atributos**
- Se definieron listas para almacenar los libros, usuarios y préstamos:
  - `List<Libro> libros`
  - `List<Usuario> usuarios`
  - `List<Prestamo> prestamos`

### **Métodos para Agregar Libros**
- **Sobrecarga**: Se implementaron múltiples versiones del método `agregarLibroInventario` para permitir agregar libros con diferentes niveles de detalle (por ejemplo, solo título o todos los atributos).
- **Validaciones**: Se validó que los libros no fueran nulos antes de agregarlos a la lista.

### **Métodos para Registrar Usuarios**
- **Sobrecarga**: Se implementaron múltiples versiones del método `registrarUsuario` para permitir registrar usuarios con diferentes niveles de detalle (por ejemplo, solo `id` o todos los atributos).
- **Validaciones**: Se validó que los usuarios no fueran nulos antes de agregarlos a la lista.

### **Método para Realizar Préstamos**
- **Lógica**: Se validó que el libro estuviera disponible y que el usuario existiera antes de realizar el préstamo. El préstamo se registra en la lista de préstamos y se actualizan los estados del libro y del usuario.
- **Fechas**: Se utilizó `LocalDate.now()` para registrar la fecha del préstamo y `LocalDate.plusDays(15)` para calcular la fecha de devolución prevista.

### **Método para Registrar Devoluciones**
- **Lógica**: Se validó que el libro estuviera prestado y que el usuario existiera antes de registrar la devolución. El préstamo se elimina de la lista de préstamos y se actualizan los estados del libro y del usuario.

### **Métodos para Buscar Libros**
- **Sobrecarga**: Se implementaron dos versiones del método `buscarLibros`:
  - Buscar por objeto `Libro`.
  - Buscar por título.
- **Validaciones**: Se validó que los parámetros no fueran nulos ni vacíos.

### **Método para Consultar Préstamos de un Usuario**
- **Lógica**: Se buscó al usuario en la lista y se imprimieron sus préstamos actuales.

### **Método para Generar Informes**
- **Lógica**: Se generaron informes detallados de los libros, usuarios y préstamos registrados en la biblioteca.
- **Validaciones**: Se verificó si las listas estaban vacías antes de imprimir los datos.

---

## **Conclusión**
El sistema de gestión de biblioteca implementa todas las funcionalidades requeridas, incluyendo la administración de libros, usuarios y préstamos. Las decisiones tomadas, como el uso de sobrecarga de métodos, validaciones en los setters y el uso de `LocalDate` para manejar fechas, garantizan un diseño robusto, flexible y fácil de mantener.

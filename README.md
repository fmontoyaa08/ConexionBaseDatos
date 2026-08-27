# CONEXION A BASE DE DATOS
## Funcionalidades principales
* **Insertar estudiante:** Registra un nuevo estudiante incluyendo nombre, carnet, estado (activo/inactivo), tipo (Pregrado/Posgrado) y edad.
* **Actualizar estudiante:** Modifica el estado y el tipo de un estudiante según su ID.
* **Consultar activos:** Muestra la lista de estudiantes con estado activo (`activo = 1`).
* **Consultar inactivos:** Muestra la lista de estudiantes con estado inactivo (`activo = 0`).

## Estructura del proyecto
* `src/EstudianteDAO.java`: Maneja las consultas SQL y la conexión JDBC.
* `src/Main.java`: Menú interactivo en consola.
* `esquema.sql`: Contiene los comandos `ALTER TABLE` aplicados a la base de datos.
*

# Java-MVC-JDBC-Empleados

Aplicación Java desarrollada siguiendo el patrón **Modelo–Vista–Controlador (MVC)**, con interfaz Swing y acceso a base de datos MySQL mediante JDBC.

## Estructura del proyecto
- **modelo** → Clases `Empleado`, `EmpleadoDAO`, `JDBCSingleton`
- **vista** → `VentanaPrincipal` (interfaz gráfica Swing)
- **controlador** → `QuerysController` (gestiona la interacción vista ↔ modelo)
- **utils** → `Conversor` (manejo de fechas y tipos SQL)

## Tecnologías
- Java 21
- MySQL 8+
- JDBC
- Swing (GUI)
- Patrón MVC

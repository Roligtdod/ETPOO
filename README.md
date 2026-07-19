``` markdown
# Sistema de Gestión de Recursos Turísticos

Proyecto desarrollado en Java orientado a la gestión de recursos asociados a servicios turísticos. La aplicación permite registrar, almacenar y consultar información de distintos tipos de recursos, tales como guías turísticos, operadores de transporte y proveedores.

## Autor

**Maximiliano Pino**

## Descripción del proyecto

Este sistema permite administrar información relevante de recursos utilizados en una operación turística. A través de una interfaz gráfica desarrollada con Java Swing, el usuario puede ingresar datos, registrar recursos y leer la información almacenada desde un archivo de texto.

El proyecto aplica conceptos fundamentales de Programación Orientada a Objetos, destacando especialmente:

- Herencia
- Polimorfismo
- Interfaces
- Encapsulamiento
- Lectura y escritura de archivos
- Separación de responsabilidades por paquetes

## Tecnologías utilizadas

- Java
- Java Swing
- Maven
- Programación Orientada a Objetos
- Archivos de texto `.txt`

## Estructura del proyecto
```

text ETPOO ├── src │ └── main │ └── java │ ├── app │ │ └── Main.java │ ├── data │ │ └── GestorDatos.java │ ├── gui │ │ └── gui.java │ └── model │ ├── GuiaTuristico.java │ ├── OperadorTransporte.java │ ├── Proveedores.java │ ├── Recurso.java │ └── Registrable.java ├── datos.txt ├── pom.xml └── README.md``` 

## Funcionalidades principales

### Registro de recursos

El sistema permite registrar diferentes tipos de recursos:

- Guías turísticos
- Operadores de transporte
- Proveedores

Cada recurso cuenta con información propia, como identificación, nombre, teléfono, correo electrónico y datos específicos según su tipo.

### Lectura de archivos

La aplicación permite leer información almacenada previamente en el archivo `datos.txt`.

Cada tipo de recurso es identificado mediante una letra al inicio de cada línea:

| Código | Tipo de recurso |
|--------|-----------------|
| `g` | Guía turístico |
| `t` | Operador de transporte |
| `p` | Proveedor |

Ejemplo de formato utilizado en el archivo:
```

text g;123;Max;23123;correo@test.cl;Cargo;Especialidad;500000 t;456;Transportista;90000000;transporte@test.cl;A1;2026-12-31;600000 p;789;Proveedor;988888888;proveedor@test.cl;Artículos;Venta;Dirección``` 

### Escritura de archivos

Cuando se registra un nuevo recurso desde la interfaz gráfica, sus datos se guardan automáticamente en el archivo `datos.txt`.

La escritura se realiza en modo agregado, por lo que los nuevos registros se añaden al final del archivo sin eliminar la información existente.

## Aplicación de polimorfismo

El proyecto utiliza polimorfismo mediante la interfaz `Registrable`, la cual define comportamientos comunes para los recursos del sistema.

Las clases que representan recursos implementan esta interfaz y sobrescriben sus métodos, permitiendo que distintos objetos puedan ser tratados de forma general como elementos registrables.

Ejemplo conceptual:
```

java Registrable recurso = new GuiaTuristico(...); Registrable transporte = new OperadorTransporte(...); Registrable proveedor = new Proveedores(...);``` 

Gracias al polimorfismo, el sistema puede manejar distintos tipos de recursos bajo una misma estructura, invocando métodos como `registrar()` o `MostrarDatos()` sin depender directamente de la clase específica del objeto.

Esto permite que el código sea más flexible, reutilizable y fácil de mantener.

## Paquetes principales

### `app`

Contiene la clase principal encargada de iniciar la aplicación.

### `gui`

Contiene la interfaz gráfica desarrollada con Java Swing. Desde esta interfaz el usuario puede registrar y leer recursos.

### `model`

Contiene las clases del modelo del sistema, donde se representan los distintos recursos turísticos.

Clases principales:

- `Recurso`
- `GuiaTuristico`
- `OperadorTransporte`
- `Proveedores`
- `Registrable`

### `data`

Contiene la clase encargada de gestionar la lectura y escritura de datos en archivos.

Clase principal:

- `GestorDatos`

## Archivo de datos

El archivo utilizado para almacenar la información es:
```

text datos.txt``` 

Este archivo funciona como medio de persistencia simple, permitiendo conservar los datos ingresados incluso después de cerrar la aplicación.

## Cómo ejecutar el proyecto

1. Clonar o descargar el proyecto.
2. Abrirlo en un IDE compatible con Java, como IntelliJ IDEA, Eclipse o NetBeans.
3. Verificar que el proyecto tenga configurado Maven correctamente.
4. Ejecutar la clase principal ubicada en el paquete `app`.
5. Utilizar la interfaz gráfica para registrar o consultar recursos.

## Requisitos

- JDK instalado
- Maven configurado
- IDE compatible con proyectos Java

## Objetivo académico

El objetivo de este proyecto es aplicar conceptos de Programación Orientada a Objetos en Java mediante un sistema funcional que permita registrar, almacenar y consultar información, utilizando una interfaz gráfica y persistencia básica en archivos de texto.

## Estado del proyecto

Proyecto funcional con gestión de:

- Guías turísticos
- Operadores de transporte
- Proveedores
- Lectura de archivo
- Escritura de archivo
- Uso de polimorfismo mediante interfaces
```

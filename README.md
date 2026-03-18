# Sistema de Gestión de Inventarios Farmacéuticos – SophyFarm

## 📌 Descripción del proyecto

Este repositorio contiene el desarrollo progresivo de un sistema de gestión de inventarios farmacéuticos para la empresa **SophyFarm**, enfocado en el control de productos, stock y movimientos de inventario.

El proyecto se está desarrollando siguiendo un enfoque estructurado basado en **ingeniería de requisitos y buenas prácticas de calidad de software**, avanzando por fases: análisis, diseño e implementación.

---

## 🧭 Estado actual del proyecto

🔹 **Fase actual:** Construcción   
🔹 **Avance implementado:**
* CRUD básico de productos
* Arquitectura en capas
* Conexión a base de datos MySQL
* Eliminación lógica de productos
* Interfaz gráfica en Java Swing:
  - Visualización tabular de productos
  - Acciones directas (editar / eliminar)
  - Retroalimentación al usuario mediante mensajes

🔹 **Pendiente (próximas iteraciones):**

* Validación robusta de entradas
* Manejo estructurado de errores
* Búsqueda por nombre de producto
* Gestión de lotes y fechas de vencimiento
* Registro de entradas y ventas
* Mejoras de calidad (consistencia lógica y pruebas)

---

## 🏗️ Arquitectura del sistema

El sistema sigue una **arquitectura en capas**:

* **Presentación:** interfaz gráfica (Java Swing)
* **Lógica (servicio):** reglas de negocio y validaciones
* **Persistencia (DAO):** acceso a base de datos
* **Modelo:** entidades del dominio

Esta separación busca mejorar:

* mantenibilidad
* testabilidad
* escalabilidad

---

## 📁 Estructura del repositorio

```text
docs/
  ├─ srs.md
  ├─ srs.pdf
  └─ uml/
      └─ use-cases/

src/
  └─ com/sophyfarm/inventario/
        ├─ modelo/
        ├─ logica/
        ├─ persistencia/
        └─ presentacion/

db/
  └─ schema_producto.sql

README.md
.gitignore
```

---

## 🗄️ Base de datos

Motor utilizado: **MySQL**

### Script de creación

Ubicado en:

```text
db/schema_producto.sql
```

### Estructura principal

* Tabla: `producto`
* Campos:

  * `id` (PK)
  * `codigo` (único)
  * `nombre`
  * `activo`

---

## ⚙️ Configuración y ejecución

### 1. Crear base de datos

```sql
CREATE DATABASE inventario;
```

### 2. Ejecutar script

Ejecutar el archivo:

```text
db/schema_producto.sql
```

### 3. Configurar conexión

En:

```text
ConexionBD.java
```

Verificar:

```java
jdbc:mysql://localhost:3306/inventario
usuario: root
contraseña:
```

### 4. Ejecutar el sistema

Ejecutar la clase:

```text
Main.java
```

El sistema se ejecuta mediante una interfaz gráfica de escritorio desarrollada en Java Swing.

---

## 📚 Documentación

El repositorio incluye artefactos de ingeniería de requisitos:

* 📄 SRS (Software Requirements Specification)
* 📊 Diagramas UML de casos de uso
* 📋 Requisitos funcionales y no funcionales

Ubicación:

```text
docs/
```

---

## 🔍 Consideraciones de calidad

El desarrollo sigue principios de calidad como:

* Separación de responsabilidades
* Validación de entradas
* Uso de restricciones en base de datos
* Eliminación lógica para preservar integridad
* Trazabilidad entre requisitos y funcionalidades

---

## 🚀 Próximos pasos

* Implementar módulo de lotes
* Gestionar fechas de vencimiento
* Registrar entradas de inventario
* Registrar ventas
* Consultar stock por producto y por lote
* Incorporar pruebas básicas

---

⚠️ Nota: Aunque la visión del proyecto es una solución web, la implementación actual corresponde a un prototipo de escritorio utilizado para validar la lógica de negocio y persistencia.
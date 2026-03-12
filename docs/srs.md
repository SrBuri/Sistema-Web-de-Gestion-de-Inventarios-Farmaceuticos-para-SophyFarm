# Especificación de Requisitos de Software (SRS)
## Módulo Web de Inventarios — SophyFarm

Versión: 0.1  
Estado: Revisión  
Preparado por: Equipo del proyecto  
Organización: XYZ Soluciones Integrales  
Fecha: 12/03/26

---

## Historial de revisiones

| Nombre | Fecha | Motivo del cambio | Versión |
|------|------|-------------------|---------|
|   Definición de requisitos   |   12/03/26   |      Primera versión             | 0.1     |

---

## 1. Introducción

### 1.1 Propósito del documento
El presente documento tiene como propósito especificar de manera clara, estructurada y verificable los requisitos del sistema de información web para la gestión básica de inventarios correspondiente al MVP del sistema solicitado.

Este documento describe las funcionalidades que deberá proporcionar el sistema, así como las restricciones, supuestos y requisitos de calidad que orientarán su diseño, desarrollo, prueba y validación.

El documento establece una base común de entendimiento sobre el comportamiento esperado del sistema y sirve como referencia para verificar que la solución desarrollada cumpla con las necesidades definidas.

### 1.2 Alcance del producto
El sistema propuesto corresponde a un módulo web de gestión básica de inventarios diseñado como MVP para validar el funcionamiento de las operaciones fundamentales de control de existencias.

El sistema permitirá realizar las siguientes operaciones principales:
- Autenticación de usuario mediante inicio y cierre de sesión.
- Registro y gestión básica de productos.
- Registro de ventas simples de productos.
- Actualización automática del stock disponible.
- Consulta de existencias por producto.
- Consulta detallada de existencias por lote.

Este MVP no incluirá las siguientes funcionalidades:
- Facturación electrónica.
- Gestión de usuarios o administración de roles.
- Integración con sistemas externos.
- Reportes analíticos avanzados.
- Alertas automáticas de vencimiento.

El objetivo principal del MVP es validar el flujo operativo básico del inventario y garantizar la consistencia de las operaciones de registro, consulta y actualización de existencias.

### 1.3 Definiciones, acrónimos y abreviaturas
| Término | Definición |
|---|---|
| SRS | Especificación de Requisitos de Software |
| MVP | Versión mínima viable del sistema que permite validar las funcionalidades esenciales del producto |
| Producto | Entidad que representa un artículo inventariable identificado por un código único y un nombre |
| Lote | Conjunto de unidades de un producto que comparten la misma fecha de vencimiento |
| Entrada de inventario | Registro de incorporación de unidades de un producto al inventario |
| Venta | Registro de salida de unidades de un producto del inventario debido a una operación de venta |
| Movimiento de inventario | Evento que modifica el inventario disponible de un producto, incluyendo entradas y ventas |
| Stock total | Cantidad total disponible de un producto en inventario, considerando todos sus lotes |
| Stock por lote | Cantidad disponible de un producto asociada a un lote específico |

### 1.4 Referencias
| Referencia | Tipo | Detalle |
|---|---|---|
| ISO/IEC/IEEE 29148 | Normativa | Ingeniería de requisitos: calidad, estructura y trazabilidad |
| Informe Gerencial del proyecto | Documento de contexto | Fuente del alcance y contexto del producto |
|jam01 – SRS Template (GitHub)|Plantilla|Plantilla de documento SRS basada en estándares de ingeniería de requisitos. Disponible en: [https://github.com/jam01/SRS-Template]|

### 1.5 Convenciones del documento
- Los requisitos usan lenguaje normativo: “El sistema deberá…”.
- Cada requisito tiene un ID único e inmutable.
- Cada requisito incluye criterios de aceptación y método de verificación.

---

## 2. Visión general del producto

### 2.1 Perspectiva del producto
El sistema corresponde a una aplicación web destinada a soportar las operaciones básicas de inventario dentro del contexto organizacional.

El sistema permitirá registrar y controlar las existencias de productos mediante el manejo de lotes, entradas y ventas, asegurando la actualización automática del inventario disponible.

El sistema será desarrollado como una solución independiente y no dependerá de la integración con sistemas externos durante el alcance del MVP.

### 2.2 Funciones del producto
- Autenticación de usuario mediante inicio de sesión.
- Cierre de sesión del usuario.
- Registro de productos.
- Modificación de productos existentes.
- Búsqueda de productos.
- Visualización de productos registrados.
- Registro de entradas de inventario asociadas a lote y fecha de vencimiento.
- Registro de ventas simples de productos.
- Validación de disponibilidad de stock.
- Actualización automática del inventario tras una venta.
- Consulta de stock total por producto.
- Consulta de stock discriminado por lote.

### 2.3 Características de los usuarios

El sistema está diseñado para ser utilizado por un único tipo de usuario operativo.

| Rol | Características |
|---|---|
| Operador de inventario | Registra productos, entradas de inventario, ventas y consulta el estado del inventario |

Para el alcance del MVP se asume que todos los usuarios tendrán el mismo nivel de acceso operativo, por lo que no se implementará gestión de roles ni control de permisos diferenciados.

### 2.4 Supuestos
- El sistema será utilizado por usuarios previamente registrados en el sistema.
- El sistema operará en un entorno web accesible desde navegadores modernos.
- El volumen de datos inicial será pequeño, correspondiente a un escenario de prueba o validación del MVP.
- Las operaciones de inventario serán realizadas manualmente por el operador.

### 2.5 Restricciones del sistema
- El sistema deberá desarrollarse como aplicación web.
- El sistema no deberá integrarse con sistemas externos en esta versión del MVP.
- El sistema no incluirá funcionalidades de facturación electrónica.
- El sistema no incluirá gestión de roles ni administración de usuarios.
---

## 3. Requisitos

### 3.1 Requisitos funcionales (FR)

##### REQ-FUNC-001
- Título: Iniciar sesión
- Enunciado: El sistema deberá permitir que un usuario registrado inicie sesión mediante credenciales válidas para acceder a las funcionalidades.
- Justificación: El control de acceso es necesario para restringir el uso del sistema únicamente a usuarios autorizados, protegiendo la información del inventario.
- Criterios de aceptación:
    - CA-1: El sistema deberá permitir ingresar credenciales de usuario (usuario y contraseña).
    - CA-2: Cuando las credenciales sean válidas, el sistema deberá permitir el acceso al sistema.
    - CA-3: Cuando las credenciales sean inválidas, el sistema deberá impedir el acceso y mostrar un mensaje informando al usuario que los datos son incorrectos.
    - CA-4: El sistema deberá redirigir al usuario autenticado a la pantalla principal del sistema.
- Método de verificación: Prueba.
- Información adicional: Las credenciales de acceso deberán corresponder a usuarios previamente registrados en el sistema y almacenados en la base de datos de autenticación.

##### REQ-FUNC-002
- Título: Cerrar sesión
- Enunciado: El sistema deberá permitir al usuario cerrar sesión cuando finalice su operación.
- Justificación: Permitir el cierre de sesión es necesario para finalizar de forma segura la interacción del usuario con el sistema, evitando accesos no autorizados posteriores desde el mismo dispositivo y protegiendo la información operativa del inventario.
- Criterios de aceptación:
    - CA-1: El sistema deberá disponer de una opción visible para cerrar sesión.
    - CA-2: Cuando el usuario seleccione la opción de cerrar sesión, el sistema deberá finalizar la sesión activa.
    - CA-3: Después del cierre de sesión, el sistema no deberá permitir el acceso a funcionalidades internas sin una nueva autenticación.
    - CA-4: Después del cierre de sesión, el sistema deberá redirigir al usuario a la pantalla de inicio de sesión.
- Método de verificación: Prueba.

##### REQ-FUNC-003
- Título: Registrar producto
- Enunciado: El sistema deberá permitir registrar un producto con al menos su código y nombre.
- Justificación: El registro de productos es necesario para disponer de una base maestra mínima sobre la cual se soporten las operaciones de inventario. Sin la identificación previa de los productos no es posible controlar existencias ni mantener consistencia en la información operativa.
- Criterios de aceptación:
    - CA-1: El sistema deberá permitir ingresar como mínimo el código y el nombre del producto.
    - CA-2: El sistema deberá registrar el producto únicamente cuando los campos obligatorios hayan sido diligenciados.
    - CA-3: El sistema deberá almacenar correctamente la información del producto registrado.
    - CA-4: Una vez registrado el producto, este deberá quedar disponible para su consulta y para su uso en las operaciones de entrada de inventario y venta.
    - CA-5: El sistema deberá mostrar un mensaje de confirmación cuando el registro del producto se complete exitosamente.
- Método de verificación: Prueba.

##### REQ-FUNC-004
- Título: Buscar producto
- Enunciado: El sistema deberá permitir buscar productos por código o por nombre.
- Justificación: La búsqueda de productos es necesaria para localizar de forma rápida y precisa la información requerida durante las operaciones, especialmente en los procesos de consulta, entrada de inventario y venta. Esto mejora la eficiencia operativa y reduce errores derivados de la selección manual de productos.
- Criterios de aceptación:
    - CA-1: El sistema deberá permitir al usuario realizar búsquedas ingresando el código del producto.
    - CA-2: El sistema deberá permitir al usuario realizar búsquedas ingresando el nombre del producto.
    - CA-3: Cuando exista coincidencia, el sistema deberá mostrar el o los productos que correspondan al criterio ingresado.
    - CA-4: Cuando no exista coincidencia, el sistema deberá informar al usuario que no se encontraron resultados.
- Método de verificación: Prueba.
- Información adicional: La búsqueda por nombre podrá ser exacta o parcial e insensible a mayúsculas y minúsculas.

##### REQ-FUNC-005
- Título: Editar producto
- Enunciado: El sistema deberá permitir modificar la información básica de un producto previamente registrado.
- Justificación: La edición de productos es necesaria para mantener actualizada y correcta la información maestra del inventario. Esto permite corregir errores de registro, ajustar cambios en los datos del producto.
- Criterios de aceptación:
    - CA-1: El sistema deberá permitir seleccionar un producto previamente registrado para su edición.
    - CA-2: El sistema deberá mostrar la información actual del producto antes de realizar modificaciones.
    - CA-3:  El sistema deberá permitir modificar los campos básicos (nombre) del producto.
    - CA-4: El sistema deberá guardar los cambios únicamente cuando la información editada cumpla las validaciones definidas por el sistema.
    - CA-5:  Una vez confirmada la edición, el sistema deberá actualizar la información del producto y reflejar los cambios en las consultas posteriores.
    - CA-6: El sistema deberá mostrar un mensaje de confirmación cuando la actualización se realice exitosamente.
- Método de verificación: Prueba.
- Información adicional: El código del producto deberá permanecer inmutable por razones de integridad.

##### REQ-FUNC-006
- Título: Visualizar listado de productos
- Enunciado: El sistema deberá permitir visualizar un listado de los productos registrados.
- Justificación: La visualización del listado de productos es necesaria para que el usuario pueda consultar de manera general los productos disponibles en el sistema y facilitar su identificación durante las operaciones del inventario.
- Criterios de aceptación:
    - CA-1: El sistema deberá mostrar un listado con los productos previamente registrados.
    - CA-2: El listado deberá presentar información suficiente para identificar cada producto, como mínimo su código y nombre.
    - CA-3: El sistema deberá permitir acceder al listado únicamente a usuarios con sesión iniciada.
    - CA-4: Cuando no existan productos registrados, el sistema deberá informar al usuario que no hay datos disponibles.
    - CA-5: La información mostrada en el listado deberá corresponder a los registros almacenados en el sistema y reflejar los cambios realizados sobre los productos.
- Método de verificación: Prueba.

##### REQ-FUNC-007
- Título: Registrar entrada de inventario
- Enunciado: El sistema deberá permitir registrar una entrada de inventario asociada a un producto con al menos lote, fecha de vencimiento y cantidad.
- Justificación: El registro de entradas de inventario es necesario para incorporar existencias al sistema de forma controlada y mantener actualizado el stock disponible de cada producto. Además, permite asociar cada ingreso con su lote y fecha de vencimiento, lo cual es fundamental para el control operativo del inventario y para reducir riesgos relacionados con productos vencidos o mal identificados.
- Criterios de aceptación:
    - CA-1: El sistema deberá permitir seleccionar un producto previamente registrado para asociarle una entrada de inventario.
    - CA-2: El sistema deberá permitir ingresar como mínimo el lote, la fecha de vencimiento y la cantidad correspondiente a la entrada.
    - CA-3: El sistema deberá registrar la entrada únicamente cuando se hayan diligenciado todos los datos obligatorios.
    - CA-4: El sistema deberá almacenar correctamente la información de la entrada asociándola al producto seleccionado.
    - CA-5: Una vez registrada la entrada, el sistema deberá actualizar el stock disponible del producto correspondiente.
    - CA-6: El sistema deberá mostrar un mensaje de confirmación cuando la entrada de inventario sea registrada exitosamente.
- Método de verificación: Prueba.

##### REQ-FUNC-008
- Título: Validar cantidad positiva en entrada
- Enunciado: El sistema deberá impedir el registro de entradas con cantidades menores o iguales a cero.
- Justificación: La validación de cantidades positivas en las entradas de inventario es necesaria para garantizar la integridad de los datos almacenados y evitar inconsistencias en el cálculo del stock disponible. Permitir valores cero o negativos podría generar registros inválidos que afectarían la confiabilidad del inventario y las operaciones posteriores de consulta y venta.
- Criterios de aceptación:
    - CA-1: El sistema deberá permitir registrar entradas de inventario únicamente cuando la cantidad ingresada sea mayor que cero.
    - CA-2: Si el usuario ingresa una cantidad menor o igual a cero, el sistema deberá impedir el registro de la entrada.
    - CA-3: Cuando se detecte una cantidad inválida, el sistema deberá mostrar un mensaje informando que la cantidad debe ser mayor que cero.
    - CA-4: El sistema no deberá almacenar registros de entrada con cantidades menores o iguales a cero.
- Método de verificación: Prueba.

##### REQ-FUNC-009
- Título: Buscar producto para venta
- Enunciado: El sistema deberá permitir buscar un producto antes de registrar una venta.
- Justificación: La búsqueda de productos antes de registrar una venta es necesaria para identificar de forma precisa el producto sobre el cual se realizará la operación, reducir errores de selección y asegurar que la salida de inventario se aplique al artículo correcto.
- Criterios de aceptación:
    - CA-1: El sistema deberá permitir al usuario buscar un producto antes de iniciar el registro de una venta.
    - CA-2: El sistema deberá permitir localizar el producto mediante criterios de identificación definidos para el sistema, como código o nombre.
    - CA-3: Cuando exista coincidencia, el sistema deberá mostrar el producto encontrado con información suficiente (nombre, código y stock) para su identificación.
    - CA-4: Cuando no exista coincidencia, el sistema deberá informar al usuario que no se encontraron productos para el criterio ingresado. 
    - CA-5: El sistema deberá permitir continuar con el registro de la venta únicamente después de seleccionar un producto válido.
- Método de verificación: Prueba.

##### REQ-FUNC-010
- Título: Registrar cantidad de venta
- Enunciado: El sistema deberá permitir ingresar la cantidad de unidades a vender de un producto seleccionado.
- Justificación: El registro de la cantidad de unidades a vender es necesario para ejecutar correctamente la operación de salida de inventario asociada a una venta. Este dato permite calcular la reducción del stock disponible del producto y mantener actualizada la información del inventario, asegurando la coherencia entre las operaciones de venta y las existencias registradas.
- Criterios de aceptación:
    - CA-1: El sistema deberá permitir ingresar la cantidad de unidades a vender después de seleccionar un producto.
    - CA-2: El sistema deberá registrar la cantidad ingresada como parte del proceso de venta.
    - CA-3: El sistema deberá permitir continuar con el proceso de venta únicamente cuando se haya ingresado una cantidad válida mayor de cero.
    - CA-4: El sistema deberá mostrar al usuario la cantidad registrada antes de confirmar la venta.
    - CA-5: El sistema deberá almacenar correctamente la cantidad de unidades vendidas una vez la operación sea confirmada.
- Método de verificación: Prueba.

##### REQ-FUNC-011
- Título: Validar cantidad positiva en venta
- Enunciado: El sistema deberá impedir registrar ventas con cantidades menores o iguales a cero.
- Justificación: La validación de cantidades positivas en las ventas es necesaria para asegurar la integridad de los registros de inventario y evitar inconsistencias en el cálculo del stock disponible. Permitir valores cero o negativos podría generar movimientos inválidos de salida que afecten la confiabilidad de la información almacenada y el control del inventario.
- Criterios de aceptación:
    - CA-1: El sistema deberá permitir registrar ventas únicamente cuando la cantidad ingresada sea mayor que cero.
    - CA-2: Si el usuario ingresa una cantidad menor o igual a cero, el sistema deberá impedir el registro de la venta.
    - CA-3: Cuando se detecte una cantidad inválida, el sistema deberá mostrar un mensaje informando que la cantidad debe ser mayor que cero.
    - CA-4: El sistema no deberá registrar ni almacenar ventas con cantidades menores o iguales a cero.
- Método de verificación: Prueba.

##### REQ-FUNC-012
- Título: Validar disponibilidad de stock para venta
- Enunciado: El sistema deberá verificar que exista stock suficiente antes de confirmar una venta.
- Justificación: La validación de disponibilidad de stock antes de confirmar una venta es necesaria para evitar salidas de inventario no respaldadas por existencias reales, preservar la integridad del inventario y asegurar que la operación comercial se realice sobre información confiable. Esta regla es crítica para prevenir sobreventas y mantener coherencia entre las ventas registradas y el stock disponible.
- Criterios de aceptación:
    - CA-1: El sistema deberá consultar el stock disponible del producto seleccionado antes de confirmar la venta.
    - CA-2: El sistema deberá permitir confirmar la venta únicamente cuando la cantidad solicitada sea menor o igual al stock disponible.
    - CA-3: Si la cantidad solicitada supera el stock disponible, el sistema deberá impedir la confirmación de la venta.
    - CA-4: Cuando no exista stock suficiente, el sistema deberá informar al usuario que la cantidad solicitada excede la disponibilidad actual.
    - CA-5: El sistema no deberá descontar inventario ni registrar la venta cuando la validación de stock resulte negativa.
- Método de verificación: Prueba.
- Información adicional: El stock disponible es la suma de existencias vigentes registradas para un producto.

##### REQ-FUNC-013
- Título: Descuento de inventario por lote próximo a vencer
- Enunciado: El sistema deberá descontar las unidades vendidas del lote del producto cuya fecha de vencimiento sea la más próxima.
- Justificación: Garantizar la rotación adecuada de inventarios y reducir el riesgo de vencimiento de productos, asegurando que los productos con menor tiempo de vida útil disponible sean despachados primero.
- Criterios de aceptación:
    - CA-1: Dado un producto con múltiples lotes disponibles, el sistema deberá identificar el lote cuya fecha de vencimiento sea la más próxima.
    - CA-2: Al registrar una venta, el sistema deberá descontar la cantidad solicitada del lote identificado con la fecha de vencimiento más próxima.
    - CA-3: Si el lote con fecha de vencimiento más próxima no dispone de cantidad suficiente para cubrir la venta, el sistema deberá continuar descontando del siguiente lote con fecha de vencimiento más próxima hasta completar la cantidad solicitada.
    - CA-4: El sistema deberá actualizar el stock por lote y el stock total del producto después de realizar el descuento.
- Método de verificación: Prueba
- Información adicional: Esta regla sigue el principio de rotación FEFO.

##### REQ-FUNC-014
- Título: Registrar venta
- Enunciado: El sistema deberá permitir registrar una venta de un producto cuando exista disponibilidad suficiente.
- Justificación: El registro de ventas es necesario para formalizar la salida de productos del inventario y reflejar de manera controlada las operaciones comerciales realizadas en el sistema.
- Criterios de aceptación:
    - CA-1: El sistema deberá permitir registrar una venta únicamente sobre un producto previamente seleccionado.
    - CA-2: El sistema deberá permitir confirmar la venta solo cuando la cantidad solicitada haya sido ingresada y exista disponibilidad suficiente en inventario.
    - CA-3: Una vez confirmada la venta, el sistema deberá almacenar el registro de la operación.
    - CA-4: El sistema deberá asociar la venta al producto correspondiente y a la cantidad vendida.
    - CA-5: El sistema deberá mostrar un mensaje de confirmación cuando la venta sea registrada exitosamente.
- Método de verificación: Prueba.

##### REQ-FUNC-015
- Título: Actualizar stock posterior a la venta
- Enunciado: El sistema deberá reflejar el nuevo stock disponible inmediatamente después del registro exitoso de la venta.
- Justificación: La actualización inmediata del stock después de una venta es necesaria para mantener la consistencia del inventario y asegurar que las consultas posteriores reflejen la disponibilidad real de los productos.
- Criterios de aceptación:
    - CA-1: Una vez registrada exitosamente una venta, el sistema deberá descontar del stock disponible la cantidad vendida.
    - CA-2: El sistema deberá recalcular y almacenar el nuevo stock del producto afectado.
    - CA-3: El sistema deberá mostrar el stock actualizado en las consultas posteriores del producto.
    - CA-4: El sistema no deberá modificar el stock si la venta no fue confirmada o si su registro falló.
    - CA-5: La cantidad descontada del stock deberá corresponder exactamente a la cantidad registrada en la venta.
- Método de verificación: Prueba.

##### REQ-FUNC-016
- Título: Consultar stock por producto
- Enunciado: El sistema deberá permitir consultar el stock disponible de un producto.
- Justificación: La consulta de stock por producto es necesaria para que el usuario conozca la disponibilidad actual de inventario antes de realizar operaciones como ventas, verificaciones o control operativo. Este requisito contribuye a la toma de decisiones basada en información actualizada y reduce el riesgo de errores derivados del desconocimiento de las existencias reales.
- Criterios de aceptación:
    - CA-1: El sistema deberá permitir seleccionar o buscar un producto para consultar su stock.
    - CA-2: El sistema deberá mostrar la cantidad disponible asociada al producto consultado.
    - CA-3: La información presentada deberá corresponder al stock actualizado del producto al momento de la consulta.
    - CA-4: Si el producto no registra existencias, el sistema deberá mostrar stock igual a cero o un mensaje equivalente que indique ausencia de disponibilidad.
    - CA-5: Si el producto no existe en el sistema, el sistema deberá informar al usuario que no se encontró información para la consulta realizada.
- Método de verificación: Prueba.
- Información adicional: El stock que se visualizará será únicamente de la cantidad total por producto.

##### REQ-FUNC-017
- Título: Visualizar stock por lote
- Enunciado: El sistema deberá permitir visualizar las existencias disponibles discriminadas por lote.
- Justificación: La visualización del stock por lote es necesaria para identificar con precisión cómo se distribuyen las existencias de un producto dentro del inventario. Esto permite un mejor control operativo, facilita la gestión de productos con diferentes fechas de vencimiento y reduce el riesgo de errores en la consulta y uso de existencias.
- Criterios de aceptación:
    - CA-1: El sistema deberá mostrar las existencias disponibles de un producto separadas por lote.
    - CA-2: Para cada lote visualizado, el sistema deberá presentar como mínimo el identificador del lote, la cantidad disponible y fecha de vencimiento.
    - CA-3: La información mostrada deberá corresponder a los registros actualizados del inventario al momento de la consulta.
    - CA-4: Si un producto no tiene lotes con existencias registradas, el sistema deberá informar que no existen datos disponibles para ese producto.
- Método de verificación: Prueba.

### 3.2 Requisitos no funcionales

##### REQ-NO-FUNC-001
- Título: Consistencia visual
- Enunciado: El sistema deberá mantener una estructura visual uniforme en formularios, botones, mensajes y pantallas.
- Justificación: La consistencia visual mejora la usabilidad del sistema, reduce la curva de aprendizaje del usuario y disminuye errores operativos al mantener patrones de interacción homogéneos en todas las funcionalidades
- Criterios de aceptación: 
    - CA-1: El sistema deberá usar una misma línea visual en al menos el 100 % de las pantallas para botones, campos de entrada, títulos, mensajes y tablas.
    - CA-2: Los botones con la misma función deberán conservar la misma etiqueta y comportamiento en todas las pantallas.
    - CA-3: Los mensajes de confirmación, advertencia y error deberán presentarse con formato uniforme en el 100 % de los casos evaluados.
    - CA-4: Los formularios del sistema deberán mantener una estructura homogénea de etiquetas, alineación y disposición de campos en al menos el 90 % de los formularios revisados.
- Método de verificación: Inspección.

##### REQ-NO-FUNC-002
- Título: Tiempo de respuesta en consultas
- Enunciado: El sistema deberá responder las consultas de productos y stock en un tiempo no mayor a cinco segundos para no afectar la operación normal del usuario.
- Justificación: Un tiempo de respuesta bajo en consultas mejora la eficiencia operativa y permite que el usuario tome decisiones con agilidad durante las tareas diarias del inventario.
- Criterios de aceptación:
    - CA-1: El sistema deberá responder las consultas de productos y stock en un tiempo máximo de 2 segundos, medido desde el envío de la solicitud hasta la visualización del resultado.
    - CA-2: En al menos el 95 % de las consultas ejecutadas, el tiempo de respuesta no deberá superar los 2 segundos.
    - CA-3: En ningún caso el tiempo de respuesta de una consulta deberá superar los 5 segundos.
- Método de verificación: Prueba.

##### REQ-NO-FUNC-003
- Título: Tiempo de respuesta en registros
- Enunciado: El sistema deberá procesar el registro de productos, entradas y ventas en un tiempo adecuado para la operación diaria.
- Justificación: El registro oportuno de operaciones evita demoras en la atención del usuario, mejora la productividad y reduce el riesgo de errores por repetición o interrupción de tareas.
- Criterios de aceptación:
    - CA-1: El sistema deberá completar el registro de productos, entradas y ventas en un tiempo máximo de 3 segundos por operación.
    - CA-2: En al menos el 95 % de los registros ejecutados, el tiempo de procesamiento no deberá superar los 3 segundos.
    - CA-3: En ningún caso una operación de registro deberá superar los 6 segundos.
- Método de verificación: Prueba.

##### REQ-NO-FUNC-004
- Título: Desempeño bajo carga operativa básica
- Enunciado: El sistema deberá mantener un desempeño estable bajo la carga operativa esperada.
- Justificación: El sistema debe conservar un comportamiento estable para garantizar continuidad operativa y evitar degradación severa cuando varios usuarios ejecuten operaciones simultáneamente.
- Criterios de aceptación:
    - CA-1: El sistema deberá soportar al menos 20 usuarios concurrentes ejecutando consultas y registros básicos sin fallos críticos.
    - CA-2: Bajo esa carga, el tiempo de respuesta promedio en consultas no deberá superar los 4 segundos.
    - CA-3: Bajo esa carga, el tiempo de respuesta promedio en registros no deberá superar los 5 segundos.
    - CA-4: La tasa de error del sistema bajo carga básica no deberá ser superior al 2 % de las solicitudes ejecutadas.
- Método de verificación: Prueba.

##### REQ-NO-FUNC-005
- Título: Disponibilidad operativa
- Enunciado: El sistema deberá estar disponible durante el horario operativo definido.
- Justificación: La disponibilidad del sistema es necesaria para asegurar que las operaciones de inventario y venta puedan ejecutarse cuando la organización lo requiera, evitando interrupciones que afecten la operación.
- Criterios de aceptación:
    - CA-1: El sistema deberá estar disponible al menos el 98 % del tiempo durante el horario operativo establecido.
    - CA-2: El horario operativo del sistema se definirá entre las 6:00 a. m. y 10:00 p. m., de lunes a sábado.
- Método de verificación: Análisis.

##### REQ-NO-FUNC-006
- Título: Tolerancia básica a fallos
- Enunciado: El sistema deberá manejar fallos no críticos sin comprometer la integridad de la información ya registrada.
- Justificación: El manejo adecuado de fallos no críticos protege la información persistida y evita que errores menores deriven en corrupción de datos o pérdida de operaciones válidas.
- Criterios de aceptación:
    - CA-1: Ante un fallo no crítico en interfaz o validación, el sistema no deberá alterar ni eliminar información previamente confirmada.
    - CA-2: El sistema deberá conservar el 100 % de los registros ya almacenados correctamente antes del fallo.
    - CA-3: Cuando ocurra un fallo no crítico, el sistema deberá informar al usuario lo sucedido sin cerrar abruptamente la sesión, salvo que el tipo de error lo exija por seguridad.
    - CA-4: Las operaciones incompletas no deberán generar registros parciales inconsistentes en la base de datos.
- Método de verificación: Prueba.

##### REQ-NO-FUNC-007
- Título: Manejo seguro de errores
- Enunciado: El sistema no deberá exponer información técnica sensible en los mensajes de error presentados al usuario final.
- Justificación: Ocultar detalles técnicos internos reduce riesgos de seguridad, evita confusión en los usuarios y protege la arquitectura y configuración interna del sistema.
- Criterios de aceptación:
    - CA-1: El sistema no deberá mostrar al usuario final trazas de error, sentencias SQL, rutas internas del servidor ni detalles de configuración en el 100 % de los errores evaluados.
    - CA-2: Todo error visible para el usuario deberá presentarse en lenguaje comprensible y orientado a la acción.
- Método de verificación: Inspección.
- Información adicional:

##### REQ-NO-FUNC-008
- Título: Unicidad del código de producto
- Enunciado: El sistema deberá garantizar la unicidad del código asignado a cada producto.
- Justificación: La unicidad del código del producto es esencial para asegurar identificación inequívoca, evitar duplicidades y mantener consistencia en las operaciones de inventario.
- Criterios de aceptación:
    - CA-1: El sistema deberá impedir que existan dos o más productos con el mismo código.
    - CA-2: En el 100 % de los intentos de registro o actualización evaluados, el sistema deberá rechazar códigos duplicados.
- Método de verificación: Inspección.

##### REQ-NO-FUNC-009
- Título: Integridad referencial
- Enunciado: El sistema deberá garantizar integridad referencial entre productos y lotes almacenados.
- Justificación: La integridad referencial asegura coherencia estructural entre las entidades del sistema y evita registros huérfanos o relaciones inconsistentes que comprometan la confiabilidad del inventario.
- Criterios de aceptación:
    - CA-1: El sistema no deberá permitir registrar lotes asociados a productos inexistentes.
- Método de verificación: Inspección.

##### REQ-NO-FUNC-010
- Título: Modularidad
- Enunciado: El sistema deberá organizar sus funcionalidades en módulos o componentes coherentes.
- Justificación: La modularidad favorece el mantenimiento, la comprensión del sistema, la reutilización de componentes y la posibilidad de evolución funcional controlada.
- Criterios de aceptación:
    - CA-1: El sistema deberá organizar sus funcionalidades al menos en módulos coherentes de autenticación, productos, inventario y ventas.
    - CA-2: Cada módulo deberá agrupar responsabilidades relacionadas y evitar mezclar funcionalidades no afines.
    - CA-3: En el 100 % de los componentes inspeccionados, deberá identificarse de manera clara el módulo funcional al que pertenecen.
    - CA-4: Los cambios en un módulo no deberán requerir modificaciones directas en módulos no relacionados, salvo dependencias justificadas por diseño.
- Método de verificación: Inspección.

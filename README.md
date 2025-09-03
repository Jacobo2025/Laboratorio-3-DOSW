# Laboratorio-3-DOSW



# Reto 1
## Identifiquen reglas de negocio.
- Los números de cuenta deben tener exactamente 10 dígitos.
- Solo es válido si los dos primeros dígitos corresponden a un banco registrado.
- Cada cuenta no debe tener letras ni caracteres especiales.
## Definan las funcionalidades principales.
- Crear cuenta como cliente y validarla.
- Permitir consultas del saldo de una cuenta.
- Hacer un depósito.
## Escriban los actores principales

- Cliente : titular de la cuenta que crea su cuenta, consulta saldo y realiza depósitos.

- Operador de Soporte: administra datos maestros (p. ej., mantenimiento del catálogo de bancos si se gestiona internamente) y atiende casos excepcionales.
## Documenten las precondiciones necesarias para el sistema. 

### Generales (de negocio)

- Formato de número de cuenta válido: exactamente 10 dígitos numéricos, sin letras ni caracteres especiales.

- Banco registrado: los dos primeros dígitos del número de cuenta corresponden a un banco válido en el catálogo.

- Cuenta existente y activa: para consultar saldo o realizar depósitos, la cuenta debe existir en el sistema y estar activa.

- Montos válidos en depósitos: el importe a depositar debe ser numérico y mayor que cero.

- Integridad de datos del cliente: la información mínima del cliente (p. ej., identificación) está registrada y validada antes de crear la cuenta.

### Específicas por funcionalidad

#### Crear cuenta:

- Se verificó el formato del número (10 dígitos) y el código de banco en el catálogo.

#### Consultar saldo:

- La cuenta existe y pasó las validaciones de formato.

#### Realizar depósito:

- La cuenta existe; el monto es positivo y procesable.

# RETO 2
## Realicen un diagrama de contexto de la solución (relaciones entre el sistema y los actores identificados) y explíquenlo.
![imagen11.png](docs%2Fimagenes%2Fimagen11.png)

## Realicen un diagrama de Casos de uso en base a sus actores y las funcionalidades identificadas.
![diagramaDeCasosDeUso.png](docs/uml/diagramaDeCasosDeUso.png)
## En base al diagrama anterior generen historias de usuario basado en el formato: Como [actor], quiero [objetivo], para [beneficio]
- COMO usuario QUIERO crear una cuenta PARA PODER depositar mi dinero.
- COMO usuario QUIERO consultar mi cuenta PARA PODER revisar la cantidad de dinero que poseo
- COMO usuario QUIERO realizar un depósito PARA PODER guardar mi dinero en mi cuenta.
- COMO operador de soporte QUIERO actualizar catálogo de bancos PARA PODER tener más bancos asociados con el sistema.
## Generen una tabla de Excel con las historias de usuario creadas e indique para cada una que atributo de calidad resuelve.
![excel.png](docs/imagenes/excel.png)
## Realicen un diagrama de Clases de las entidades identificadas en el enunciado. 
![diagramaDeClasesActualizado.png](docs/uml/diagramaDeClasesActualizado.png)

# RETO 3

Este proyecto es una simulación de una sesión de Planning Poker en donde un equipo de desarrolladores discuten el nivel de dificultad de una tarea. Todas las partes tienen que estar de acuerdo con el puntaje de la tarea o sino se repetirá hasta llegar a un consenso.

- El puntaje válido es 1, 2, 3, 5, 8 o 13.
- Si la tarea recibe el mismo puntaje, se asigna ese puntaje.
- Si los integrantes del equipo asignan diferentes puntajes a una tarea, entonces se repetirá la votación.
- Al finalizar, se muestra un resumen que muestra el nombre de la tarea y su respetivo puntaje.
- 
### Implementación del código
![imagen1.png](docs/imagenes/imagen1.png)
![imagen2.png](docs/imagenes/imagen2.png)
![imagen3.png](docs/imagenes/imagen3.png)
### ¿Cómo funciona?
- El contructor recibe como parámetros el número de tareas y el número de integrantes del equipo. Después el programa pregunta por el nombre de la tarea. 
Luego se le pedirá a cada integrante que vote por la tarea. El código revisa que todo esté en orden, es decir, que el puntaje cumpla con los requisitos y
 que una tarea haya recibido el mismo puntaje. Por último imprime el nombre de la tarea junto a su puntaje.
### Simulación
- A continuación se simulará el caso en que hay 3 integrantes y dos tareas.
![imagen4.png](docs/imagenes/imagen4.png)
![imagen5.png](docs/imagenes/imagen5.png)

## Principios y Patrones Utilizados
- SRP: Cada método cumple un rol específico (votacion, verificarPuntaje, isVotoCorrecto).
- Validación de entradas: Se asegura que los votos siempre sean parte de la secuencia de Fibonacci antes de aceptarlos.
- Uso de Colecciones Java: HashMap para almacenar tareas y su puntaje final, ArrayList para gestionar votos de los integrantes y Set para valores válidos permitidos.
- DRY: La validación de votos está centralizada en isVotoCorrecto, evitando duplicar lógica.

# RETO 4

## Codigo fuente de las clases e implementacion
- srs/main/java/edu.dosw.lab/agilismo/reto4
- Banco.java
- Cliente.java
- CuentaBancaria.java
- GestorCuenta.java
## Codigo fuente de las clases de prueba
- srs/test/java/edu.dosw.lab/agilismo/reto4
- BancoTest.java
- ClienteTest.java
- CuentaBancariaTest.java
- GestorCuentaTest.java

## Evidencia de pruebas 

![prueba](docs/imagenes/pruebasDeReto4.png)

## Explicacion y que principios de patrones fueros usados

- TDD (Test-Driven Development):
Se implementaron primero las pruebas (Rojo), luego las clases hasta que pasaron (Verde) y finalmente se refactorizó el código.

- Principio de Responsabilidad Única (SRP – SOLID):
Banco solo gestiona información de banco.
Cliente solo modela un cliente.
CuentaBancaria encapsula lógica de validación y depósitos.
GestorCuenta coordina operaciones de cuentas (creación, búsqueda, depósitos, consultas).

- Patrón Facade (simplificación de operaciones):
GestorCuenta actúa como una fachada para centralizar operaciones sobre cuentas, ocultando la complejidad de validaciones.

- Uso de Streams y Lambdas:
Para buscar cuentas, calcular saldos totales y filtrar información de clientes (filter, mapToInt, collect).

- Principio Fail Fast:
El código lanza excepciones (IllegalArgumentException) cuando se detectan datos inválidos (ej. depósitos negativos, cuentas duplicadas).

- Encapsulamiento y Abstracción:
Atributos privados con getters, validaciones en constructores y métodos, garantizando integridad de datos.
# RETO 5
### pom.xml compilado:
![imagen6.png](docs/imagenes/imagen6.png)
![imagen7.png](docs/imagenes/imagen7.png)
### index.html:
![imagen8.png](docs/imagenes/imagen8.png)
- Cobertura de Instrucciones: 87%
- Cobertura de Ramas: 84%
### Reflexión:
Para mejorar nuestra cobertura tuvimos que crear dos nuevas pruebas en la clase GestorCuentaTest.
![imagen9.png](docs/imagenes/imagen9.png)
Estas nuevas pruebas ayudaron a subir el nivel de cobertura de nuestro proyecto.
![imagen10.png](docs/imagenes/imagen10.png)
JaCoCo nos permitió saber cuales escenarios no estaban cubiertos y eso nos ayudó a identificar qué pruebas nos hacian falta
para lograr que nuestro proyecto alcanzara las rúbricas mínimas que se nos pedían. Pasamos de un 84% en la cobertura de la rama
a un 87%.
# RETO 6 – Análisis Estático con SonarLint

Se utilizó el plugin **SonarLint (SonarQube for IDE)** en IntelliJ IDEA para realizar el análisis estático del código del proyecto Bankify.

###  Evidencia
![sonarQubeReto6](docs/imagenes/sonarQubereto6.png)

El análisis detectó:
- 17 issues en 4 archivos.
- Problemas de nombres de variables que ocultaban atributos.
- Uso innecesario del modificador `public` en pruebas.
- Recomendación de usar `assertEquals` en lugar de otras aserciones.

###  Reflexiones de los Integrantes
- Juan Silva: El análisis estático ayuda a identificar problemas antes de ejecutar el programa, reduciendo riesgos y errores en producción.
- Jacobo Diaz: El uso de esta herramienta de análisis estático es fundamental para mantener la calidad del código desde las primeras etapas del desarrollo. Permite detectar problemas comunes y malas prácticas.
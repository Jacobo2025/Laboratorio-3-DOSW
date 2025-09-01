# Laboratorio-3-DOSW

## preguntas parte 1 punto 12:



### ¿Cuál es la diferencia principal entre una prueba unitaria y una prueba de integración E2E?

Prueba unitaria:

Verifica el funcionamiento de una unidad mínima de código (por ejemplo, un método o clase).

Se aísla de dependencias externas (base de datos, red, servicios).

Busca asegurar que la lógica interna sea correcta.

Ejemplo: comprobar que una función sumar(2,3) devuelve 5.

Prueba de integración/E2E (end-to-end):

Verifica que todo el sistema funcione de extremo a extremo.

Incluye interacción entre múltiples módulos y dependencias (base de datos, APIs, frontend, backend).

Se asemeja al flujo real del usuario.

Ejemplo: en una app de e-commerce, simular que el usuario agrega un producto al carrito, paga y recibe confirmación.

### En Scrum ¿Cuál es el propósito de la Sprint Retrospective y porque es crucial para la mejora continua del equipo?
Es una reunión que ocurre al final de cada Sprint.

Objetivo: que el equipo reflexione sobre:

Qué salió bien.

Qué problemas se encontraron.

Qué se puede mejorar en el próximo Sprint.

Es crucial porque:

Promueve la mejora continua.

Fomenta la colaboración y transparencia.

Permite ajustar procesos, herramientas y dinámicas del equipo para mejorar la productividad y satisfacción.

### Explique la diferencia entre una Épica, una Feature y una historia de Usuario. Proporcione un ejemplo de cada una si tenemos un sistema de streaming de video como lo es Netflix.

Épica:

Es una iniciativa grande, de alto nivel, que puede abarcar varios sprints.

Generalmente se descompone en features o historias de usuario.

Ejemplo (Netflix): “Permitir a los usuarios consumir contenido en múltiples dispositivos”.

Feature:

Una funcionalidad específica dentro de la épica, pero aún algo amplia.

Ejemplo (Netflix): “Soporte para perfiles individuales dentro de una cuenta”.

Historia de Usuario:

Es la unidad más pequeña, centrada en la necesidad de un usuario.

Se redacta en formato: Como [rol], quiero [acción] para [beneficio].

Ejemplo (Netflix): “Como usuario, quiero poder crear un perfil personalizado para guardar mis series y recomendaciones”.

### ¿Qué es una cobertura de Código (code coverage) y porque una cobertura del 100% no garantiza necesariamente que el software esté libre de errores? 

Es una métrica que indica qué porcentaje del código ha sido ejecutado por las pruebas.

Tipos:

Line coverage: líneas ejecutadas.

Branch coverage: ramas de decisión evaluadas.

Method/Class coverage: métodos/clases probados.

Por qué 100% de cobertura ≠ software libre de errores:

Cobertura solo indica que el código fue ejecutado, no que fue probado con casos correctos.

Ejemplo: un test puede ejecutar una función sin validar correctamente el resultado.

Puede faltar probar casos límite, errores de concurrencia, problemas de integración, etc.

### Describa que es un Diagrama de Casos de Uso y que elementos lo componen. ¿Para qué sirve en la fase de análisis de requerimientos? 

### ¿Cuál es la diferencia entre el uso de Junit y Jacoco en un proyecto, y como complementa SonarQube este proceso en términos de calidad de software?
### ¿Qué ventajas tiene el uso de Planning Poker frente a otros métodos de estimación tradicional y como ayuda a mejorar la transparencia y compromiso del equipo?
### Menciona los valores de Scrum y explica cual consideras más difícil de aplicar en un equipo. 



# Reto 1
## Identifiquen reglas de negocio.
- Los números de cuenta deben tener exactamente 10 dígitos.
- Cada cuenta no debe tener letras ni caracteres especiales.
## Definan las funcionalidades principales.
- Crear cuenta como cliente y validarla.
- Permitir consultas del saldo de una cuenta.
- Hacer un depósito.
## Escriban los actores principales
## Documenten las precondiciones necesarias para el sistema. 
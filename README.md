# Procesador de Planillas
Cuando se obtienen los empleados de la planilla, el procesador debe sumar el pago mensual de cada empleado si este está activo y devolver el total como resultado.

## Java Version: 17

## Como Ejecutar

  Presionar  RUN en la clase **PlanillasApplication.**

  ![image](https://github.com/daRios07/ProcesadorPlanillas/assets/123895702/b612db8c-74c1-44b0-8524-beec4dc61d3d)


## Correr pruebas unitarias

la clase Config.java debe estár así:

![image](https://github.com/daRios07/ProcesadorPlanillas/assets/123895702/9a16127f-c762-4c2f-a0fd-073c33911ed1)


Presionar el boton Run Test en la clase **ProcesadorPlanillasTest**

![image](https://github.com/daRios07/ProcesadorPlanillas/assets/123895702/924ea5f0-9807-41b3-8568-505f82faa8c3)


## Pruebas con Postman
en la clase config.java  comentar el método **proveedorMiembrosPlanilla**
y quitar el comentario en el método **proveedorMiembrosPlanillaRest**.
![image](https://github.com/daRios07/ProcesadorPlanillas/assets/123895702/a0c4c4ce-b343-466c-921a-3c46fbc716b3)


Ejecutar la aplicación 

crear un request con método Get y el siguiente endpoint
**localhost:8080/planillas/v1/planilla**

![image](https://github.com/daRios07/ProcesadorPlanillas/assets/123895702/099caf96-f5ab-4b1d-961f-bdfa48e55243)


## Diferentes implementaciones del proveedor de planilla

- Crear una nueva Implementación que herede de ProveedorMiembrosPlanilla y que implemente el método getEmpleados
- Decorator??
- colas de mensajería?? 







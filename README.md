poolobject
==========

[![Java CI](https://github.com/Sermare16/poolobject/actions/workflows/ci_jdk11_build.yml/badge.svg)](https://github.com/Sermare16/poolobject/actions/workflows/ci_jdk11_build.yml) 
[![Java CI](https://github.com/Sermare16/poolobject/actions/workflows/ci_jdk1.8_build_test.yml/badge.svg)](https://github.com/Sermare16/poolobject/actions/workflows/ci_jdk1.8_build_test.yml) 
[![codecov](https://codecov.io/gh/Sermare16/poolobject/graph/badge.svg?token=NvQ17D5kct)](https://codecov.io/gh/Sermare16/poolobject)

Java code example of creational design pattern pool object

Workshop to use good practices in software development: testing, ci and measurement.

Authors:

- Carlos Lopez Nozal
- Jesus Alonso Abad
- Sergio Martín Reizábal
- Javier Pampliega García

# **INDICE**
-   [Introducción](#introducción)
-   [Objetivos](#objetivos)
-   [Preguntas](#preguntas)
    -   [¿Se ha realizado trabajo en equipo?](#¿se-ha-realizado-trabajo-en-equipo)
    -   [¿Tiene calidad el conjunto de pruebas disponibles?](#¿tiene-calidad-el-conjunto-de-pruebas-disponibles)
    -   [¿Cuál es el esfuerzo invertido en realizar la actividad?](#¿cuál-es-el-esfuerzo-invertido-en-realizar-la-actividad)
    -   [¿Cuál es el número de fallos encontrados en el código original?](#¿cuál-es-el-número-de-fallos-encontrados-en-el-código-original)
    -   [¿El proceso de integración continua realizado ha sido de calidad?](#¿el-proceso-de-integración-continua-realizado-ha-sido-de-calidad)

# **Introducción**
En esta practica el objetivo ha sido la creacion de pruebas unitarias, asi como, la implementacion de un sistema de integración continua empleando la herramienta GitHub Actions. Se ha empleado como herramienta de medición de calidad basada en el cubrimiento de código, la herramienta Codecov.

# **Objetivos**
-   Comprender los objetivos de medición relacionados con la caracterización y la evaluación de productos, procesos y recursos software.
-   Comprender, aplicar y analizar técnicas de medición sobre entidades de productos software relacionados con conjuntos de pruebas de software.
-   Comprender, aplicar y analizar medidas relacionadas sobre entidades de proceso y recursos de prueba del software.

# **Solución**
Se ha realizado un fork al repositorio proporcionado: 

# **Preguntas**

## **¿Se ha realizado trabajo en equipo?**
Si, se ha realizado el trabajo en equipo. Esto se puede comprobar accediendo al historial de commits del propio repositorio. Entre ambos compañeros se han realizado las distintas tareas solicitadas. Ademas, la implementación de los tests se han hecho de forma conjunta y consultando las ideas a implementar entre ambos.
A continuacion se adjunta una imagen con la grafica de commits:
![Gráfica de commits](img/graficaCommits.png)

## **¿Tiene calidad el conjunto de pruebas disponibles?**
Si, el conjunto de pruebas disponibles tiene calidad. Para entender esto, se va a definir el concepto cobertura de codigo: se define como una metrica empleada en pruebas software que nos permite medir el grado en el que el codigo fuente de un producto software ha sido probado. Teniendo en cuenta el concepto anterior, podemos decir que el codigo fuente de nuestro producto cuenta con un 69% de cobertura según la herramienta Codecov. Si accedemos a los informes que nos proporciona dicha herramienta, podremos observar en porfundidad que partes de nuestro proyecto se encuentran cubiertas. A continuacion se adjuntan imagenes de los resultados:

![Cobertura del src](img/codecovCoverage.png)

Se puede profundizar mas consultando el codigo fuente. En el src de nuestro proyecto contamos con dos carpetas: main y test. En el main contamos con las distintas clases que componen el producto software, dichas clases tienen que ser probadas en pruebas unitarias con el fin de comprobar si sus funcionalidades actuarian de forma correcta cuando se requiriesen de ellas. Es por ello, que usando Codecov podemos comprobar la cobertura que le proporcionamos a estas clases. En nuestro caso la cobertura quedaria de la siguiente forma:

![Cobertura main](img/mainCoverage.png)

Se debe de tener en cuenta que se han realizado tests sobre el ReusablePool, asi como, las posibles excepciones que pueden llegar a lanzarse. Es por ello, que al no contemplarse Cliente el porcentaje de cobertura sea mas bajo de lo esperado.

A continuacion, se hara hincapie de como Codecov nos indica si hemos realizado la cobertura del codigo.

![Cobertura realizada](img/coverageHecho.png)

Se puede observar que el codigo aparece remarcado en verde, esto nos quiere decir que esa parte de codigo si que esta siendo cubierta por una prueba unitaria. En cambio, cuando una prueba unitaria no tiene en cuenta una parte del codigo, la remarcara en rojo.

![Cobertura no realizada](img/coverageNoHecho.png)

## **¿Cuál es el esfuerzo invertido en realizar la actividad?**


## **¿Cuál es el número de fallos encontrados en el código original?**


## **¿El proceso de integración continua realizado ha sido de calidad?**


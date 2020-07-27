fun main(args: Array<String>) {
    val colores = mutableListOf("Rojo", "Azul", "Verde", "Naranja", "Amarillo")
    println(colores.filter { it[0] == 'R' })
    val listaMayuscula = colores.filter { it.contains("A") }
    println(listaMayuscula)
    val listaCuatroLetras = colores.filter { it.length == 4 }
    println(listaCuatroLetras)

    println("ListaMayusculas y listaAMinuscula son de tipo List = " + (listaMayuscula is List) + ". Lo que implica cierto consumo de memoria dependiendo de su tamaño.")
    println("Puedes comprobarlo usando el depurador")

    // De esta manera no creas una copia de la lista, sino que ejecutarás el filtro cuando sea necesario.
    // A este tipo de acceso se le denomina lazy
    val lazyMayuscula = colores.asSequence().filter { it.contains("A") }
    println("Escribir la lazyMayuscula solo escribe el puntero, viendose así... " + lazyMayuscula)
    // Sin embargo si puedes acceder a los elementos de manera dinámica.

    println("Accediendo a los elementos de uno en uno si es posible ver los valores")
    lazyMayuscula.forEach {
        print("$it ")
    }
}


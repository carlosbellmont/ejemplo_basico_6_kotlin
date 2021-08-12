fun main() {
    val colores = mutableListOf("Rojo", "Azul", "Verde", "Naranja", "Amarillo")

    println(colores.filter { it[0] == 'R' })
    val listaMayuscula = colores.filter { it.contains("A") }
    println(listaMayuscula)
    val listaCuatroLetras = colores.filter { it.length == 4 }
    println(listaCuatroLetras)

    println("ListaMayusculas y listaAMinuscula son de tipo List =  ${listaMayuscula.javaClass.name}. Lo que implica cierto consumo de memoria dependiendo de su tamaño.")
    println("Puedes comprobarlo usando el depurador")

    // De esta manera no creas una copia de la lista, sino que ejecutarás el filtro cuando sea necesario.
    // A este tipo de acceso se le denomina lazy
    val lazyMayusculaLazy = colores.asSequence().filter { it.contains("A") }
    println("Escribir la lazyMayuscula solo escribe el puntero, viendose así... $lazyMayusculaLazy")
    // Sin embargo si puedes acceder a los elementos de manera dinámica.

    println("Accediendo a los elementos de uno en uno si es posible ver los valores")
    lazyMayusculaLazy.forEach {
        print("$it ")
    }

    println()
    println("Accediendo a los elementos de uno en uno si es posible ver los valores y su posicion")
    lazyMayusculaLazy.forEachIndexed { pos, it ->
        print("$it $pos ")
    }


    val memoriaInicial = getMemoriaUsada()
    println("Actualmente el programa ocupa $memoriaInicial")

    val listLarga = List(100000){ 1L }
    println("Creamos una lista de ${listLarga.size} elementos")

    val memoriaConLista = getMemoriaUsada()
    println("Ahora el programa ocupa $memoriaConLista, ${memoriaConLista - memoriaInicial} bits más")

    val listLarga2 = listLarga.toList()
    println("Copiamos la lista de ${listLarga2.size} elementos")

    val memoriaCopiandoLista = getMemoriaUsada()
    println("Ahora el programa ocupa $memoriaCopiandoLista, ${memoriaCopiandoLista - memoriaInicial} bits más")


    val listLargaLazy = listLarga.asSequence()
    println("Copiamos la lista como una Sequence")

    val memoriaConLazyList = getMemoriaUsada()
    println("Ahora el programa ocupa $memoriaConLazyList, ${memoriaConLazyList - memoriaInicial} bits más")

}


fun getMemoriaUsada() : Long {
    val info = Runtime.getRuntime()
    val freeSize = info.freeMemory()
    val totalSize = info.totalMemory()
    return totalSize - freeSize
}

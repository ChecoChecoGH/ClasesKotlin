fun main() {
    var nombre : String?
    var apellido : String?
    var resp : Char?
    var auxResp : String?
    val charAux : Int = (97..122).random()

    var nombreMascota : String?
    var especie : String?
    var numeroChip : Int?
    var cantidadMascotas : Int

    var mascota : Mascota?
    val listaMascotas : List<Mascota>?

    print("Introducir nombre: ")
    do{ nombre = readLine() }while (nombre.isNullOrEmpty())

    print("Introducir apellido: ")
    do{ apellido = readLine() }while (apellido.isNullOrEmpty())

    val nombreCompleto = NombreCompleto(nombre, apellido)

    print("¿Tiene alguna mascota?(S/N)")
    do{
        do{
            auxResp = readLine()
        }while (auxResp.isNullOrEmpty())
        resp = auxResp[0].toUpperCase()
    }while (resp != 'S' && resp != 'N')


    if (resp == 'S'){
        listaMascotas = mutableListOf()
        println("¿Cuantas mascotas tiene?")
        do{
            do{
                auxResp = readLine()
            }while (auxResp?.toInt() == null)
            cantidadMascotas = auxResp.toInt()
        }while (cantidadMascotas < 1)

        for(i in 1..cantidadMascotas) {
            print("Introducir nombre de la mascota: ")
            do {nombreMascota = readLine()} while (nombreMascota.isNullOrEmpty())
            print("Introducir especie: ")
            do {especie = readLine()} while (especie.isNullOrEmpty())

            numeroChip = (0..10000).random()
            print("Su número de chip es: $numeroChip\n")
            mascota =  Mascota(nombreMascota, especie, numeroChip)
	        listaMascotas.add(mascota)
        }
    }

    val persona = Persona(nombreCompleto, listaMascotas)

    if(persona.listaMascota != null)
        println("${persona.nombreCompleto} si tiene una mascota con los siguientes datos: ${persona.mascota}")
    else
        println("${persona.nombreCompleto} no tiene una mascota")

    persona.setDni((10000000..99999999).random().toString()+charAux.toChar())
    println(persona.getDni())

}

class NombreCompleto(var nombre : String, var apellido : String){
    override fun toString(): String {
        return "$nombre $apellido"
    }
}

class Persona(val nombreCompleto : NombreCompleto, val listaMascota: MutableList<Mascota>){
    private var edad = 18 //no lo utilizo
    private var dni : String? = null

    fun getDni() : String?{
        return dni
    }

    fun setDni(dni: String) {
        if(dni.length == 9 && dni[dni.length-1].isLetter())
            this.dni = dni
        else
            println("El dni no se modifico, debe tener 8 digitos y acabar por una letra")
    }

    override fun toString(): String {
        return "Soy ${nombreCompleto.nombre} ${nombreCompleto.apellido}, con DNI $dni y $edad años."
    }
}

//una persona tiene 1 o ninguna mascota. La mascota tiene nombre, pertenece a una especie y tiene un número de chip

class Mascota(private var nombreMascota: String?, private var especie: String?, private var numeroChip: Int?){
    override fun toString(): String {
        return "Nombre de mascota: $nombreMascota \nEspecie: $especie\nNúmero de chip: $numeroChip"
    }
}






















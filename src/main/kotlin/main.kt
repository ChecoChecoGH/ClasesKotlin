fun main(args: Array<String>) {

    val nombreCompleto = NombreCompleto("Ignacio", "de Moreta")
    val mascota = Mascota()
    val persona = Persona(nombreCompleto, mascota)



    persona.edad = 30
    persona.setDni("12345678H")
    println(persona)

}

class Persona(val nombreCompleto : NombreCompleto, val mascota: Mascota){
    var edad = 18
    private var dni : String? = null

    fun setDni(dni: String) {
        if(dni.length == 9 && dni[dni.length-1].isLetter())
            this.dni = dni
        else
            println("El dni no se modifico, debe tener 8 digitos y acabar por una letra")
    }


    override fun toString(): String {

        return "Soy ${nombreCompleto.nombre}, con DNI $dni y "
    }


}

class NombreCompleto(var nombre : String, var apellido : String)


//una persona tiene 1 o ninguna mascota. La mascota tiene nombre, pertenece a una especie y tiene un número de chip

class Mascota(){
    private var nombreMascota: String? = null
    private var especie : String? = null
    private var numeroChip : Int? = null

    //nombreMascota
    fun getNombreMascota() : String?{
        nombreMascota?.let { return it }?: run{ return null }
    }
    fun setNombreMascota(nombreMascota: String){
        this.nombreMascota = nombreMascota
    }

    //especie
    fun getEspecie() : String?{
        especie?.let { return it }?: run{ return null }
    }
    fun setEspecie(especie : String){
        this.especie = especie
    }

    //numeroChip
    fun getNumeroChip() : Int?{
        numeroChip?.let { return it }?: run{ return null }
    }
    fun setNumeroChip(numeroChip : Int){
        this.numeroChip = numeroChip
    }



}






















import classes.DigitalHouseManager

fun main(){
    var digitalHouseManager = DigitalHouseManager()

    digitalHouseManager.registrarCurso("Curso Mobile", 1, 40)

    digitalHouseManager.matricularAluno("Vittoria", "Cassoni", 1)
    digitalHouseManager.matricularAluno("Giuliana", "Cassoni", 2)
    digitalHouseManager.matricularAluno("Stefano", "Cassoni", 3)

    digitalHouseManager.matricularAluno(1, 1)

    digitalHouseManager.registrarProfessorTitular("Marco", "Cassoni",1, "Android")
    digitalHouseManager.registrarProfessorAdjunto("Jurema", "Mazur",2, 15)

    digitalHouseManager.alocarProfessores(1, 1, 2)

    digitalHouseManager.excluirProfessor(1)
    digitalHouseManager.excluirCurso(1)
}
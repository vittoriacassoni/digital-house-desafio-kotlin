package classes

class Curso(var nomeCurso: String, var codigo: Int, var quantidadeMaximaAlunos: Int) {
    var alunos = mutableListOf<Aluno>()
    lateinit var professorTitular: ProfessorTitular
    lateinit var professorAdjunto: ProfessorAdjunto

    fun adicionarUmAluno(umAluno: Aluno): Boolean{
        try {
            if(alunos.size == quantidadeMaximaAlunos){
                return false; //Não tem vagas disponiveis
            }
            else{
                alunos.add(umAluno);
                return true;
            }
        }catch(erro: Exception){
            println("Ocorreu um erro: ${erro.message}")
            return false;
        }
    }

    fun excluirAluno(umAluno: Aluno){
        try{
            alunos.remove(umAluno);
        }catch(erro: Exception){
            println("Ocorreu um erro: ${erro.message}")
        }
    }

}
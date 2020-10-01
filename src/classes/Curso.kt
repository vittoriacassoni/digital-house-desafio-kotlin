package classes

class Curso(var nomeCurso: String, var codigo: Int, var professorTitular: ProfessorTitular,
            var professorAdjunto: ProfessorAdjunto, var quantidadeMaximaAlunos: Int) {
    var alunos = mutableListOf<Aluno>()

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